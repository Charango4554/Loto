public class LesLots {
    private java.util.ArrayList<Lot> lots; // collection d'objets
    LesLots(){
        // initialisation de la collection
        lots = new java.util.ArrayList<Lot>();
    }
    public void initLesLots(){
        // initialise la collection avec des lots prédéfinis
        String s[][] = new String[][]{
            {
                "Xbox Series X",
                "'Minecraft",
                "iPhone 14 pro max"
            },{
                "/XBOX.jpeg",
                "/Minecraft.jpg",
                "/iPhone.jpg"
            }
        };
        for(int i = 1; i < 4; i++){
            // Ajoute les lots à la collection
            ajouteLot(new CarteCadeau(i, "Carte cadeau "+i*100+"€", i*100));
            ajouteLot(new Cadeau(i, s[0][i - 1], new javax.swing.ImageIcon(getClass().getResource(s[1][i - 1]))));
        }
    }
    public void ajouteLot(Lot l){
        // ajoute un lot à la collection
        lots.add(l);
    }
    public Lot[] getLots(){
        // retourne la collection sous forme d'un tableau
        return lots.toArray(new Lot[getTaille()]);
    }
    public Lot[] getLots(int n) throws RuntimeException{
        // renvoie un tableau de lots ayant le niveau n
        LesLots l =  new LesLots();
        for(Lot lo : lots){
            if(lo.getNiveau() == n){
                l.ajouteLot(lo);
            }
        }
        if (l.getTaille() == 0){ // si il n'y a aucun lot correspondant
            throw new RuntimeException("Aucun lot correspondant à ce rang.");
        }
        return l.getLots();
    }
    public Lot getLot(int i){
        // renvoie le (i+1)-ème lot de la collection
        return lots.get(i);
    }
    public int getTaille(){
        // renvoie la taille de la collection
        return lots.size();
    }
    public void supprimerTout(){
        // retire tous les lots de la collection
        lots.clear();
    }
    public void retireLot(Lot l){
        // retire le lot l de la collection
        lots.remove(l);
    }
    public Lot piocheLot(int n){
        // pioche un lot au de niveau n dans la collection et le retire de la collection
        Lot l = getLots(n)[new java.util.Random().nextInt(getLots(n).length)];
        retireLot(l);
        return l;
    }
    public String toString(){
        // retourne la liste des lots de la collection sous forme d'une chaine de caractères
        String s = "";
        for(Lot l : lots){
            s += l.toString() + "\n";
        }
        return s;
    }
}
