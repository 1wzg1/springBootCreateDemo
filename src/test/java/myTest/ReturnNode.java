package myTest;

import com.ztc.springB.SpringBApplication;
import com.ztc.springB.model.User;
import com.ztc.springB.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReturnNode{

    @Autowired
    private IUserService userService;

    @Test
    public  void testT(){
        //List<User> list = userService.getList();
        System.out.println("list");
    }


}
