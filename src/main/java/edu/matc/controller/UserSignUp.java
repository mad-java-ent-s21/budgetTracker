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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userSignUp")
public class UserSignUp {
    private final Logger logger = LogManager.getLogger(this.getClass());

//    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GenericDao userDao;
//        userDao = new GenericDao(User.class);
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("email"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        logger.debug("Adding User: " + user);

        Role role = new Role();
        role.setUserName(user);
        role.setRoleName("general");
//        user.addRole(role);


        String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
        System.out.println(gRecaptchaResponse);
        boolean isVerified = VerifyRecaptcha.verify(gRecaptchaResponse);

        if (isVerified) {
            // TODO check if user is already in the database
            GenericDao userDao = FactoryDao.createDao(User.class);
            userDao.insert(user);

            GenericDao roleDao = new GenericDao(Role.class);
            roleDao.insert(role);
        } else {
            req.setAttribute("errorMessage", "Failed Captcha - Please try again");
            logger.info("Failed Captcha");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
