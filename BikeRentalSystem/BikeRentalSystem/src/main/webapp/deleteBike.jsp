<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Bike</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Delete Bike</h2>
        <% if (request.getParameter("error") != null) { %>
            <p style="color:red;"><%= request.getParameter("error") %></p>
        <% } %>
        <form action="DeleteBikeServlet" method="post" class="form-container">
            <label for="bikeId">Bike ID:</label>
            <input type="number" id="bikeId" name="bikeId" required><br>
            <input type="submit" value="Delete Bike" class="button" onclick="return confirm('Are you sure you want to delete this bike?');">
        </form>
        <a href="viewBike.jsp">Back to Bike List</a>
    </div>
</body>
</html>