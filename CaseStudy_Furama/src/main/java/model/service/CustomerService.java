package model.service;

import model.bean.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public List<String> insert(Customer customer);
    public Customer getCustomerById(int id);
    public boolean delete(int id);
    public List<String> edit(Customer customer);
    public List<Customer> search(String searchType, String searchName, String searchAddress);
}
