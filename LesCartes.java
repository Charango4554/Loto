import java.util.ArrayList;
public class LesCartes {
    private ArrayList<CarteLoto> lst;
    public LesCartes(){
        this.lst = new ArrayList<CarteLoto>();
    }
    public int getTaille(){
        return this.lst.size();
    }
    public CarteLoto getCarte(int i){
        return i >= 0 && i < getTaille() ? this.lst.get(i) : null;
    }
    public CarteLoto[] getCartes(){
        return this.lst.toArray(new CarteLoto[this.lst.size()]);
    }
    public void ajouteCarte(CarteLoto c){
        this.lst.add(c);
    }
    public void retireCarte(CarteLoto c){
        this.lst.remove(c);
    }
    public void retireCartes(){
        this.lst.clear();
    }
    public LesCartes rechCartes(int num){
        LesCartes lc = new LesCartes();
        for(int i=0; i<getTaille(); i++)
            if (getCarte(i).estDans(num))
                lc.ajouteCarte(getCarte(i));
        return lc;
    }
    public void initLesCartes(int n, int nbcol, int nbval){
        for(int i=0; i<n; i++){
            ajouteCarte(new CarteLoto(nbcol, nbval));
        }
    }
    public String toString(){
        String res = "";
        for(int i=0; i<getTaille(); i++)
            res = res + "Carte n°" + (i+1) +"\n" + getCarte(i).toString()+"\n";
        return res;
    }
}
