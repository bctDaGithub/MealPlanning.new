package controllers;
import dao.DishDAO;
import dto.Dishes;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;


public class ManageMenuServlet extends HttpServlet {
    
    private DishDAO dishDAO;
    
    public void init() {
        // Khởi tạo DAO
        dishDAO = new DishDAO(); // Đảm bảo rằng DishDAO đã được triển khai để thao tác với cơ sở dữ liệu
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list"; // Mặc định hiển thị danh sách món ăn nếu không có action được xác định
        }
        
        switch (action) {
            case "list":
                listDishes(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateDish(request, response);
                break;
            case "delete":
                softDeleteDish(request, response);
                break;
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createDish(request, response);
                break;
            case "filter":
                filterDishes(request, response);
                break;
            default:
                listDishes(request, response);
                break;
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Đảm bảo các yêu cầu POST được xử lý bởi doGet
    }
    
    private void listDishes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dishes> dishes = dishDAO.getAllDishes();
        request.setAttribute("dishes", dishes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminDish.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        Dishes dish = dishDAO.getDishById(dishId);
        request.setAttribute("dish", dish);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editDishForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void updateDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int calories = Integer.parseInt(request.getParameter("calories"));

        int price = Integer.parseInt(request.getParameter("estimatedPrice"));
        String ingredients = request.getParameter("ingredients");
        String method = request.getParameter("method");
        String imagePath=request.getParameter("imagePath");
        Dishes dish = new Dishes(dishId, name,  description,calories, price, ingredients, method, imagePath); // Tạo đối tượng Dish từ dữ liệu form
        
        dishDAO.update(dish); // Cập nhật món ăn trong cơ sở dữ liệu
        
        // Chuyển hướng lại đến trang danh sách món ăn
        response.sendRedirect(request.getContextPath() + "/ManageMenuServlet?action=list");
    }
    
    private void softDeleteDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        
        dishDAO.deleteById(dishId); // Xóa mềm món ăn từ cơ sở dữ liệu (thay đổi trạng thái Available)
        
        // Chuyển hướng lại đến trang danh sách món ăn
        response.sendRedirect(request.getContextPath() + "/ManageMenuServlet?action=list");
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newDishForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void createDish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int calories = Integer.parseInt(request.getParameter("calories"));

        int price = Integer.parseInt(request.getParameter("estimatedPrice"));
        String ingredients = request.getParameter("ingredients");
        String method = request.getParameter("method");
        String imagePath=request.getParameter("imagePath");
        Dishes dish = new Dishes(dishId, name,  description,calories, price, ingredients, method, imagePath);
        
        
        dishDAO.addDishes(dish); // Thêm món ăn vào cơ sở dữ liệu
        
        // Chuyển hướng lại đến trang danh sách món ăn
        response.sendRedirect(request.getContextPath() + "/ManageMenuServlet?action=list");
    }
    
    private void filterDishes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý logic tìm kiếm theo các tiêu chí như giá, loại đồ ăn, ...
        // Lấy thông tin từ request.getParameter và sử dụng DAO để lấy danh sách món ăn đã lọc
        
        // Ví dụ:
        int maxPrice = Integer.parseInt(request.getParameter("maxPrice"));
        List<Dishes> filteredDishes = dishDAO.getDishesByPrice(0,maxPrice);
        
        request.setAttribute("dishes", filteredDishes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminDish.jsp");
        dispatcher.forward(request, response);
    }
}
