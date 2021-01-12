import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcConnection {

    // just a simple JDBC connection
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/students";
        String user = "root";
        String password = "root";

        try {
            Connection myConnections = DriverManager.getConnection(url, user, password);
            Statement statement = myConnections.createStatement();

            // create new Table
            String sql3 = "create table students.data5 (id VARCHAR(255) ,name VARCHAR(255))";
            statement.execute(sql3);


            // insert into database
            String sql2 = "insert into students.data5 (id,name) values(\"102\",\"shantam\")";
            statement.execute(sql2);

            // read for database
            String sql1 = "SELECT * FROM students.data5";
            ResultSet resultSet = statement.executeQuery(sql1);

            // print
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("id")+"   "+resultSet.getString("name"));
            }

            String sql4 = "DROP table students.data2";
            statement.execute(sql4);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
