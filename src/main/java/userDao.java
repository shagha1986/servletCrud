

import java.sql.*;

public class userDao {
    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public static int save(User user) throws SQLException {
        int status = 0;
        Connection con = userDao.getConnection();
        PreparedStatement insertUser = con.prepareStatement("insert into user(name,email,country) values (?,?,?)");
        insertUser.setString(1, user.getName());
        insertUser.setString(2, user.getEmail());
        insertUser.setString(3, user.getCountry());
        status = insertUser.executeUpdate();
        con.close();
        return status;
    }

    public static int update(User user) throws SQLException {
        int status = 0;
        Connection con = userDao.getConnection();
        PreparedStatement updateuser = con.prepareStatement("update user set name =?,email=?,country=? where id=?");
        updateuser.setString(1, user.getName());
        updateuser.setString(2, user.getEmail());
        updateuser.setString(4, user.getCountry());
        updateuser.setInt(4, user.getId());
        status = updateuser.executeUpdate();
        return status;
    }

    public static int delete(int id) throws SQLException {
        int status = 0;
        Connection con = userDao.getConnection();
        PreparedStatement deleteuser = con.prepareStatement("delete from user  where id=?");

        deleteuser.setInt(1, id);
        status = deleteuser.executeUpdate();
        return status;
    }

}
