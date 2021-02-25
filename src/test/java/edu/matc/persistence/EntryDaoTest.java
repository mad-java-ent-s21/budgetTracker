package edu.matc.persistence;

import edu.matc.entity.Category;
import edu.matc.entity.Entry;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.AfterEach;
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
        String newEntryName = "Update Entry";

        Entry entryUpdate = dao.getById(1);
        entryUpdate.setEntryName(newEntryName);
        dao.saveOrUpdate(entryUpdate);
        Entry retrieveEntry = dao.getById(1);
        assertEquals(newEntryName, retrieveEntry.getEntryName());
    }

    @Test
    void insert() {
        Category category = new Category();
        category.setId(1);

        User user = new User();
        user.setId(1);

        Entry newEntry;
        newEntry = new Entry(LocalDate.parse("2021-02-24"), "Something", "Expense", 20.00, category, user);
        int id = dao.insert(newEntry);
        assertNotEquals(0,id);
        Entry insertedEntry = dao.getById(id);
        assertEquals(id, insertedEntry.getId());
    }

    @Test
    void delete() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    @Test
    void getByPropertyEqual() {
        List<Entry> entry = dao.getByPropertyLike("entryName", "Walmart - Pizzas");
        assertEquals(1, entry.size());
        assertEquals(1, entry.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
    }
}