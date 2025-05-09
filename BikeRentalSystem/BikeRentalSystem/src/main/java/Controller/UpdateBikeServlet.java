package Controller;

import model.BikeDAO;
import model.Bike;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateBikeServlet")
public class UpdateBikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BikeDAO bikeDAO = new BikeDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int bikeId = Integer.parseInt(request.getParameter("bikeId"));
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));
        double rentalRate = Double.parseDouble(request.getParameter("rentalRate"));
        String availabilityStatus = request.getParameter("availabilityStatus");

        Bike bike = new Bike(bikeId, make, model, year, rentalRate, availabilityStatus);
        boolean success = bikeDAO.updateBike(bike);

        if (success) {
            response.sendRedirect("ViewBikeServlet?message=Bike updated successfully");
        } else {
            request.setAttribute("error", "Failed to update bike");
            request.getRequestDispatcher("updateBike.jsp").forward(request, response);
        }
    }
}
