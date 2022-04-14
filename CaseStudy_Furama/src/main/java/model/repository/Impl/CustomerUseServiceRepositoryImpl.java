package model.repository.Impl;

import model.bean.CustomerUseService;
import model.repository.BaseRepository;
import model.repository.CustomerUseServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUseServiceRepositoryImpl implements CustomerUseServiceRepository {
    private static final String FIND_ALL = "select cus.customer_id,cus.customer_name,cus.customer_birthday,cus.customer_gender,cus.customer_id_card,cus.customer_phone,cus.customer_email,cus.customer_address,atsv.attach_service_name,sv.service_name\n" +
            "from ((((customer as cus left join contract as ct on cus.customer_id=ct.customer_id)\n" +
            "join service sv on sv.service_id = ct.service_id)\n" +
            "left join contract_detail as ctde on ct.contract_id=ctde.contract_id)\n" +
            "left join attach_service atsv on atsv.attach_service_id = ctde.attach_service_id\n" +
            ");";
    @Override
    public List<CustomerUseService> findAll() {
        List<CustomerUseService> customerUseServices = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                boolean customer_gender = resultSet.getBoolean("customer_gender");
                String customer_id_card =resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                String attach_service_name = resultSet.getString("attach_service_name");
                String service_name = resultSet.getString("service_name");

                CustomerUseService customerUseService = new CustomerUseService(customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,attach_service_name,service_name);
                customerUseServices.add(customerUseService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUseServices;
    }
}
