// src/Menu.java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Menu {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // Méthode pour afficher le menu
    public void afficherMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Jouer");
        System.out.println("2. Afficher les règles");
        System.out.println("3. Quitter");
    }

    // Méthode pour gérer les choix du joueur (copilot)
    public int gererChoix() {
        String input = "";
        do {
            System.out.print("Saisissez votre choix [1, 2 ou 3] : ");
            try {
                input = in.readLine();
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        } while (!Pattern.matches("[123]", input));
        return Integer.parseInt(input);
    }

    // Méthode pour afficher les règles du jeu
    public void afficherRegles() {
        System.out.println("\n=== Règles du jeu ===");
        System.out.println("1. Chaque joueur dispose de 5 bateaux à placer sur une grille");
        System.out.println("2. Le but est de couler tous les bateaux de l'adversaire");
        System.out.println("3. Chaque joueur tire à tour de rôle en indiquant une case");
        System.out.println("4. Si un bateau est touché, il est marqué sur la grille");
        System.out.println("5. Le jeu se termine quand tous les bateaux d’un joueur sont coulés\n");
    }
}
