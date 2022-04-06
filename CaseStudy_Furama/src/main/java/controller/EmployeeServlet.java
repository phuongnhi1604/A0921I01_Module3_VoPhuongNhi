package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.DivisionRepository;
import model.repository.Impl.DivisionRepositoryImpl;
import model.service.DivisionService;
import model.service.EducationDegreeService;
import model.service.EmployeeService;
import model.service.Impl.DivisionServiceImpl;
import model.service.Impl.EducationDegreeServiceImpl;
import model.service.Impl.EmployeeServiceImpl;
import model.service.Impl.PositionServiceImpl;
import model.service.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private PositionService positionService = new PositionServiceImpl();
    private DivisionService divisionService = new DivisionServiceImpl();
    private EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                listEmployee(request,response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
        request.setAttribute("degreeList",educationDegreeService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.getEmployeeById(id);

        RequestDispatcher dispatcher=request.getRequestDispatcher("view/employee/edit.jsp");
        request.setAttribute("employee",employee);
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("degreeList",educationDegreeService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
        request.setAttribute("degreeList",educationDegreeService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
        request.setAttribute("degreeList",educationDegreeService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                insertEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("searchName");
        int searchPosition = Integer.parseInt(request.getParameter("searchPosition"));
        int searchDivision = Integer.parseInt(request.getParameter("searchDivision"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        request.setAttribute("employeeList",employeeService.search(searchName,searchPosition,searchDivision));
        request.setAttribute("positionList",positionService.findAll());
        request.setAttribute("divisionList",divisionService.findAll());
        request.setAttribute("degreeList",educationDegreeService.findAll());
        String mess="";
        if (employeeService.search(searchName,searchPosition,searchDivision).size()==0)
            mess= "No employees found!";
        request.setAttribute("mess",mess);
        requestDispatcher.forward(request,response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String id_card = request.getParameter("id_card");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email=request.getParameter("email");
        int position = Integer.parseInt(request.getParameter("position_type_id"));
        int degree = Integer.parseInt(request.getParameter("education_degree_id"));
        int division = Integer.parseInt(request.getParameter("division_id"));

        Employee employee = new Employee(id,name,birthday,id_card,phone,email,degree,position,division,salary);
        boolean check = employeeService.edit(employee);
        String mess = "Edited employee successfully";
        if (!check){
            mess = "Edit employee unsuccessfully";
        }
        request.setAttribute("mess",mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String id_card = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email=request.getParameter("email");
        int position = Integer.parseInt(request.getParameter("position"));
        int degree = Integer.parseInt(request.getParameter("degree"));
        int division = Integer.parseInt(request.getParameter("division"));
        //String username = request.getParameter("username");
        Employee employee = new Employee(name,birthday,id_card,phone,email,degree,position,division,salary);
        boolean check = employeeService.insert(employee);
        String mess = "Added new employee successfully";
        if (!check){
            mess = "Add new employee unsuccessfully";
        }
        request.setAttribute("mess",mess);

        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
