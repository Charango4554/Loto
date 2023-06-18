import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class AchatCarteDlg extends javax.swing.JDialog {
    private LesJoueurs ljc; // collections des joueurs de la partie
    private int nbCol, nbLig, nbNum; // caractéristiques de la carte à générer
    private Joueur jc; // joueur courant
    private CarteLoto cc; // carte courante
    private boolean achat; // vrai si au moins un joueur a acheté une carte
    public AchatCarteDlg(java.awt.Frame parent, int nbLig, int nbCol, int nbNum, LesJoueurs ljc) {
        super(parent, true); 
        initComponents(); 
        // initialisation des attributs
        this.nbLig = nbLig;
        this.nbCol = nbCol;
        this.nbNum = nbNum; 
        this.ljc = ljc;
        achat = false;
        jc = ljc.getJoueur(0);
        // création de la carte aléatoire
        cc = new CarteLoto(this.nbCol, this.nbLig, this.nbNum);
        // remplissage de la JComboBox avec les noms des joueurs
        remplirListeJoueurs();
        // affichage de la première carte
        initCarte();
    }
    private void remplirListeJoueurs(){
        // on enlève tout ce qui pourrait nous dérander 
        ListeJoueurs.removeAllItems();
        // ajoute le pseudo de chaque joueur dans la JComboBox
        for(int i = 0; i < ljc.getNbJoueurs(); i++){
            ListeJoueurs.addItem(ljc.getJoueur(i).getPseudo());
        }
        // on sélectionne le premier joueur de la liste
        ListeJoueursActionPerformed(new ActionEvent(this, 1, ""));
    }
    private void initCarte(){
        // modifie l'affichage pour coller aux cases de la carte
        Panneau.setLayout(new GridLayout(nbLig, nbCol));
        // ajoute un bouton pour modéliser chaque case de la carte
        for(int i = 0; i < nbLig * nbCol; i++){
            Panneau.add(new JButton(" "));
        }
        // affiche la carte générée 
        afficheCarte();
    }
    private void afficheCarte(){
        int i, j;
        // pour chaque case de la carte, on affiche sa valeur dans un bouton du Paneau
        for(i = 0; i < nbLig; i++){
            for(j=0; j < nbCol; j++){
                ((JButton) Panneau.getComponent(i*nbCol+j)).setText((cc
                        .getCase(i, j) == 0 ? "" : "" + cc.getCase(i, j)));
            }
        }
    }
    public boolean getAchat() {
        // accesseur permettant de savoir si une carte a été achetée
        // une fois la boite de dialogue fermée
        return achat;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titre = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        PanSud = new javax.swing.JPanel();
        InfoSolde = new javax.swing.JLabel();
        PanBoutonsSud = new javax.swing.JPanel();
        ListeJoueurs = new javax.swing.JComboBox<>();
        AutreChoix = new javax.swing.JButton();
        Acheter = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 250));

        Titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titre.setText("Acheter une ou plusieurs cartes");
        getContentPane().add(Titre, java.awt.BorderLayout.NORTH);

        Panneau.setLayout(null);
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        PanSud.setLayout(new java.awt.BorderLayout());

        InfoSolde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanSud.add(InfoSolde, java.awt.BorderLayout.NORTH);

        PanBoutonsSud.setLayout(new java.awt.GridLayout(1, 4));

        ListeJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeJoueursActionPerformed(evt);
            }
        });
        PanBoutonsSud.add(ListeJoueurs);

        AutreChoix.setText("AutreChoix");
        AutreChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutreChoixActionPerformed(evt);
            }
        });
        PanBoutonsSud.add(AutreChoix);

        Acheter.setText("Acheter");
        Acheter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcheterActionPerformed(evt);
            }
        });
        PanBoutonsSud.add(Acheter);

        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        PanBoutonsSud.add(Quitter);

        PanSud.add(PanBoutonsSud, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanSud, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AutreChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutreChoixActionPerformed
        cc = new CarteLoto(this.nbCol, this.nbLig, this.nbNum);
        afficheCarte();
    }//GEN-LAST:event_AutreChoixActionPerformed

    private void AcheterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcheterActionPerformed
        // achète la carte si le joueur courant le peut
        boolean t = jc.acheter(cc);
        if(t){ // si il a pu l'acheter
            // on actualise l'affichage de son solde
            InfoSolde.setText("" + jc.getPseudo() + " dispose de " + jc.getSolde() + "€");
            // un achat a été réalisé
            achat = true;
            // on crée une nouvelle carte et on l'affiche
            cc = new CarteLoto(this.nbCol, this.nbLig, this.nbNum);
            afficheCarte();
        }else{ // il n'a pas pu l'acheter, deux raisons possibles :
            // soit il a trop de cartes en sa possesion 
            // soit il n'avait pas un solde suffisant
            // on affiche donc la raison correspondante
            javax.swing.JOptionPane.showMessageDialog(this, 
                    jc.getMesCartes().getTaille() == 2 ? 
                    "Nombre maximal de cartes atteint." : 
                    "Solde du joueur insuffisant.", "Attention", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_AcheterActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        // quitte la boite de dialogue
        dispose();
    }//GEN-LAST:event_QuitterActionPerformed

    private void ListeJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeJoueursActionPerformed
        // on change la selection du joueur
        jc = ljc.getJoueur(ListeJoueurs.getSelectedIndex());
        // un affiche le solde du joueur correspondant
        InfoSolde.setText("" + jc.getPseudo() + " dispose de " + jc.getSolde() + "€");
    }//GEN-LAST:event_ListeJoueursActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acheter;
    private javax.swing.JButton AutreChoix;
    private javax.swing.JLabel InfoSolde;
    private javax.swing.JComboBox<String> ListeJoueurs;
    private javax.swing.JPanel PanBoutonsSud;
    private javax.swing.JPanel PanSud;
    private javax.swing.JPanel Panneau;
    private javax.swing.JButton Quitter;
    private javax.swing.JLabel Titre;
    // End of variables declaration//GEN-END:variables
}
