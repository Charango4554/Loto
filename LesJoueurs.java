
import java.util.ArrayList;

public class LesJoueurs {
    private ArrayList<Joueur> lstJ;


    LesJoueurs(Joueur[] joueurs){
    this();
    for(Joueur j : joueurs){
        ajouteJoueur(j);
    }
}

LesJoueurs(){
    lstJ = new ArrayList<Joueur>();
}

public Joueur getJoueur(int i){
    return (i >= 0 && i <= getNbJoueurs()-1)? lstJ.get(i) : null;
}

public Joueur[] getJoueurs(){
    return lstJ.toArray(new Joueur[lstJ.size()]);
}

public int getNbJoueurs(){
    return lstJ.size();
}

public void ajouteJoueur(Joueur j){
    lstJ.add(j);
}

public void supprimeJoueur(Joueur j){
    lstJ.remove(j);
}

public Joueur rechJoueur(String ps){
    Joueur r = null;
    for(Joueur j : lstJ){
        r = j.getPseudo().equals(ps) ? j : r;
    }
    return r;
}

public String toString(){
    String r = "";
    for(int i = 0; i < getNbJoueurs(); i++){
        r += (i != 0 ? i == getNbJoueurs() - 1 ? " et " : ", " : "")
                + getJoueur(i).getPseudo();
    }
    return r;
}

}
