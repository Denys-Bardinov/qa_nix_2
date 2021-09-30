package ua.com.alevel.config;

public class FileTypeBook {

    public enum FileType {

        JSON_TYPE("author.json");

        private final String path;

        FileType(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}
