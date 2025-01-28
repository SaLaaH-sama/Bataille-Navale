// src/BatailleNavale.java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BatailleNavale {

    public static void main(String[] args) {
        System.out.println("=== Bataille Navale ===");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean quitter = false;

        while (!quitter) {
            // Affichage du menu principal
            System.out.println("\nMenu principal :");
            System.out.println("1. Jouer");
            System.out.println("2. Afficher les règles");
            System.out.println("3. Quitter");

            try {
                System.out.print("Votre choix [1-3] : ");
                String choix = in.readLine();

                if (Pattern.matches("[123]", choix)) {
                    switch (choix) {
                        case "1":
                            // Lancer une partie
                            Joueur joueur1 = null;
                            Joueur joueur2 = null;

                            // Sélection du mode de jeu
                            System.out.println("\nModes de jeu disponibles :");
                            System.out.println("1. Joueur vs Ordinateur");
                            System.out.println("2. Ordinateur vs Ordinateur");
                            System.out.println("3. Joueur vs Joueur");
                            System.out.print("Choisissez un mode [1-3] : ");
                            String mode = in.readLine();

                            if (Pattern.matches("[123]", mode)) {
                                switch (mode) {
                                    case "1":
                                        joueur1 = new JoueurHumain("Joueur 1");
                                        joueur2 = new JoueurBot("Ordinateur");
                                        break;
                                    case "2":
                                        joueur1 = new JoueurBot("Ordinateur 1");
                                        joueur2 = new JoueurBot("Ordinateur 2");
                                        break;
                                    case "3":
                                        joueur1 = new JoueurHumain("Joueur 1");
                                        joueur2 = new JoueurHumain("Joueur 2");
                                        break;
                                }

                                // Créer et lancer la partie
                                Partie partie = new Partie(joueur1, joueur2);
                                partie.initialiser();
                                partie.jouer();
                            } else {
                                System.out.println("Choix invalide, retour au menu principal.");
                            }
                            break;
                        case "2":
                            // Afficher les règles
                            System.out.println("\n=== Règles du jeu ===");
                            System.out.println("1. Chaque joueur dispose de 5 bateaux à placer sur une grille.");
                            System.out.println("2. Le but est de couler tous les bateaux de l'adversaire.");
                            System.out.println("3. Chaque joueur tire à tour de rôle en indiquant une case.");
                            System.out.println("4. Si un bateau est touché, il est marqué sur la grille.");
                            System.out.println("5. Le jeu se termine quand tous les bateaux d’un joueur sont coulés.");
                            break;
                        case "3":
                            // Quitter le programme
                            System.out.println("Merci d'avoir joué. À bientôt !");
                            quitter = true;
                            break;
                    }
                } else {
                    System.out.println("Choix invalide, veuillez entrer un chiffre entre 1 et 3.");
                }
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}
