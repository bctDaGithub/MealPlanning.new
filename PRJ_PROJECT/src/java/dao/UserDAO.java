package dao;

import mylib.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.Account;

public class UserDAO extends DButil {

    public Account check(String username, String password) {
        String sql = "SELECT * FROM Users WHERE userName = ? and password = ? and [status] = 1";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("userName"), rs.getString("fullName"), rs.getString("password"),
                        rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("BirthDay"), rs.getInt("roleID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public int checkAccountAdmin(String userName) {
        String sql = "SELECT roleID FROM Users WHERE userName = ? and [status] = 1";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, userName);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public List<Account> getAllUsers() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE [status] = 1 ORDER BY roleID ASC";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString("userName"), rs.getString("fullName"), rs.getString("password"),
                        rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("BirthDay"), rs.getInt("roleID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean checkUserNameDuplicate(String username) {
        String sql = "SELECT * FROM Users WHERE userName = ? and [status] = 1";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, username);
            rs = st.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void updateImage(String image, String userName) {
        String sql = "UPDATE Users SET Image = ? WHERE userName = ? and [status] = 1";
        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, image);
            st.setString(2, userName);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String fullname, String address, String phone, String email, String dob, String userName) {
        String sql = "UPDATE Users SET fullName = ?, address = ?, phone = ?, email = ?, BirthDay = ? WHERE userName = ?";
        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, fullname);
            st.setString(2, address);
            st.setString(3, phone);
            st.setString(4, email);
            st.setString(5, dob);
            st.setString(6, userName);
            int rowsUpdated = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Account getUserByUserName(String userName) {
        String sql = "SELECT * FROM Users WHERE userName = ? and [status] = 1";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, userName);
            rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString("userName"), rs.getString("fullName"), rs.getString("password"),
                        rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("BirthDay"), rs.getInt("roleID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int getNumberUsers() {
        String sql = "SELECT COUNT(*) FROM Users";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public void insert(Account c) {
        String sql = "INSERT INTO Users (UserName, FullName, Password, RoleID, Email, BirthDay, Address, Phone, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, c.getUserName());
            st.setString(2, c.getFullName());
            st.setString(3, c.getPassword());
            st.setInt(4, c.getRoleID());
            st.setString(5, c.getEmail());
            st.setString(6, c.getBirthdate());
            st.setString(7, c.getAddress());
            st.setString(8, c.getPhone());
            st.setInt(9, 1);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int countAllUser() {
        String sql = "SELECT COUNT(*) FROM Users WHERE [status] = 1";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }


    public void deleteUser(String username) {
        String sql = "UPDATE Users SET status = 0 WHERE userName = ?";
        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public List<Account> getUsersBySearchName(String txtSearch) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE userName LIKE ? and [status] = 1";
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DButil.makeConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString("userName"), rs.getString("fullName"), rs.getString("password"),
                        rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("BirthDay"), rs.getInt("roleID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
