package model.service.Impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.Impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean insert(Employee employee) {
        return employeeRepository.insert(employee);
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
    public boolean edit(Employee employee) {
        return employeeRepository.edit(employee);
    }

    @Override
    public List<Employee> search(String searchName, int searchPosition, int searchDivision) {
        return employeeRepository.search(searchName,searchPosition,searchDivision);
    }
}
