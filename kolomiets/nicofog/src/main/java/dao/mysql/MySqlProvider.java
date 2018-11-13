package dao.mysql;

import util.Proretry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mihail on 11/9/18.
 */
public class MySqlProvider {

    private Connection connection;

    public MySqlProvider() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Proretry.BASEURL, Proretry.dbUSER, Proretry.dbPASSWORD);

            //init database & connect
            createDb();

        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        } catch (SQLException e) {
            System.out.println("connection error");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * Create database and table need for project if is does not exist.
     * Create connection for project database
     */
    private void createDb() {

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SHOW DATABASES LIKE 'nicofog'");
            if (!resultSet.next()) {
                System.out.println("its ok");
                connection.createStatement().execute("CREATE DATABASE nicofog;");
                connection.createStatement().execute("USE nicofog;");
                connection.createStatement().execute("CREATE TABLE user(id int PRIMARY KEY AUTO_INCREMENT,name varchar(20)," +
                        "role VARCHAR (20), sigaretPrice int (7), dateRegistration VARCHAR (23));");
            }

            connection = DriverManager.getConnection(Proretry.BASEURL.concat("/nicofog"), Proretry.dbUSER, Proretry.dbPASSWORD);

        } catch (SQLException e) {
            System.out.println("Trouble with connection: " + e);
        }

    }
}
