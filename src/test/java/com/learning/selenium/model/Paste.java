package com.learning.selenium.model;

public class Paste {

    private String codeToPaste;
    private String highlighting;
    private String expiration;
    private String name;

    public String getCodeToPaste() {
        return codeToPaste;
    }

    public String getHighlighting() {
        return highlighting;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getName() {
        return name;
    }

    public Paste withCodeToPaste(String code) {
        this.codeToPaste = code;
        return this;
    }

    public Paste withHighlighting(String highlighting) {
        this.highlighting = highlighting;
        return this;
    }

    public Paste withExpiration(String expiration) {
        this.expiration = expiration;
        return this;
    }

    public Paste withName(String name) {
        this.name = name;
        return this;
    }
}
