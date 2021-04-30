package edu.matc.controller.user;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.FactoryDao;
import edu.matc.util.VerifyRecaptcha;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

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
                "2021-01-01"
        );
        logger.debug(user + " user added.");

        // TODO check to make login username unique
        userDao.insert(user);


//        if (user.getUserName() != null || user.getUserName() != "") {
//
//            userDao.insert(user);
//
//        } else {
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpFailure.jsp");
//            dispatcher.forward(req, resp);
//            logger.debug("Unable to add " + user);
//        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        GenericDao userDao;
////        userDao = new GenericDao(User.class);
//        User user = new User();
//        user.setUserName(req.getParameter("userName"));
//        user.setEmail(req.getParameter("email"));
//        user.setFirstName(req.getParameter("firstName"));
//        user.setLastName(req.getParameter("lastName"));
//        user.setPassword(req.getParameter("password"));
//        logger.debug("Adding User: " + user);
//
//        Role role = new Role();
//        role.setUserName(user);
//        role.setRoleName("general");
////        user.addRole(role);
//
//
//        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
//        System.out.println(gRecaptchaResponse);
//        boolean isVerified = VerifyRecaptcha.verify(gRecaptchaResponse);
//
//        if (isVerified) {
//            GenericDao userDao = FactoryDao.createDao(User.class);
//            userDao.insert(user);
//
//            GenericDao roleDao = new GenericDao(Role.class);
//            roleDao.insert(role);
//        } else {
//            req.setAttribute("errorMessage", "Failed Captcha - Please try again");
//            logger.info("Failed Captcha");
//        }
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpSuccess.jsp");
//        dispatcher.forward(req, resp);
//    }


