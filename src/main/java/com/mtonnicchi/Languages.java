package com.mtonnicchi;

public enum Languages {

    EN("en");

    private final String code;

    Languages(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }
}
