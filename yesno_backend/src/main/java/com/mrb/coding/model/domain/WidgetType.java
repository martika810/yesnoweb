package com.mrb.coding.model.domain;

/**
 * Created by rsm095 on 29/08/2018.
 */
public enum WidgetType {
    // this is coupled with the widget folder in the frontend
    YES_NO("yes-no-widget.html");

    private String html;

    WidgetType(String html) {
        this.html = html;
    }

    public String getHtml(){
        return html;
    }
}
