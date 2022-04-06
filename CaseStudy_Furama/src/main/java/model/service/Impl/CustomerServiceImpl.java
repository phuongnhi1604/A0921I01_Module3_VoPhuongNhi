package model.service.Impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.Impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository=new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean insert(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean edit(Customer customer) {
        return customerRepository.edit(customer);
    }

    @Override
    public List<Customer> search(int searchType, String searchName, String searchAddress) {
        return customerRepository.search(searchType,searchName,searchAddress);
    }
}
