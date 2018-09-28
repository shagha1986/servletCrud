import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ServletSaveById")
public class ServletSaveById extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int status = 0;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int uid = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User useredit = new User();
        useredit.setId(uid);
        useredit.setName(name);
        useredit.setEmail(email);
        useredit.setCountry(country);

            status = userDao.update(useredit);

        if(status > 0){

            res.sendRedirect("/ServletViewUsers");




        }else {
            out.print("can not Edit this user");
        }


    }

}
