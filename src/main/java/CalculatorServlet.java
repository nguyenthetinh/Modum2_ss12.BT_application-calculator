import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double firstOperand = Integer.parseInt(req.getParameter("firstOperand"));
        double secondOperand = Integer.parseInt(req.getParameter("secondOperand"));
        char operator = req.getParameter("operator").charAt(0);

        PrintWriter writer =resp.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result : </h1>");
        try {
            double result = Calculate.calculate(firstOperand , secondOperand , operator);
            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        }catch (Exception ex){
            writer.println("Error: "+ ex.getMessage());
        }
        writer.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
