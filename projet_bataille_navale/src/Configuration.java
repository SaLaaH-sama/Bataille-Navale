// src/Configuration.java
public abstract class Configuration {

    // Attributs statiques (communs à tous les objets, constants pour la configuration du jeu)
    private static final String[][] BATEAUX = {
        {"1", "Porte-avions", "5"},
        {"2", "Cuirassé", "4"},
        {"3", "Croiseur", "3"},
        {"4", "Croiseur", "3"},
        {"5", "Torpilleur", "2"}
    };
    private static final int TAILLE_GRILLE = 10; // Grille 10x10

    // Méthodes statiques pour accéder aux informations
    public static String[][] getBateaux() {
        return BATEAUX;
    }

    public static int getTailleGrille() {
        return TAILLE_GRILLE;
    }

    public static String[] getBateauParId(int id) throws IndexOutOfBoundsException {
        if (id < 0 || id >= BATEAUX.length) {
            throw new IndexOutOfBoundsException("L'id du bateau est invalide.");
        }
        return BATEAUX[id];
    }

    public static int getNombreBateaux() {
        return BATEAUX.length;
    }
}
