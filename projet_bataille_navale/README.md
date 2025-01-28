# Bataille Navale

Ce projet implémente un jeu de bataille navale en mode texte, où deux joueurs (humains ou bots) s’affrontent pour couler les bateaux de l’adversaire.

## Fonctionnalités principales

- **Modes de jeu :**
  - Joueur contre Ordinateur.
  - Ordinateur contre Ordinateur.
  - Joueur contre Joueur.

## Organisation des classes

1. **Configuration** : Définit les paramètres du jeu (bateaux, taille de grille).
2. **Case** : Représente une cellule de la grille (coordonnées, état, bateau).
3. **Bateau** : Représente un bateau sur le plateau.
4. **Plateau** : Contient les cases et les bateaux d’un joueur.
5. **Joueur** : Classe abstraite pour les joueurs.
   - `JoueurHumain` : Permet les saisies utilisateur.
   - `JoueurBot` : Implémente une IA basique.
6. **Partie** : Gère la logique du jeu, les tours et la fin de partie.

## Instructions pour exécuter le projet

1. Clonez le dépôt ou téléchargez les fichiers source.
2. Compilez les fichiers Java :
   javac src/*.java
3. Lancez le programme principal :
   java src.BatailleNavale
