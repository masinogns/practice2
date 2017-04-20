import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public class UpdateUserStatementStrategy implements StatementStrategy{
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        User user = (User)object;
        preparedStatement = connection.prepareStatement("update userinfo set name = ? , password = ? where id = ?");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getId());
        preparedStatement.executeUpdate();
        return preparedStatement;
    }
}
