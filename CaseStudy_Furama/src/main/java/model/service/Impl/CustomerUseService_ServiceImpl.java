package model.service.Impl;

import model.bean.CustomerUseService;
import model.repository.CustomerUseServiceRepository;
import model.repository.Impl.CustomerUseServiceRepositoryImpl;
import model.service.CustomerUseService_Service;

import java.util.List;

public class CustomerUseService_ServiceImpl implements CustomerUseService_Service {
    CustomerUseServiceRepository customerUseServiceRepository = new CustomerUseServiceRepositoryImpl();
    @Override
    public List<CustomerUseService> findAll() {
        return customerUseServiceRepository.findAll();
    }
}
