// src/Plateau.java
import java.util.ArrayList;
import java.util.List;

public class Plateau {

    // Attributs
    private final Case[][] grille; // Grille de cases
    private final List<Bateau> bateaux; // Liste des bateaux placés

    // Constructeur
    public Plateau() {
        int taille = Configuration.getTailleGrille();
        this.grille = new Case[taille][taille];
        this.bateaux = new ArrayList<>();

        // Initialisation de la grille
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                grille[x][y] = new Case(x, y);
            }
        }
    }

    // Méthode pour accéder à la liste des bateaux
    public List<Bateau> getBateaux() {
        return bateaux;
    }

    // Méthode pour accéder à une case spécifique
    public Case getCase(int x, int y) {
        if (x < 0 || x >= grille.length || y < 0 || y >= grille.length) {
            throw new IndexOutOfBoundsException("Coordonnées hors limites !");
        }
        return grille[x][y];
    }

    // Méthode pour ajouter un bateau
    public boolean ajouterBateau(Bateau bateau) {
        for (Case c : bateau.getCases()) {
            if (!caseEstValide(c)) {
                return false; // Placement invalide
            }
        }

        // Si toutes les cases sont valides, ajoute le bateau
        bateaux.add(bateau);
        for (Case c : bateau.getCases()) {
            grille[c.getX()][c.getY()].setIdBateau(bateau.getId());
        }
        return true;
    }

    // Vérifie si une case est valide pour le placement d’un bateau
    public boolean caseEstValide(Case c) {
        int x = c.getX();
        int y = c.getY();

        // Vérifie les limites du plateau
        if (x < 0 || x >= grille.length || y < 0 || y >= grille.length) {
            return false;
        }

        // Vérifie si la case est vide
        if (!grille[x][y].estVide()) {
            return false;
        }

        // Vérifie les cases voisines
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && nx < grille.length && ny >= 0 && ny < grille.length) {
                    if (!grille[nx][ny].estVide()) {
                        return false; // Une case voisine est occupée
                    }
                }
            }
        }

        return true; // Placement valide
    }

    // Affichage du plateau
    public void afficher() {
        System.out.print("  ");
        for (int y = 0; y < grille.length; y++) {
            System.out.print((char) ('A' + y) + " ");
        }
        System.out.println();

        for (int x = 0; x < grille.length; x++) {
            System.out.print(x + " ");
            for (int y = 0; y < grille[x].length; y++) {
                System.out.print(grille[x][y] + " ");
            }
            System.out.println();
        }
    }
}