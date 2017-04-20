import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public class UserDaoTest {
    UserDao userDao;

    @Before
    public void setup(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        String id = "1";
        String name = "masinogns";
        String password = "masinogns";

        User getUser = userDao.get(id);

        assertThat(id, is(getUser.getId()));
    }



    @Test
    public void add() throws SQLException, ClassNotFoundException {
        String id = String.valueOf(new Random().nextInt());
        String name = "masinogns";
        String password = "masinogns";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.add(user);
        User addUser = userDao.get(id);

        assertThat(id, is(addUser.getId()));
        assertThat(name, is(addUser.getName()));
        assertThat(password, is(addUser.getPassword()));
    }
}
