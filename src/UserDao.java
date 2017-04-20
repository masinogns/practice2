import java.sql.*;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public abstract class UserDao {
    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setString(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (id, name, password) VALUES (?,?,?)");
        preparedStatement.setString(1,user.getId());
        preparedStatement.setString(2,user.getName());
        preparedStatement.setString(3,user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

}
