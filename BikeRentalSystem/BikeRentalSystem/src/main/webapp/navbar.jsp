<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body { margin: 0; font-family: Arial, sans-serif; }
        .navbar { background-color:  #AA336A; display: flex; align-items: center; justify-content: space-between; padding: 10px 20px; }
        .navbar .app-title { color: white; font-size: 24px; font-weight: bold; text-transform: uppercase; }
        .nav-links { display: flex; gap: 15px; }
        .nav-links a { color: white; text-decoration: none; padding: 10px 15px; font-size: 18px; transition: 0.3s; border-radius: 5px; }
        .nav-links a:hover { background-color: #ddd; color: black; }
        .user-info { color: white; font-size: 18px; display: flex; align-items: center; gap: 15px; }
        .bike-count { background-color: #28a745; padding: 5px 10px; border-radius: 10px; font-weight: bold; font-size: 16px; color: white; }
        .logout-btn { background-color: red; color: white; padding: 8px 15px; text-decoration: none; border-radius: 5px; font-size: 16px; transition: 0.3s; }
        .logout-btn:hover { background-color: darkred; }
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="app-title">BIKE RENTAL MANAGEMENT SYSTEM</div>
        <div class="nav-links">
            <a href="home.jsp">Home</a>
            <a href="addBike.jsp">Add Bike</a>
            <a href="ViewBikeServlet">View Bikes</a>
            <a href="updateBike.jsp">Update Bike</a>
            <a href="deleteBike.jsp">Delete Bike</a>
        </div>
        <div class="user-info">
            <c:if test="${not empty sessionScope.rollNumber}">
                Welcome, ${sessionScope.rollNumber}
                <%
                    Cookie[] cookies = request.getCookies();
                    String bikeCount = "0";
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if ("bikeCount".equals(cookie.getName())) {
                                bikeCount = cookie.getValue();
                                break;
                            }
                        }
                    }
                %>
                <span class="bike-count">Bikes: <%= bikeCount %></span>
                <a href="LogoutServlet" class="logout-btn">Logout</a>
            </c:if>
        </div>
    </nav>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>