package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import edu.matc.util.FactoryDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao dao;
    User user;
    UserDao userDao;

    @BeforeEach
    public void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(User.class);
        user = new User("NewGuy", "newguy", "New", "Guy", "newguy@some.com", "2000-02-16");
        userDao = new UserDao();
    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void getByIdSuccess() {
        int id = dao.insert(user);
        User retrievedUser = (User) dao.getById(id);
        assertEquals(user.toString(), retrievedUser.toString());
        assertNotNull(retrievedUser);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void insertSuccess() {
        int id = dao.insert(user);
        assertNotEquals(0,id);
        User insertedUser = (User) dao.getById(id);
        assertEquals(id, insertedUser.getId());
        assertEquals(user.toString(), insertedUser.toString());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newName = "Harry";

        User userUpdate = (User) dao.getById(1);
        userUpdate.setFirstName(newName);
        dao.saveOrUpdate(userUpdate);
        User retrieveUser = (User) dao.getById(1);
        assertEquals(newName, retrieveUser.getFirstName());
    }

    @Test
    void findByPropertyEqualSuccess() {
        String username = "mikeyjones123";

        List<User> findUser = dao.findByPropertyEqual("userName", username);
        for (User user: findUser) {
            assertEquals(username, user.getUserName());
        }
    }

    @Test
    void findByTwoPropertiesEqualSuccess() {
        String username = "mikeyjones123";
        int id = 1;

        List<User> findUser = dao.findByTwoPropertiesEqual("userName", username, "id", id);
        for (User user: findUser) {
            assertEquals(username, user.getUserName());
            assertEquals(id, user.getId());
        }
    }

    @Test
    void validateSuccess() {
        int id = dao.insert(user);
        User newUser = (User) dao.getById(id);
        assertTrue(userDao.validate(newUser.getUserName(), newUser.getPassword()));
    }

    @Test
    void retrieveSessionUsernameSuccess() {
        int id = dao.insert(user);
        User newUser = (User) dao.getById(id);
        String username = newUser.getUserName();
        assertEquals(user.getUserName(), newUser.getUserName());
    }

    @Test
    void retrieveUserListSessionSuccess() {
        int id = dao.insert(user);
        User newUser = (User) dao.getById(id);
        List<User> userList = userDao.retrieveUserListSession(newUser.getUserName());
        assertEquals(user.toString(), userList.get(0).toString());
    }

    @Test
    void retrieveUserFromUserListSessionSuccess() {
        int id = dao.insert(user);
        User newUser = (User) dao.getById(id);
        List<User> userList = userDao.retrieveUserListSession(newUser.getUserName());
        User retrieveUser = userDao.retrieveUserFromUserListSession(userList);
        assertEquals(user.toString(), retrieveUser.toString());
    }

}