package com.mrb.coding.service;

import com.mrb.coding.model.domain.Snippet;

import java.util.List;

public interface SnippetService{

    String getHtmlSnippet(String snippetId);

    List<Snippet> selectAllOrderByCreated();

    Snippet selectById(String id);

    void update(Snippet snippet);

    void insert(Snippet snippet);

    void delete(Snippet snippet);

}
