package com.mrb.coding.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mrb.coding.model.domain.Group;
import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.model.domain.Vote;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ApplicationTests extends SpringBaseTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void loadAllSnippets() throws Exception {
        Snippet expectedSnippet = createMockSnippet();

        mockMvc.perform(get("/snippet/listall")
                            .header("token","123"))
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


        MockHttpServletRequestBuilder voteRequest = put("/snippet/vote/5")
                .header("token","123")
                .content("\"yes\"")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(voteRequest)
                .andDo(print())
                .andExpect(status().isAccepted());

        mockMvc.perform(get("/snippet/get/5").header("token","123"))
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
        Snippet newSnippet= createMockSnippet();
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
        Snippet expectedSnippet = new Snippet("5");
        expectedSnippet.setNote("Blog page about react and differences");
        expectedSnippet.setTemplateId("1");
        expectedSnippet.setData("Did you find this page useful?");
        expectedSnippet.setYesAnswers(13);
        expectedSnippet.setNeutralAnswers(14);
        expectedSnippet.setNoAnswers(15);
        expectedSnippet.setGroup("default");
        return expectedSnippet;
    }

    private Group createGroup(){
        Group group = new Group("group1");
        group.setName("Group 1");
        return group;
    }


}