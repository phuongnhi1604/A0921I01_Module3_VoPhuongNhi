package model.repository.Impl;

import model.bean.Contract_Detail;
import model.repository.BaseRepository;
import model.repository.ContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Contract_DetailRepositoryImpl implements ContractDetailRepository {
    private static final String FIND_ALL = "select * from contract_detail;";
    private static final String ADD_CONTRACT_DETAIL = "insert into contract_detail(contract_id,attach_service_id,quantity)\n" +
            "values(?,?,?);";
    @Override
    public List<Contract_Detail> findAll() {
        Connection connection = BaseRepository.getConnection();
        List<Contract_Detail> contract_details = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int contract_detail_id = resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                Contract_Detail contract_detail = new Contract_Detail(contract_detail_id,contract_id,attach_service_id,quantity);
                contract_details.add(contract_detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract_details;
    }

    @Override
    public boolean add(Contract_Detail contract_detail) {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CONTRACT_DETAIL);
            preparedStatement.setInt(1,contract_detail.getContract_id());
            preparedStatement.setInt(2,contract_detail.getAttach_service_id());
            preparedStatement.setInt(3,contract_detail.getQuantity());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
