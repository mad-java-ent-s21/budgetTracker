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
import java.time.LocalDate;
import java.util.List;

/**
 * The class adds a new entry for the user.
 */
@WebServlet("/addNewEntry")

public class AddNewEntry extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);
        GenericDao categoryDao = new GenericDao(Category.class);

        // retrieve user
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // Retrieve from form
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String entryName = req.getParameter("entryName");
        String entryType = req.getParameter("entryType");
        Double value = Double.parseDouble(req.getParameter("value"));

        // Retrieve Category selection
        String category = req.getParameter("categoryName");
        // find category by categoryName
        List<Category> findCategory = categoryDao.findByTwoPropertiesEqual("categoryName", category,
                "userId", user);
        // find category object by the category id
        int categoryId = findCategory.get(0).getId();
        Category useCategory = (Category) categoryDao.getById(categoryId);

        if (useCategory == null) {

            logger.debug("Failed to add a new entry.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/addEntryFailure.jsp");
            dispatcher.forward(req, resp);

        } else {

            Entry insertEntry = new Entry(
                    date,
                    entryName,
                    entryType,
                    value,
                    useCategory,
                    user
            );

            // Insert entry
            entryDao.insert(insertEntry);
            logger.debug("Entry added: " + insertEntry.getEntryName());

            RequestDispatcher dispatcher = req.getRequestDispatcher("/addEntrySuccess.jsp");
            dispatcher.forward(req, resp);

        }
    }
}
