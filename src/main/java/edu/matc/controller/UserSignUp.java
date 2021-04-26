package edu.matc.controller;

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

@WebServlet("/userSignUp")
public class UserSignUp extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

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
//            // TODO check if user is already in the database
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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);
        GenericDao roleDao = new GenericDao(Role.class);

        // Grab from form user
//        String username = req.getParameter("username");
//        String email = req.getParameter("email");
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String password = req.getParameter("password");
//        User user = new User(
//                username,
//                email,
//                firstName,
//                lastName,
//                password,
//                ""
//        );
//        logger.debug(user + " user added.");
//
//        String roleName = "general";
//        User newUser = user;
//        Role role = new Role(
//                roleName,
//                newUser
//        );

        User user = new User();
        user.setUserName(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        user.setBirthdate("");
        logger.debug("Adding User: " + user);

        Role role = new Role();
        role.setUserName(user);
        role.setRoleName("general");

        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        System.out.println(gRecaptchaResponse);
        boolean isVerified = VerifyRecaptcha.verify(gRecaptchaResponse);

        if (isVerified) {
            if ((userDao.findByPropertyEqual("userName", user.getUserName()) == null)
                    && (userDao.findByPropertyEqual("email", user.getEmail()) == null)) {
                GenericDao uDao = FactoryDao.createDao(User.class);
                uDao.insert(user);

                GenericDao rDao = FactoryDao.createDao(Role.class);
                rDao.insert(role);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpFailure.jsp");
                dispatcher.forward(req, resp);
                logger.debug("Unable to add " + user);
            }
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpFailure.jsp");
            dispatcher.forward(req, resp);
            logger.info("Failed Captcha");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
