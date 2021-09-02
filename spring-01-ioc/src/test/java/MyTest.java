import com.kuang.demo01.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        /*
        //用户实际是调用的业务层，dao层他们不用接触！
        UserService userService = new UserServiceImpl();

        //有个set后，用户想用什么直接去自己创建就可以了
        userService.setUserDao(new UserDaoMysqlImpl());

        userService.getUser();
        */

        //引用spring容器创建好的对象，以后改调用直接改xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = (UserService) context.getBean("service");
        service.getUser();
    }
}
