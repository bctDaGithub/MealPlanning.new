/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author phamg
 */
public class MealPlans {
    private int mealPlanId;
    private int userId;
    private Date weekStarting;
    private String mealTime;
    private String dayOfWeek;
    private int dishId;

    public MealPlans(int mealPlanId, int userId, Date weekStarting, String mealTime, String dayOfWeek, int dishId) {
        this.mealPlanId = mealPlanId;
        this.userId = userId;
        this.weekStarting = weekStarting;
        this.mealTime = mealTime;
        this.dayOfWeek = dayOfWeek;
        this.dishId = dishId;
    }

    public MealPlans() {
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getWeekStarting() {
        return weekStarting;
    }

    public void setWeekStarting(Date weekStarting) {
        this.weekStarting = weekStarting;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }
    
    
}
