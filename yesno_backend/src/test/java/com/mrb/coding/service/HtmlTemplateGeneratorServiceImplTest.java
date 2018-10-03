package com.mrb.coding.service;

import com.mrb.coding.service.impl.HtmlTemplateGeneratorServiceImpl;
import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;

public class HtmlTemplateGeneratorServiceImplTest {

    private HtmlTemplateGeneratorService htmlTemplateGeneratorService;

    @Before
    public void setup(){
        htmlTemplateGeneratorService = new HtmlTemplateGeneratorServiceImpl();
    }


    @Test
    public void updatePanelColor(){
        TemplateUpdate templateUpdate = new TemplateUpdate.Builder().withColor("blue").build();
        String updatedHtml = htmlTemplateGeneratorService.generateHtmlTemplate(templateUpdate);

        String htmlValue = Jsoup.parse(updatedHtml).select("#widgetPanel").attr("style");
        assert(htmlValue).contains("blue");
    }

}
