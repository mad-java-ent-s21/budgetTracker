package edu.matc.controller.user;

import edu.matc.entity.User;
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

@WebServlet(
        urlPatterns = {"/userProfile"}
)

public class UserProfile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        GenericDao userDao = new GenericDao(User.class);
//        HttpSession session = req.getSession();
//
//        String username = (String) session.getAttribute("username");
//        List<User> users = userDao.findByPropertyEqual("userName", username);

        UserDao retrieveUser = new UserDao();
        String username = retrieveUser.retrieveSessionUsername(req);
        List<User> users = retrieveUser.retrieveUserListSession(username);

        req.setAttribute("user", users);

        logger.debug("Retrieving users profile information.");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);
    }
}