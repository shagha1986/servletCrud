import org.junit.Assert;
import org.junit.Test;


import java.sql.SQLException;

import static org.junit.Assert.*;

public class testClassTest {
    @Test
    public void as() throws SQLException {

       User u1= new User();
       u1.setName("gozmo");
       u1.setCountry("UK");
       u1.setEmail("gizmo@gmail.com");
       if(userDao.save(u1)>0){
           System.out.print("ok");
       }

    }

}