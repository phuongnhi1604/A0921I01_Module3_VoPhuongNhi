package model.repository.Impl;

import model.bean.Education_Degree;
import model.repository.BaseRepository;
import model.repository.EducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements EducationDegreeRepository {
    private static final String FIND_ALL = "select * from education_degree";
    @Override
    public List<Education_Degree> findAll() {
        List<Education_Degree> education_degrees = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                Education_Degree education_degree = new Education_Degree(id, name);
                education_degrees.add(education_degree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return education_degrees;
    }
}
