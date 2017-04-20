import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public class GetUserStatementStrategy implements StatementStrategy {
    String id;

    public GetUserStatementStrategy(String id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setString(1, id);
        return preparedStatement;
    }
}
