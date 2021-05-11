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
        assertEquals(dao.getById(1).toString(), retrievedCategory.toString());
    }

    @Test
    void saveOrUpdateSuccess() {
        String categoryName = "New Category";

        Category categoryUpdate = (Category) dao.getById(1);
        categoryUpdate.setCategoryName(categoryName);
        dao.saveOrUpdate(categoryUpdate);
        Category retrieveCategory = (Category) dao.getById(1);
        assertEquals(categoryName, retrieveCategory.getCategoryName());
    }

    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(1);
        Category newCategory = new Category("asdf", "asdf", "Red", user);
        dao.insert(newCategory);
        int id = newCategory.getId();

        Category retrieveCategory = (Category) dao.getById(id);
        assertEquals(newCategory.toString(), retrieveCategory.toString());
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
}