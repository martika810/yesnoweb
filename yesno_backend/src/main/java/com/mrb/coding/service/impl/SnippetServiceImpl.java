package com.mrb.coding.service.impl;

import com.google.common.collect.Lists;
import com.mrb.coding.mapper.SnippetRepository;
import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("snippetService")
public class SnippetServiceImpl implements SnippetService {

    @Autowired
    SnippetRepository repository;

    @Override
    public String getHtmlSnippet(String snippetId) {
        String html=
            "<div class=\"feedback-wrapper\" style=\"\">"+
                "<iframe id=\"frame-form\" src=\"http://localhost:8087/snippet-hello.html\" name=\"feedback_iframe_a\" "+
                    "frameBorder=\"0\" style=\"width:240px; height:170px;padding:5px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); align-content: center\">" +
                "</iframe>"+
            "</div>";
        return html;
    }

    @Override
    public List<Snippet> selectAllOrderByCreated() {

       return Lists.newArrayList(repository.findAll());

    }

    @Override
    public Snippet selectById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void update(Snippet snippet) {
        repository.save(snippet);
    }

    @Override
    public void insert(Snippet snippet) {
        repository.save(snippet);
    }

    @Override
    public void delete(Snippet snippet) {
        repository.delete(snippet);
    }
}
