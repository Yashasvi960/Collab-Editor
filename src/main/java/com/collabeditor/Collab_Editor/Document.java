package com.collabeditor.Collab_Editor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Document {

    @Id
    private String id;

    private int version;

    private String contentJson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getContentJson() {
        return contentJson;
    }

    public void setContentJson(String contentJson) {
        this.contentJson = contentJson;
    }
}
