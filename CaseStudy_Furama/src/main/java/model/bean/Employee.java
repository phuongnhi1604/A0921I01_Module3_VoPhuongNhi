package model.bean;

public class Employee extends Person{
    private int education_degree_id;
    private int position_id;
    private int division_id;
    private double employee_salary;
    private String username;

    public Employee() {
        super();
    }

    public Employee(int id, String name, String birthday, String id_card, String phone, String email, int education_degree_id, int position_id, int division_id, double employee_salary) {
        super(id, name, birthday, id_card, phone, email);
        this.education_degree_id = education_degree_id;
        this.position_id = position_id;
        this.division_id = division_id;
        this.employee_salary = employee_salary;
    }

    public Employee(int id, String name, String birthday, String id_card, String phone, String email, int education_degree_id, int position_id, int division_id, double employee_salary, String username) {
        super(id, name, birthday, id_card, phone, email);
        this.education_degree_id = education_degree_id;
        this.position_id = position_id;
        this.division_id = division_id;
        this.employee_salary = employee_salary;
        this.username = username;
    }


    public Employee(String name, String birthday, String id_card, String phone, String email, int education_degree_id, int position_id, int division_id, double employee_salary, String username) {
        super(name, birthday, id_card, phone, email);
        this.education_degree_id = education_degree_id;
        this.position_id = position_id;
        this.division_id = division_id;
        this.employee_salary = employee_salary;
        this.username = username;
    }

    public Employee(String name, String birthday, String id_card, String phone, String email, int education_degree_id, int position_id, int division_id, double employee_salary) {
        super(name, birthday, id_card, phone, email);
        this.education_degree_id = education_degree_id;
        this.position_id = position_id;
        this.division_id = division_id;
        this.employee_salary = employee_salary;

    }
    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
