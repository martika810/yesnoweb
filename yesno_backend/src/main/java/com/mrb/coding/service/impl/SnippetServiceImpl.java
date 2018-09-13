package com.mrb.coding.service.impl;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.mrb.coding.mapper.SnippetRepository;
import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.model.domain.WidgetType;
import com.mrb.coding.service.SnippetService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service("snippetService")
public class SnippetServiceImpl implements SnippetService {

    private static final String WRAPPER_WIDGET_TEMPLATES_PATH = "/widget-wrapper/";
    private static final String WIDGET_TEMPLATES_PATH = "/widget-wrapper/widgets/";
    private static final String PLACEHOLDER_START_SYMBOL = "{";
    private static final String PLACEHOLDER_END_SYMBOL = "}";

    @Autowired
    SnippetRepository repository;

    @Override
    public String getHtmlWrapperSnippet(String snippetId) {
        String html= readFile(WRAPPER_WIDGET_TEMPLATES_PATH + "wrapper.html");
        html = html.replace(PLACEHOLDER_START_SYMBOL + "widget_type"+ PLACEHOLDER_END_SYMBOL, WidgetType.YES_NO.getHtml());
        html = html.replace(PLACEHOLDER_START_SYMBOL + "widgetId"+ PLACEHOLDER_END_SYMBOL, snippetId);
        return html;
    }

    @Override
    public String getHtmlInsideWidget(Snippet snippet) {
        String html= readFile(WIDGET_TEMPLATES_PATH + "yes-no-widget.html");
        html = html.replace(PLACEHOLDER_START_SYMBOL + "widgetId"+ PLACEHOLDER_END_SYMBOL, snippet.getId());
        html = html.replace(PLACEHOLDER_START_SYMBOL + "question"+ PLACEHOLDER_END_SYMBOL, snippet.getData());
        return html;
    }

    private String readFile(String fullFilePath){
        try {
            return FileUtils.readFileToString(new File(getClass().getResource(fullFilePath).getPath()),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
