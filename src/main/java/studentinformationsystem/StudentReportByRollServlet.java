package studentinformationsystem;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/StudentReportByRollServlet")
public class StudentReportByRollServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int roll = Integer.parseInt(request.getParameter("rollno"));

            Connection con = connect.getConnection();

            String query = "SELECT SUBJECT_ID, MARKS, EXAM_TYPE FROM MARKS_TABLE WHERE ROLL_NO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, roll);

            ResultSet rs = ps.executeQuery();

            out.println("<table border='1'>");
            out.println("<tr><th>Subject</th><th>Marks</th><th>Exam</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("SUBJECT_ID") + "</td>");
                out.println("<td>" + rs.getInt("MARKS") + "</td>");
                out.println("<td>" + rs.getString("EXAM_TYPE") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}