package RestMysqlDao;

import java.util.List;

public interface HomeDao {

    public void CreateTableHome();
    public List<String> getAllHomes();
    public void addHome();

}
