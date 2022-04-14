package model.service.Impl;

import common.Validation;
import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.Impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository=new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<String> insert(Customer customer) {
        List<String> messList = new ArrayList<>();
        boolean check= true;
        // check tên
        if (Validation.checkName(customer.getName())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Name is not in the correct format!");
        }

        //check phone
        if (Validation.checkPhone(customer.getPhone())){
            messList.add("");
        }else {
            check=false;
            messList.add("The NumberPhone is not in the correct format.");
        }

        //check id_card
        if (Validation.checkIdCard(customer.getId_card())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Id_Card is not in the correct format.");
        }

        //check email
        if (Validation.checkEmail(customer.getEmail())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Email is not in the correct format!");
        }
        if (check){
            // cho lưu
            customerRepository.insert(customer);
        }
        return messList;
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
    public List<String>  edit(Customer customer) {
        List<String> messList = new ArrayList<>();
        boolean check= true;
        // check tên
        if (Validation.checkName(customer.getName())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Name is not in the correct format!");
        }

        //check phone
        if (Validation.checkPhone(customer.getPhone())){
            messList.add("");
        }else {
            check=false;
            messList.add("The NumberPhone is not in the correct format.");
        }

        //check id_card
        if (Validation.checkIdCard(customer.getId_card())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Id_Card is not in the correct format.");
        }

        //check email
        if (Validation.checkEmail(customer.getEmail())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Email is not in the correct format!");
        }
        if (check){
            // cho lưu
            customerRepository.edit(customer);
        }
        return messList;
    }

    @Override
    public List<Customer> search(String searchType, String searchName, String searchAddress) {
        return customerRepository.search(searchType,searchName,searchAddress);
    }
}
