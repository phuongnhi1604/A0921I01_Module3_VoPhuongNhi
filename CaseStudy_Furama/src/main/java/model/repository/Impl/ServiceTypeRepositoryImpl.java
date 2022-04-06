package model.repository.Impl;

import model.bean.Service_Type;
import model.repository.BaseRepository;
import model.repository.ServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository {
    private static final String FIND_ALL = "select * from service_type";
    @Override
    public List<Service_Type> findAll() {
        List<Service_Type> customer_types=new ArrayList<>();
        Connection connection= BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                Service_Type service_type=new Service_Type(id,name);
                customer_types.add(service_type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer_types;
    }
}
