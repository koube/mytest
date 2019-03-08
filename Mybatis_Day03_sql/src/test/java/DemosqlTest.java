import com.itheima.dao.UserDao;
import com.itheima.domain.QueryVO;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemosqlTest {
    private InputStream is;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    @Test
    public void Testsql(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user =new User();
        user.setUsername("%王%");
        user.setSex("男");
        List<User> users = mapper.findUser(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void Testfor(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        QueryVO queryVO=new QueryVO();
        queryVO.setIds(new Integer[]{45,46,47,48});
        List<User> users = mapper.findByIDS(queryVO);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        factory = sqlSessionFactoryBuilder.build(is);
        sqlSession = factory.openSession();

    }
    @After
    public void detory() throws IOException {
        sqlSession.close();
        is.close();
    }


}
