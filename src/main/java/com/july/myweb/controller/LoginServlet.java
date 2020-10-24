/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.july.prj321x.a2.controller;

import com.july.prj321x.a2.beans.Account;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
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
        PrintWriter out = response.getWriter();
        try {
            // ?????????????????????????????????
            request.getSession(true).invalidate();
            // Pattern Regex
            String emailPattern = "^[A-Z0-9_a-z]+@[A-z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
            String pwdPattern = "[a-zA-Z0-9_!@#$%^&*]+";
            
            // Collect data from the login form
            String userID = request.getParameter("username");
            String password = request.getParameter("password");
            
            // ????????????????????????????
            Account loginAccount = new Account();
            loginAccount.setUser(userID);
            loginAccount.setPwd(password);
            
            
            // ??????????????????????????????
            HttpSession session = request.getSession(true);
            if (!userID.matches(emailPattern) || !password.matches(pwdPattern)) {
                session.setAttribute("error", "invalid syntax");
                response.sendRedirect("login.jsp");
               
            } else {
                // Read information of account in web.xml
                String uid = getServletContext().getInitParameter("username");
                String pwd = getServletContext().getInitParameter("password");
                // Check account
                if (loginAccount.getUser().equalsIgnoreCase(uid) &&
                    loginAccount.getPwd().equals(pwd)) {
                    // Set session
                    session.setAttribute("userID", userID);
                    // Login is valid, redirect to index page of admin
                    response.sendRedirect("admin/index.jsp");
                    
                } else {
                   session.setAttribute("error", "wrong username or password");
                   response.sendRedirect("login.jsp");
                }
            }
        } catch (NullPointerException e) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } catch (IOException e) {
            out.println(e);
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
