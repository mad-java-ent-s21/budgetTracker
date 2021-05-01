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

@WebServlet("/addNewCategory")

public class AddNewCategory extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao categoryDao = new GenericDao(Category.class);

        // retrieve user
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // Retrieve from form
        String categoryName = req.getParameter("categoryName");
        String categoryDescription = req.getParameter("categoryDescription");
        String color = req.getParameter("color");

        Category insertCategory = new Category(
                categoryName,
                categoryDescription,
                color,
                user
        );

        // Insert entry
        categoryDao.insert(insertCategory);

        logger.debug("Category added: " + insertCategory.getCategoryName());
//        req.setAttribute("entry", entryList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userCategory");
        dispatcher.forward(req, resp);
    }
}