package model.service.Impl;

import model.bean.Education_Degree;
import model.repository.EducationDegreeRepository;
import model.repository.Impl.EducationDegreeRepositoryImpl;
import model.service.EducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeService {
    EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<Education_Degree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
