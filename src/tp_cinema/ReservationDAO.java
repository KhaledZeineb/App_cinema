package tp_cinema;

import java.util.List;

public interface ReservationDAO {
	 boolean ajouterReservation(Reservation reservation);
	 List<Reservation> getReservationsParClient(String nomClient);
}