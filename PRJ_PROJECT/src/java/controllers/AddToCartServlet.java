/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dao.DishDAO;
import dto.Dishes;
import dto.Order;
import dto.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cong Tuong
 */
public class AddToCartServlet extends HttpServlet {
   
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
            // Get parameters from the form
            int dishId = Integer.parseInt(request.getParameter("dishId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Fetch dish information from database
            DishDAO dishDAO = new DishDAO();
            Dishes dish = dishDAO.getDishById(dishId);

            if (dish != null) {
                // Calculate total price
                int totalPrice = dish.getEstimatedPrice() * quantity;

                // Create OrderDetails object
                OrderDetails orderDetail = new OrderDetails();
                orderDetail.setDishId(dishId);
                orderDetail.setDishname(dish.getName());
                orderDetail.setQuantity(quantity);
                orderDetail.setImageUrl(dish.getImagePath());
                orderDetail.setPrice(dish.getEstimatedPrice());

                // Check if there's an existing cart in session
                ArrayList<OrderDetails> cart;
                if (request.getSession().getAttribute("cart") == null) {
                    cart = new ArrayList<>();
                } else {
                    cart = (ArrayList<OrderDetails>) request.getSession().getAttribute("cart");
                }

                // Add orderDetail to cart
                cart.add(orderDetail);

                // Update session attribute
                request.getSession().setAttribute("cart", cart);

                // Set success message
                request.setAttribute("addToCartSuccess", true);

                // Forward to order.jsp
                request.getRequestDispatcher("order.jsp").forward(request, response);
            } else {
                // Dish not found
                request.setAttribute("addToCartSuccess", false);
                request.getRequestDispatcher("order.jsp").forward(request, response);
            }

        } catch (Exception e) {
            // Error occurred
            request.setAttribute("addToCartSuccess", false);
            request.getRequestDispatcher("order.jsp").forward(request, response);
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
