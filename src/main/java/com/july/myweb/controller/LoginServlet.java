/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.july.myweb.controller;

import com.july.myweb.dao.AccountDAO;
import com.july.myweb.beans.Account;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet handles login 
 * 
 * @author Loi Dinh Oct 15, 2020
 * @version 1.0 
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            // Use it to reset session after login when using cookies 
//            request.getSession(true).invalidate();

            // Pattern Regex
            String emailPattern = "^[A-Z0-9_a-z]+@[A-z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
            String pwdPattern = "[a-zA-Z0-9_!@#$%^&*]+";
            
            // Collect data from the login form
            String userID = request.getParameter("username");
            String password = request.getParameter("password");
            
            // Set "error" atrribute to session scope
            HttpSession session = request.getSession(true);
            if (!userID.matches(emailPattern) || !password.matches(pwdPattern)) {
                session.setAttribute("error", "invalid syntax");
                response.sendRedirect("login.jsp");
                
            } else {
                // Read information of account from database
                AccountDAO accountDAO = new AccountDAO();
                // Create list of fields to query
                List<String> fields = new ArrayList<>();
                fields.add("user_mail");
                fields.add("password");
                // Create list of wild cards from user input
                List<String> wildCards = new ArrayList<>();
                wildCards.add(userID);
                wildCards.add(password);
                
                Account loginAccount = accountDAO.getAccount(fields, wildCards);
                
                
                // Check account
                if (loginAccount != null) {
                    if (loginAccount.getRole() == 1102) {       // admin's role here
                        // Set session
                        session.setAttribute("user", loginAccount);
                        // Login is valid, redirect to index page of admin
                        response.sendRedirect("./admin/index.jsp");
                    } else {
                        // Set session
                        session.setAttribute("user", loginAccount);
                        // Login is valid, redirect to index page of admin
                        response.sendRedirect("./home.jsp");
                    }
                        
                } else {
                   session.setAttribute("error", "wrong username or password");
                   response.sendRedirect("./login.jsp");
                }
            }
        } catch (NullPointerException e) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
