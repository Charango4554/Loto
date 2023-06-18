public class AjoutJoueurDlg extends javax.swing.JDialog {

    private Joueur j;        // Création d'un objet Joueur qui sera utilisé plus tard
    private boolean valide; // Création d'une variable booléenne qui servira à valider les entrées utilisateur

    public AjoutJoueurDlg(java.awt.Frame parent) {
        super(parent, true);
        initComponents();   // Initialisation des composants graphiques de la fenêtre

        valide = false;      // Initialisation de la variable booléenne à false
        j = null;            // Initialisation de l'objet Joueur à null
        Solde.setText(new Joueur().getSolde()+" €"); // Affichage du solde du joueur dans l'interface graphique
        setVisible(true);    // Affichage de la fenêtre
    }

    @SuppressWarnings("unchecked")  // Annotation pour ignorer les avertissements de type non vérifiés
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titre = new javax.swing.JLabel();
        PanCentre = new javax.swing.JPanel();
        LabPseudo = new javax.swing.JLabel();
        Pseudo = new javax.swing.JTextField();
        LabCouleur = new javax.swing.JLabel();
        PanCouleur = new javax.swing.JPanel();
        ChagerCouleur = new javax.swing.JButton();
        Couleur = new javax.swing.JPanel();
        LabSolde = new javax.swing.JLabel();
        Solde = new javax.swing.JLabel();
        PanBoutons = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Titre.setFont(new java.awt.Font("Tahoma", 1, 14));
        Titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titre.setText("Saisie d'un nouveau joueur");
        getContentPane().add(Titre, java.awt.BorderLayout.NORTH);

        PanCentre.setLayout(new java.awt.GridLayout(4, 2));

        LabPseudo.setText("Pseudo");
        PanCentre.add(LabPseudo);
        PanCentre.add(Pseudo);

        LabCouleur.setText("Couleur");
        PanCentre.add(LabCouleur);

        PanCouleur.setLayout(new java.awt.GridLayout(1, 2));

        ChagerCouleur.setText("Choisir couleur");
        ChagerCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChagerCouleurActionPerformed(evt);
            }
        });
        PanCouleur.add(ChagerCouleur);

        javax.swing.GroupLayout CouleurLayout = new javax.swing.GroupLayout(Couleur);
        Couleur.setLayout(CouleurLayout);
        CouleurLayout.setHorizontalGroup(
            CouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );
        CouleurLayout.setVerticalGroup(
            CouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        PanCouleur.add(Couleur);

        PanCentre.add(PanCouleur);

        LabSolde.setText("Solde");
        PanCentre.add(LabSolde);
        PanCentre.add(Solde);

        getContentPane().add(PanCentre, java.awt.BorderLayout.CENTER);

        PanBoutons.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        PanBoutons.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        PanBoutons.add(Valider);

        getContentPane().add(PanBoutons, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // Ferme la fenêtre
        dispose();
    }//GEN-LAST:event_AnnulerActionPerformed
// Cette méthode permet d'obtenir la valeur de l'attribut 'valide'
public boolean getValide(){
    return valide;
}

// Cette méthode permet d'obtenir l'objet Joueur associé à cette instance
public Joueur getJoueur(){
    return j;
}
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
// Vérifie si le texte dans le champ "Pseudo" n'est pas vide.
    if(!Pseudo.getText().strip().equals("")){
// Crée un nouvel objet Joueur.
        j = new Joueur();
        // Définit le pseudo du joueur avec le texte entré dans le champ "Pseudo".
        j.setPseudo(Pseudo.getText().strip());
        // Définit la couleur du joueur avec la couleur du composant "Couleur".
        j.setCouleur(Couleur.getBackground());
        // Marque la validation comme étant réussie.
        valide = true;
        // Ferme la fenêtre courante.
        dispose();
    } else {
// Affiche un message d'erreur si le champ "Pseudo" est vide.
javax.swing.JOptionPane.showMessageDialog(this, "Veuillez entrer un pseudo.", "Attention", javax.swing.JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_ValiderActionPerformed
    private void ChagerCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChagerCouleurActionPerformed
    // Définition d'une nouvelle couleur blanche en utilisant la classe Color de Java AWT
    java.awt.Color c = new java.awt.Color(255, 255, 255);

    // Ouverture de l'outil de sélection de couleur JColorChooser de Java Swing et affichage de la boîte de dialogue pour choisir une couleur, en utilisant la couleur c comme couleur initiale
    c = javax.swing.JColorChooser.showDialog(this, "Selectionnez une couleur", c);

    // Attribution de la couleur sélectionnée à l'arrière-plan d'un objet nommé "Couleur"
    Couleur.setBackground(c);
    }//GEN-LAST:event_ChagerCouleurActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton ChagerCouleur;
    private javax.swing.JPanel Couleur;
    private javax.swing.JLabel LabCouleur;
    private javax.swing.JLabel LabPseudo;
    private javax.swing.JLabel LabSolde;
    private javax.swing.JPanel PanBoutons;
    private javax.swing.JPanel PanCentre;
    private javax.swing.JPanel PanCouleur;
    private javax.swing.JTextField Pseudo;
    private javax.swing.JLabel Solde;
    private javax.swing.JLabel Titre;
    private javax.swing.JButton Valider;
    // End of variables declaration//GEN-END:variables
}
