/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.admin;

import dao.OrdersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cong Tuong
 */
public class ManageOrderStatusServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if (action != null && !action.isEmpty()) {
            switch (action) {
                case "cancel":
                    cancelOrder(request, response);
                    break;
                case "cancelForCus":
                    cancelOrder2(request, response);
                    break;
                case "process":
                    processOrder(request, response);
                    break;
                case "complete":
                    completeOrder(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageOrderStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageOrderStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    private void cancelOrder2(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        String orderIdStr = request.getParameter("orderId");
        if (orderIdStr != null && !orderIdStr.isEmpty()) {
            try {
                int orderId = Integer.parseInt(orderIdStr);
                OrdersDAO dao = new OrdersDAO();
                boolean success = dao.updateOrderStatus(orderId, "Cancelled"); // Assume updateOrderStatus method is implemented

                if (success) {
                    response.sendRedirect("cancel-success.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
    
    private void cancelOrder(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        String orderIdStr = request.getParameter("orderId");
        if (orderIdStr != null && !orderIdStr.isEmpty()) {
            try {
                int orderId = Integer.parseInt(orderIdStr);
                OrdersDAO dao = new OrdersDAO();
                boolean success = dao.updateOrderStatus(orderId, "Cancelled"); // Assume updateOrderStatus method is implemented

                if (success) {
                    response.sendRedirect("manage-orders.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void processOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String orderIdStr = request.getParameter("orderId");
        if (orderIdStr != null && !orderIdStr.isEmpty()) {
            try {
                int orderId = Integer.parseInt(orderIdStr);
                OrdersDAO dao = new OrdersDAO();
                boolean success = dao.updateOrderStatus(orderId, "Processing");

                if (success) {
                    response.sendRedirect("manage-orders.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void completeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String orderIdStr = request.getParameter("orderId");
        if (orderIdStr != null && !orderIdStr.isEmpty()) {
            try {
                int orderId = Integer.parseInt(orderIdStr);
                OrdersDAO dao = new OrdersDAO();
                boolean success = dao.updateOrderStatus(orderId, "Completed");

                if (success) {
                    response.sendRedirect("manage-orders.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
