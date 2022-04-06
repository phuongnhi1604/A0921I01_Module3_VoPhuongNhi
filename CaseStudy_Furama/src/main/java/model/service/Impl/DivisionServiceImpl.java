package model.service.Impl;

import model.bean.Division;
import model.repository.DivisionRepository;
import model.repository.Impl.DivisionRepositoryImpl;
import model.service.DivisionService;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
