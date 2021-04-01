package edu.matc.util;

import edu.matc.persistence.GenericDao;

/**
 * Created by cvang on 3/26/2021.
 */
public class FactoryDao {

    // Empty constructor is private - static class
    private FactoryDao() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);

    }
}
