package studentinformationsystem;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/GetStudentsServlet")
public class GetStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            dao d = new studaoimple();
            List<studentinfo> list = d.getAllStudents();

            out.println("<h2>Student List</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Roll No</th><th>Name</th><th>Gender</th><th>Age</th></tr>");

            for (studentinfo s : list) {
                out.println("<tr>");
                out.println("<td>" + s.getrollno() + "</td>");
                out.println("<td>" + s.getsname() + "</td>");
                out.println("<td>" + s.getsgender() + "</td>");
                out.println("<td>" + s.getsage() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}