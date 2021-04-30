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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@WebServlet("/addNewEntry")

public class AddNewEntry extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);
        GenericDao categoryDao = new GenericDao(Category.class);

        // retrieve user
        UserDao retrieveUser = new UserDao();
        String username = retrieveUser.retrieveSessionUsername(req);
        List<User> users = retrieveUser.retrieveUser(username);
        User user = retrieveUser.retrieveUserId(users);

        // Retrieve from form
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String entryName = req.getParameter("entryName");
        String entryType = req.getParameter("entryType");
        Double value = Double.parseDouble(req.getParameter("value"));

        // Retrieve Category selection
        String category = req.getParameter("category");
        List<Category> findCategory = categoryDao.findByPropertyEqual("categoryName", category);

        int categoryId = findCategory.get(0).getId();
        Category useCategory = (Category) categoryDao.getById(categoryId);

        Entry insertEntry = new Entry(
                date,
                entryName,
                entryType,
                value,
                useCategory,
                user
        );
        logger.debug("Entry added: " + insertEntry.getEntryName());
//        req.setAttribute("entry", entryList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/entry.jsp");
        dispatcher.forward(req, resp);
    }
}
