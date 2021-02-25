package edu.matc.persistence;

import edu.matc.entity.Category;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDaoTest {
    CategoryDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("src/test/resources/cleandb.sql");

        dao = new CategoryDao();
    }

    @Test
    void getById() {
        Category retrievedCategory = dao.getById(1);
        assertEquals("Food - Dine Out", retrievedCategory.getCategoryName());
        assertEquals("Dining out", retrievedCategory.getCategoryDescription());
        assertEquals("#FFFFFF", retrievedCategory.getColor());
    }

    @Test
    void saveOrUpdate() {
        String newCategoryName = "Update Category";

        Category categoryUpdate = dao.getById(1);
        categoryUpdate.setCategoryName(newCategoryName);
        dao.saveOrUpdate(categoryUpdate);
        Category retrieveCategory = dao.getById(1);
        assertEquals(newCategoryName, retrieveCategory.getCategoryName());
    }

    @Test
    void insert() {
//        Category category = new Category();
//        category.setId(1);
//
//        User user = new User();
//        user.setId(1);

        Category newCategory;
        newCategory = new Category();
        int id = dao.insert(newCategory);
        assertNotEquals(0,id);
        Category insertedCategory = dao.getById(id);
        assertEquals(id, insertedCategory.getId());
    }

    @Test
    void delete() {
    }

    @Test
    void getByPropertyLike() {
    }
}