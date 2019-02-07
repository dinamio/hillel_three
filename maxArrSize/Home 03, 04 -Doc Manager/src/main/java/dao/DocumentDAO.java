package dao;

import model.Document;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DocumentDAO {
    public void add(Document doc) throws SQLException;
    public void update(Document doc) throws SQLException;
    public void delete(int id) throws SQLException;
    public Document getByID(int id) throws SQLException;
    public ArrayList<Document> getAll() throws SQLException;
    public int getNumRow() throws SQLException;
}
