package controller;

import model.service.CustomerUseService_Service;
import model.service.Impl.CustomerUseService_ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerUseServiceServlet", value = "/customerUseServices")
public class CustomerUseServiceServlet extends HttpServlet {
    CustomerUseService_Service customerUseService_service = new CustomerUseService_ServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                listCustomerUseService(request,response);
        }
    }

    private void listCustomerUseService(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customeruseservice/list.jsp");
        request.setAttribute("customeruseservice",customerUseService_service.findAll());
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

    }
}
