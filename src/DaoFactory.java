/**
 * Created by masinogns on 2017. 4. 20..
 */
public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
