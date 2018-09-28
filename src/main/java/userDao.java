

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDao  {
    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

    public static int update(User user)  {
        int status = 0;
        Connection con = userDao.getConnection();
        try {
            PreparedStatement updateuser = con.prepareStatement("update user set name =?,email=?,country=? where id=?");
            updateuser.setInt(4, user.getId());
            updateuser.setString(1, user.getName());
            updateuser.setString(2, user.getEmail());
            updateuser.setString(3, user.getCountry());

            status = updateuser.executeUpdate();

        }catch (Exception e){e.printStackTrace();}

        return status;
    }

    public static int delete(int id)  {
        int status = 0;

        try {
            Connection con = userDao.getConnection();
            PreparedStatement deleteuser = con.prepareStatement("delete from user  where id=?");

            deleteuser.setInt(1, id);
            status = deleteuser.executeUpdate();

        }catch (SQLException e){e.printStackTrace();}

        return status;
    }
    public static User getUserByid(int id){
        User user = new User();
        try{
            Connection con = userDao.getConnection();
        PreparedStatement getUser = con.prepareStatement("select * from user  where id=?");
        getUser.setInt(1,id);
        ResultSet rs = getUser.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setCountry(rs.getString(4));}


            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
        public static List<User> getAllUsers() {
        Connection con = userDao.getConnection();
        List<User> userlist = new ArrayList<User>();
        try{

            PreparedStatement getAllUsers = con.prepareStatement("select * from user");
            ResultSet rs = getAllUsers.executeQuery();
            while (rs.next()){
                User user = new User();
               user.setId(rs.getInt(1));
               user.setName(rs.getString(2));
               user.setEmail(rs.getString(3));
               user.setCountry(rs.getString(4));
               userlist.add(user);
            }
            con.close();

        }catch(Exception e){e.printStackTrace();}
        return userlist;
    }

}
