package model.service;

import model.bean.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public List<String> insert(Employee employee);
    public Employee getEmployeeById(int id);
    public boolean delete(int id);
    public List<String> edit(Employee employee);
    public List<Employee> search(String searchName, String searchPosition, String searchDivision);
}
