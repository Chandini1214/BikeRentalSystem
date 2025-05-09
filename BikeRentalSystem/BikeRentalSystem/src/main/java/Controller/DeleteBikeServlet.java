package Controller;

import model.BikeDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBikeServlet")
public class DeleteBikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BikeDAO bikeDAO = new BikeDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int bikeId = Integer.parseInt(request.getParameter("bikeId"));
        boolean success = bikeDAO.deleteBike(bikeId);

        if (success) {
            response.sendRedirect("ViewBikeServlet?message=Bike deleted successfully");
        } else {
            response.sendRedirect("deleteBike.jsp?error=Failed to delete bike");
        }
    }
}
