package edu.matc.controller.entry;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

@WebServlet("/exportCSV")

public class CreateCSV extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, FileNotFoundException {
        GenericDao entryDao = new GenericDao(Entry.class);

        // retrieve all users
        UserDao userDao = new UserDao();
        User user = userDao.getUserFromSession(req);

        // retrieve all entries in date range
        // retrieve from form
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        List<Entry> entryList = null;
        try {
            entryList = entryDao.findByPropertyLocalDateRange("date",
                    startDate,endDate,
                    "userId", user);

            try {
                // TODO send file to google api
                // TODO allow user to download file
                PrintWriter printWriter = new PrintWriter(new File("/home"));
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append("date");
                stringBuilder.append(",");
                stringBuilder.append("entry name");
                stringBuilder.append(",");
                stringBuilder.append("entry type");
                stringBuilder.append(",");
                stringBuilder.append("value");
                stringBuilder.append(",");
                stringBuilder.append("category");
                stringBuilder.append("\r\n");

                for (Entry entries : entryList) {
                    stringBuilder.append(entries.getDate());
                    stringBuilder.append(",");
                    stringBuilder.append(entries.getEntryName());
                    stringBuilder.append(",");
                    stringBuilder.append(entries.getEntryType());
                    stringBuilder.append(",");
                    stringBuilder.append(entries.getValue());
                    stringBuilder.append(",");
                    stringBuilder.append(entries.getCategoryId());
                    stringBuilder.append("\r\n");
                }

                printWriter.write(stringBuilder.toString());
                printWriter.close();
                logger.debug("Created csv file.");

            } catch (Exception e) {
                logger.debug(e);
            }

        } catch (ParseException e) {
            logger.debug(e);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
