package controllers;

import dao.OrdersDAO;
import dto.Order;
import dto.OrderDetails;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PlaceOrderServlet", urlPatterns = {"/place-order"})
public class PlaceOrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Lấy thông tin giỏ hàng từ session
        HttpSession session = request.getSession();
        List<OrderDetails> cart = (List<OrderDetails>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            // Giỏ hàng trống, redirect về view-cart.jsp hoặc trang thông báo lỗi
            response.sendRedirect("view-cart.jsp?message=Your cart is empty");
            return;
        }

        // Lọc ra danh sách các món đã chọn để order
        List<OrderDetails> selectedOrders = new ArrayList<>();
        String[] selectedOrderIds = request.getParameterValues("selectedOrders");

        if (selectedOrderIds != null && selectedOrderIds.length > 0) {
            for (String orderId : selectedOrderIds) {
                int id = Integer.parseInt(orderId);
                for (OrderDetails order : cart) {
                    if (order.getDetailId() == id) {
                        selectedOrders.add(order);
                        break;
                    }
                }
            }
        }

        if (selectedOrders.isEmpty()) {
            // Nếu không có món nào được chọn, forward lại view-cart.jsp với thông báo lỗi
            request.setAttribute("errorMessage", "No items selected");
            request.getRequestDispatcher("view-cart.jsp").forward(request, response);
            return;
        }

        // Lấy thông tin người dùng từ session (ví dụ: userId)
        int userId = 1; // Thay thế bằng cách lấy từ session thực tế

        // Tính tổng tiền
        int total = 0;
        for (OrderDetails order : selectedOrders) {
            total += order.getPrice() * order.getQuantity();
        }

        // Tạo đối tượng Order
        Order order = new Order();
        order.setOrderDate(new java.util.Date());
        order.setStatus("Pending"); // Hoặc có thể set là "Confirmed", "Processing", tùy theo logic của bạn
        order.setTotal(total);
        order.setUserId(userId);

        // Gọi DAO để tạo đơn hàng và lưu vào cơ sở dữ liệu
        OrdersDAO orderDAO = new OrdersDAO();
        int orderId = orderDAO.createOrder(order);

        // Tạo các OrderDetails cho các món đã chọn
        for (OrderDetails orderDetail : selectedOrders) {
            orderDetail.setOrderId(orderId);
            orderDAO.createOrderDetail(orderDetail);
            // Xóa món đã chọn khỏi giỏ hàng trong session
            cart.remove(orderDetail);
        }

        // Redirect hoặc forward đến trang thông báo đặt hàng thành công
        response.sendRedirect("order-success.jsp?orderId=" + orderId);
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
