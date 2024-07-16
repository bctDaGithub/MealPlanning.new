/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.login;

import dao.UserDAO;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khabu
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/register"})
public class SignUpServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("sign-up.jsp").forward(request, response);
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
    request.setCharacterEncoding("UTF-8");
    String fName = request.getParameter("fullname");
    String uName = request.getParameter("username");
    String uPass = request.getParameter("password");
    String uPhone = request.getParameter("telephone");
    String uAddress = request.getParameter("adress");
    String uEmail = request.getParameter("email");
    String birthDate = request.getParameter("birthday");

    UserDAO ud = new UserDAO();
    Account user;
    String message = "Something wrong"; // Initial error message
    int slUPrev = ud.getNumberUsers(); // Previous number of users

    // Check for username duplication
    boolean isDup = ud.checkUserNameDuplicate(uName);
    if (isDup) {
        message = "Username already exist!";
        request.setAttribute("error", message);
        request.getRequestDispatcher("sign-up.jsp").forward(request, response);
        return; // Exit after forwarding to avoid further processing
    }

    // Proceed with user registration
    try {
        user = new Account(uName, fName, uPass, uAddress, uPhone, uEmail, birthDate, 2);
        ud.insert(user);
        int slUAfter = ud.getNumberUsers(); // Number of users after insertion

        if (slUAfter > slUPrev) {
            message = "Register successfully. Please Login!";
        } else {
            message = "Registration failed, please try again."; // Specific failure message
        }
    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging
        message = "An error occurred during registration.";
    }

    request.setAttribute("successfully", message);
    request.getRequestDispatcher("sign-in.jsp").forward(request, response);
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
