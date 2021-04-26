package edu.matc.persistence;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    GenericDao userDao;
    GenericDao roleDao;

    @BeforeEach
    public void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new GenericDao(User.class);
        roleDao = new GenericDao(Role.class);
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void delete() {
    }

    @Test
    void insert() {
        // insert new user
        User newUser;
        newUser = new User("NewGuy", "newguy", "New", "Guy", "newguy@some.com", "2000-02-16");
        userDao.insert(newUser);

        String roleName = "general";
        String userName = newUser.getUserName();
        Role role = new Role();
        role.addRole(roleName, userName, newUser);

        assertEquals("NewGuy", role.getUserName());
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