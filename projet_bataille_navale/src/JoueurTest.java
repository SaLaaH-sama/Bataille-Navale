// src/JoueurTest.java
public class JoueurTest extends Joueur {

    public JoueurTest(String nom) {
        super(nom);
    }

    @Override
    public void placerBateaux() {
        System.out.println(nom + " place ses bateaux.");
    }

    @Override
    public Case tirer() {
        System.out.println(nom + " tire sur une case.");
        return new Case(0, 0); // Retourne une case fixe pour ce test
    }
}
