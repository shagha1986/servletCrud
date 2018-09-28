import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ServletUpdate")
public class ServletUpdate extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<h1>Edit User Information</h1>");
        int uid = Integer.parseInt(req.getParameter("id"));
        User user = null;

            user = userDao.getUserByid(uid);


        out.print("<form action='/ServletSaveById' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + user.getId() + "'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + user.getName() + "'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='email' value='" + user.getEmail() + "'/></td></tr>");
        out.print("<tr><td>Country:</td><td>");
        out.print("<select name='country' style='width:150px'>");
        String selected = user.getCountry();

        if (selected.equals("USA"))
            out.print("<option selected>USA</option>");
        else
            out.print("<option >USA</option>");

        if (selected.equals("UK"))
            out.print("<option selected>UK</option>");
        else
            out.print("<option >UK</option>");
        if (selected.equals("Deutschland"))
            out.print("<option selected>Deutschland</option>");
        else
            out.print("<option >Deutschland</option>");

        if (selected.equals("Other"))
            out.print("<option selected>Other</option>");
        else
            out.print("<option >Other</option>");

        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");


    }


}
