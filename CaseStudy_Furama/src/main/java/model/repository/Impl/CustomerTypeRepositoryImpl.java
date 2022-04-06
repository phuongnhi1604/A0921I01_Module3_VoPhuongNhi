package model.repository.Impl;

import model.bean.Customer_Type;
import model.repository.BaseRepository;
import model.repository.CustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private static final String FIND_ALL ="select * from customer_type";
    private static final String FIND_CUSTOMER_TYPE_BY_ID = "select * from customer_type where customer_type_id=?";
    @Override
    public List<Customer_Type> findAll() {
        List<Customer_Type> list=new ArrayList<>();
        Connection connection= BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("customer_type_id");
                String name=resultSet.getString("customer_type_name");
                Customer_Type customer_type=new Customer_Type(id,name);
                list.add(customer_type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer_Type getCustomerTypeById(int id) {
        return null;
    }
}
