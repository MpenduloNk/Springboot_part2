import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import sun.security.tools.keytool.Main;

@SpringBootTest(classes = Main.class)
public class UserServiceTest {
    @Autowired
    SecurityProperties.User userServiceImpl;


    @Test
    public void cachingTest(){
        String name1 = userServiceImpl.getName();
        String name2 = userServiceImpl.getName();
        String name3 = userServiceImpl.getName();

        System.out.println(name1+" "+name2+" "+name3);
    }

    //Still To DO....
    //....
}
