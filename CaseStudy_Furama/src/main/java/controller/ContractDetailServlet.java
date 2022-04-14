package controller;

import model.bean.Contract;
import model.bean.Contract_Detail;
import model.service.ContractDetailService;
import model.service.Impl.ContractDetailServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContractDetailServlet", value = "/contractDetails")
public class ContractDetailServlet extends HttpServlet {
    ContractDetailService contractDetailService = new ContractDetailServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                showCreateForm(request,response);
                break;
            default:
                listContractDetail(request,response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contractdetail/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contractdetail/list.jsp");
        request.setAttribute("contractdetailList",contractDetailService.findAll());
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
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                save(request,response);
                break;
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Contract_Detail contract_detail = new Contract_Detail(contract_id,attach_service_id,quantity);
        boolean check=contractDetailService.add(contract_detail);
        String mess = "Added new contract detail successfully";
        if (!check){
            mess = "Add new contract detail unsuccessfully";
        }
        request.setAttribute("mess",mess);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("view/contractdetail/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
