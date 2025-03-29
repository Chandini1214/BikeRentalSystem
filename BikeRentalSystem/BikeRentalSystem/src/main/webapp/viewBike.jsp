<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Bike" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Bikes</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <h2>Bike List</h2>
    <% 
        String message = request.getParameter("message");
        if (message != null) {
    %>
        <p style="color:green;"><%= message %></p>
    <% } %>
    <table class="table" border="1">
        <tr>
            <th>ID</th>
            <th>Make</th>
            <th>Model</th>
            <th>Year</th>
            <th>Rental Rate/Day</th>
            <th>Availability</th>
            <th>Actions</th>
        </tr>
        <% 
            List<Bike> bikes = (List<Bike>) request.getAttribute("bikes");
            if (bikes != null && !bikes.isEmpty()) {
                for (Bike bike : bikes) {
        %>
        <tr>
            <td><%= bike.getBikeId() %></td>
            <td><%= bike.getMake() %></td>
            <td><%= bike.getModel() %></td>
            <td><%= bike.getYear() %></td>
            <td><%= bike.getRentalRatePerDay() %></td>
            <td><%= bike.getAvailabilityStatus() %></td>
            <td>
                <a href="updateBike.jsp?id=<%= bike.getBikeId() %>" class="button edit-btn">Edit</a>
                <form action="DeleteBikeServlet" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this bike?');">
                    <input type="hidden" name="bikeId" value="<%= bike.getBikeId() %>">
                    <input type="submit" value="Delete" class="button delete-btn">
                </form>
            </td>
        </tr>
        <% 
                }
            } else {
        %>
        <tr>
            <td colspan="7" style="text-align:center;">No bikes found. Add a bike to get started.</td>
        </tr>
        <% } %>
    </table>
</body>
</html>