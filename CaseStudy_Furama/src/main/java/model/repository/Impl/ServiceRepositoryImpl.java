package model.repository.Impl;

import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.ServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private static final String FIND_ALL = "select * from service";
    private static final String ADD_SERVICE= "insert into service(service_name,service_area,service_max_people,rent_type_id,service_type_id,stardard_room,description_other_convenience,pool_area,number_of_floors)\n" +
            "values(?,?,?,?,?,?,?,?,?); ";
    @Override
    public List<Service> findAll() {
        List<Service> services=new ArrayList<>();
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                Double area = resultSet.getDouble("service_area");
                int max_people = resultSet.getInt("service_max_people");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("stardard_room");
                String description = resultSet.getString("description_other_convenience");
                Double pool_area = resultSet.getDouble("pool_area");
                int number_of_floors = resultSet.getInt("number_of_floors");
                Service service = new Service(id,name,area,max_people,rent_type_id,service_type_id,standard_room,description,pool_area,number_of_floors);
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    @Override
    public boolean add(Service service) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_SERVICE);
            preparedStatement.setString(1,service.getService_name());
            preparedStatement.setDouble(2,service.getService_area());
            preparedStatement.setInt(3,service.getService_max_people());
            preparedStatement.setInt(4,service.getRent_type_id());
            preparedStatement.setInt(5,service.getService_type_id());
            preparedStatement.setString(6,service.getStandard_room());
            preparedStatement.setString(7,service.getDescription_other_convenience());
            preparedStatement.setDouble(8,service.getPool_area());
            preparedStatement.setInt(9,service.getNumber_of_floors());
            int check = preparedStatement.executeUpdate();
            if (check != 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
