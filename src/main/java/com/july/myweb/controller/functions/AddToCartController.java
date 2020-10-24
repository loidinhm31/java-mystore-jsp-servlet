/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.controller.functions;

import com.july.myweb.dao.ListProductDAO;
import com.july.myweb.model.Cart;
import com.july.myweb.model.Product;
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
@WebServlet(name="AddToCartController", urlPatterns={"/AddToCartController"})
public class AddToCartController extends HttpServlet {
    private ListProductDAO listProductDAO;
    
    @Override
    public void init() {
        listProductDAO = new ListProductDAO();
    }
    
    
    
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
            String idd = request.getParameter("id");
            String action = request.getParameter("action");
            
            if (action != null && action.equalsIgnoreCase("add")) {
                if (session.getAttribute("cart") == null) {
                    session.setAttribute("cart", new Cart());
                }
                
                int id = Integer.parseInt(idd);
                
                //
                Product p = listProductDAO.getProduct("product_id", String.valueOf(id));
                
                Cart c = (Cart) session.getAttribute("cart");
                
                
                
                Product newp = new Product(p.getId(),
                                            p.getName(),
                                            p.getDescription(),
                                            p.getPrice(),
                                            p.getSrc(),
                                            p.getType(),
                                            p.getBrand(),
                                            1);
             
                c.addItem(newp);
            } else if (action != null && action.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(idd);
                Cart c = (Cart) session.getAttribute("cart");
                c.removeItem(id);
            }
            
            //
            response.sendRedirect("cart.jsp");
            
        } catch (Exception e) {
            response.getWriter().println(e);
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
