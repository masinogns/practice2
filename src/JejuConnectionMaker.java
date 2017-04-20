import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 20..
 */
public class JejuConnectionMaker implements ConnectionMaker{
    String driverclass;
    String url;
    String username ;
    String password ;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverclass);
        return DriverManager.getConnection(url, username, password);

    }

    public void setDriverclass(String driverclass) {
        this.driverclass = driverclass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverclass() {
        return driverclass;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
