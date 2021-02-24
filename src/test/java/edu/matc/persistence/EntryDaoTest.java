package edu.matc.persistence;

import edu.matc.entity.Category;
import edu.matc.entity.Entry;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntryDaoTest {
    EntryDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("src/test/resources/cleandb.sql");

        dao = new EntryDao();
    }

    @Test
    void getAllEntry() {
//        List<Entry> entries;

    }

    @Test
    void getById() {
        LocalDate localDate = LocalDate.parse("2021-02-23");
//        Category category = new Category();
//        User user = new User();

        Entry retrievedEntry = dao.getById(1);
        assertEquals(localDate, retrievedEntry.getDate());
        assertEquals("Walmart - Pizzas", retrievedEntry.getEntryName());
        assertEquals("Expense", retrievedEntry.getEntryType());
        assertEquals(Double.valueOf(10.50), Double.valueOf(retrievedEntry.getValue()));
//        assertEquals(category.getId(1), retrievedEntry.getCategoryId());
//        assertEquals(user.getId(1), retrievedEntry.getUserId());
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}