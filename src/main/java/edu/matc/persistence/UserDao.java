package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserDao {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public boolean validate(String userName, String password) {

        Transaction transaction = null;
        User user = null;
        try (Session session = SessionFactoryProvider.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // get an user object
            user = (User) session.createQuery("FROM User WHERE userName = :username").setParameter("username", userName)
                    .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public String retrieveSessionUsername(HttpServletRequest req) throws ServletException, IOException {

        // retrieve username from session
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        return username;
    }

    public List<User> retrieveUserListSession(String username) {
        GenericDao userDao = new GenericDao(User.class);

        // retrieve user from database by username
        List<User> users = userDao.findByPropertyEqual("userName", username);

        return users;
    }

    public User retrieveUserFromUserListSession(List<User> users) {
        GenericDao userDao = new GenericDao(User.class);

        // retrieve user by User entity
        int userId = users.get(0).getId();
        User user = (User) userDao.getById(userId);

        return user;
    }

    public User getUserFromSession(HttpServletRequest req) throws ServletException, IOException {
        // retrieve user
        UserDao retrieveUser = new UserDao();
        String username = retrieveUser.retrieveSessionUsername(req);
        List<User> users = retrieveUser.retrieveUserListSession(username);
        User user = retrieveUser.retrieveUserFromUserListSession(users);

        return user;
    }
}
