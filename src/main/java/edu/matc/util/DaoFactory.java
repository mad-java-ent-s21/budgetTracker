package edu.matc.util;

import edu.matc.persistence.GenericDao;
import edu.matc.persistence.UserDao;

/**
 * Created by cvang on 3/26/2021.
 */
public class DaoFactory {

    // Empty constructor is private - static class
    private DaoFactory() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);

    }

//    public static UserDao createDao(Class type) {
//        return new UserDao(type);
//    }
}
