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
import java.text.ParseException;
import java.util.List;

/**
 * The class searches a date range for user entries.
 */
@WebServlet ("/searchEntry")

public class SearchEntry extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);

        // retrieve user
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // Retrieve from form
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        try {
            // search date range and user
            List<Entry> entriesByDate = entryDao.findByPropertyLocalDateRange("date", startDate, endDate,
                    "userId", user);

            req.setAttribute("entry", entriesByDate);
            logger.debug("Retrieving user entries by date range.");

            } catch (ParseException e) {
                logger.debug(e);
            }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/entry.jsp");
        dispatcher.forward(req, resp);
    }
}
