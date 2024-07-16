/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Order;
import dto.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import mylib.DButil;

/**
 *
 * @author Cong Tuong
 */
public class CartDAO {

    public void addItemToCart(OrderDetails order, List<OrderDetails> cart) {
        cart.add(order);
    }

    public void removeItemFromCart(int detailId, List<OrderDetails> cart) {
        for (OrderDetails order : cart) {
            if (order.getDetailId() == detailId) {
                cart.remove(order);
                break;
            }
        }
    }
    public int createOrder(Order order) {
    Connection cn = null;
    int orderId = 0;
    try {
        cn = DButil.makeConnection();
        if (cn != null) {
            String query = "INSERT INTO Orders (userId, totalAmount) VALUES (?, ?)";
            PreparedStatement pst = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, order.getUserId());
            pst.setInt(2,  order.getTotal());
            pst.executeUpdate();
            
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            }
            
            pst.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (cn != null) cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return orderId;
}
    public int createOrderDetail(OrderDetails orderDetail) throws ClassNotFoundException {
        Connection cn = null;
        int detailId = -1;
        
        try {
            cn = DButil.makeConnection();
            if (cn != null) {
                String query = "INSERT INTO OrderDetails (dishId, orderId, quantity) VALUES (?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                pst.setInt(1, orderDetail.getDishId());
                pst.setInt(2, orderDetail.getOrderId());
                pst.setInt(3, orderDetail.getQuantity());
                
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    // Retrieve the generated keys (detailId)
                    java.sql.ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        detailId = generatedKeys.getInt(1);
                    }
                }
                
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
        
        return detailId;
    }
}
