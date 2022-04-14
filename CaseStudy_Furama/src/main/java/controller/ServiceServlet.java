package controller;

import model.bean.Customer;
import model.bean.Service;
import model.repository.BaseRepository;
import model.service.Impl.RentTypeServiceImpl;
import model.service.Impl.ServiceServiceImpl;
import model.service.Impl.ServiceTypeServiceImpl;
import model.service.RentTypeService;
import model.service.ServiceService;
import model.service.ServiceTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();
    ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();
    RentTypeService rentTypeService = new RentTypeServiceImpl();
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
            case "sort":
                showSortList(request,response);
                break;
            default:
                listService(request,response);
        }
    }

    private void showSortList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/sort.jsp");
        request.setAttribute("serviceList",serviceService.sortArea());
        request.setAttribute("serviceTypeList",serviceTypeService.findAll());
        request.setAttribute("rentTypeList",rentTypeService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("serviceTypeList",serviceTypeService.findAll());
        request.setAttribute("rentTypeList",rentTypeService.findAll());
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/service/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/list.jsp");
        request.setAttribute("serviceList",serviceService.findAll());
        request.setAttribute("serviceTypeList",serviceTypeService.findAll());
        request.setAttribute("rentTypeList",rentTypeService.findAll());
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
        if (action == null) {
            action = "";
        }
        switch (action){
            case "add":
                insertService(request,response);
                break;
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double area = Double.parseDouble(request.getParameter("area"));
        int max_people = Integer.parseInt(request.getParameter("max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));

        String standard_room = request.getParameter("standard_room");
        String description=request.getParameter("description");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));

        Service service = new Service(name,area,max_people,rent_type_id,service_type_id,standard_room,description,pool_area,number_of_floors);
        List<String> messList = serviceService.add(service);
        boolean check =true;
        for (String mess: messList) {
            if (!mess.equals("")){
                check =false;
            }
        }
        String mess = "Added new service successfully";
        if (!check){
            mess = "Add new service unsuccessfully";
        }
        request.setAttribute("mess",mess);
        request.setAttribute("messList",messList);
        request.setAttribute("serviceTypeList",serviceTypeService.findAll());
        request.setAttribute("rentTypeList",rentTypeService.findAll());
        try {
            request.getRequestDispatcher("view/service/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
