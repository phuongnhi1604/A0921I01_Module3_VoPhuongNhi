package model.service;

import model.bean.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public boolean insert(Employee employee);
    public Employee getEmployeeById(int id);
    public boolean delete(int id);
    public boolean edit(Employee employee);
    public List<Employee> search(String searchName, int searchPosition, int searchDivision);
}
