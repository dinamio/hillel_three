package dao.impldaoJDBC;

import dao.ApartmentsDAO;
import dao.MySqlConnector;
import entity.Apartment;
import entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
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

    public void addApartment(Apartment apartment) {
        String sql = "INSERT INTO `real_estate_agency`.`apartments` (`address`, `typeEstate`, " +
                "`floor`, `countOfRoom`, `size`, `additionalDescription`, `user_id`, `date`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, apartment);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateApartment(Apartment apartment) {
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

    public void prepareStatement(PreparedStatement statement, Apartment apartment) throws SQLException {
        statement.setString(1, apartment.getAddress());
        statement.setString(2, apartment.getTypeEstate());
        statement.setInt(3, apartment.getFloor());
        statement.setInt(4, apartment.getCountOfRoom());
        statement.setInt(5, apartment.getSize());
        statement.setString(6, apartment.getAdditionalDescription());
        if(apartment.getUser()!=null)
            statement.setInt(7, (apartment.getUser().getId()));
        if(apartment.getDate()!=null)
            statement.setString(8, apartment.getDate());
    }

    public Apartment getApartment(int id) {
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

    public Apartment extractObject(ResultSet resultSet) throws SQLException {

        String address = resultSet.getString("address");
        String typeEstate = resultSet.getString("typeEstate");
        String additionalDescription = resultSet.getString("additionalDescription");
        int floor = resultSet.getInt("floor");
        int countOfRoom = resultSet.getInt("countOfRoom");
        int IDApartments = resultSet.getInt("IDApartments");
        int size = resultSet.getInt("size");
        String date = resultSet.getString("date");
        User user = new ImplUserDAO().getUser(resultSet.getInt("user"));

        return new Apartment(address, typeEstate, floor, countOfRoom, size, additionalDescription, IDApartments, user, date);
    }

    public List<Apartment> getAllAppartments() {

        String sql = "SELECT * from `real_estate_agency`.`apartments` as ap " +
                "inner JOIN real_estate_agency.users as us on ap.user_id = us.user_id;";
        ArrayList<Apartment> list = new ArrayList<Apartment>();

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
