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
import java.util.ArrayList;
import java.util.List;

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

        // TODO grab categories by user only -- connects with AddNewEntry
        // Category name has to be unique
//        List<Category> allCategoryList = categoryDao.getAll();
        List<Category> allCategoryList = categoryDao.findByPropertyEqual("userId", user);
        List<String> categoryList = new ArrayList<>();
        for (Category list : allCategoryList) {
            categoryList.add(list.getCategoryName());
        }

        if (categoryList.contains(categoryName)) {
            logger.debug("Failed to add a new category, category name is not unique.");

            RequestDispatcher dispatcher = req.getRequestDispatcher("addCategoryFailure.jsp");
            dispatcher.forward(req, resp);

        } else {

            Category insertCategory = new Category(
                    categoryName,
                    categoryDescription,
                    color,
                    user
            );

            // Insert entry
            categoryDao.insert(insertCategory);

            logger.debug("Category added: " + insertCategory.getCategoryName());

            RequestDispatcher dispatcher = req.getRequestDispatcher("addCategorySuccess.jsp");
            dispatcher.forward(req, resp);
        }
    }
}