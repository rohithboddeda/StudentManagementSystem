package studentinformationsystem;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int roll = Integer.parseInt(request.getParameter("rollno"));

            Connection con = connect.getConnection();

            String query = "SELECT SUM(MARKS) TOTAL, AVG(MARKS) PERCENT FROM MARKS_TABLE WHERE ROLL_NO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, roll);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Total: " + rs.getInt("TOTAL") + "</h2>");
                out.println("<h2>Percentage: " + rs.getDouble("PERCENT") + "</h2>");
            } else {
                out.println("No data found");
            }

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}