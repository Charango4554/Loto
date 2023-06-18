public class OptionDlg extends javax.swing.JDialog {
    private int choixOpt, nbCol, nbNum;
    private boolean cartesAch;
    public OptionDlg(java.awt.Frame parent, boolean ca, int nc, int nn) {
        super(parent, true);
        initComponents();
        // Cocher l’option Quine par défaut
        RBMode1.setSelected(true);
        remplirComboCol(); // Méthode qui permet d’initialiser les valeurs de la liste déroulante
        cartesAch = ca;
        if (!ca) {// test si des cartes ont déjà été achetées
            // Fixer le nombre de colonnes à 5 et le nombre de numéros à 5 . . . 
            nbCol = nbNum = 5;
        } else {
            // Fixer le nombre de colonnes et de numéros aux valeurs reçues en paramètres
            nbCol = nc;
            nbNum = nn;
            // Afficher la valeur du nombre de numéros dans la zone d’édition (JTextField)
            NbNumero.setText("" + nbNum);
            // Sélectionner dans la liste déroulante l’index de la valeur du nombre de colonnes
            // en utilisant la  méthode (setSelectedIndex(..))
            ComboNbCol.setSelectedIndex(nbCol-5);
            // Rendre la liste et la zone d’édition non utilisables, en utilisant la méthode setEnabled(boolean)
            ComboNbCol.setEnabled(false);
            NbNumero.setEnabled(false);
            // Afficher le message: «Nb de colonnes et de numéros non modifiables» 
            // dans le JLabel nommé «Message»
            Message.setText("Nb de colonnes et de numéros non modifiables");
        }
    }
    // accesseurs en lecture
    public int getChoixOpt() { return choixOpt; }
    public int getNbCol() { return nbCol; }
    public int getNbNum() { return nbNum; }
    public void remplirComboCol(){
        // Méthode qui permet d’initialiser les valeurs de la liste déroulante à 5,6,7,8 et 9
        for(int i = 5; i < 10; i++){
            ComboNbCol.addItem("" + i);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGMode = new javax.swing.ButtonGroup();
        LabTitre = new javax.swing.JLabel();
        PanCentre = new javax.swing.JPanel();
        LabMode = new javax.swing.JLabel();
        LabCartons = new javax.swing.JLabel();
        RBMode1 = new javax.swing.JRadioButton();
        PanColonnes = new javax.swing.JPanel();
        LabColonnes = new javax.swing.JLabel();
        ComboNbCol = new javax.swing.JComboBox<>();
        RBMode2 = new javax.swing.JRadioButton();
        PanNumeros = new javax.swing.JPanel();
        LabNumeros = new javax.swing.JLabel();
        NbNumero = new javax.swing.JTextField();
        RBMode3 = new javax.swing.JRadioButton();
        Message = new javax.swing.JLabel();
        PanSud = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabTitre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        LabTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabTitre.setText("Options du jeu");
        getContentPane().add(LabTitre, java.awt.BorderLayout.NORTH);

        PanCentre.setLayout(new java.awt.GridLayout(4, 2));

        LabMode.setText("Comment voulez-vous jouer ?");
        PanCentre.add(LabMode);

        LabCartons.setText("Configuration des cartons");
        PanCentre.add(LabCartons);

        BGMode.add(RBMode1);
        RBMode1.setText("Quine - Une ligne complète");
        PanCentre.add(RBMode1);

        PanColonnes.setLayout(new java.awt.GridLayout(1, 2));

        LabColonnes.setText("Combien de colonnes ?");
        PanColonnes.add(LabColonnes);

        PanColonnes.add(ComboNbCol);

        PanCentre.add(PanColonnes);

        BGMode.add(RBMode2);
        RBMode2.setText("Double Quine - Deux lignes complètes");
        PanCentre.add(RBMode2);

        PanNumeros.setLayout(new java.awt.GridLayout(1, 2));

        LabNumeros.setText("Combien de numéros ?");
        PanNumeros.add(LabNumeros);
        PanNumeros.add(NbNumero);

        PanCentre.add(PanNumeros);

        BGMode.add(RBMode3);
        RBMode3.setText("Carton plein - Trois lignes complètes");
        PanCentre.add(RBMode3);
        PanCentre.add(Message);

        getContentPane().add(PanCentre, java.awt.BorderLayout.CENTER);

        PanSud.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        PanSud.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        PanSud.add(Valider);

        getContentPane().add(PanSud, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // fixe la valeur du choix de jeu (choixOpt) en fonction du bouton coché
        choixOpt = RBMode3.isSelected() ? 3 : RBMode2.isSelected() ? 2 : 1;
        // récupère le nombre de colonnes sélectionné et l’affecte à nbCol
        // l'erreur peut être ignorée car ComboNbCol est rempli par le programme
        nbCol = Integer.parseInt(ComboNbCol.getSelectedItem().toString()); 
        if (NbNumero.getText().trim().equals("")){
            // si la zone d’édition correspondant au nombre de colonnes est vide,
            // un message d’erreur est affiché
            javax.swing.JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre de colonnes.",
                    "Attention", javax.swing.JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // récupère le nombre de numéros choisi (ou fixé) dans la zone d’édition et l’affecte à nbNum
                nbNum = Integer.parseInt(NbNumero.getText().trim()); // peut produire une erreur
                if ((nbNum < 5 || nbNum > nbCol * 3) && !cartesAch) {
                    // si le nombre de numéros est <5 ou supérieur au nombre de colonnes *3,
                    // un message d’erreur est affiché
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "Veuillez entrer un nombre de numéro entre 5 et trois fois le nombre de colonne.",
                            "Attention", javax.swing.JOptionPane.WARNING_MESSAGE);
                } else {
                    // sinon, ferme la boîte de dialogue
                    dispose();
                }
            } catch (Exception e) {
                // Affiche un message d'erreur
                javax.swing.JOptionPane.showMessageDialog(this, "Entrez un nombre de numéro correct",
                        "Attention", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_ValiderActionPerformed
    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // ferme la fenêtre
        dispose();
    }//GEN-LAST:event_AnnulerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.ButtonGroup BGMode;
    private javax.swing.JComboBox<String> ComboNbCol;
    private javax.swing.JLabel LabCartons;
    private javax.swing.JLabel LabColonnes;
    private javax.swing.JLabel LabMode;
    private javax.swing.JLabel LabNumeros;
    private javax.swing.JLabel LabTitre;
    private javax.swing.JLabel Message;
    private javax.swing.JTextField NbNumero;
    private javax.swing.JPanel PanCentre;
    private javax.swing.JPanel PanColonnes;
    private javax.swing.JPanel PanNumeros;
    private javax.swing.JPanel PanSud;
    private javax.swing.JRadioButton RBMode1;
    private javax.swing.JRadioButton RBMode2;
    private javax.swing.JRadioButton RBMode3;
    private javax.swing.JButton Valider;
    // End of variables declaration//GEN-END:variables
}
