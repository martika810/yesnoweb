package com.mrb.coding;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mrb.coding.model.domain.Group;
import com.mrb.coding.model.domain.Snippet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests extends SpringBaseTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void loadAllSnippets() throws Exception {

        String accessToken = obtainAccessToken("john","123");
        Snippet expectedSnippet = createMockSnippet();

        mockMvc.perform(get("/snippet/listall")
                            .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id",is(expectedSnippet.getId())))
                .andExpect(jsonPath("$.[0].note",is(expectedSnippet.getNote())))
                .andExpect(jsonPath("$.[0].templateId",is(expectedSnippet.getTemplateId())))
                .andExpect(jsonPath("$.[0].data",is(expectedSnippet.getData())))
                .andExpect(jsonPath("$.[0].yesAnswers",is(expectedSnippet.getYesAnswers())))
                .andExpect(jsonPath("$.[0].neutralAnswers",is(expectedSnippet.getNeutralAnswers())))
                .andExpect(jsonPath("$.[0].noAnswers",is(expectedSnippet.getNoAnswers())));
    }

    @Test
    public void updateVote() throws Exception {

        Snippet expectedSnippet = createMockSnippet();


        MockHttpServletRequestBuilder voteRequest = put("/snippet/vote/4")
                .header("token","123")
                .content("\"yes\"")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(voteRequest)
                .andDo(print())
                .andExpect(status().isAccepted());

        mockMvc.perform(get("/snippet/get/4").header("token","123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(expectedSnippet.getId())))
                .andExpect(jsonPath("$.note",is(expectedSnippet.getNote())))
                .andExpect(jsonPath("$.templateId",is(expectedSnippet.getTemplateId())))
                .andExpect(jsonPath("$.data",is(expectedSnippet.getData())))
                .andExpect(jsonPath("$.yesAnswers",is(expectedSnippet.getYesAnswers()+1)))
                .andExpect(jsonPath("$.neutralAnswers",is(expectedSnippet.getNeutralAnswers())))
                .andExpect(jsonPath("$.noAnswers",is(expectedSnippet.getNoAnswers())));



    }

    @Test
    public void createSnippet() throws Exception {
        Snippet newSnippet= createNewMockSnippet();
        newSnippet.setId(UUID.randomUUID().toString());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(newSnippet);
        mockMvc.perform(post("/snippet/create")
                             .header("token","123")
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void listGroups() throws Exception {
        Group expectedGroup = createGroup();
        mockMvc.perform(get("/snippet/group/listall")
                .header("token","123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id",is(expectedGroup.getId())))
                .andExpect(jsonPath("$.[0].name",is(expectedGroup.getName())));
    }

    private Snippet createMockSnippet(){
        Snippet expectedSnippet = new Snippet();
        expectedSnippet.setId("4");
        expectedSnippet.setNote("Blog page about react");
        expectedSnippet.setTemplateId("1");
        expectedSnippet.setData("Did you find this page useful?");
        expectedSnippet.setYesAnswers(10);
        expectedSnippet.setNeutralAnswers(11);
        expectedSnippet.setNoAnswers(12);
        expectedSnippet.setGroup("default");
        expectedSnippet.setConfirmed(false);
        return expectedSnippet;

    }

    private Snippet createNewMockSnippet(){
        Snippet expectedSnippet = new Snippet();
        expectedSnippet.setNote("Blog page about react");
        expectedSnippet.setTemplateId("1");
        expectedSnippet.setData("Did you find this page useful?");
        expectedSnippet.setYesAnswers(10);
        expectedSnippet.setNeutralAnswers(11);
        expectedSnippet.setNoAnswers(12);
        expectedSnippet.setGroup("default");
        expectedSnippet.setConfirmed(false);
        return expectedSnippet;

    }

    private Group createGroup(){
        Group group = new Group("group1");
        group.setName("Group 1");
        return group;
    }

    private String obtainAccessToken(String username, String password) throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "fooClientIdPassword");
        params.add("username", username);
        params.add("password", password);

        ResultActions result
                = mockMvc.perform(post("/oauth/token")
                .params(params)
                .with(httpBasic("fooClientIdPassword","secret"))
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

}