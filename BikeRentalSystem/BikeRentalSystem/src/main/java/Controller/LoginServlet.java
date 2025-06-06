package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String rollNumber = request.getParameter("rollNumber");
        String password = request.getParameter("password");

        if ("1214".equals(rollNumber) && "1214".equals(password)|| "22VV1A1214".equals(rollNumber) && "1214".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("rollNumber", rollNumber);

            int bikeCount = getBikeCount();
            Cookie bikeCountCookie = new Cookie("bikeCount", String.valueOf(bikeCount));
            bikeCountCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
            response.addCookie(bikeCountCookie);

            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.html?error=Invalid Credentials");
        }
    }

    private int getBikeCount() {
        int count = 0;
        java.sql.Connection conn = null;
        java.sql.Statement stmt = null;
        java.sql.ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/BikeRentalDB", "root", "Chandubindu@123");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM Bike");
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return count;
    }
}