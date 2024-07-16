/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Dishes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mylib.DButil;


public class DishDAO {

    public List<Dishes> getAllDishes() {
        List<Dishes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DButil.makeConnection();
            if (cn != null) {
                String query = "SELECT id, name, description, calories, estimatedPrice, ingredients, method, imagePath FROM Dishes";
                PreparedStatement pst = cn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int calories = rs.getInt("calories");
                    int estimatedPrice = rs.getInt("estimatedPrice");
                    String ingredients = rs.getString("ingredients");
                    String method = rs.getString("method");
                    String imagePath = rs.getString("imagePath");

                    Dishes dish = new Dishes(id, name, description, calories, estimatedPrice, ingredients, method, imagePath);
                    list.add(dish);
                }
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

        return list;
    }
    
    public Dishes getDishById(int dishId) {
    Dishes dish = null;
    Connection cn = null;
    try {
        cn = DButil.makeConnection();
        if (cn != null) {
            String query = "SELECT id, name, description, calories, estimatedPrice, ingredients, method, imagePath FROM Dishes WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, dishId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int calories = rs.getInt("calories");
                int estimatedPrice = rs.getInt("estimatedPrice");
                String ingredients = rs.getString("ingredients");
                String method = rs.getString("method");
                String imagePath = rs.getString("imagePath");

                dish = new Dishes(id, name, description, calories, estimatedPrice, ingredients, method, imagePath);
            }
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
    return dish;
}

}

