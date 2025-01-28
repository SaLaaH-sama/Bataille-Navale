// src/Joueur.java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Joueur {

    protected String nom;
    protected Plateau plateau; // Plateau contenant ses propres bateaux
    protected Plateau plateauTirs; // Plateau contenant les tirs effectués
    protected int frappesTotales;
    protected int frappesReussies;
    protected int bateauxCoules;
    protected Case derniereFrappe;
    protected BufferedReader in;

    public Joueur(String nom) {
        this.nom = nom;
        this.plateau = new Plateau();
        this.plateauTirs = new Plateau(); // Nouveau plateau pour les tirs
        this.frappesTotales = 0;
        this.frappesReussies = 0;
        this.bateauxCoules = 0;
        this.derniereFrappe = new Case(-1, -1);
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    public Plateau getPlateauTirs() {
        return plateauTirs;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public int getFrappesTotales() {
        return frappesTotales;
    }

    public int getFrappesReussies() {
        return frappesReussies;
    }

    public int getBateauxCoules() {
        return bateauxCoules;
    }

    public Case getDerniereFrappe() {
        return derniereFrappe;
    }

    // Méthodes utilitaires
    public void incrementerFrappesTotales() {
        frappesTotales++;
    }

    public void incrementerFrappesReussies() {
        frappesReussies++;
    }

    public void incrementerBateauxCoules() {
        bateauxCoules++;
    }

    public void setDerniereFrappe(Case derniereFrappe) {
        this.derniereFrappe = derniereFrappe;
    }

    // Méthode pour afficher les statistiques du joueur
    public void afficherStatistiques() {
        System.out.println("=== Statistiques de " + nom + " ===");
        System.out.println("Frappes totales : " + frappesTotales);
        System.out.println("Frappes réussies : " + frappesReussies);
        System.out.println("Bateaux coulés : " + bateauxCoules);
    }

    // Méthodes abstraites (à implémenter dans les sous-classes)
    public abstract void placerBateaux();
    public abstract Case tirer();
}
