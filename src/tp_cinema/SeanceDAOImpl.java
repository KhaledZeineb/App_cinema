package tp_cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAOImpl implements SeanceDAO {
    @Override
    public List<Seance> listerSeances() {
        List<Seance> seances = new ArrayList<>();
        String sql = "SELECT * FROM seance";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seance seance = new Seance(
                    rs.getInt("id"),
                    rs.getString("film"),
                    rs.getDate("date_seance"),
                    rs.getTime("heure"),
                    rs.getInt("places_disponibles")
                );
                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    @Override
    public Seance getSeanceById(int id) {
        String sql = "SELECT * FROM seance WHERE id = ?";
        Seance seance = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                seance = new Seance(
                    rs.getInt("id"),
                    rs.getString("film"),
                    rs.getDate("date_seance"),
                    rs.getTime("heure"),
                    rs.getInt("places_disponibles")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    @Override
    public boolean mettreAJourPlaces(int seanceId, int nouvellesPlaces) {
        String sql = "UPDATE seance SET places_disponibles = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, nouvellesPlaces);
            pstmt.setInt(2, seanceId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
