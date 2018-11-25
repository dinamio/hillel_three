package entity;

public class ConnectionDataStorage {
    private static final String host = "localhost:3306";
    private static final String database = "docs";
    private static final String user = "root";
    private static final String password = "root";

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
