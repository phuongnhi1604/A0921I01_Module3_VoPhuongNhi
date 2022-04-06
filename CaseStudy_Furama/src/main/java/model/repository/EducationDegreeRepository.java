package model.repository;

import model.bean.Education_Degree;

import java.util.List;

public interface EducationDegreeRepository {
    public List<Education_Degree> findAll();
}
