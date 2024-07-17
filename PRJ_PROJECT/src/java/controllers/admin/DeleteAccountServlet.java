package controllers.admin;

import dao.UserDAO;
import dto.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DeleteAccountServlet", urlPatterns = {"/deleteaccount"})
public class DeleteAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        Account userss = (Account) session.getAttribute("account");
        UserDAO dao = new UserDAO();
        String msg;

        if (username != null) {
            dao.deleteUser(username);
            msg = "Delete username " + username + " successfully!";
        } else {
            msg = "Delete failed!";
        }

        request.setAttribute("mess", msg);

        if (userss != null && username.equals(userss.getUserName())) {
            session.removeAttribute("account");
            request.getRequestDispatcher("home").forward(request, response);
        } else {
            request.getRequestDispatcher("managerAccount").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "DeleteAccountServlet handles account deletion";
    }
}
