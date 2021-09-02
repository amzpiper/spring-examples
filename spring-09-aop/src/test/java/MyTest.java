import com.kuang.demo01.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    /**
     * 方式一：原生SpringAOP接口
     */
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //主要动态代理代理的是接口,必须写接口
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }

    /**
     * 方式二：自定义类,更加容易明确了,方式一比方式二更强大，可以操作类的方法
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //主要动态代理代理的是接口,必须写接口
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }

    /**
     * 方式三：自定义类,更加容易明确了,方式一比方式二更强大，可以操作类的方法
     */
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //主要动态代理代理的是接口,必须写接口
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }
}
