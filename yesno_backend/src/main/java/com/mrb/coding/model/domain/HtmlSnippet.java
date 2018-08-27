package com.mrb.coding.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HtmlSnippet {

    @JsonProperty("html")
    private String html;

    public HtmlSnippet(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
