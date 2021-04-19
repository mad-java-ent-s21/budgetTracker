package edu.matc.controller;

import edu.matc.entity.Category;
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

@WebServlet(
        urlPatterns = {"/userCategory"}
)

public class UserCategory extends HttpServlet {
    final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        GenericDao<Entry> dao = new GenericDao<>();
//        List<Entry> entry = dao.getAll();
        GenericDao dao = new GenericDao(Category.class);

        req.setAttribute("category", dao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/category.jsp");
        dispatcher.forward(req, resp);
    }
}