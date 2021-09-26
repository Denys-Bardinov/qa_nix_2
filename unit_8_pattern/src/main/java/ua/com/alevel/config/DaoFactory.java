package ua.com.alevel.config;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.dao.JsonAuthorDao;
import ua.com.alevel.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {
    private static DaoFactory instance;
    private AuthorDao authorDao;
    private DaoType daoType;

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public AuthorDao getAuthorDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {

            case JSON : {
                if (authorDao == null) {
                    authorDao = new JsonAuthorDao();
                }
            } break;
        }
        return authorDao;
    }
}
