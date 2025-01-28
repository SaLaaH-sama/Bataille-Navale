// src/Bateau.java
public class Bateau {

    // Attributs privés
    private final int id; // Identifiant unique
    private final String nom; // Nom du bateau
    private final Case[] cases; // Tableau de cases où se trouve le bateau

    // Constructeur
    public Bateau(int id, String nom, Case[] cases) {
        this.id = id;
        this.nom = nom;
        this.cases = cases;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getTaille() {
        return cases.length; // La taille est le nombre de cases
    }

    public Case[] getCases() {
        return cases;
    }

    // Méthode pour vérifier si le bateau est coulé
    public boolean estCoule() {
        for (Case c : cases) {
            if (!c.isTouche()) { // Si une case n'est pas touchée, le bateau n'est pas coulé
                return false;
            }
        }
        return true;
    }

    // Méthode toString pour afficher les informations du bateau
    @Override
    public String toString() {
        return nom + " (taille : " + getTaille() + ", ID : " + id + ")";
    }
}