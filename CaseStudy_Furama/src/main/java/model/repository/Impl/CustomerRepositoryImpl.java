package model.repository.Impl;

import model.bean.Customer;
import model.bean.Customer_Type;
import model.repository.BaseRepository;
import model.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String FIND_ALL = "select * from customer";
    private static final String ADD_CUSTOMER = "insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)\n" +
            "values (?,?,?,?,?,?,?,?);";
    private static final String FIND_CUSTOMER_BY_ID = "select * from customer where customer_id=?;";
    private static final String UPDATE_CUSTOMER_BY_ID="update customer set customer_type_id=?, customer_name=?, customer_birthday=?, customer_gender=?,customer_id_card=?, customer_phone=?,customer_email=?,customer_address=? where customer_id=?;";
    private static final String DELETE_CUSTOMER="delete from customer where customer_id=?;";
    private static final String SEARCH = "select * from customer where customer_type_id like ? and customer_name like ? and customer_address like ?;";

    @Override
    public List<Customer> findAll() {
        List<Customer> customers=new ArrayList<>();
        Connection connection= BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            System.out.println(preparedStatement);

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int customer_id=resultSet.getInt("customer_id");
                int customer_type_id=resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday=resultSet.getString("customer_birthday");
                boolean customer_gender = resultSet.getBoolean("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                Customer customer=new Customer(customer_id,customer_name,customer_birthday,customer_id_card,customer_gender,customer_phone,customer_email,customer_type_id,customer_address);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean insert(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
            preparedStatement.setInt(1,customer.getCustomer_type_id());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setBoolean(4,customer.isGender());
            preparedStatement.setString(5,customer.getId_card());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getCustomer_address());
            int check = preparedStatement.executeUpdate();
            if (check != 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int customer_type_id=resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday=resultSet.getString("customer_birthday");
                boolean customer_gender = resultSet.getBoolean("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer=new Customer(id,customer_name,customer_birthday,customer_id_card,customer_gender,customer_phone,customer_email,customer_type_id,customer_address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean edit(Customer customer) {
        boolean rowUpdated = false;
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,customer.getCustomer_type_id());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setBoolean(4,customer.isGender());
            preparedStatement.setString(5,customer.getId_card());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getCustomer_address());
            preparedStatement.setInt(9,customer.getId());
            rowUpdated=preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> search(String searchType, String searchName, String searchAddress) {
        List<Customer> customers=new ArrayList<>();
        Connection connection= BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%"+searchType+"%");
            preparedStatement.setString(2,"%"+searchName+"%");
            preparedStatement.setString(3,"%"+searchAddress+"%");

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int customer_id=resultSet.getInt("customer_id");
                int customer_type_id=resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday=resultSet.getString("customer_birthday");
                boolean customer_gender = resultSet.getBoolean("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                Customer customer=new Customer(customer_id,customer_name,customer_birthday,customer_id_card,customer_gender,customer_phone,customer_email,customer_type_id,customer_address);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
