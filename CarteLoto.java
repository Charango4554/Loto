// Import des classes nécessaires pour l'application
import java.awt.*;
import javax.swing.*;

// Déclaration de la classe CarteLoto
public class CarteLoto {
// Déclaration des variables membres de la classe
    int tab[][];
    int jetons[][];
    int nbCol;
    int nbLig;
    int nbNumeros;
    double prix;
    final int valMax = 90;

    // Constructeurs de la classe
public CarteLoto() { this(5); } // Appel du constructeur avec un argument entier de valeur 5
public CarteLoto(int nbc) { this(nbc, nbc); } // Appel du constructeur avec deux arguments entiers de même valeur nbc
public CarteLoto(int nbc, int nbVal) { this(nbc, 3, nbVal); } // Appel du constructeur avec trois arguments entiers : nbc, 3 et nbVal
public CarteLoto(int nbc, int nbl, int nbVal) { // Appel du constructeur avec trois arguments entiers : nbc, nbl et nbVal
    // Initialisation des variables membres de la classe
    this.nbNumeros = nbVal;
    this.nbCol = nbc;
    this.nbLig = nbl;
    this.tab = new int[nbLig][nbCol];
    this.jetons = new int[nbLig][nbCol];
    this.prix = 5;
    // Appel à la méthode d'initialisation des valeurs de la carte
    initValeursCarte();
}

// Méthode qui permet de modifier le nombre de numéros sur la carte
public void setNbNumeros(int nbVal) {
    if (nbVal >= 3 && nbVal <= nbLig * nbCol) { // Vérification de la validité de la valeur entrée
        this.nbNumeros = nbVal; // Modification de la variable membre nbNumeros si la valeur entrée est valide
    } else {
        System.out.println("Entrez une valeur entre 3 et le nombre de cases"); // Affichage d'un message d'erreur si la valeur entrée n'est pas valide
    }
}

// Méthodes d'accès aux variables membres de la classe
public int getNbLigne() { return this.nbLig; }
public int getNbCol() { return this.nbCol; }
public double getPrix() { return this.prix; }
public int getNbNumeros() { return this.nbNumeros; }
public int getCase(int i, int j) { // Méthode qui retourne la valeur de la case (i, j) de la carte
    return (i >= 0 && i < nbLig && j >= 0 && j < nbCol)? this.tab[i][j] : -1; // Retourne -1 si la case (i, j) n'est pas valide, sinon retourne la valeur de la case
}

// Méthode qui vérifie si une valeur donnée est présente sur la carte
public boolean estDans(int val){
    boolean res = false; // Initialisation de la variable de résultat à false
    int i = 0; // Initialisation de la variable i à 0
    do {
        int j = 0; // Initialisation de la variable j à 0
        while (j < this.nbCol && this.tab[i][j] != val) {
                j++;
            }
            if (j < this.nbCol) {
                res = true;
            } else {
                i++;
            }
        } while (i < this.nbLig && !res);
        return res;
    }

// Initialise les valeurs de la carte à 0 et place les numéros aléatoirement
private void initValeursCarte() {
    // Parcourt toutes les lignes et toutes les colonnes de la carte
    for (int i = 0; i < this.nbLig; i++) {
        for (int j = 0; j < this.nbCol; j++) {
            // Initialise la valeur de la case à 0 et la valeur du jeton à 0
            tab[i][j] = 0;
            jetons[i][j] = 0;
        }
    }
    // Variables pour stocker le numéro et la position de la case
    int n, i = 0, j;
    // Place le nombre de numéros aléatoires spécifié
    for (int k = 0; k < this.nbNumeros; k++) {
        // Trouve une position aléatoire qui n'a pas déjà été prise
        do {
            j = (int) (Math.random() * this.nbCol);
        } while (tab[i][j] != 0);
        // Trouve un numéro aléatoire qui n'a pas déjà été pris sur la carte
        do {
            n = (int) (Math.random() * this.valMax + 1);
        } while (estDans(n));
        // Place le numéro sur la carte à la position aléatoire
        tab[i][j] = n;
        // Passe à la ligne suivante
        i = (i + 1) % this.nbLig;
    }
}

// Place un pion sur la case correspondante si la valeur de la case correspond
public boolean placePion(int val) {
    // Initialise le résultat à faux
    boolean res = false;
    // Parcourt toutes les lignes et toutes les colonnes de la carte
    for (int i = 0; i < this.nbLig; i++) {
        for (int j = 0; j < this.nbCol; j++) {
            // Si la valeur de la case correspond à la valeur passée en paramètre
            if (tab[i][j] == val) {
                // Change la valeur du jeton à la position correspondante
                jetons[i][j] = val;
                // Met le résultat à vrai
                res = true;
            }
        }
    }
    // Retourne le résultat
    return res;
}

// Vérifie si une ligne est pleine de jetons
public boolean estLignePleine(int lig) {
    // Initialise le résultat à vrai
    boolean res = true;
    // Parcourt toutes les colonnes de la ligne
    for (int j = 0; j < this.nbCol; j++) {
        // Si la valeur du jeton à cette position ne correspond pas à la valeur de la case correspondante
        if (jetons[lig][j] != tab[lig][j]) {
            // Met le résultat à faux
            res = false;
        }
    }
    // Retourne le résultat
    return res;
}

// Compte le nombre de lignes pleines de jetons sur la carte
private int getNbLignesPleines() {
    // Initialise le résultat à 0
    int res = 0;
    // Parcourt toutes les lignes de la carte
    for (int i = 0; i < this.nbLig; i++) {
        // Si la ligne est pleine de jetons
            if (estLignePleine(i)) {
                res++;
            }
        }
        return res;
    }
    public boolean cartonGagnant(int option) {
        return getNbLignesPleines() >= option;
    }
// Méthode pour afficher la grille sous forme de chaîne de caractères
public String toString() {
    String res = "";
    for (int i = 0; i < this.nbLig; i++) {
    for (int j = 0; j < this.nbCol; j++) {
    res += (tab[i][j] > 9 ? " " : " ") + tab[i][j]; // Si le nombre est supérieur à 9, un seul espace est ajouté avant le nombre, sinon deux espaces sont ajoutés
    }
    res += "\n"; // Ajout d'un saut de ligne après chaque ligne de la grille
    }
    return res; // Renvoie la chaîne de caractères représentant la grille
}

// Méthode pour dessiner la grille de jeu dans un JPanel
public void dessineCarte(JPanel jp, Color coul){
    JButton jb;
    int i, j;
    jp.removeAll(); // Supprime tous les composants du JPanel pour une nouvelle mise à jour
    jp.setLayout(new GridLayout(getNbLigne(), getNbCol())); // Définit la disposition du JPanel en fonction du nombre de lignes et de colonnes de la grille
    for(i = 0; i < getNbLigne(); i++){
        for(j = 0; j < getNbCol(); j++){
            jb = new JButton(getCase(i, j) == 0 ? "" : "" + getCase(i, j)); // Si la case est vide, le bouton n'affiche rien, sinon il affiche le numéro de la case
            jb.setBackground(jetons[i][j] == getCase(i,j) && getCase(i,j) != 0 ? Color.WHITE: coul); // Si le jeton est sur la case et que la case n'est pas vide, le fond du bouton est blanc, sinon il prend la couleur passée en paramètre
            jp.add(jb); // Ajout du bouton dans le JPanel
    }
}
jp.revalidate(); // Mise à jour de l'affichage du JPanel
}
}
