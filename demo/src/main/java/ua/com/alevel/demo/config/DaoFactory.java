package ua.com.alevel.demo.config;


import ua.com.alevel.demo.dao.AuthorDao;
import ua.com.alevel.demo.dao.BookDao;
import ua.com.alevel.demo.dao.JsonAuthorDao;
import ua.com.alevel.demo.dao.JsonBookDao;
import ua.com.alevel.demo.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {
    private static DaoFactory instance;

    private AuthorDao authorDao;
    private BookDao bookDao;
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
            case JSON: {
                if (authorDao == null) {
                    authorDao = new JsonAuthorDao();
                }
            }
            break;
        }
        return authorDao;
    }

    public BookDao getBookDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case JSON: {
                if (bookDao == null) {
                    bookDao = new JsonBookDao();
                }
            }
            break;
        }
        return bookDao;
    }
}
