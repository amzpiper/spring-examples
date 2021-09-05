import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    /**
     * mybatis测试
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        // spring的bean中注册了sqlSession，可以直接用来
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * spring整合mybatis测试
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        // spring的bean中注册了sqlSession和userMapperImpl，可以直接用来
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = applicationContext.getBean("userMapperImpl", UserMapper.class);
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * spring整合mybatis测试,使用继承SqlSessionDaoSupport
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        // spring的bean中注册了sqlSession和userMapperImpl，可以直接用来
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = applicationContext.getBean("userMapperImpl2", UserMapper.class);
        List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
