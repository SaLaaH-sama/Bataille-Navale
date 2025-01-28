// src/Case.java
public class Case {

    // Attributs privés
    private final int x; // Coordonnée ligne
    private final int y; // Coordonnée colonne
    private int idBateau; // Identifiant du bateau sur la case (0 si aucun)
    private boolean touche; // Indique si la case a été touchée

    // Constructeur
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.idBateau = 0; // Par défaut, aucun bateau
        this.touche = false; // Par défaut, la case n'est pas touchée
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIdBateau() {
        return idBateau;
    }

    public boolean isTouche() {
        return touche;
    }

    // Setters
    public void setIdBateau(int idBateau) {
        this.idBateau = idBateau;
    }

    public void setTouche(boolean touche) {
        this.touche = touche;
    }

    // Méthode pour vérifier si la case est vide (sans bateau)
    public boolean estVide() {
        return idBateau == 0;
    }

    // Méthode toString pour afficher les informations de la case
    @Override
    public String toString() {
        if (touche) {
            return idBateau == 0 ? "~" : "X"; // ~ pour raté, X pour touché
        }
        return idBateau == 0 ? "." : Integer.toString(idBateau); // . pour vide, id pour bateau
    }
}
