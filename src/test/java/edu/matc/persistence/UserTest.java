package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    GenericDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
//        users = dao.getAll();
    }

    @Test
    void getAll() {
//        assertTrue(users.size() > 0);
//        assertFalse(users.get(0).getFirstName().equals(""));
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void getById() {
        User retrievedUser = (User) dao.getById(1);
        assertEquals("mikeyjones123", retrievedUser.getUserName());
//        assertEquals("Mike", retrievedUser.getFirstName());
//        assertEquals("Jones", retrievedUser.getLastName());
//        assertEquals("1987-03-21", retrievedUser.getBirthdate());
//        assertNotNull(retrievedUser);
    }

    @Test
    void delete() {
    }

    @Test
    void insert() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void findByPropertyEqual() {
    }

    @Test
    void testFindByPropertyEqual() {
    }
}