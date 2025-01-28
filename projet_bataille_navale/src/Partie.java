// src/Partie.java
public class Partie {

    private final Joueur joueur1;
    private final Joueur joueur2;
    private Joueur joueurActuel;
    private Joueur joueurAdverse;

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurActuel = joueur1;
        this.joueurAdverse = joueur2;
    }

    public void initialiser() {
        System.out.println("Initialisation de la partie...");
        joueur1.placerBateaux();
        joueur2.placerBateaux();
    }

// src/Partie.java
public void jouer() {
    boolean partieTerminee = false;

    while (!partieTerminee) {
        System.out.println("\nTour de " + joueurActuel.getNom());
                // Affichage des plateaux
                System.out.println("\nPlateau de " + joueurActuel.getNom() + " :");
                joueurActuel.getPlateau().afficher();
                System.out.println("\nPlateau de tirs de " + joueurActuel.getNom() + " :");
                joueurActuel.getPlateauTirs().afficher();
        Case cible = joueurActuel.tirer();

        // Mise à jour du plateau de l'adversaire
        Case caseAdverse = joueurAdverse.getPlateau().getCase(cible.getX(), cible.getY());
        if (!caseAdverse.estVide()) {
            System.out.println("Touché !");
            caseAdverse.setTouche(true);
            joueurActuel.incrementerFrappesReussies();

            for (Bateau bateau : joueurAdverse.getPlateau().getBateaux()) {
                if (bateau.estCoule()) {
                    System.out.println("Bravo, " + joueurActuel.getNom() + " a coulé un " + bateau.getNom() + " !");
                    joueurActuel.incrementerBateauxCoules();
                    joueurAdverse.getPlateau().getBateaux().remove(bateau);
                    break;
                }
            }
        } else {
            System.out.println("Raté !");
        }

        joueurActuel.incrementerFrappesTotales();
/*
        // Affichage des plateaux
        System.out.println("\nPlateau de " + joueurActuel.getNom() + " :");
        joueurActuel.getPlateau().afficher();
        System.out.println("\nPlateau de tirs de " + joueurActuel.getNom() + " :");
        joueurActuel.getPlateauTirs().afficher();
*/
        // Vérification de la fin de la partie
        if (joueurAdverse.getPlateau().getBateaux().isEmpty()) {
            partieTerminee = true;
            System.out.println("\n" + joueurActuel.getNom() + " a gagné !");
        } else {
            Joueur temp = joueurActuel;
            joueurActuel = joueurAdverse;
            joueurAdverse = temp;
        }
    }
}
}