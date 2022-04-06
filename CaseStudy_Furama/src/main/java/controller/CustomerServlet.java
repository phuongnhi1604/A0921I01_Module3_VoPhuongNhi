package controller;

import model.bean.Customer;
import model.bean.Customer_Type;
import model.service.CustomerService;
import model.service.CustomerTypeService;
import model.service.Impl.CustomerServiceImpl;
import model.service.Impl.CustomerTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService=new CustomerServiceImpl();
    CustomerTypeService customerTypeService=new CustomerTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
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
                deleteCustomer(request,response);
                break;
            default:
                listCustomer(request,response);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       customerService.delete(id);
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/customer/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=customerService.getCustomerById(id);

        RequestDispatcher dispatcher=request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("customer",customer);
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerTypeList", customerTypeService.findAll());
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/customer/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("customerTypeList",customerTypeService.findAll());
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
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                insertCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type_id = Integer.parseInt(request.getParameter("searchType"));
        String name = request.getParameter("searchName");
        String address = request.getParameter("searchAddress");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customerList",customerService.search(type_id,name,address));
        request.setAttribute("customerTypeList",customerTypeService.findAll());
        String mess="";
        if (customerService.search(type_id,name,address).size()==0)
             mess= "No customers found!";
        request.setAttribute("mess",mess);
        requestDispatcher.forward(request,response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String id_card = request.getParameter("id_card");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email=request.getParameter("email");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String address = request.getParameter("address");

        Customer customer =new Customer(id,name,birthday,id_card,gender,phone,email,customer_type_id,address);
        boolean check = customerService.edit(customer);
        String mess = "Edited customer successfully";
        if (!check){
            mess = "Edit customer unsuccessfully";
        }
        request.setAttribute("mess",mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String id_card = request.getParameter("id_card");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String email=request.getParameter("email");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String address = request.getParameter("address");
        Customer customer = new Customer(name,birthday,id_card,gender,phone,email,customer_type_id,address);
        boolean check = customerService.insert(customer);
        String mess = "Added new customer successfully";
        if (!check){
            mess = "Add new customer unsuccessfully";
        }
        request.setAttribute("mess",mess);

        try {
            request.getRequestDispatcher("view/customer/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
