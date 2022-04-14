package model.service.Impl;

import common.Validation;
import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.Impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<String> insert(Employee employee) {
        List<String> messList = new ArrayList<>();
        boolean check= true;
        // check tên
        if (Validation.checkName(employee.getName())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Name is not in the correct format!");
        }

        //check id_card
        if (Validation.checkIdCard(employee.getId_card())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Id_Card is not in the correct format.");
        }

        //check salary
        if (Validation.checkNumber(String.valueOf(employee.getEmployee_salary()))){
            messList.add("");
        }else {
            check = false;
            messList.add("The salary is not in the correct format.");
        }
        //check phone
        if (Validation.checkPhone(employee.getPhone())){
            messList.add("");
        }else {
            check=false;
            messList.add("The NumberPhone is not in the correct format.");
        }

        //check email
        if (Validation.checkEmail(employee.getEmail())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Email is not in the correct format!");
        }
        if (check){
            // cho lưu
            employeeRepository.insert(employee);
        }
        return messList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public List<String> edit(Employee employee) {
        List<String> messList = new ArrayList<>();
        boolean check= true;
        // check tên
        if (Validation.checkName(employee.getName())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Name is not in the correct format!");
        }

        //check id_card
        if (Validation.checkIdCard(employee.getId_card())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Id_Card is not in the correct format.");
        }

        //check salary
        if (Validation.checkNumber(String.valueOf(employee.getEmployee_salary()))){
            messList.add("");
        }else {
            check = false;
            messList.add("The salary is not in the correct format.");
        }
        //check phone
        if (Validation.checkPhone(employee.getPhone())){
            messList.add("");
        }else {
            check=false;
            messList.add("The NumberPhone is not in the correct format.");
        }

        //check email
        if (Validation.checkEmail(employee.getEmail())){
            messList.add("");
        }else {
            check=false;
            messList.add("The Email is not in the correct format!");
        }
        if (check){
            // cho lưu
            employeeRepository.edit(employee);
        }
        return messList;
    }

    @Override
    public List<Employee> search(String searchName, String searchPosition, String searchDivision) {
        return employeeRepository.search(searchName,searchPosition,searchDivision);
    }
}
