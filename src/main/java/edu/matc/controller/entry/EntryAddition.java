package edu.matc.controller.entry;

import edu.matc.entity.Category;
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

/**
 * The class retrieves entry information for adding new entry.
 */
@WebServlet("/entryAddition")

public class EntryAddition extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao categoryDao = new GenericDao(Category.class);

        // retrieve user
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // find entries by user id
        List<Category> categoryList = categoryDao.findByPropertyEqual("userId", user);
        req.setAttribute("category", categoryList);
        logger.debug("Retrieving user categories.");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addEntry.jsp");
        dispatcher.forward(req, resp);
    }
}
