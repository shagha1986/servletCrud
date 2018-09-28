import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletViewUsers")
public class ServletViewUsers extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        List<User> userList = null;

            userList = userDao.getAllUsers();

        out.print("<table border='1' width = '80%'>");
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th>" + "<th>Edit</th><th>Delete</th></tr>");
        for (User user : userList) {
            out.print("<tr><td>"+user.getId()+"</td><td>"+user.getName()+"</td><td>"+user.getEmail()+"</td><td>"+user.getCountry()+"</td><td><a href='/ServletUpdate?id="+user.getId()+"'>Edit</a></td><td><a href='ServletDeleteUser?id="+user.getId()+"'>Delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();

    }


}
