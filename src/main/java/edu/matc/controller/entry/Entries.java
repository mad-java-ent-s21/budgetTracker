package edu.matc.controller.entry;

import edu.matc.entity.Entry;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.PropertiesLoader;
import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebServlet(
        urlPatterns = {"/userEntry"}
)

public class Entries extends HttpServlet {
    final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        GenericDao entryDao = new GenericDao(edu.matc.entity.Entry.class);
//        GenericDao userDao = new GenericDao(User.class);
//        HttpSession session = req.getSession();
//
//        String username = (String) session.getAttribute("username");
//        List<User> users = userDao.findByPropertyEqual("userName", username);
//        int userId = users.get(0).getId();
//        User user = (User) userDao.getById(userId);
//
//        List<Entry> entryList = entryDao.findByPropertyEqual("userId", user);



        GenericDao entryDao = new GenericDao(Entry.class);

        // retrieve user
        UserDao retrieveUser = new UserDao();
        String username = retrieveUser.retrieveSessionUsername(req);
        List<User> users = retrieveUser.retrieveUser(username);
        User user = retrieveUser.retrieveUserId(users);

        // find entries by user id
        List<Entry> entryList = entryDao.findByPropertyEqual("userId", user);

        req.setAttribute("entry", entryList);
        logger.debug("Retrieving user entries.");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/entry.jsp");
        dispatcher.forward(req, resp);
    }
}