package model.repository;

import model.bean.Customer;
import model.bean.Customer_Type;

import java.util.List;

public interface CustomerTypeRepository {
    public List<Customer_Type> findAll();
    public Customer_Type getCustomerTypeById(int id);
}
