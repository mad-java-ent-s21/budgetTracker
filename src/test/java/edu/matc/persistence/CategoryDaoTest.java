package edu.matc.persistence;

import edu.matc.entity.Category;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDaoTest {
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("src/test/resources/cleandb.sql");

        dao = new GenericDao(Category.class);
    }

    @Test
    void getByIdSuccess() {
        Category retrievedCategory = (Category) dao.getById(1);
        assertEquals("Food - Dine Out", retrievedCategory.getCategoryName());
        assertEquals("Dining out", retrievedCategory.getCategoryDescription());
        assertEquals("#FFFFFF", retrievedCategory.getColor());
    }

    @Test
    void saveOrUpdateSuccess() {
    }

    @Test
    void insertSuccess() {
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<Category> category = dao.findByPropertyEqual("categoryName", "Hobby");
        assertEquals(1, category.size());
        assertEquals(2, category.get(0).getId());
    }

    @Test
    void getByPropertyLikeByUsernameSuccess() {

    }
}