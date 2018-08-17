package com.mrb.coding.service;

import com.mrb.coding.model.domain.Snippet;

import java.util.List;

public interface SnippetService extends BaseService<Snippet, String> {

    String getHtmlSnippet(String snippetId);

    List<Snippet> selectAllOrderByCreated();

}
