/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.controller.functions;

import com.july.myweb.dao.OrdersDAO;
import com.july.myweb.model.Cart;
import com.july.myweb.model.Orders;
import com.july.myweb.beans.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Loi Dinh Oct 24, 2020
 * @version 1.0
 */
@WebServlet(name="PayController", urlPatterns={"/PayController"})
public class PayController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            
            if (session.getAttribute("cart") == null) {
                // Create an error here to avoid manipulating data source
                
                return;
            }
            
            Account account = (Account) session.getAttribute("user");

            
            OrdersDAO ordersDAO = new OrdersDAO();
            Cart c = (Cart) session.getAttribute("cart");
            
            String username = account.getUserId();
            String discount = request.getParameter("discount");
            String address = account.getAddress();
            // Check field in db ?????????????
            Orders d = new Orders(username, discount, address);
            
            ordersDAO.insertOrder(d, c);
            
            // Set Cart to null
            session.setAttribute("cart", null);
            
            // Redirect to homepage
            response.sendRedirect("./jsp/home.jsp");
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
            e.printStackTrace();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
