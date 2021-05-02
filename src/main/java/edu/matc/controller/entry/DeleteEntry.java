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

@WebServlet("/deleteEntry")

public class DeleteEntry extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);

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

        RequestDispatcher dispatcher = req.getRequestDispatcher("/deleteEntry.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao entryDao = new GenericDao(Entry.class);

        // Retrieve from form
        int entryId = Integer.parseInt(req.getParameter("entryId"));

        // delete entry
        entryDao.delete(entryDao.getById(entryId));
        logger.debug("Deleted entry: " + entryDao.getById(entryId));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/deleteEntrySuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
