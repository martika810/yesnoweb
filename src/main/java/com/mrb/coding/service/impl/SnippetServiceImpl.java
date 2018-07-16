package com.mrb.coding.service.impl;

import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.service.SnippetService;
import org.springframework.stereotype.Service;

@Service("snippetService")
public class SnippetServiceImpl extends BaseServiceImpl<Snippet,String> implements SnippetService {
}
