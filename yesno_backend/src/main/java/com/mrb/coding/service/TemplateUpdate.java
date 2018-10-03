package com.mrb.coding.service;

public class TemplateUpdate {
    private final String color;
    private final String position;
    private final String answerType;

    public static class Builder {
        private String color;
        private String position;
        private String answerType;

        public Builder(){}

        public Builder withColor(String color){
            this.color = color;
            return this;
        }

        public Builder withPosition(String position){
            this.position = position;
            return this;
        }

        public Builder withAnswerType(String answerType){
            this.answerType = answerType;
            return this;
        }

        public TemplateUpdate build(){
            return new TemplateUpdate(this);
        }
    }

    private TemplateUpdate(Builder builder){

        this.color = builder.color;
        this.position = builder.position;
        this.answerType = builder.answerType;
    }

    public String getColor(){
        return color;
    }

    public String getPosition(){
        return position;
    }

    public String getAnswerType(){
        return answerType;
    }
}
