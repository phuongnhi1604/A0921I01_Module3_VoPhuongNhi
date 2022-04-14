package controller;

import model.bean.Contract;
import model.service.Attach_ServiceService;
import model.service.ContractService;
import model.service.Impl.Attach_ServiceServiceImpl;
import model.service.Impl.ContractServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    private ContractService contractService = new ContractServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "add":
                showCreateForm(request,response);
                break;
            default:
                listContract(request,response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/contract/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        request.setAttribute("contractList",contractService.findAll());
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
        switch (action) {
            case "add":
                save(request, response);
                break;
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        String startday = request.getParameter("startday");
        String endday =request.getParameter("endday");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double total = Double.parseDouble(request.getParameter("total"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(startday,endday,deposit,total,employee_id,customer_id,service_id);
        boolean check=contractService.add(contract);
        String mess = "Added new contract successfully";
        if (!check){
            mess = "Add new contract unsuccessfully";
        }
        request.setAttribute("mess",mess);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("view/contract/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
