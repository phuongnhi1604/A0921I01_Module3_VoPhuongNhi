package model.service.Impl;

import model.bean.Service;
import model.repository.Impl.ServiceRepositoryImpl;
import model.repository.ServiceRepository;
import model.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceRepository serviceRepository=new ServiceRepositoryImpl();
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean add(Service service) {
        return serviceRepository.add(service);
    }


}
