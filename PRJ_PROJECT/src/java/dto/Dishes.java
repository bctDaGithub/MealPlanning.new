/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Cong Tuong
 */
public class Dishes {
    private int id;
    private String name;
    private String description;
    private int calories;
    private int estimatedPrice;
    private String ingredients;
    private String method;
    private String imagePath;

    public Dishes(int id, String name, String description, int calories, int estimatedPrice, String ingredients, String method, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.estimatedPrice = estimatedPrice;
        this.ingredients = ingredients;
        this.method = method;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(int estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Dishes{" + "id=" + id + ", name=" + name + ", description=" + description + ", calories=" + calories + ", estimatedPrice=" + estimatedPrice + ", ingredients=" + ingredients + ", method=" + method + ", imagePath=" + imagePath + '}';
    }
    
    
}
