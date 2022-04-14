package model.repository.Impl;

import model.bean.Contract;
import model.repository.BaseRepository;
import model.repository.ContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository  {
    private static final String FIND_ALL = "select * from contract;";
    private static final String ADD_CONTRACT = "insert into contract(contract_start_day,contract_end_day,contract_deposit,contract_total_money,employee_id,customer_id,service_id)\n" +
            "values (?,?,?,?,?,?,?);";
    
    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_day = resultSet.getString("contract_start_day");
                String contract_end_day = resultSet.getString("contract_end_day");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");
                Contract contract = new Contract(contract_id,contract_start_day,contract_end_day,contract_deposit,contract_total_money,employee_id,customer_id,service_id);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean add(Contract contract) {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CONTRACT);
            preparedStatement.setString(1,contract.getContract_start_date());
            preparedStatement.setString(2,contract.getContract_end_date());
            preparedStatement.setDouble(3,contract.getContract_deposit());
            preparedStatement.setDouble(4,contract.getContract_total_money());
            preparedStatement.setInt(5,contract.getEmployee_id());
            preparedStatement.setInt(6,contract.getCustomer_id());
            preparedStatement.setInt(7,contract.getService_id());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
