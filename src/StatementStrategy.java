import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public interface StatementStrategy {
    public PreparedStatement makeStatement(Connection connection) throws SQLException;
}
