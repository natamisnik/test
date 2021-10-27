import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "Amerika_2021";

    public Connection getDBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =DriverManager.getConnection(url,user,password);
        System.out.println("Connection is successfull to the database" + url);
        return connection;
    }



    }



