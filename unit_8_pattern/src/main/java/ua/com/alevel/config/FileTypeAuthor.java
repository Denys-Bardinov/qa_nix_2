package ua.com.alevel.config;

public enum FileTypeAuthor {
    JSON_TYPE("author.json");

    private final String path;

    FileTypeAuthor(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
