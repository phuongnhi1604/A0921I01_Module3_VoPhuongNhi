package model.repository.Impl;

import model.bean.RentType;
import model.repository.BaseRepository;
import model.repository.RentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {
    private static final String FIND_ALL = "select * from rent_type";
    @Override
    public List<RentType> findAll() {
        List<RentType> rentTypes=new ArrayList<>();
        Connection connection= BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                Double cost= resultSet.getDouble("rent_type_cost");
                RentType rentType = new RentType(id,name,cost);
                rentTypes.add(rentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypes;
    }
}
