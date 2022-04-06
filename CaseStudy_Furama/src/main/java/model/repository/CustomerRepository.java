package model.repository;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> findAll();
    public boolean insert(Customer customer);
    public Customer getCustomerById(int id);
    public boolean delete(int id);
    public boolean edit(Customer customer);
    public List<Customer> search(int searchType, String searchName, String searchAddress);
}
