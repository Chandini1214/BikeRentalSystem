package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BikeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/BikeRentalDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Chandubindu@123";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Bike> getAllBikes() {
        List<Bike> bikes = new ArrayList<>();
        String sql = "SELECT * FROM Bike";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                bikes.add(new Bike(
                    rs.getInt("bike_id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getDouble("rental_rate_per_day"),
                    rs.getString("availability_status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bikes;
    }

    public boolean addBike(Bike bike) {
        String sql = "INSERT INTO Bike (make, model, year, rental_rate_per_day, availability_status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bike.getMake());
            pstmt.setString(2, bike.getModel());
            pstmt.setInt(3, bike.getYear());
            pstmt.setDouble(4, bike.getRentalRatePerDay());
            pstmt.setString(5, bike.getAvailabilityStatus());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Bike getBikeById(int id) {
        String sql = "SELECT * FROM Bike WHERE bike_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Bike(
                    rs.getInt("bike_id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getDouble("rental_rate_per_day"),
                    rs.getString("availability_status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateBike(Bike bike) {
        String sql = "UPDATE Bike SET make = ?, model = ?, year = ?, rental_rate_per_day = ?, availability_status = ? WHERE bike_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bike.getMake());
            pstmt.setString(2, bike.getModel());
            pstmt.setInt(3, bike.getYear());
            pstmt.setDouble(4, bike.getRentalRatePerDay());
            pstmt.setString(5, bike.getAvailabilityStatus());
            pstmt.setInt(6, bike.getBikeId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBike(int id) {
        String sql = "DELETE FROM Bike WHERE bike_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}