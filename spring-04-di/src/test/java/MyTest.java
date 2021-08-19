import com.kuang.pojo.Student;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
        /*
        Student{name='kuang', address=Address{address='address'}, books=[红楼梦, 西游戏, 三国演义, 水浒传], hobbys=[听歌, 代码, 电影], card={身份证=123, 银行卡=456}, games=[VC, LOL], info={学号=001, 邮箱=123456@qq.com}, wife='null'}
         */
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User student = context.getBean("p-user",User.class);
        System.out.println(student.toString());
    }
}
