//package edu.matc.controller;
//
//import edu.matc.persistence.UserDao;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/login")
//public class Login extends HttpServlet {
//    private static final long serialVersionUID = 1;
//    private UserDao login;
//
//    public void init() {
//        login = new UserDao();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.sendRedirect("userLogin.jsp");
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            authenticate(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void authenticate(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if (login.validate(username, password)) {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            throw new Exception("Login not successful..");
//        }
//    }
//}