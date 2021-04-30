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
//    CategoryDao dao;
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("src/test/resources/cleandb.sql");

//        dao = new CategoryDao();
        dao = new GenericDao(Category.class);
    }

    @Test
    void getById() {
//        Category retrievedCategory = dao.getById(1);
//        assertEquals("Food - Dine Out", retrievedCategory.getCategoryName());
//        assertEquals("Dining out", retrievedCategory.getCategoryDescription());
//        assertEquals("#FFFFFF", retrievedCategory.getColor());

        Category retrievedCategory = (Category) dao.getById(1);
        assertEquals("Food - Dine Out", retrievedCategory.getCategoryName());
        assertEquals("Dining out", retrievedCategory.getCategoryDescription());
        assertEquals("#FFFFFF", retrievedCategory.getColor());
    }

    @Test
    void saveOrUpdate() {
//        String newCategoryName = "Update Category";
//
////        Category categoryUpdate = dao.getById(1);
//        categoryUpdate.setCategoryName(newCategoryName);
//        dao.saveOrUpdate(categoryUpdate);
//        Category retrieveCategory = dao.getById(1);
//        assertEquals(newCategoryName, retrieveCategory.getCategoryName());
    }

    @Test
    void insert() {
//        User user = new User();
//        user.setId(1);
//
//        Category newCategory;
//        newCategory = new Category("Essentials","Toilet paper, paper towels, etc.","#000000",user);
//        int id = dao.insert(newCategory);
//        assertNotEquals(0,id);
//        Category insertedCategory = dao.getById(id);
//        assertEquals(id, insertedCategory.getId());
    }

    @Test
    void delete() {
//        dao.delete(dao.getById(2));
//        assertNull(dao.getById(2));
    }

    @Test
    void getByPropertyLike() {
//        List<Category> category = dao.findByPropertyEqual("categoryName", "Food - Dine Out");
//        assertEquals(1, category.size());
//        assertEquals(1, category.get(0).getId());

        List<Category> category = dao.findByPropertyEqual("categoryName", "Hobby");
        assertEquals(1, category.size());
        assertEquals(2, category.get(0).getId());
    }

    @Test
    void getByPropertyLikeByUsername() {
//        GenericDao userDao = new GenericDao(User.class);
//        User getUser = (User) userDao.getById(1);

//        List<Category> category = dao.findByPropertyEqual("entryName", "Food - Dine Out");
//
//
    }
}