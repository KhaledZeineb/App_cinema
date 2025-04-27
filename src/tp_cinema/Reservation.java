package tp_cinema;

public class Reservation {
	private int id;
    private String nomClient;
    private int seanceId;
    private int nombrePlaces;

    public Reservation() {}

    public Reservation(int id, String nomClient, int seanceId, int nombrePlaces) {
        this.id = id;
        this.nomClient = nomClient;
        this.seanceId = seanceId;
        this.nombrePlaces = nombrePlaces;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNomClient() { return nomClient; }
    public void setNomClient(String nomClient) { this.nomClient = nomClient; }
    public int getSeanceId() { return seanceId; }
    public void setSeanceId(int seanceId) { this.seanceId = seanceId; }
    public int getNombrePlaces() { return nombrePlaces; }
    public void setNombrePlaces(int nombrePlaces) { this.nombrePlaces = nombrePlaces; }

    @Override
    public String toString() {
        return "ID: " + id + " | Client: " + nomClient + 
               " | ID Séance: " + seanceId + " | Places réservées: " + nombrePlaces;
    }
}
