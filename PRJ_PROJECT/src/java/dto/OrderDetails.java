/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Cong Tuong
 */
public class OrderDetails {

    private int detailId;
    private int dishId;
    private String dishname;
    private int quantity;
    private int orderId;
    private String imageUrl;
    private int price;
    
    public OrderDetails(){}
    
    public OrderDetails(int detailId, int dishId, String dishname, int quantity, int orderId, String imageUrl, int price) {
        this.detailId = detailId;
        this.dishId = dishId;
        this.dishname = dishname;
        this.quantity = quantity;
        this.orderId = orderId;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public int getDetailId() {
        return detailId;
    }

    public int getDishId() {
        return dishId;
    }

    public String getDishname() {
        return dishname;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "detailId=" + detailId + ", dishId=" + dishId + ", dishname=" + dishname + ", quantity=" + quantity + ", orderId=" + orderId + ", imageUrl=" + imageUrl + ", price=" + price + '}';
    }

    
}
