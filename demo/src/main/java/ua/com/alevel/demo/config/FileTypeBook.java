package ua.com.alevel.demo.config;

public enum FileTypeBook {

    JSON_TYPE("book.json");

    private final String path;

    FileTypeBook(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}