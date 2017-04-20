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
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
            preparedStatement.setString(1, id);
            return preparedStatement;
        };
        return jdbcContext.JdbcContextWithStatementStrategyForQuery(statementStrategy);
    }


    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("insert into userinfo (id, name, password) VALUES (?,?,?)");
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            return preparedStatement;
        };
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);

    }


    public void update(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("update userinfo set name = ? , password = ? where id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getId());
            preparedStatement.executeUpdate();
            return preparedStatement;
        };
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);

    }


    public void delete(String id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("delete from userinfo where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return preparedStatement;
        };
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);

    }
}
