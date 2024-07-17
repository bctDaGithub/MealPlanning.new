package dao;

import dto.MealPlans;
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
public class MealPlanDAO {

    private List<MealPlans> data = new ArrayList<>();

    public List<MealPlans> getAllMealPlans() {
        List<MealPlans> list = new ArrayList<>();
        try (Connection cn = DButil.makeConnection();
             Statement st = cn.createStatement()) {
            String query = "SELECT * FROM MealPlan";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int mealPlanId = rs.getInt("mealPlanId");
                int userId = rs.getInt("userId");
                Date weekStarting = rs.getDate("weekStarting");
                String mealTime = rs.getString("mealTime");
                String dayOfWeek = rs.getString("dayOfWeek");
                int dishId = rs.getInt("dishId");

                MealPlans mealPlan = new MealPlans(mealPlanId, userId, weekStarting, mealTime, dayOfWeek, dishId);
                list.add(mealPlan);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Consider logging the exception instead of printing stack trace directly
        }
        return list;
    }

    public MealPlans getMealPlanById(int mealPlanId) {
        MealPlans mealPlan = null;
        try (Connection cn = DButil.makeConnection();
             PreparedStatement pst = cn.prepareStatement("SELECT * FROM MealPlan WHERE mealPlanId=?")) {
            pst.setInt(1, mealPlanId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userId");
                Date weekStarting = rs.getDate("weekStarting");
                String mealTime = rs.getString("mealTime");
                String dayOfWeek = rs.getString("dayOfWeek");
                int dishId = rs.getInt("dishId");

                mealPlan = new MealPlans(mealPlanId, userId, weekStarting, mealTime, dayOfWeek, dishId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Consider logging the exception instead of printing stack trace directly
        }
        return mealPlan;
    }

    // Add additional CRUD methods as needed

}
