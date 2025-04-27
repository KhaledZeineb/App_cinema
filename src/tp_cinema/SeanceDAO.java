package tp_cinema;

import java.util.List;

public interface SeanceDAO {
	List<Seance> listerSeances();
    Seance getSeanceById(int id);
    boolean mettreAJourPlaces(int seanceId, int nouvellesPlaces);
}
