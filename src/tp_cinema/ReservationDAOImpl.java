package tp_cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
	@Override
    public boolean ajouterReservation(Reservation reservation) {
        String sql = "INSERT INTO reservation (nom_client, seance_id, nombre_places) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, reservation.getNomClient());
            pstmt.setInt(2, reservation.getSeanceId());
            pstmt.setInt(3, reservation.getNombrePlaces());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Reservation> getReservationsParClient(String nomClient) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservation WHERE nom_client = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nomClient);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation(
                    rs.getInt("id"),
                    rs.getString("nom_client"),
                    rs.getInt("seance_id"),
                    rs.getInt("nombre_places")
                );
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
