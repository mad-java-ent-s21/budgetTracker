package edu.matc.controller.entry;

import edu.matc.entity.Category;
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

/**
 * The class displays all user entries.
 */
@WebServlet(
        urlPatterns = {"/userEntry"}
)

public class Entries extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);
        GenericDao categoryDao = new GenericDao(Category.class);

        // retrieve user
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // retrieve entries by user id
        List<Entry> userEntries = entryDao.findByPropertyEqual("userId", user);
        req.setAttribute("entry", userEntries);
        logger.debug("Retrieving user entries.");

        // retrieve categories for form
        List<Category> categoryList = categoryDao.findByPropertyEqual("userId", user);
        req.setAttribute("category", categoryList);
        logger.debug("Retrieving user categories");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/entry.jsp");
        dispatcher.forward(req, resp);
    }
}