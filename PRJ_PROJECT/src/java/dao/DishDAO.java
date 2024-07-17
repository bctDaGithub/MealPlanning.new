package dao;

import dto.Dishes;
import java.sql.Connection;
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
public class DishDAO implements DAOInterface<Dishes> {

    private ArrayList<Dishes> data = new ArrayList<>();

    public ArrayList<Dishes> getAllDishes() {
        ArrayList<Dishes> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DButil.makeConnection();
            if (cn != null) {
                String query = "SELECT * FROM Dishes";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
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
                rs.close();
                st.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
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

        return list;
    }

    public Dishes getDishById(int id) {
        Dishes dish = null;
        Connection cn = null;
        try {
            cn = DButil.makeConnection();
            if (cn != null) {
                String query = "SELECT * FROM Dishes WHERE id=?";
                PreparedStatement pst = cn.prepareStatement(query);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int calories = rs.getInt("calories");
                    int estimatedPrice = rs.getInt("estimatedPrice");
                    String ingredients = rs.getString("ingredients");
                    String method = rs.getString("method");
                    String imagePath = rs.getString("imagePath");

                    dish = new Dishes(id, name, description, calories, estimatedPrice, ingredients, method, imagePath);
                }
                rs.close();
                pst.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
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

        return dish;
    }
    public int deleteById(int id) {
    Connection cn = null;
    try {
        cn = DButil.makeConnection();
        if (cn != null) {
            String query = "DELETE FROM Dishes WHERE id=?";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, id);
            int rowsDeleted = pst.executeUpdate();
            pst.close();
            return rowsDeleted;
        }
    } catch (SQLException | ClassNotFoundException e) {
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
    return 0;
}
    public int addDishes(Dishes dish) {
    Connection cn = null;
    try {
        cn = DButil.makeConnection();
        if (cn != null) {
            String query = "INSERT INTO Dishes (name, description, calories, estimatedPrice, ingredients, method, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dish.getName());
            pst.setString(2, dish.getDescription());
            pst.setInt(3, dish.getCalories());
            pst.setInt(4, dish.getEstimatedPrice());
            pst.setString(5, dish.getIngredients());
            pst.setString(6, dish.getMethod());
            pst.setString(7, dish.getImagePath());
            
            int rowsInserted = pst.executeUpdate();
            pst.close();
            return rowsInserted;
        }
    } catch (SQLException | ClassNotFoundException e) {
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
    return 0;
}
public ArrayList<Dishes> getDishesByPrice(int minPrice, int maxPrice) {
    ArrayList<Dishes> list = new ArrayList<>();
    Connection cn = null;
    try {
        cn = DButil.makeConnection();
        if (cn != null) {
            String query = "SELECT * FROM Dishes ";
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
            rs.close();
            pst.close();
        }
    } catch (SQLException | ClassNotFoundException e) {
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

    return list;
}


    @Override
    public ArrayList<Dishes> selectAll() {
        return this.data;
    }

    @Override
    public Dishes selectById(Dishes t) {
        for (Dishes dish : data) {
            if (dish.getId() == t.getId()) {
                return dish;
            }
        }
        return null;
    }

    @Override
    public int insert(Dishes t) {
        if (this.selectById(t) == null) {
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<Dishes> arr) {
        for (Dishes dish : arr) {
            this.insert(dish);
        }
        return 0;
    }

    @Override
    public int delete(Dishes t) {
        if (selectById(t) != null) {
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<Dishes> arr) {
        for (Dishes dish : arr) {
            this.delete(dish);
        }
        return 0;
    }

    @Override
    public int update(Dishes t) {
        if (selectById(t) != null) {
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }
    
}
