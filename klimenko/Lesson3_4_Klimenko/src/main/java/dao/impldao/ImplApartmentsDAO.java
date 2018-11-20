package dao.impldao;

import dao.ApartmentsDAO;
import dao.MySqlConnector;
import entity.Apartments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplApartmentsDAO implements ApartmentsDAO {

    private Connection connection;

    public ImplApartmentsDAO() {
        connection = MySqlConnector.getDbConnection();
    }

    public void deleteApartment(int id) {
        String sql = "delete from `real_estate_agency`.`apartments`  where IDApartments = ?; ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addApartment(Apartments apartment) {
        String sql = "INSERT INTO `real_estate_agency`.`apartments` (`address`, `typeEstate`, " +
                "`floor`, `countOfRoom`, `size`, `additionalDescription`) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, apartment);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateApartment(Apartments apartment) {
        String sql = "UPDATE `real_estate_agency`.`apartments` set `address` = ?, `typeEstate` = ?, " +
                "`floor` = ?, `countOfRoom` = ?, `size` = ?, `additionalDescription` = ? " +
                " where IDApartments = ?; ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, apartment);
            statement.setInt(7, apartment.getEstateId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void prepareStatement(PreparedStatement statement, Apartments apartment) throws SQLException {
        statement.setString(1, apartment.getAddress());
        statement.setString(2, apartment.getTypeEstate());
        statement.setInt(3, apartment.getFloor());
        statement.setInt(4, apartment.getCountOfRoom());
        statement.setInt(5, apartment.getSize());
        statement.setString(6, apartment.getAdditionalDescription());
    }

    public Apartments getApartment(int id) {
        String sql = "SELECT * from `real_estate_agency`.`apartments` where IDApartments = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Apartments extractObject(ResultSet resultSet) throws SQLException {

        String address = resultSet.getString("address");
        String typeEstate = resultSet.getString("typeEstate");
        String additionalDescription = resultSet.getString("additionalDescription");
        int floor = resultSet.getInt("floor");
        int countOfRoom = resultSet.getInt("countOfRoom");
        int IDApartments = resultSet.getInt("IDApartments");
        int size = resultSet.getInt("size");

        return new Apartments(address, typeEstate, floor, countOfRoom, size, additionalDescription, IDApartments);
    }

    public List<Apartments> getAllAppartments() {

        String sql = "SELECT * from `real_estate_agency`.`apartments`;";
        ArrayList<Apartments> list = new ArrayList<Apartments>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                list.add(extractObject(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
