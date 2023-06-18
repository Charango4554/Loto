public class VisuJoueurDlg extends javax.swing.JDialog {
    public VisuJoueurDlg(java.awt.Frame parent, Joueur j) {
        super(parent, true);
        initComponents();
        // affiche les attributs du joueur dans les bons contrôles
        PseudoJoueur.setText(j.getPseudo());
        CouleurJoueur.setBackground(j.getCouleur());
        SoldeJoueur.setText(""+j.getSolde()+" €");
        IconeJoueur.setIcon(j.getPhoto());
        if(j.getMesLots().getTaille() > 0){
            LotsGagnes.setText(j.getMesLots().toString());
        }
        // affiche la boite de dialogue à l'écran
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabTitre = new javax.swing.JLabel();
        PanCentre = new javax.swing.JPanel();
        PanOuest = new javax.swing.JPanel();
        LabPseudo = new javax.swing.JLabel();
        PseudoJoueur = new javax.swing.JLabel();
        LabCouleur = new javax.swing.JLabel();
        CouleurJoueur = new javax.swing.JPanel();
        LabSolde = new javax.swing.JLabel();
        SoldeJoueur = new javax.swing.JLabel();
        PanEst = new javax.swing.JPanel();
        LotsGagnes = new javax.swing.JTextArea();
        IconeJoueur = new javax.swing.JButton();
        PanSud = new javax.swing.JPanel();
        osef = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabTitre.setText("Informations relatives à un joueur");
        getContentPane().add(LabTitre, java.awt.BorderLayout.NORTH);

        PanCentre.setLayout(new java.awt.GridLayout(1, 2));

        PanOuest.setLayout(new java.awt.GridLayout(3, 2));

        LabPseudo.setText("Pseudo");
        PanOuest.add(LabPseudo);
        PanOuest.add(PseudoJoueur);

        LabCouleur.setText("Couleur");
        PanOuest.add(LabCouleur);
        PanOuest.add(CouleurJoueur);

        LabSolde.setText("Solde");
        PanOuest.add(LabSolde);
        PanOuest.add(SoldeJoueur);

        PanCentre.add(PanOuest);

        PanEst.setLayout(new java.awt.GridLayout(1, 2));

        LotsGagnes.setColumns(20);
        LotsGagnes.setLineWrap(true);
        LotsGagnes.setRows(5);
        LotsGagnes.setText("Aucun lot gagné");
        LotsGagnes.setWrapStyleWord(true);
        PanEst.add(LotsGagnes);
        PanEst.add(IconeJoueur);

        PanCentre.add(PanEst);

        getContentPane().add(PanCentre, java.awt.BorderLayout.CENTER);

        PanSud.setLayout(new java.awt.GridLayout(1, 2));
        PanSud.add(osef);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        PanSud.add(Fermer);

        getContentPane().add(PanSud, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        // ferme la fenêtre
        dispose();
    }//GEN-LAST:event_FermerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CouleurJoueur;
    private javax.swing.JButton Fermer;
    private javax.swing.JButton IconeJoueur;
    private javax.swing.JLabel LabCouleur;
    private javax.swing.JLabel LabPseudo;
    private javax.swing.JLabel LabSolde;
    private javax.swing.JLabel LabTitre;
    private javax.swing.JTextArea LotsGagnes;
    private javax.swing.JPanel PanCentre;
    private javax.swing.JPanel PanEst;
    private javax.swing.JPanel PanOuest;
    private javax.swing.JPanel PanSud;
    private javax.swing.JLabel PseudoJoueur;
    private javax.swing.JLabel SoldeJoueur;
    private javax.swing.JButton osef;
    // End of variables declaration//GEN-END:variables
}
