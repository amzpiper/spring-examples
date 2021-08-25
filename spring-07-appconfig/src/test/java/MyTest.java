import com.kuang.config.MyConfig;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test() {
        //如果完全使用了配置类方式做，只能通过AnnotationConfigApplicationContext来获取容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = context.getBean("getUser2", User.class);
        System.out.println(user.getName());
    }
}
