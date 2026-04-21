package studentinformationsystem;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateMarksServlet")
public class UpdateMarksServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int roll = Integer.parseInt(request.getParameter("rollno"));
            String subid = request.getParameter("subid");
            int marks = Integer.parseInt(request.getParameter("marks"));

            marksinfo m = new marksinfo(roll, subid, marks);

            dao d = new studaoimple();
            d.updatemarks(m);

            out.println("<h3>Marks Updated Successfully!</h3>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}