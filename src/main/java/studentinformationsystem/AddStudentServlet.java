package studentinformationsystem;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int roll = Integer.parseInt(request.getParameter("rollno"));
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            int age = Integer.parseInt(request.getParameter("age"));

            studentinfo s = new studentinfo(roll, name, gender, age);

            dao d = new studaoimple();
            d.insertstudent(s);

            out.println("<h3>Student Added Successfully!</h3>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}