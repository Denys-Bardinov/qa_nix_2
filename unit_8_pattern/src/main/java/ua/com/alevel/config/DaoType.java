package ua.com.alevel.config;

public enum DaoType {
    JSON("json");

    private final String type;

    DaoType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static DaoType init(String type) {
        switch (type) {
            case "json":
                return JSON;
        }
        return null;
    }
}
