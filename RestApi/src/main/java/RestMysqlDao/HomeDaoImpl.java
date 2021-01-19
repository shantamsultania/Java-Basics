package RestMysqlDao;

import com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HomeDaoImpl implements HomeDao{

    @Autowired
    JdbcTemplate jdbc;

    public HomeDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public String CreateTableHome() {
        String sql = "create table students.home(id VARCHAR(255),name Varchar (255))";
        jdbc.execute(sql);
        return "table created";
    }

    @Override
    public List<String> getAllHomes() {
            return null;
    }

    @Override
    public void addHome() {
        String sql = "insert into students.home (id,name) values(\"101\",\"trial\")";
        jdbc.execute(sql);
    }
}
