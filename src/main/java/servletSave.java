import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "servletSave")
public class servletSave extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        int status = 0;
        try {
            status = userDao.save(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (status > 0) {
           res.sendRedirect("/ServletViewUsers");
        } else {
            out.println("user is not saved ! ");
        }
        out.close();
    }


}
