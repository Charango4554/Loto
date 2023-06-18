// Définition de la classe Cadeau qui hérite de la classe Lot
public class Cadeau extends Lot {
// Attribut photo de type ImageIcon
private javax.swing.ImageIcon photo;

// Constructeur de la classe Cadeau qui prend en paramètres un entier n, une chaîne de caractères d et une ImageIcon i
public Cadeau(int n, String d, javax.swing.ImageIcon i) {
    // Appel du constructeur de la classe Lot avec les paramètres n et d
    super(n,d);
    // Initialisation de l'attribut photo avec la ImageIcon i
    photo = i;
}

// Méthode getPhoto qui retourne l'attribut photo
public javax.swing.ImageIcon getPhoto(){
    return photo;
}


}