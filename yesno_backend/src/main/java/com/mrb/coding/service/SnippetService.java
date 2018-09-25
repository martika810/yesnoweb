package com.mrb.coding.service;

import com.mrb.coding.model.domain.Snippet;

import java.util.List;

public interface  SnippetService{

    String getHtmlWrapperSnippet(String snippetId);

    String getHtmlInsideWidget(Snippet snippet);

    List<Snippet> selectAllOrderByCreated();

    List<Snippet> selectAllByAccountIdOrderByCreated(String accountId);

    Snippet selectById(String id);

    void update(Snippet snippet);

    void insert(Snippet snippet);

    void delete(Snippet snippet);

}
