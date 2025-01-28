// src/JoueurBot.java
import java.util.Random;

public class JoueurBot extends Joueur {

    private final Random random;

    // Constructeur
    public JoueurBot(String nom) {
        super(nom);
        this.random = new Random();
    }

    @Override
    public void placerBateaux() {
        System.out.println("\n" + nom + " place ses bateaux...");

        for (int i = 0; i < Configuration.getNombreBateaux(); i++) {
            String[] infoBateau = Configuration.getBateauParId(i);
            String nomBateau = infoBateau[1];
            int tailleBateau = Integer.parseInt(infoBateau[2]);

            boolean placeValide = false;
            while (!placeValide) {
                int x = random.nextInt(Configuration.getTailleGrille());
                int y = random.nextInt(Configuration.getTailleGrille());
                boolean horizontal = random.nextBoolean();

                Case[] casesBateau = new Case[tailleBateau];
                try {
                    for (int j = 0; j < tailleBateau; j++) {
                        if (horizontal) {
                            casesBateau[j] = plateau.getCase(x, y + j);
                        } else {
                            casesBateau[j] = plateau.getCase(x + j, y);
                        }
                    }

                    Bateau bateau = new Bateau(i + 1, nomBateau, casesBateau);
                    if (plateau.ajouterBateau(bateau)) {
                        placeValide = true;
                        System.out.println("Bateau " + nomBateau + " placé avec succès.");
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Si les coordonnées sont invalides, recommence
                }
            }
        }
    }

    @Override
    public Case tirer() {
        Case caseTir;
        boolean tirValide = false;
        
    
        do {
            int x = random.nextInt(Configuration.getTailleGrille());
            int y = random.nextInt(Configuration.getTailleGrille());
            caseTir = plateauTirs.getCase(x, y); // Vérifie le plateau de tirs
    
            if (!caseTir.isTouche()) {
                tirValide = true;
                caseTir.setTouche(true); // Marque la case comme touchée
                setDerniereFrappe(caseTir);
            }
        } while (!tirValide);
    
        System.out.println(nom + " tire sur la case (" + caseTir.getX() + ", " + caseTir.getY() + ")");
        return caseTir;
    }
    
}
