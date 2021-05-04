package edu.matc.controller.user;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class allows new user signups.
 */
@WebServlet("/userSignUp")
public class SignUp extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);

        // Grab from form user
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        User user = new User(
                username,
                password,
                firstName,
                lastName,
                email,
                "0001-01-01"
        );

        List<User> allUsers = userDao.getAll();
        List<String> usernameList = new ArrayList<>();
        List<String> emailList = new ArrayList<>();

        for (User eachUser : allUsers) {
            usernameList.add(eachUser.getUserName());
        }

        for (User eachUser : allUsers) {
            emailList.add(eachUser.getEmail());
        }

        if (usernameList.contains(username)) {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpFailure.jsp");
            dispatcher.forward(req, resp);
            logger.debug("Unable to add " + user + " by username/email.");

        } else if (emailList.contains(email)) {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpFailure.jsp");
            dispatcher.forward(req, resp);
            logger.debug("Unable to add " + user + " by username/email.");

        } else {

            userDao.insert(user);
            logger.debug(user + " user added.");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpSuccess.jsp");
            dispatcher.forward(req, resp);
        }
    }
}



