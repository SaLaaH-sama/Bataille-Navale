// src/Test.java
public class Test {

    public static void main(String[] args) {
        // Test de Configuration
        System.out.println("Taille de la grille : " + Configuration.getTailleGrille());
        System.out.println("Nombre de bateaux : " + Configuration.getNombreBateaux());
        System.out.println("Bateaux disponibles :");
        for (String[] bateau : Configuration.getBateaux()) {
            System.out.println("- " + bateau[1] + " (taille : " + bateau[2] + ")");
        }

        // Test du Menu #############################################################################
        Menu menu = new Menu();
        menu.afficherMenu();
        int choix = menu.gererChoix();
        if (choix == 1) {
            System.out.println("Lancement du jeu...");
        } else if (choix == 2) {
            menu.afficherRegles();
        } else {
            System.out.println("Au revoir !");
        }

        // Test de la classe Case #############################################################################
        System.out.println("\n=== Test de la classe Case ===");
        Case c1 = new Case(0, 0);
        Case c2 = new Case(3, 5);

        // Vérifions les valeurs par défaut
        System.out.println("Case (0,0) : " + c1); // Devrait afficher "."
        System.out.println("Case (3,5) : " + c2); // Devrait afficher "."

        // Modifions l'état des cases
        c1.setIdBateau(1);
        c1.setTouche(true);
        System.out.println("Case (0,0) après ajout d'un bateau et touche : " + c1); // Devrait afficher "X"

        c2.setIdBateau(2);
        System.out.println("Case (3,5) avec un bateau mais non touchée : " + c2); // Devrait afficher "2"

        System.out.println("Case (3,5) est vide ? " + c2.estVide()); // Devrait être false

        // Test de la classe Bateau #############################################################################
        System.out.println("\n=== Test de la classe Bateau ===");

        // Créons des cases pour un bateau
        Case c3 = new Case(0, 0);
        Case c4 = new Case(0, 1);
        Case c5 = new Case(0, 2);
        Case[] casesBateau = {c3, c4, c5};

        // Créons un bateau
        Bateau croiseur = new Bateau(1, "Croiseur", casesBateau);

        // Affichons ses informations
        System.out.println(croiseur);

        // Vérifions s'il est coulé
        System.out.println("Le bateau est coulé ? " + croiseur.estCoule()); // Devrait être false

        // Touchons toutes les cases
        for (Case c : casesBateau) {
            c.setTouche(true);
        }

        // Vérifions à nouveau s'il est coulé
        System.out.println("Le bateau est coulé après avoir touché toutes ses cases ? " + croiseur.estCoule()); // Devrait être true

        // Test de la classe Plateau #############################################################################
        System.out.println("\n=== Test de la classe Plateau ===");

        Plateau plateau = new Plateau();
        plateau.afficher();

        // Créons des cases et un bateau
        Case c6 = plateau.getCase(1, 1);
        Case c7 = plateau.getCase(1, 2);
        Case c8 = plateau.getCase(1, 3);
        Case[] casesBateau2 = {c6, c7, c8};

        Bateau croiseur2 = new Bateau(1, "Croiseur", casesBateau2);

        // Tentons d’ajouter le bateau au plateau
        if (plateau.ajouterBateau(croiseur2)) {
            System.out.println("Bateau ajouté avec succès !");
        } else {
            System.out.println("Erreur : Impossible d'ajouter le bateau.");
        }

        // Affichons le plateau après ajout
        plateau.afficher();

        // Test de la classe Joueur #############################################################################
        System.out.println("\n=== Test de la classe Joueur ===");

        Joueur joueur = new JoueurTest("TestPlayer");
        joueur.placerBateaux();
        joueur.tirer();
        joueur.incrementerFrappesTotales();
        joueur.incrementerFrappesReussies();
        joueur.afficherStatistiques();

        // Test de la classe JoueurHumain #############################################################################
        System.out.println("\n=== Test de la classe JoueurHumain ===");
        JoueurHumain joueurHumain = new JoueurHumain("J1");

        // Test du placement des bateaux
        joueurHumain.placerBateaux();

        // Test d’un tir
        Case caseTir = joueurHumain.tirer();
        System.out.println("Case tirée : (" + caseTir.getX() + ", " + caseTir.getY() + ")");

        // Test de la classe JoueurBot #############################################################################
        System.out.println("\n=== Test de la classe JoueurBot ===");
        JoueurBot bot = new JoueurBot("Bot");

        // Test du placement des bateaux
        bot.placerBateaux();

        // Test d’un tir
        Case caseTirBot = bot.tirer();
        System.out.println("Case tirée par le bot : (" + caseTirBot.getX() + ", " + caseTirBot.getY() + ")");
    }
}
