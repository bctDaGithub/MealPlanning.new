/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author Cong Tuong
 */
public class Order {

    private int orderId;
    private Date orderDate;
    private String status;
    private int total;
    private int userId;
    
    public Order(){}

    public Order(int orderId, Date orderDate, String status, int total, int userId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.total = total;
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public int getTotal() {
        return total;
    }

    public int getUserId() {
        return userId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", status=" + status + ", total=" + total + ", userId=" + userId + '}';
    }

}
