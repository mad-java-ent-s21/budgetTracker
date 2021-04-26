package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import edu.matc.util.FactoryDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao dao;

    @BeforeEach
    public void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(User.class);
    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) dao.getById(1);
        assertEquals("mikeyjones123", retrievedUser.getUserName());
//        assertEquals("Mike", retrievedUser.getFirstName());
//        assertEquals("Jones", retrievedUser.getLastName());
//        assertEquals("1987-03-21", retrievedUser.getBirthdate());
//        assertNotNull(retrievedUser);
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    @Test
    void insertSuccess() {
//        User newUser;
//        newUser = new User("NewGuy", "newguy", "New", "Guy", "newguy@some.com", "2000-02-16");
//        int id = dao.insert(newUser);
//        assertNotEquals(0,id);
//        User insertedUser = (User) dao.getById(id);
//        assertEquals(id, insertedUser.getId());
//        assertEquals("New", insertedUser.getFirstName());

        String uname = "somelady";
        String pass = "pass";
        String fname = "some";
        String lname = "lady";
        String email = "emaillady@l.com";
        String bday = "2001-03-04";

        User newU = new User();
        newU.setUserName(uname);
        newU.setPassword(pass);
        newU.setFirstName(fname);
        newU.setLastName(lname);
        newU.setEmail(email);
        newU.setBirthdate(bday);

        GenericDao userDao = FactoryDao.createDao(User.class);

        int idNew = userDao.insert(newU);

        User insertedUser2 = (User) dao.getById(idNew);
        assertEquals("somelady", insertedUser2.getUserName());
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
//        String name = "Mike";
//        String column = "firstName";
//
//        List<User> userFirstName = dao.findByPropertyEqual(column, name);
//        for (User firstName: userFirstName) {
//            assertEquals(name, firstName.getFirstName());
//        }

        String username = "mikeyjones123";

        List<User> findUser = dao.findByPropertyEqual("userName", username);
        for (User user: findUser) {
            assertEquals(username, user.getUserName());
        }
    }

    @Test
    void testFindByPropertyEqual() {
    }

    @Test
    void persistUser() {
        String username = "mikeyjones123";

        List<User> findUser = dao.findByPropertyEqual("username", username);
        for (User user: findUser) {
            assertEquals(username, user.getUserName());
        }

    }
}