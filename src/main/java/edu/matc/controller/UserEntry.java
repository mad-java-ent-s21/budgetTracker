package edu.matc.controller;

import edu.matc.entity.Entry;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.PropertiesLoader;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebServlet(
        urlPatterns = {"/userEntry"}
)

public class UserEntry extends HttpServlet {
    final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Entry> dao = new GenericDao<>();
        List<Entry> entry = dao.getAll();

        req.setAttribute("entry", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/userResults.jsp");
        dispatcher.forward(req, resp);
    }
}