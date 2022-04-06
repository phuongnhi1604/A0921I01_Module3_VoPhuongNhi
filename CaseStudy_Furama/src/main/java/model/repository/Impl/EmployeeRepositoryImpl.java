package model.repository.Impl;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.EmployeeRepository;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String FIND_ALL = "select * from employee;";
    private static final String ADD_EMPLOYEE = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,position_id,\n" +
            "education_degree_id,division_id) values (?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEE = "update employee set employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?,employee_email=?,position_id=?,\n" +
            "education_degree_id=?,division_id=? where employee_id = ?;";
    private static final String FIND_EMPLOYEE_BY_ID = "select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,position_id,\n" +
            "education_degree_id,division_id from employee where employee_id=?;";
    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id=?;";
    private static final String SEARCH_EMPLOYEE = "select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,position_id,\n" +
            "education_degree_id,division_id from employee where employee_name like ? and position_id =? and  division_id=?;";
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String id_card = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id=resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                //String username = resultSet.getString("username");
                Employee employee = new Employee(id,name,birthday,id_card,phone,email,education_degree_id,position_id,division_id,salary);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public boolean insert(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getId_card());
            preparedStatement.setDouble(4,employee.getEmployee_salary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setInt(7,employee.getPosition_id());
            preparedStatement.setInt(8,employee.getEducation_degree_id());
            preparedStatement.setInt(9,employee.getDivision_id());
            //preparedStatement.setString(10,employee.getUsername());
            int check = preparedStatement.executeUpdate();
            if (check != 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday=resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                employee = new Employee(id,employee_name,employee_birthday,employee_id_card,employee_phone,employee_email,education_degree_id,position_id,division_id,employee_salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean edit(Employee employee) {
        boolean rowUpdated = false;
        Connection connection=BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getId_card());
            preparedStatement.setDouble(4,employee.getEmployee_salary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setInt(7,employee.getPosition_id());
            preparedStatement.setInt(8,employee.getEducation_degree_id());
            preparedStatement.setInt(9,employee.getDivision_id());
            preparedStatement.setInt(10,employee.getId());
            rowUpdated=preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Employee> search(String searchName, int searchPosition, int searchDivision) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE);
            preparedStatement.setString(1,"%"+searchName+"%");
            preparedStatement.setInt(2,searchPosition);
            preparedStatement.setInt(3,searchDivision);

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                Double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                Employee employee = new Employee(id,employee_name,employee_birthday,employee_id_card,employee_phone,employee_email,education_degree_id,position_id,division_id,employee_salary);
                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}
