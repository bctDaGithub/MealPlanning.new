package dao;

import dto.Menu;
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
public class MenuDAO implements DAOInterface<Menu> {

    private ArrayList<Menu> data = new ArrayList<>();

    public ArrayList<Menu> getAllMenus() {
        ArrayList<Menu> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DButil.makeConnection();
            if (cn != null) {
                String query = "SELECT * FROM Menu";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    int menuId = rs.getInt("menuId");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int weekNumber = rs.getInt("weekNumber");
                    int userId = rs.getInt("userId");

                    Menu menu = new Menu(menuId, name, description, weekNumber, userId);
                    list.add(menu);
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

    public Menu getMenuById(int menuId) {
        Menu menu = null;
        Connection cn = null;
        try {
            cn = DButil.makeConnection();
            if (cn != null) {
                String query = "SELECT * FROM Menu WHERE menuId=?";
                PreparedStatement pst = cn.prepareStatement(query);
                pst.setInt(1, menuId);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    int weekNumber = rs.getInt("weekNumber");
                    int userId = rs.getInt("userId");

                    menu = new Menu(menuId, name, description, weekNumber, userId);
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

        return menu;
    }

    public List<Menu> getMenusByName(String name) {
        List<Menu> menus = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DButil.makeConnection();
            if (cn != null) {
                String query = "SELECT * FROM Menu WHERE name LIKE ?";
                PreparedStatement pst = cn.prepareStatement(query);
                pst.setString(1, "%" + name + "%");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int menuId = rs.getInt("menuId");
                    String menuName = rs.getString("name");
                    String description = rs.getString("description");
                    int weekNumber = rs.getInt("weekNumber");
                    int userId = rs.getInt("userId");

                    Menu menu = new Menu(menuId, menuName, description, weekNumber, userId);
                    menus.add(menu);
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

        return menus;
    }

    @Override
    public ArrayList<Menu> selectAll() {
        return this.data;
    }

    @Override
    public Menu selectById(Menu t) {
        for (Menu menu : data) {
            if (menu.getMenuId() == t.getMenuId()) {
                return menu;
            }
        }
        return null;
    }

    @Override
    public int insert(Menu t) {
        if (this.selectById(t) == null) {
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<Menu> arr) {
        for (Menu menu : arr) {
            this.insert(menu);
        }
        return 0;
    }

    @Override
    public int delete(Menu t) {
        if (selectById(t) != null) {
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<Menu> arr) {
        for (Menu menu : arr) {
            this.delete(menu);
        }
        return 0;
    }

    @Override
    public int update(Menu t) {
        if (selectById(t) != null) {
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }
}
