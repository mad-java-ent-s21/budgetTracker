package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    GenericDao dao;

    @BeforeEach
    public void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
//        users = dao.getAll();
        dao = new GenericDao(User.class);
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
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void insert() {
        User newUser;
        newUser = new User("NewGuy", "newguy", "New", "Guy", "newguy@some.com", "2000-02-16");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User) dao.getById(id);
        assertEquals(id, insertedUser.getId());
        assertEquals("New", insertedUser.getFirstName());
    }

    @Test
    void saveOrUpdate() {
        String newName = "Harry";

        User userUpdate = (User) dao.getById(1);
        userUpdate.setFirstName(newName);
        dao.saveOrUpdate(userUpdate);
        User retrieveUser = (User) dao.getById(1);
        assertEquals(newName, retrieveUser.getFirstName());
    }

    @Test
    void findByPropertyEqual() {
    }

    @Test
    void testFindByPropertyEqual() {
    }
}