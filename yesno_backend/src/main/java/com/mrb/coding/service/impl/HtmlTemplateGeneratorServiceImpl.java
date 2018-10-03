package com.mrb.coding.service.impl;

import com.mrb.coding.service.HtmlTemplateGeneratorService;
import com.mrb.coding.service.TemplateUpdate;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class HtmlTemplateGeneratorServiceImpl implements HtmlTemplateGeneratorService {

    private static final String WRAPPER_WIDGET_TEMPLATES_PATH = "widget-wrapper/";
    private static final String WIDGET_TEMPLATES_PATH = "widget-wrapper/widgets/";
    private static final String PLACEHOLDER_START_SYMBOL = "{";
    private static final String PLACEHOLDER_END_SYMBOL = "}";

    @Override
    public String generateHtmlTemplate(TemplateUpdate templateUpdate) {
        String html= readFile(WIDGET_TEMPLATES_PATH + "yes-no-widget.html");

        Document doc = Jsoup.parse(html);
        doc.select("#widgetPanel").attr("style", updateColorHtmlStyleValue(templateUpdate));
        //html = html.replace(PLACEHOLDER_START_SYMBOL + "widgetId"+ PLACEHOLDER_END_SYMBOL, snippet.getId());
        //html = html.replace(PLACEHOLDER_START_SYMBOL + "question"+ PLACEHOLDER_END_SYMBOL, snippet.getData());
        return doc.html();
    }


    private String readFile(String fullFilePath){
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            return FileUtils.readFileToString(new File(classLoader.getResource(fullFilePath).getPath()),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String updateColorHtmlStyleValue(TemplateUpdate templateUpdate){
        return "color:"+templateUpdate.getColor()+";";
    }
}
