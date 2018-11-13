package entity;

public class ConnectionDataStorage {
    String host = "localhost:3306";
    String database = "docs";
    String user = "root";
    String password = "root";

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
