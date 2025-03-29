package Controller;

import model.BikeDAO;
import model.Bike;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewBikeServlet")
public class ViewBikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BikeDAO bikeDAO = new BikeDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Bike> bikes = bikeDAO.getAllBikes();
        request.setAttribute("bikes", bikes);
        request.getRequestDispatcher("viewBike.jsp").forward(request, response);
    }
}