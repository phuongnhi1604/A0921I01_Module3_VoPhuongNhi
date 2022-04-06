package model.repository.Impl;

import jdk.nashorn.internal.ir.SplitReturn;
import model.bean.Attach_Service;
import model.repository.Attach_ServiceRepository;
import model.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Attach_ServiceRepositoryImpl implements Attach_ServiceRepository {
    private static final String FIND_ALL = "select * from attach_service;";
    @Override
    public List<Attach_Service> findAll() {
        List<Attach_Service> attach_serviceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int attach_service_id = resultSet.getInt("attach_service_id");
                String attach_service_name = resultSet.getString("attach_service_name");
                double attach_service_cost = resultSet.getDouble("attach_service_cost");
                int attach_service_unit = resultSet.getInt("attach_service_unit");
                String attach_service_status =resultSet.getString("attach_service_status");
                Attach_Service attach_service = new Attach_Service(attach_service_id,attach_service_name,attach_service_cost,attach_service_unit,attach_service_status);
                attach_serviceList.add(attach_service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attach_serviceList;
    }
}
