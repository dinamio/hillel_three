package dao.impl;

import dao.PetConnection;
import dao.PetDao;
import model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugen on 12/5/18.
 */
public class JdbcPetDaoImpl implements PetDao {

    private final String SELECT_ALL = "select * from pet";
    private final String SELECT_ALL_BY_NAME = "select * from pet where name = ? ";

    Connection connection;

    public JdbcPetDaoImpl() {
        connection = PetConnection.getInstance().getConnection();

    }

    public void insert(Pet pet) {

    }

    public List<Pet> findAll() {
        List<Pet> result = new ArrayList<Pet>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setId(resultSet.getInt("id"));
                pet.setName(resultSet.getString("name"));
                pet.setAge(resultSet.getInt("age"));
                result.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Pet> findPetsByName(String name) {
        List<Pet> result = new ArrayList<Pet>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setId(resultSet.getInt("id"));
                pet.setName(resultSet.getString("name"));
                pet.setAge(resultSet.getInt("age"));
                result.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Pet find(Integer id) {
        return null;
    }

    public void delete(Integer id) {

    }
}
