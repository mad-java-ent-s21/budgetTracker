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
    GenericDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("src/test/resources/cleandb.sql");

        dao = new GenericDao(Entry.class);
    }

    @Test
    void getByIdSuccess() {
        LocalDate localDate = LocalDate.parse("2021-02-23");
    }

    @Test
    void saveOrUpdateSuccess() {
        String newEntryName = "Update Entry";
    }

    @Test
    void insertSuccess() {
        Category category = new Category();
        category.setId(1);

        User user = new User();
        user.setId(1);

//        Entry newEntry;
//        newEntry = new Entry(LocalDate.parse("2021-02-24"), "Something", "Expense", 20.00, category, user);
//        int id = dao.insert(newEntry);
//        assertNotEquals(0,id);
//        Entry insertedEntry = dao.getById(id);
//        assertEquals(id, insertedEntry.getId());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<Entry> entry = dao.findByPropertyEqual("entryName", "Walmart - Pizzas");
        assertEquals(1, entry.size());
        assertEquals(1, entry.get(0).getId());
    }

    @Test
    void findByTwoPropertiesEqualSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(0);
        String entryName = "Paycheck";

        List<Entry> entryList = dao.findByTwoPropertiesEqual("userId", user, "entryName", entryName);
        for (Entry entry : entryList) {
            assertEquals(user, entry.getUserId());
            assertEquals(entryName, entry.getEntryName());
        }
    }
}