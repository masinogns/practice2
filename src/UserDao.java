import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public class UserDao {

    JdbcContext jdbcContext;


    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }



    public UserDao() {

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetUserStatementStrategy(id);


        return jdbcContext.JdbcContextWithStatementStrategyForQuery(statementStrategy);
    }


    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddUserStatementStrategy(user);


        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);

    }


    public void update(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new UpdateUserStatementStrategy(user);


        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);

    }


    public void delete(String id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new DeleteUserStatementStrategy(id);


        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);

    }
}
