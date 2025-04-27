package tp_cinema;

import java.sql.Date;
import java.sql.Time;

public class Seance {
	private int id;
    private String film;
    private Date dateSeance;
    private Time heure;
    private int placesDisponibles;

    public Seance() {}

    public Seance(int id, String film, Date dateSeance, Time heure, int placesDisponibles) {
        this.id = id;
        this.film = film;
        this.dateSeance = dateSeance;
        this.heure = heure;
        this.placesDisponibles = placesDisponibles;
    }

   
    public int getId() { 
    	return id;
    }
    public void setId(int id) { 
    	this.id = id; 
    }
    public String getFilm() { 
    	return film; 
    }
    public void setFilm(String film) { 
    	this.film = film;
    }
    public Date getDateSeance() { 
    	return dateSeance; 
    }
    public void setDateSeance(Date dateSeance) { 
    	this.dateSeance = dateSeance; 
    }
    public Time getHeure() { 
    	return heure;
    }
    public void setHeure(Time heure) { 
    	this.heure = heure; 
    }
    public int getPlacesDisponibles() { 
    	return placesDisponibles;
    }
    public void setPlacesDisponibles(int placesDisponibles) { 
    	this.placesDisponibles = placesDisponibles; 
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Film: " + film + " | Date: " + dateSeance + 
               " | Heure: " + heure + " | Places disponibles: " + placesDisponibles;
    }
}
