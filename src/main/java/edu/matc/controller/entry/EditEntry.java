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

@WebServlet("/editEntry")

public class EditEntry extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);
        GenericDao categoryDao = new GenericDao(Category.class);

        // retrieve user
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // Retrieve from form
        String entryId = req.getParameter("entryId");
        // Retrieve entry
        List<Entry> entrySelection = entryDao.findByPropertyEqual("id", entryId);
        // set attribute for entry
        req.setAttribute("entry", entrySelection);
        logger.debug("Retrieving entry.");


        // find categories by user id
        List<Category> categoryList = categoryDao.findByPropertyEqual("userId", user);
        // set attr for category
        req.setAttribute("category", categoryList);
        logger.debug("Retrieving user categories.");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editEntry.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);
        GenericDao categoryDao = new GenericDao(Category.class);

        // retrieve user
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // Retrieve from form
        int entryId = Integer.parseInt(req.getParameter("entryId"));
        LocalDate date = LocalDate.parse(req.getParameter("entryDate"));
        String entryName = req.getParameter("entryName");
        String entryType = req.getParameter("entryType");
        Double value = Double.parseDouble(req.getParameter("value"));

        // Retrieve entry
        List<Entry> entryEdit = entryDao.findByPropertyEqual("id", entryId);

        // Retrieve category name from form
        String category = req.getParameter("categoryName");
        // find category by categoryName
        List<Category> findCategory = categoryDao.findByPropertyEqual("categoryName", category);
        // find category object by the category id
        int categoryId = findCategory.get(0).getId();
        Category useCategory = (Category) categoryDao.getById(categoryId);

        if (useCategory == null) {

            logger.debug("Failed to add a new entry.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/addEntryFailure.jsp");
            dispatcher.forward(req, resp);

        } else {

            Entry updateEntry = (Entry) entryDao.getById(entryId);
            updateEntry.setDate(date);
            updateEntry.setEntryName(entryName);
            updateEntry.setEntryType(entryType);
            updateEntry.setValue(value);
            updateEntry.setCategoryId(useCategory);
            updateEntry.setUserId(user);

            // update entry
            entryDao.saveOrUpdate(updateEntry);
            logger.debug("Entry updated: " + updateEntry.getEntryName());

            RequestDispatcher dispatcher = req.getRequestDispatcher("/addEntrySuccess.jsp");
            dispatcher.forward(req, resp);

        }
    }
}
