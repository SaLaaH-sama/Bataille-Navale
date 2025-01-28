// src/JoueurHumain.java
import java.io.IOException;

public class JoueurHumain extends Joueur {

    // Constructeur
    public JoueurHumain(String nom) {
        super(nom);
    }

    @Override
    public void placerBateaux() {
        System.out.println("\n" + nom + ", placez vos bateaux !");
        for (int i = 0; i < Configuration.getNombreBateaux(); i++) {
            String[] infoBateau = Configuration.getBateauParId(i);
            String nomBateau = infoBateau[1];
            int tailleBateau = Integer.parseInt(infoBateau[2]);

            boolean placeValide = false;
            while (!placeValide) {
                try {
                    System.out.println("Placez le " + nomBateau + " (taille : " + tailleBateau + ")");
                    System.out.print("Entrez la position de départ (ex : A0) : ");
                    String position = in.readLine();
                    System.out.print("Entrez la direction (H pour horizontal, V pour vertical) : ");
                    String direction = in.readLine();

                    int x = Integer.parseInt(position.substring(1));
                    int y = position.charAt(0) - 'A';
                    Case[] casesBateau = new Case[tailleBateau];

                    // Calcul des cases en fonction de la direction
                    for (int j = 0; j < tailleBateau; j++) {
                        if (direction.equalsIgnoreCase("H")) {
                            casesBateau[j] = plateau.getCase(x, y + j);
                        } else if (direction.equalsIgnoreCase("V")) {
                            casesBateau[j] = plateau.getCase(x + j, y);
                        }
                    }

                    // Création du bateau et tentative d’ajout
                    Bateau bateau = new Bateau(i + 1, nomBateau, casesBateau);
                    if (plateau.ajouterBateau(bateau)) {
                        placeValide = true;
                        System.out.println("Bateau placé avec succès !");
                    } else {
                        System.out.println("Placement invalide. Essayez à nouveau.");
                    }
                } catch (IOException | IndexOutOfBoundsException e) {
                    System.out.println("Erreur : saisie invalide. Essayez encore.");
                }
            }
        }
    }

    @Override
public Case tirer() {
    boolean tirValide = false;
    Case caseTir = null;

    while (!tirValide) {
        
        try {
            System.out.print(nom + ", entrez les coordonnées de tir (ex : A0) : ");
            String position = in.readLine();
            int x = Integer.parseInt(position.substring(1));
            int y = position.charAt(0) - 'A';

            caseTir = plateauTirs.getCase(x, y); // Vérifie le plateau de tirs
            if (!caseTir.isTouche()) {
                tirValide = true;
                caseTir.setTouche(true); // Marque la case comme touchée
                setDerniereFrappe(caseTir);
            } else {
                System.out.println("Vous avez déjà tiré sur cette case !");
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            System.out.println("Erreur : saisie invalide. Essayez encore.");
        }
    }

    return caseTir;
}
}
