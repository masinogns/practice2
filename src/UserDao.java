import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public class UserDao {
    JdbcTemplate jdbcTemplate;



    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public UserDao() {

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from userinfo where id = ?";
        String[] params = new String[]{id};
        User user1 =null;

        try {
            user1 =  jdbcTemplate.queryForObject(sql, params, (resultSet, i) -> {
               User user = new User();
               user.setId(resultSet.getString("id"));
               user.setName(resultSet.getString("name"));
               user.setPassword(resultSet.getString("password"));

               return user;
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user1;
    }




    public void add(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into userinfo (id, name, password) VALUES (?,?,?)";
        String[] params = new String[]{user.getId(),user.getName(), user.getPassword()};

        jdbcTemplate.update(sql, params);

    }


    public void update(User user) throws ClassNotFoundException, SQLException {
        String sql = "update userinfo set name = ? , password = ? where id = ?";
        String[] params = new String[]{user.getName(), user.getPassword(), user.getId()};

        jdbcTemplate.update(sql, params);

    }


    public void delete(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from userinfo where id = ?";
        String[] params = new String[]{id};

        jdbcTemplate.update(sql, params);

    }


}
