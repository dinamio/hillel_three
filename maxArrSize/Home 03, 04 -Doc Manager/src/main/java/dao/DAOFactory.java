package dao;

import service.DocumentService;
import service.UserService;

import java.sql.SQLException;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();
    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public DocumentService getDocDAO() throws SQLException {
        return new DocumentService();
    }

    public UserService getUserDAO() throws Exception {
        return new UserService();
    }

}
