package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    @Test
    void getById() {
        User retrievedUser = dao.getById(1);
        assertEquals("mikeyjones123", retrievedUser.getUsername());
        assertEquals("Mike", retrievedUser.getFirstName());
        assertEquals("Jones", retrievedUser.getLastName());
        assertEquals("1987-03-21", retrievedUser.getBirthdate());
    }

    @Test
    void saveOrUpdate() {
        String newUserFirstName = "New First Name";

        User userUpdate = dao.getById(1);
        userUpdate.setFirstName(newUserFirstName);
        dao.saveOrUpdate(userUpdate);
        User retrieveUser = dao.getById(1);
        assertEquals(newUserFirstName, retrieveUser.getFirstName());
    }

    @Test
    void insert() {
        User newUser;
        newUser = new User("userName","123456890","User", "Name", "somewhere@gmail.com", "2021-01-01");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals(id, insertedUser.getId());
    }

    @Test
    void delete() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void getByPropertyLike() {
        List<User> user = dao.getByPropertyLike("username", "mikeyjones123");
        assertEquals(1, user.size());
        assertEquals(1, user.get(0).getId());
    }
}