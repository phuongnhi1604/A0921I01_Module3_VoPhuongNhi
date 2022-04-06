package model.service.Impl;

import model.bean.RentType;
import model.repository.Impl.RentTypeRepositoryImpl;
import model.repository.RentTypeRepository;
import model.service.RentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
