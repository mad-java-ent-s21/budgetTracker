package edu.matc.controller.category;

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
 * The class retrieves all user's categories for display.
 */
@WebServlet(
        urlPatterns = {"/userCategory"}
)

public class UserCategories extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao categoryDao = new GenericDao(Category.class);

        // Get user from session
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // retrieve categories by user id
        List<Category> userCategories = categoryDao.findByPropertyEqual("userId", user);
        req.setAttribute("category", userCategories);
        logger.debug("Retrieving categories by " + user.getUserName());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/category.jsp");
        dispatcher.forward(req, resp);
    }
}