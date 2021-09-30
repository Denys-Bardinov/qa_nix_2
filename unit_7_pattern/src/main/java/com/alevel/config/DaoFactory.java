package com.alevel.config;

import com.alevel.dao.*;
import com.alevel.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {

    private static DaoFactory instance;
    private BooksDao booksDao;
    private AuthorDao authorDao;
    private DaoType daoType;

    private DaoFactory() { }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public BooksDao getBooksDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (booksDao == null) {
                    booksDao = new CsvBooksDao();
                }
            } break;
            case JSON : {
                if (booksDao == null) {
                    booksDao = new JsonBooksDao();
                }
            } break;
        }
        return booksDao;
    }

    public AuthorDao getAuthorDao() {
        if (daoType == null) {
            Map<String, String> map = ResourceUtil.getResource("application.properties");
            daoType = DaoType.init(map.get("dao.type"));
        }
        switch (daoType) {
            case CSV : {
                if (authorDao == null) {
                    authorDao = new CsvAuthorDao();
                }
            } break;
            case JSON : {
                if (authorDao == null) {
                    authorDao = new JsonAuthorDao();
                }
            } break;
        }
        return authorDao;
    }
}
