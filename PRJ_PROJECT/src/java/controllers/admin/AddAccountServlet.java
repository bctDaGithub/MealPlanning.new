package controllers.admin;

import dao.UserDAO;
import dto.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddAccountServlet", urlPatterns = {"/addaccount"})
public class AddAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // Print statements to check servlet access and parameter values
        System.out.println("Servlet accessed");
        System.out.println("Full name: " + request.getParameter("fullname"));
        System.out.println("Username: " + request.getParameter("username"));

        String fullName = request.getParameter("fullname");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("adress");
        String phone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String birthDate = request.getParameter("birthday");
        String roleParam = request.getParameter("roleId");
        int roleID = (roleParam == null) ? 2 : 1; 

        UserDAO dao = new UserDAO();
        boolean isDuplicate = dao.checkUserNameDuplicate(userName);
        String message;

        if (isDuplicate) {
            message = "Username already exists!";
            request.setAttribute("error", message);
            request.getRequestDispatcher("managerAccount").forward(request, response);
        } else {
            Account user = new Account(userName, fullName, password, address, phone, email, birthDate, roleID);
            dao.insert(user);
            message = "Account added successfully!";
            request.setAttribute("success", message);
            request.getRequestDispatcher("managerAccount").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
