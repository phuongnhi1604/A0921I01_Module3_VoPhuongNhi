package model.service;

import model.bean.Education_Degree;
import model.repository.EducationDegreeRepository;

import java.util.List;

public interface EducationDegreeService {
    public List<Education_Degree> findAll();
}
