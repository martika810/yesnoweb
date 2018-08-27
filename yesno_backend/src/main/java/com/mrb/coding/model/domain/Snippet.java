package com.mrb.coding.model.domain;

import com.google.common.base.MoreObjects;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
@Entity
@Table(name = "snippet")
public class Snippet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "note")
    private String note;

    @Column(name = "templateId")
    private String templateId;

    @Column(name= "data")
    private String data;

    @Column(name= "groupname")
    private String group;

    @Column(name= "yesAnswers")
    private int yesAnswers;

    @Column(name= "neutralAnswers")
    private int neutralAnswers;

    @Column(name= "noAnswers")
    private int noAnswers;

    public Snippet(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getYesAnswers() {
        return yesAnswers;
    }

    public void setYesAnswers(int yesAnswers) {
        this.yesAnswers = yesAnswers;
    }

    public int getNeutralAnswers() {
        return neutralAnswers;
    }

    public void setNeutralAnswers(int neutralAnswers) {
        this.neutralAnswers = neutralAnswers;
    }

    public int getNoAnswers() {
        return noAnswers;
    }

    public void setNoAnswers(int noAnswers) {
        this.noAnswers = noAnswers;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("note", note)
                .add("templateId", templateId)
                .add("data", data)
                .add("groupname", group)
                .add("yesAnswers", yesAnswers)
                .add("neutralAnswers", neutralAnswers)
                .add("noAnswers", noAnswers)
                .toString();
    }

    public static Snippet of(Snippet snippet){
        Snippet newSnippet = new Snippet(snippet.getId());
        newSnippet.setNote(snippet.getNote());
        newSnippet.setTemplateId(snippet.getTemplateId());
        newSnippet.setData(snippet.getData());
        newSnippet.setGroup(snippet.getGroup());
        newSnippet.setYesAnswers(snippet.getYesAnswers());
        newSnippet.setNeutralAnswers(snippet.getNeutralAnswers());
        newSnippet.setNoAnswers(snippet.getNoAnswers());
        return newSnippet;
    }
}
