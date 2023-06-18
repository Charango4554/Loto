public class CarteCadeau extends Lot {
    private double montant; // montant de la carte cadeau
    CarteCadeau(int n, String d, double m){
        // initialisation des attributs
        super(n,d);
        montant = m;
    }
    // accesseur en lecture
    public double getMontant(){return montant;}
}
