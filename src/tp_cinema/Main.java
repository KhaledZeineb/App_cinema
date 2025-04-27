package tp_cinema;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
    private static SeanceDAO seanceDAO = new SeanceDAOImpl();
    private static ReservationDAO reservationDAO = new ReservationDAOImpl();

    public static void main(String[] args) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    afficherSeancesDisponibles();
                    break;
                case 2:
                    reserverSeance();
                    break;
                case 3:
                    afficherReservationsClient();
                    break;
                case 4:
                    quitter = true;
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\n--- MENU CINEMA ---");
        System.out.println("1. Afficher les séances disponibles");
        System.out.println("2. Réserver une séance");
        System.out.println("3. Afficher les réservations du client");
        System.out.println("4. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void afficherSeancesDisponibles() {
        List<Seance> seances = seanceDAO.listerSeances();
        if (seances.isEmpty()) {
            System.out.println("Aucune séance disponible pour le moment.");
        } else {
            System.out.println("\nSéances disponibles :");
            for (Seance seance : seances) {
                System.out.println(seance);
            }
        }
    }

    private static void reserverSeance() {
        afficherSeancesDisponibles();
        System.out.print("\nEntrez l'ID de la séance à réserver : ");
        int seanceId = scanner.nextInt();
        scanner.nextLine(); 

        Seance seance = seanceDAO.getSeanceById(seanceId);
        if (seance == null) {
            System.out.println("Séance introuvable.");
            return;
        }

        System.out.print("Votre nom : ");
        String nomClient = scanner.nextLine();

        System.out.print("Nombre de places à réserver : ");
        int nombrePlaces = scanner.nextInt();
        scanner.nextLine();

        if (nombrePlaces <= 0) {
            System.out.println("Nombre de places invalide.");
            return;
        }

        if (nombrePlaces > seance.getPlacesDisponibles()) {
            System.out.println("Désolé, il ne reste que " + seance.getPlacesDisponibles() + " places disponibles.");
            return;
        }

        
        Reservation reservation = new Reservation(0, nomClient, seanceId, nombrePlaces);

        if (reservationDAO.ajouterReservation(reservation)) {
            int nouvellesPlaces = seance.getPlacesDisponibles() - nombrePlaces;
            if (seanceDAO.mettreAJourPlaces(seanceId, nouvellesPlaces)) {
                System.out.println("Réservation effectuée avec succès !");
            } else {
                System.out.println("Problème lors de la mise à jour des places disponibles.");
            }
        } else {
            System.out.println("Échec de la réservation.");
        }
    }

    private static void afficherReservationsClient() {
        System.out.print("Entrez le nom du client : ");
        String nomClient = scanner.nextLine();

        List<Reservation> reservations = reservationDAO.getReservationsParClient(nomClient);
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation trouvée pour ce client.");
        } else {
            System.out.println("\nRéservations de " + nomClient + " :");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
