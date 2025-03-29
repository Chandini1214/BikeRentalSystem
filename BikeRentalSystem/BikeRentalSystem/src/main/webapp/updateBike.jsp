<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.BikeDAO, model.Bike" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Bike</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Update Bike</h2>
        <% 
            String idParam = request.getParameter("id");
            Bike bike = null;
            if (idParam != null) {
                BikeDAO dao = new BikeDAO();
                bike = dao.getBikeById(Integer.parseInt(idParam));
            }
            if (bike != null) {
        %>
        <form action="UpdateBikeServlet" method="post" class="form-container">
            <input type="hidden" name="bikeId" value="<%= bike.getBikeId() %>">
            <label for="make">Make:</label>
            <input type="text" id="make" name="make" value="<%= bike.getMake() %>" required><br>
            <label for="model">Model:</label>
            <input type="text" id="model" name="model" value="<%= bike.getModel() %>" required><br>
            <label for="year">Year:</label>
            <input type="number" id="year" name="year" value="<%= bike.getYear() %>" required><br>
            <label for="rentalRate">Rental Rate/Day:</label>
            <input type="number" step="0.01" id="rentalRate" name="rentalRate" value="<%= bike.getRentalRatePerDay() %>" required><br>
            <label for="availabilityStatus">Availability Status:</label>
            <input type="text" id="availabilityStatus" name="availabilityStatus" value="<%= bike.getAvailabilityStatus() %>" required><br>
            <input type="submit" value="Update Bike" class="button">
        </form>
        <% } else { %>
            <p style="color:red;">Bike not found. Please select a valid bike to update.</p>
            <a href="viewBike.jsp">Back to Bike List</a>
        <% } %>
    </div>
</body>
</html>