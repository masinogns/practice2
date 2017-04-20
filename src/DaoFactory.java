import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by masinogns on 2017. 4. 20..
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public JejuConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
