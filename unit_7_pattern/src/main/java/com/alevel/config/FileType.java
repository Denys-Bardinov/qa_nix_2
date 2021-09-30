package com.alevel.config;

public enum FileType {

    JSON_TYPE("goods.json"),
    CSV_TYPE("goods.csv"),
    JSON_TYPE_S("author.json"),
    CSV_TYPE_S("author.csv");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
