import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", value = "/translate")
public class TranslationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary=new HashMap<>();
        dictionary.put("hello","Xin chao");
        dictionary.put("how","The nao");
        dictionary.put("book","Quyen vo");
        dictionary.put("computer","May tinh");

        String search = request.getParameter("txtSearch");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        String result = dictionary.get(search);
        if (result != null){
            printWriter.println("Word: "+search+"<br/>");
            printWriter.println("Result: "+result);
        }else {
            printWriter.println("Not found");
        }
        printWriter.println("</html>");
    }
}
