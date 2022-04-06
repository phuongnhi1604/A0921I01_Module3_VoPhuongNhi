package model.service.Impl;

import model.bean.Customer_Type;
import model.repository.CustomerRepository;
import model.repository.CustomerTypeRepository;
import model.repository.Impl.CustomerRepositoryImpl;
import model.repository.Impl.CustomerTypeRepositoryImpl;
import model.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository=new CustomerTypeRepositoryImpl();
    @Override
    public List<Customer_Type> findAll() {
        return customerTypeRepository.findAll();
    }
}
