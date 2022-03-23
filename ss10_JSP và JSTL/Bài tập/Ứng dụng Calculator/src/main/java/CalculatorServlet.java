import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float num1= Integer.parseInt(request.getParameter("num1"));
        float num2= Integer.parseInt(request.getParameter("num2"));
        char pheptinh=request.getParameter("pheptinh").charAt(0);

        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h3>Result: </h3>");
        try {
            float result= Calculator.calculator(num1,num2,pheptinh);
            printWriter.println(num1+" "+pheptinh+" "+num2+" = "+result);
        }catch (Exception ex){
            printWriter.println(ex.getMessage());
        }
        printWriter.println("</html>");
    }
}
