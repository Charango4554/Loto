// Importation des classes nécessaires pour le code
import java.awt.Color;
import javax.swing.ImageIcon;
// Définition de la classe Joueur
public class Joueur {
    // Déclaration des attributs privés de la classe
    private String pseudo;
    private Color couleur;
    private double solde;
    private ImageIcon photo;
    private LesCartes mesC;
    private LesLots mesL;

    // Définition des getters pour les attributs privés
    public String getPseudo() { return this.pseudo;  }
    public Color getCouleur() { return this.couleur; }
    public double getSolde() { return this.solde; }
    public ImageIcon getPhoto() { return this.photo;}
    public LesCartes getMesCartes() { return mesC; }
    public LesLots getMesLots() { return mesL; }

    // Définition des setters pour les attributs privés
    public void setPseudo(String p) { this.pseudo=p; }
    public void setCouleur(Color c) { this.couleur = c; }
    public void setPhoto(ImageIcon p) { this.photo = p; }
    public void setSolde(double s) { this.solde = s; }
    
    // Constructeur par défaut de la classe Joueur
    public Joueur() {
        this("");
    }
    // Constructeur avec paramètre de la classe Joueur
    public Joueur(String p) {
    // Appel des méthodes setters pour initialiser les attributs de la classe
    setPseudo(p);
    setCouleur(new Color(180,180,180));
    setSolde(20);
    setPhoto(new ImageIcon(getClass().getResource("/joueurDefaut.png")));
    // Instanciation d'un nouvel objet LesLots et appel de la méthode supprimeCartes()
    mesL = new LesLots();
    supprimeCartes();        
}
    // Méthode permettant d'afficher les informations du joueur sous forme de chaîne de caractères
public String toString() {
    String res= "\nJoueur: " + this.pseudo;
    res+= "\nCouleur: " + this.couleur;
    res+= "\nSolde: " + this.solde;
    res+= "\nNombre de cartes possédées: " + this.mesC.getTaille();
    return res;
}  

// Méthode permettant à un joueur d'acheter une carte de loto
public boolean acheter(CarteLoto c){
    // Vérification que le joueur a suffisamment d'argent et de place pour acheter une carte
    if (getSolde() >= c.getPrix() && mesC.getTaille() < 2){
        // Ajout de la carte à l'objet LesCartes, soustraction du prix de la carte au solde du joueur et retourne vrai
        mesC.ajouteCarte(c);
        setSolde(getSolde() - c.getPrix()); 
        return true;
    }
    // Retourne faux si le joueur n'a pas assez d'argent ou de place
    return false;
}

// Méthode permettant de supprimer les cartes du joueur
public void supprimeCartes(){
    // Instanciation d'un nouvel objet LesCartes pour supprimer toutes les cartes précédentes
    mesC = new LesCartes();
    }
}
