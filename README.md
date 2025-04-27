# TP Cinéma - Gestion des séances et réservations

Application Java console pour gérer les séances et réservations d'un cinéma avec une base de données MySQL.

## 📝 Prérequis

- Java JDK 8 ou supérieur
- MySQL Server
- MySQL Connector/J (driver JDBC)
- Maven (optionnel)

## 🛠️ Configuration

1. **Base de données** :
   ```sql
   CREATE DATABASE cinema;
   
   USE cinema;
   
   CREATE TABLE seance (
       id INT AUTO_INCREMENT PRIMARY KEY,
       film VARCHAR(100) NOT NULL,
       date_seance DATE NOT NULL,
       heure TIME NOT NULL,
       places_disponibles INT NOT NULL
   );
   
   CREATE TABLE reservation (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nom_client VARCHAR(100) NOT NULL,
       seance_id INT,
       nombre_places INT,
       FOREIGN KEY (seance_id) REFERENCES seance(id)
   );
   
   INSERT INTO seance (film, date_seance, heure, places_disponibles) VALUES
   ('Inception', '2025-04-20', '19:30:00', 50),
   ('Titanic', '2025-04-20', '21:00:00', 40),
   ('Avatar 2', '2025-04-21', '18:00:00', 60);
   ```

2. **Configuration JDBC** :
   Modifiez les paramètres dans `DatabaseManager.java` :
   ```java
   private static final String DB_URL = "jdbc:mysql://localhost:3306/cinema";
   private static final String DB_USER = "votre_utilisateur";
   private static final String DB_PASSWORD = "votre_mot_de_passe";
   ```

## 🏗️ Structure du projet

```
TP_Cinema/
├── CinemaApp.java         # Classe principale avec le menu
├── DatabaseManager.java   # Gestion des connexions DB
├── Seance.java           # Modèle des séances
└── Reservation.java      # Modèle des réservations
```

## ▶️ Exécution

1. Compilation :
   ```bash
   javac *.java
   ```

2. Exécution :
   ```bash
   java CinemaApp
   ```

## 🎯 Fonctionnalités

- ✅ Afficher les séances disponibles
- ✅ Réserver des places
- ✅ Vérification des places disponibles
- ✅ Consultation des réservations par client
- ✅ Mise à jour automatique des disponibilités

## 📋 Menu Principal

```
--- MENU CINEMA ---
1. Afficher les séances disponibles
2. Réserver une séance
3. Afficher les réservations du client
4. Quitter
```

## 📚 Dépendances

- mysql-connector-java (inclus dans le projet ou via Maven)

## 📜 Licence

Projet académique - Libre d'utilisation

## ✉️ Contact

[Votre nom] - [votre.email@example.com]
```

### Instructions supplémentaires :

1. Placez ce fichier à la racine de votre projet (`C:/Mes Projets/TP_Cinema/README.md`)

2. Pour une meilleure présentation :
   - Utilisez un éditeur Markdown (VS Code, Typora, etc.)
   - Les plates-formes comme GitHub/GitLab afficheront automatiquement la mise en forme

3. Personnalisez les sections (Contact, Licence) avec vos informations

Ce README fournit une documentation complète pour votre projet, incluant :
- Les instructions d'installation
- La structure des fichiers
- Les fonctionnalités implémentées
- Les prérequis techniques
- La configuration nécessaire
