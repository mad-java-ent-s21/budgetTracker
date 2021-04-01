package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.PropertiesLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/admin/searchUser"}
)

public class SearchUser extends HttpServlet {
    final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<User> dao = new GenericDao<>();
        String username = req.getParameter("username");
        UserDao user = new UserDao();

//        if (username != null) {
//            req.setAttribute("users", dao.findByPropertyEqual("username", username));
//        } else {
//            req.setAttribute("users", dao.getAll());
//        }

        req.setAttribute("users", user.getAllUser());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/userResults.jsp");
        dispatcher.forward(req, resp);
    }
}