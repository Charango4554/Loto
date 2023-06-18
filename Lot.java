public class Lot {
    private int niveau;
    private String description;
    Lot(int n, String d){
        niveau = n;
        description = d;
    }
    public String getDescription(){return description;}
    public int getNiveau(){return niveau;}
    public String toString(){
        return getDescription();
    }
    public void afficheLot(javax.swing.JButton jb){
        jb.setIcon(null);
        jb.setText("");
        if(this instanceof Cadeau){
            jb.setIcon(((Cadeau)this).getPhoto());
        }else{
            jb.setText(toString());
        }
    }
}
