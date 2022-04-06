package model.service.Impl;

import model.bean.Service_Type;
import model.repository.Impl.ServiceTypeRepositoryImpl;
import model.repository.ServiceTypeRepository;
import model.service.ServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService {
    ServiceTypeRepository serviceTypeRepository=new ServiceTypeRepositoryImpl();
    @Override
    public List<Service_Type> findAll() {
        return serviceTypeRepository.findAll();
    }
}
