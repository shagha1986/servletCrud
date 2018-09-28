import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteUser")
public class ServletDeleteUser extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int status = 0;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));

            status = userDao.delete(id);

        if(status > 0){

            res.sendRedirect("/ServletViewUsers");




        }else {
            out.print("can not Delete this user");
        }


    }
}
