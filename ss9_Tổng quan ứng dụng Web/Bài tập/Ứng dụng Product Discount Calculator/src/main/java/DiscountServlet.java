import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proDes=request.getParameter("prodes");
        float price=Float.parseFloat(request.getParameter("listprice"));
        float discount=Float.parseFloat(request.getParameter("discount"));

        float discountAmount= (float) (price*discount*0.01);
        float discountPrice= price-discountAmount;
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<p><b>Product Description:</b> "+proDes+"</p>");
        printWriter.println("<p><b>List Price:</b> "+price+"</p>");
        printWriter.println("<p><b>Discount Percent:</b> "+discount+"</p><br>");
        printWriter.println("<p><b>Discount Amount:</b> "+discountAmount+"</p>");
        printWriter.println("<p><b>Discount Price:</b> "+discountPrice+"</p>");
        printWriter.println("</html>");
    }
}
