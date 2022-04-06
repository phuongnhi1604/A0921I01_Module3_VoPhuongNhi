package model.service.Impl;

import model.bean.Attach_Service;
import model.repository.Attach_ServiceRepository;
import model.repository.Impl.Attach_ServiceRepositoryImpl;
import model.service.Attach_ServiceService;

import java.util.List;

public class Attach_ServiceServiceImpl implements Attach_ServiceService {
    Attach_ServiceRepository attach_serviceRepository = new Attach_ServiceRepositoryImpl();
    @Override
    public List<Attach_Service> findAll() {
        return attach_serviceRepository.findAll();
    }
}
