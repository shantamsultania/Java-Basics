package RestMysqlDao;

import java.util.List;

public interface HomeDao {

    public String CreateTableHome();
    public List<String> getAllHomes();
    public void addHome();

}
