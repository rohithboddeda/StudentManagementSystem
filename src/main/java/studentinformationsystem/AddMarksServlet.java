package studentinformationsystem;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddMarksServlet")
public class AddMarksServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int roll = Integer.parseInt(request.getParameter("rollno"));
            String subid = request.getParameter("subid");
            int marks = Integer.parseInt(request.getParameter("marks"));
            String exam = request.getParameter("examtype");

            marksinfo m = new marksinfo(roll, subid, marks);
            m.setexamtype(exam);

            dao d = new studaoimple();
            d.insertmarks(m);

            out.println("<h3>Marks Added Successfully!</h3>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}