<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Bike</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Add Bike</h2>
        <% if (request.getAttribute("error") != null) { %>
            <p style="color:red;"><%= request.getAttribute("error") %></p>
        <% } %>
        <form action="AddBikeServlet" method="post" class="form-container">
            <label for="make">Make:</label>
            <input type="text" id="make" name="make" required><br>
            <label for="model">Model:</label>
            <input type="text" id="model" name="model" required><br>
            <label for="year">Year:</label>
            <input type="number" id="year" name="year" required><br>
            <label for="rentalRate">Rental Rate/Day:</label>
            <input type="number" step="0.01" id="rentalRate" name="rentalRate" required><br>
            <label for="availabilityStatus">Availability Status:</label>
            <input type="text" id="availabilityStatus" name="availabilityStatus" required><br>
            <input type="submit" value="Add Bike" class="button">
        </form>
    </div>
</body>
</html>