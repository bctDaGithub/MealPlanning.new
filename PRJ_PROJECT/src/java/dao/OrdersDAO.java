/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.OrderDetails;
import dto.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mylib.DButil;

/**
 *
 * @author Cong Tuong
 */
public class OrdersDAO implements DAOInterface<Order> {

    ArrayList<Order> data = new ArrayList<>();

    public ArrayList<Order> getAllOrders(int status) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        try {
            //b1tao ket noi
            cn = DButil.makeConnection();
            if (cn != null) {
                //b2:viet query va exec query
                String query = "SELECT * FROM Orders WHERE status = ?";
                PreparedStatement pst = cn.prepareStatement(query);
                pst.setInt(1, status);
                ResultSet rs = pst.executeQuery();

                // Bước 3: Duyệt qua kết quả và tạo đối tượng Order
                while (rs.next()) {
                    int orderId = rs.getInt("orderId");
                    Date orderDate = rs.getDate("orderDate");
                    String orderStatus = rs.getString("status");
                    int total = rs.getInt("total");
                    int userId = rs.getInt("userId");

                    // Tạo đối tượng Order và thêm vào danh sách
                    Order order = new Order(orderId, orderDate, orderStatus, total, userId);
                    list.add(order);
                }
                rs.close();
                pst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
    public List<Order> getAllOrders() {
    List<Order> list = new ArrayList<>();
    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        try {
            cn = DButil.makeConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cn != null) {
            String query = "SELECT orderId, userId, orderDate, total, status FROM Orders";
            pst = cn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                int customerId = rs.getInt("userId");
                Date orderDate = rs.getDate("orderDate");
                int totalAmount = rs.getInt("total");
                String status = rs.getString("status");

                Order order = new Order(orderId, orderDate, status, totalAmount, customerId);
                list.add(order);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (cn != null) cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return list;
}
   
    public int insertOrder(Order order) {
        Connection cn = null;
        int orderId = -1;
        try {
            // Bước 1: Tạo kết nối
            cn = DButil.makeConnection();
            if (cn != null) {
                // Bước 2: Viết và thực thi truy vấn
                String query = "INSERT INTO Orders (orderDate, status, total, userId) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pst.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
                pst.setString(2, order.getStatus());
                pst.setDouble(3, order.getTotal());
                pst.setInt(4, order.getUserId());

                // Thực thi truy vấn
                pst.executeUpdate();

                // Lấy orderId được sinh tự động
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getInt(1);
                }

                // Đóng PreparedStatement
                pst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return orderId;
    }

    public boolean insertOrderDetails(OrderDetails orderDetails) {
        Connection cn = null;
        boolean success = false;
        try {
            // Bước 1: Tạo kết nối
            cn = DButil.makeConnection();
            if (cn != null) {
                // Bước 2: Viết và thực thi truy vấn
                String query = "INSERT INTO OrderDetails (dishId, orderId, quantity) VALUES (?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(query);
                pst.setInt(1, orderDetails.getDishId());
                pst.setInt(2, orderDetails.getOrderId());
                pst.setInt(3, orderDetails.getQuantity());

                // Thực thi truy vấn
                int rowsAffected = pst.executeUpdate();

                // Kiểm tra xem có insert thành công hay không
                if (rowsAffected > 0) {
                    success = true;
                }

                // Đóng PreparedStatement
                pst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    @Override
    public ArrayList<Order> selectAll() {
        return this.data;
    }

    @Override
    public Order selectById(Order t) {
        for (Order orders : data) {
            if (data.equals(t)) {
                return orders;
            }
        }
        return null;
    }

    @Override
    public int insert(Order t) {
        if (this.selectById(t) == null) {
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<Order> arr) {
        for (Order orders : arr) {
            this.insert(orders);
        }
        return 0;
    }

    @Override
    public int delete(Order t) {
        if (selectById(t) != null) {
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<Order> arr) {
        for (Order orders : arr) {
            this.delete(orders);
        }
        return 0;
    }

    @Override
    public int update(Order t) {
        if (selectById(t) != null) {
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    public int createOrder(Order order) {
        Connection cn = null;
        int orderId = -1; // Mặc định trả về -1 nếu không thành công

        try {
            try {
                // Bước 1: Tạo kết nối
                cn = DButil.makeConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (cn != null) {
                // Bước 2: Viết và thực thi truy vấn
                String query = "INSERT INTO Orders (orderDate, status, total, userId) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pst.setTimestamp(1, new java.sql.Timestamp(order.getOrderDate().getTime()));
                pst.setString(2, order.getStatus());
                pst.setInt(3, order.getTotal());
                pst.setInt(4, order.getUserId());

                // Thực thi truy vấn
                pst.executeUpdate();

                // Lấy orderId được sinh tự động
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getInt(1);
                }

                // Đóng PreparedStatement
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orderId;
    }

    public boolean createOrderDetail1(OrderDetails orderDetail) {
        Connection cn = null;
        boolean success = false;

        try {
            try {
                // Bước 1: Tạo kết nối
                cn = DButil.makeConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (cn != null) {
                // Bước 2: Viết và thực thi truy vấn
                String query = "INSERT INTO OrderDetails (dishId, orderId, quantity, imageUrl, price) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(query);
                pst.setInt(1, orderDetail.getDishId());
                pst.setInt(2, orderDetail.getOrderId());
                pst.setInt(3, orderDetail.getQuantity());
                pst.setString(4, orderDetail.getImageUrl());
                pst.setInt(5, orderDetail.getPrice());

                // Thực thi truy vấn
                int rowsAffected = pst.executeUpdate();

                // Kiểm tra xem có insert thành công hay không
                if (rowsAffected > 0) {
                    success = true;
                }

                // Đóng PreparedStatement
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }
    
    public int createOrderDetail(OrderDetails orderDetail) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int detailId = -1;

    try {
        try {
            conn = DButil.makeConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "INSERT INTO OrderDetails (dishId, orderId, quantity) VALUES (?, ?, ?)";
        stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, orderDetail.getDishId());
        stmt.setInt(2, orderDetail.getOrderId());
        stmt.setInt(3, orderDetail.getQuantity());

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected == 1) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                detailId = rs.getInt(1); // Lấy detailId được sinh tự động
                orderDetail.setDetailId(detailId); // Cập nhật detailId cho đối tượng OrderDetails
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    return detailId;
}

    public boolean deleteOrder(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Order> getOrdersByUserName(String userName) {
         List<Order> orderList = new ArrayList<>();
        String sql = "SELECT o.orderId, o.orderDate, o.status, o.total, o.userId " +
             "FROM Orders o " +
             "INNER JOIN Users u ON o.userId = u.userId " +
             "WHERE u.userName = ? " +
             "ORDER BY o.orderDate DESC";

        try (Connection conn = DButil.makeConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setOrderDate(rs.getTimestamp("orderDate"));
                order.setStatus(rs.getString("status"));
                order.setTotal(rs.getInt("total"));
                order.setUserId(rs.getInt("userId"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public Order getOrderById(int orderId) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Order order = null;

    try {
        try {
            con = DButil.makeConnection(); // DButil là lớp để thiết lập kết nối CSDL
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con != null) {
            String sql = "SELECT orderId, orderDate, status, total, userId FROM Orders WHERE orderId = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            rs = pst.executeQuery();

            if (rs.next()) {
                int orderID = rs.getInt("orderId");
                Date orderDate = rs.getDate("orderDate");
                String status = rs.getString("status");
                int total = rs.getInt("total");
                int userId = rs.getInt("userId");

                // Tạo đối tượng Order từ kết quả truy vấn
                order = new Order(orderID, orderDate, status, total, userId);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
    }
    return order;
}

    public boolean updateOrderStatus(int orderId, String status) throws ClassNotFoundException {
    Connection conn = null;
    PreparedStatement stmt = null;
    boolean success = false;

    try {
        conn = DButil.makeConnection();
        String sql = "UPDATE Orders SET status = ? WHERE orderId = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, status);
        stmt.setInt(2, orderId);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            success = true;
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Handle or log the exception as needed
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle or log the exception as needed
        }
    }
    return success;
}
    
}
