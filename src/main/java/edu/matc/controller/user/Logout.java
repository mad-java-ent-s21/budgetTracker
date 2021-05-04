package edu.matc.controller.user;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The class logouts user in session.
 */
@WebServlet("/logout")

public class Logout extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            removeSession(req, resp);
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            logger.debug(e);
        }
    }

    private void removeSession(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {

        if (req.getSession() != null) {
            HttpSession session = req.getSession();

            req.removeAttribute("username");
            req.removeAttribute("password");
            session.removeAttribute("username");
            session.removeAttribute("user");
            logger.debug("Removed user from session.");

            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("logoutError.jsp");
            dispatcher.forward(req, resp);
            throw new Exception("Logout not successful..");
        }
    }
}