
public class LeJeuLoto extends javax.swing.JFrame {

    private LesJoueurs lj; // collection des joueurs
    private LesLots ll; // collection de lots
    private Lot lotj; // lot en jeu
    private boolean partieTerminee, // vrai si la partie est finie
            carteAchetee;// vrai si une carte à été achetée
    private int option, // option de jeu choisie
            nbCol, // nombre de colonnes des cartes
            nbLig, // nombre de lignes des cartes
            nbNum, // nombre de numéros présents dans chaque carte
            boules[]; // boules déja tirés
    private final int MAX = 90; // valeur maximale que peut prendre les numéros d'une carte

    public LeJeuLoto() {
        initComponents();
        // initialise les collections et les variables
        lj = new LesJoueurs();
        ll = new LesLots();
        lotj = null;
        carteAchetee = partieTerminee = false;
        option = 1;
        nbCol = 5;
        nbLig = 3;
        nbNum = 4;
        // initialise l'historique des boules
        initBoules();
        // initialise les lots
        initLots();
        // initJoueurs();
    }

    public void initJoueurs() {
        // initialisation à des fins de test
        lj.ajouteJoueur(new Joueur("Elis"));
        lj.ajouteJoueur(new Joueur("Bob"));
        // actualise l'affichage des joueurs
        refreshJoueurs();
    }

    public void initLots() {
        // initialise la collection de lots
        ll.initLesLots();
    }

    public void initBoules() {
        // initialise la liste des boules tirées
        boules = new int[MAX];
        // normalement inutile
        for (int i = 0; i < boules.length; i++) {
            boules[i] = 0;
        }
    }

    private void afficheCartes() {
        // dessine les cartes dans le panel prévu à cet effet
        int i = 0, k;
        for (Joueur j : lj.getJoueurs()) {
            switch (j.getMesCartes().getTaille()) {
                // selon la taille de la collection de cartes de chaque joueur
                case 1:
                    // dessine la carte du joueur
                    j.getMesCartes().getCarte(0)
                            .dessineCarte((javax.swing.JPanel) LesCartons
                                    .getComponent(i), j.getCouleur());
                case 0:
                    i += 2; // on passe au joueur suivant
                    break;
                default:
                    // dessine chaque carte du joueur
                    for (k = 0; k < j.getMesCartes().getTaille(); k++, i++) {
                        j.getMesCartes().getCarte(k)
                                .dessineCarte((javax.swing.JPanel) LesCartons
                                        .getComponent(i), j.getCouleur());
                    }
            }
        }
    }

    private void refreshJoueurs() {
        // Actualise l'affichage des joueurs sur les bouttons
        int i;
        javax.swing.JButton[] aj = new javax.swing.JButton[]{Joueur1, Joueur2, Joueur3, Joueur4};
        for (i = 0; i < lj.getNbJoueurs(); i++) {// sur chaque bouton,
            aj[i].setText(lj.getJoueur(i).getPseudo()); // affiche le nom du joueur
            aj[i].setBackground(lj.getJoueur(i).getCouleur()); // affiche la couleur du joueur
        }
        while (i < 4) { // pour les emplacements non-utilisés
            aj[i].setText("Joueur" + (i + 1)); // affiche 'JoueurN' par défaut
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanCentre = new javax.swing.JPanel();
        LabCentre = new javax.swing.JLabel();
        LesCartons = new javax.swing.JPanel();
        Carte1 = new javax.swing.JPanel();
        Carte2 = new javax.swing.JPanel();
        Carte3 = new javax.swing.JPanel();
        Carte4 = new javax.swing.JPanel();
        Carte5 = new javax.swing.JPanel();
        Carte6 = new javax.swing.JPanel();
        Carte7 = new javax.swing.JPanel();
        Carte8 = new javax.swing.JPanel();
        PanJoueurs = new javax.swing.JPanel();
        Joueur1 = new javax.swing.JButton();
        Joueur2 = new javax.swing.JButton();
        Joueur3 = new javax.swing.JButton();
        Joueur4 = new javax.swing.JButton();
        PanSud = new javax.swing.JPanel();
        LabCadeau = new javax.swing.JLabel();
        PanSSud = new javax.swing.JPanel();
        PanHistorique = new javax.swing.JPanel();
        LabHistorique = new javax.swing.JLabel();
        Sop = new javax.swing.JPanel();
        spHistorique = new javax.swing.JScrollPane();
        Historique = new javax.swing.JTextArea();
        Cadeau = new javax.swing.JButton();
        PanOption = new javax.swing.JPanel();
        LabOption = new javax.swing.JLabel();
        PanTirage = new javax.swing.JPanel();
        NouveauTirage = new javax.swing.JButton();
        LabTirage = new javax.swing.JLabel();
        Arreter = new javax.swing.JButton();
        Menu = new javax.swing.JMenuBar();
        MenuAjout = new javax.swing.JMenu();
        AjoutJoueur = new javax.swing.JMenuItem();
        AjoutLot = new javax.swing.JMenuItem();
        MenuAction = new javax.swing.JMenu();
        ActionOptionJeu = new javax.swing.JMenuItem();
        ActionAcheterCartes = new javax.swing.JMenuItem();
        ActionDemarrerJeu = new javax.swing.JMenuItem();
        ActionContinuer = new javax.swing.JMenuItem();
        ActionRecommencer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanCentre.setLayout(new java.awt.BorderLayout());

        LabCentre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        LabCentre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCentre.setText("Voici les cartes dont vous disposez");
        LabCentre.setToolTipText("");
        PanCentre.add(LabCentre, java.awt.BorderLayout.NORTH);

        LesCartons.setLayout(new java.awt.GridLayout(4, 2));

        javax.swing.GroupLayout Carte1Layout = new javax.swing.GroupLayout(Carte1);
        Carte1.setLayout(Carte1Layout);
        Carte1Layout.setHorizontalGroup(
            Carte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte1Layout.setVerticalGroup(
            Carte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte1);

        javax.swing.GroupLayout Carte2Layout = new javax.swing.GroupLayout(Carte2);
        Carte2.setLayout(Carte2Layout);
        Carte2Layout.setHorizontalGroup(
            Carte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte2Layout.setVerticalGroup(
            Carte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte2);

        javax.swing.GroupLayout Carte3Layout = new javax.swing.GroupLayout(Carte3);
        Carte3.setLayout(Carte3Layout);
        Carte3Layout.setHorizontalGroup(
            Carte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte3Layout.setVerticalGroup(
            Carte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte3);

        javax.swing.GroupLayout Carte4Layout = new javax.swing.GroupLayout(Carte4);
        Carte4.setLayout(Carte4Layout);
        Carte4Layout.setHorizontalGroup(
            Carte4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte4Layout.setVerticalGroup(
            Carte4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte4);

        javax.swing.GroupLayout Carte5Layout = new javax.swing.GroupLayout(Carte5);
        Carte5.setLayout(Carte5Layout);
        Carte5Layout.setHorizontalGroup(
            Carte5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte5Layout.setVerticalGroup(
            Carte5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte5);

        javax.swing.GroupLayout Carte6Layout = new javax.swing.GroupLayout(Carte6);
        Carte6.setLayout(Carte6Layout);
        Carte6Layout.setHorizontalGroup(
            Carte6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte6Layout.setVerticalGroup(
            Carte6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte6);

        javax.swing.GroupLayout Carte7Layout = new javax.swing.GroupLayout(Carte7);
        Carte7.setLayout(Carte7Layout);
        Carte7Layout.setHorizontalGroup(
            Carte7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte7Layout.setVerticalGroup(
            Carte7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte7);

        javax.swing.GroupLayout Carte8Layout = new javax.swing.GroupLayout(Carte8);
        Carte8.setLayout(Carte8Layout);
        Carte8Layout.setHorizontalGroup(
            Carte8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        Carte8Layout.setVerticalGroup(
            Carte8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        LesCartons.add(Carte8);

        PanCentre.add(LesCartons, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanCentre, java.awt.BorderLayout.CENTER);

        PanJoueurs.setLayout(new java.awt.GridLayout(4, 1));

        Joueur1.setText("Joueur1");
        Joueur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Joueur1ActionPerformed(evt);
            }
        });
        PanJoueurs.add(Joueur1);

        Joueur2.setText("Joueur2");
        Joueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Joueur2ActionPerformed(evt);
            }
        });
        PanJoueurs.add(Joueur2);

        Joueur3.setText("Joueur3");
        Joueur3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Joueur3ActionPerformed(evt);
            }
        });
        PanJoueurs.add(Joueur3);

        Joueur4.setText("Joueur4");
        Joueur4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Joueur4ActionPerformed(evt);
            }
        });
        PanJoueurs.add(Joueur4);

        getContentPane().add(PanJoueurs, java.awt.BorderLayout.EAST);

        PanSud.setLayout(new java.awt.BorderLayout());

        LabCadeau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCadeau.setText("Cadeau : ");
        PanSud.add(LabCadeau, java.awt.BorderLayout.NORTH);

        PanSSud.setLayout(new java.awt.GridLayout(1, 2));

        PanHistorique.setLayout(new java.awt.BorderLayout());

        LabHistorique.setText("Historique du tirage des boules");
        PanHistorique.add(LabHistorique, java.awt.BorderLayout.NORTH);

        Sop.setLayout(new java.awt.GridLayout(1, 2));

        Historique.setEditable(false);
        Historique.setColumns(20);
        Historique.setLineWrap(true);
        Historique.setRows(5);
        Historique.setWrapStyleWord(true);
        Historique.setEnabled(false);
        spHistorique.setViewportView(Historique);

        Sop.add(spHistorique);

        Cadeau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadeauActionPerformed(evt);
            }
        });
        Sop.add(Cadeau);

        PanHistorique.add(Sop, java.awt.BorderLayout.CENTER);

        PanSSud.add(PanHistorique);

        PanOption.setLayout(new java.awt.BorderLayout());

        LabOption.setText("Option choisie :");
        PanOption.add(LabOption, java.awt.BorderLayout.NORTH);

        PanTirage.setLayout(new java.awt.GridLayout(1, 3));

        NouveauTirage.setText("Tirage");
        NouveauTirage.setEnabled(false);
        NouveauTirage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NouveauTirageActionPerformed(evt);
            }
        });
        PanTirage.add(NouveauTirage);

        LabTirage.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        LabTirage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanTirage.add(LabTirage);

        Arreter.setText("Arrêter");
        Arreter.setEnabled(false);
        Arreter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArreterActionPerformed(evt);
            }
        });
        PanTirage.add(Arreter);

        PanOption.add(PanTirage, java.awt.BorderLayout.CENTER);

        PanSSud.add(PanOption);

        PanSud.add(PanSSud, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanSud, java.awt.BorderLayout.SOUTH);

        MenuAjout.setText("Ajout");

        AjoutJoueur.setText("Joueur");
        AjoutJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutJoueurActionPerformed(evt);
            }
        });
        MenuAjout.add(AjoutJoueur);

        AjoutLot.setText("Lot");
        AjoutLot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutLotActionPerformed(evt);
            }
        });
        MenuAjout.add(AjoutLot);

        Menu.add(MenuAjout);

        MenuAction.setText("Action");

        ActionOptionJeu.setText("Options Jeu");
        ActionOptionJeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionOptionJeuActionPerformed(evt);
            }
        });
        MenuAction.add(ActionOptionJeu);

        ActionAcheterCartes.setText("Acheter cartes");
        ActionAcheterCartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionAcheterCartesActionPerformed(evt);
            }
        });
        MenuAction.add(ActionAcheterCartes);

        ActionDemarrerJeu.setText("Démarrer Jeu");
        ActionDemarrerJeu.setEnabled(false);
        ActionDemarrerJeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionDemarrerJeuActionPerformed(evt);
            }
        });
        MenuAction.add(ActionDemarrerJeu);

        ActionContinuer.setText("Continuer");
        ActionContinuer.setEnabled(false);
        ActionContinuer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionContinuerActionPerformed(evt);
            }
        });
        MenuAction.add(ActionContinuer);

        ActionRecommencer.setText("Recommencer");
        ActionRecommencer.setEnabled(false);
        ActionRecommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionRecommencerActionPerformed(evt);
            }
        });
        MenuAction.add(ActionRecommencer);

        Menu.add(MenuAction);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void AjoutJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutJoueurActionPerformed
        // Ajoute un nouveau joueur
        if (lj.getNbJoueurs() < 4) {// si le nombre maximum de joueur n'a pas été atteint
            AjoutJoueurDlg a = new AjoutJoueurDlg(this);
            if (a.getValide()) { // si l'entrée a été validée
                lj.ajouteJoueur(a.getJoueur()); // ajoute le joueur à la collection
            }
            // actualise la liste des joueurs sur les bouton
            refreshJoueurs();
            // vérifie si la partie est prête à être lancée
            verifPartiePrete();
        }
    }//GEN-LAST:event_AjoutJoueurActionPerformed
    private void AjoutLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutLotActionPerformed
        // AjoutLotDlg facultative
        // réinitialise la liste des lots si besoin
        initLots();
        // vérifie si la partie est prête à être lancée
        verifPartiePrete();
    }//GEN-LAST:event_AjoutLotActionPerformed
    private void Joueur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Joueur1ActionPerformed
        visuJoueur(0); // affiche le joueur 1 dans VisuJoueurDlg
    }//GEN-LAST:event_Joueur1ActionPerformed
    private void Joueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Joueur2ActionPerformed
        visuJoueur(1); // affiche le joueur 2 dans VisuJoueurDlg
    }//GEN-LAST:event_Joueur2ActionPerformed
    private void Joueur3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Joueur3ActionPerformed
        visuJoueur(2); // affiche le joueur 3 dans VisuJoueurDlg
    }//GEN-LAST:event_Joueur3ActionPerformed
    private void Joueur4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Joueur4ActionPerformed
        visuJoueur(3); // affiche le joueur 4 dans VisuJoueurDlg
    }//GEN-LAST:event_Joueur4ActionPerformed
    private void ActionOptionJeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionOptionJeuActionPerformed
        // création de la boite de dialogue OptionDlg et affichage de cette dernière
        OptionDlg od = new OptionDlg(this, carteAchetee, nbCol, nbNum);
        od.setVisible(true);
        // récupère les valeurs de la boite de dialogue
        nbCol = od.getNbCol();
        nbNum = od.getNbNum();
        option = od.getChoixOpt();
        // affiche l'option choisie dans l'interface
        String opt = "Option choisie : ";
        switch (option) {
            case 1:
                opt += "Quine";
                break;
            case 2:
                opt += "Double Quine";
                break;
            case 3:
                opt += "Carton plein";
                break;
            default:
        }
        LabOption.setText(opt);
        // vérifie si la partie est prête à être lancée
        verifPartiePrete();
    }//GEN-LAST:event_ActionOptionJeuActionPerformed

    private void ActionAcheterCartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionAcheterCartesActionPerformed
        if (lj.getNbJoueurs() > 0){ // si il a au moins un joueur dans la partie
            AchatCarteDlg ad = new AchatCarteDlg(this, nbLig, nbCol, nbNum, lj);
            ad.setVisible(true);
            if (carteAchetee |= ad.getAchat()) { // si une carte a été achetée
                afficheCartes(); // actualise l'affichage des cartes
            }
            // vérifie si la partie est prête à être lancée
            verifPartiePrete();
        }
    }//GEN-LAST:event_ActionAcheterCartesActionPerformed

    private void verifPartiePrete() {
        // vérifie si la partie est prête à être lancée
        boolean c = true;
        for (Joueur j : lj.getJoueurs()) { // vérifie que chaque joueur possède au moins une carte
            c &= j.getMesCartes().getTaille() > 0;
        }
        c &= !LabOption.getText().equals("Option choisie :"); // vérifie qu'une option a été choisie
        c &= ll.getTaille() > 0; // vérifie qu'il y a au moins un lot dans la collection
        c &= lj.getNbJoueurs() > 1; // vérifie qu'il y a au moins un joueur dans la partie
        ActionDemarrerJeu.setEnabled(c); // active la sous option du menu si elle répond à tous les critères
    }
    private void NouveauTirageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NouveauTirageActionPerformed
        int nb;
        String msg;
        LesJoueurs Gagnants = new LesJoueurs();
        // tire une boule aléatoirement en vérifiant qu'elle n'a pas été encore tirée
        do {
            nb = new java.util.Random().nextInt(MAX);
        } while (boules[nb] > 0);
        boules[nb]++;
        LabTirage.setText("" + nb); // affiche le numéro de la boule tirée
        Historique.append(nb + " "); // l'ajoute à l'historique
        // pour chaque joueur, vérifie si il y a un gagnant
        for (Joueur j : lj.getJoueurs()) {
            for (CarteLoto c : j.getMesCartes().getCartes()) {
                if (c.placePion(nb)) {
                    if (c.cartonGagnant(option)) { // si un joueur est gagnant
                        Gagnants.ajouteJoueur(j); // l'ajoute à la collection Gagnants
                    }
                }
            }
        }
        // actualise l'affichage des cartes
        afficheCartes();
        nb = -1;
        if (Gagnants.getNbJoueurs() > 0) { // si il y a au moins un gagnant
            // affiche les logs dans l'historique
            msg = "\n" + Gagnants.toString();
            msg += Gagnants.getNbJoueurs() == 1 ? " a gagné en réalisant un "
                    : " ont gagné en réalisant chacun un ";
            switch (option) {
                case 2:
                    msg += "double ";
                case 1:
                    msg += "quine";
                    break;
                default:
                    msg += "carton plein";
            }
            // si il y a plusieurs gagnant, offre le lot à un joueur aléatoirement
            nb = Gagnants.getNbJoueurs() == 1 ? 0 : new java.util.Random()
                    .nextInt(Gagnants.getNbJoueurs());
            msg += ".\n" + Gagnants.getJoueur(nb).getPseudo() + " remporte le cadeau : "
                    + lotj.toString();
            Historique.append(msg); // affiche les logs
            Gagnants.getJoueur(nb).getMesLots().ajouteLot(lotj); // ajoute le lot à la collection du joueur
            lotj = null; // vide le lot à gagner
            ArreterActionPerformed(evt); // arrête la partie
            partieTerminee = true; // déclare la partie comme terminée
        }
    }//GEN-LAST:event_NouveauTirageActionPerformed

    private void ActionDemarrerJeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionDemarrerJeuActionPerformed
        // essaye de lancer une partie
        try{
            lotj = ll.piocheLot(option); // pioche un lot dans la collection
            initBoules(); // initialise les boules tirées
            // affiche le lot choisi
            LabCadeau.setText("Cadeau : " + lotj.toString());
            lotj.afficheLot(Cadeau);
            // active les contrôles nécessaires et désactive les autres
            AjoutJoueur.setEnabled(false);
            AjoutLot.setEnabled(false);
            ActionOptionJeu.setEnabled(false);
            ActionAcheterCartes.setEnabled(false);
            ActionDemarrerJeu.setEnabled(false);
            ActionContinuer.setEnabled(false);
            ActionRecommencer.setEnabled(true);
            NouveauTirage.setEnabled(true);
            Arreter.setEnabled(true);
            // affiche les joueurs présents dans la partie dans l'historique
            Historique.append("Joueurs : " + lj.toString() + "\nLot : " + lotj.toString() + "\n");
        } catch (RuntimeException e) {
            // en cas d'erreur, on affiche cette dernière
            javax.swing.JOptionPane.showMessageDialog(this, e.toString(), "Erreur",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ActionDemarrerJeuActionPerformed

    private void ActionRecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionRecommencerActionPerformed
        // réinitialise (presque) tout
        Historique.setText(""); // efface l'historique
        // efface le lot
        Cadeau.setText("");
        Cadeau.repaint();
        if(!partieTerminee){
            ll.ajouteLot(lotj); //range le lot non gagné
            lotj = null;
        }
        LabCadeau.setText("Cadeau : ");
        // réinitialise l'affichage des options de jeu
        LabOption.setText("Option choisie :");
        // réinitialisation des cartes achetées
        carteAchetee = false;
        for (Joueur j : lj.getJoueurs()) {
            j.supprimeCartes();
            if (j.getSolde() < new CarteLoto().getPrix()) { // si un joueur n'a plus assez d'argent,
                // on lui passe assez pour lui permettre d'acheter une carte
                j.setSolde(new CarteLoto().getPrix());
            }
        }
        // réinitialise l'affichage des cartes
        for (java.awt.Component c : LesCartons.getComponents()) {
            ((java.awt.Container) c).removeAll();
        }
        LesCartons.revalidate();
        // réinitialise l'activation/désactivation des composants graphiques
        AjoutJoueur.setEnabled(true);
        AjoutLot.setEnabled(true);
        ActionOptionJeu.setEnabled(true);
        ActionAcheterCartes.setEnabled(true);
        ActionDemarrerJeu.setEnabled(false);
        ActionContinuer.setEnabled(false);
        ActionRecommencer.setEnabled(false);
        NouveauTirage.setEnabled(false);
        Arreter.setEnabled(false);
    }//GEN-LAST:event_ActionRecommencerActionPerformed

    private void ArreterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArreterActionPerformed
        // desactive les boutons pour tirer et arrêter le jeu
        // et ne laisse active que les options pour continuer ou recommencer la partie
        ActionContinuer.setEnabled(true);
        ActionRecommencer.setEnabled(true);
        NouveauTirage.setEnabled(false);
        Arreter.setEnabled(false);
    }//GEN-LAST:event_ArreterActionPerformed

    private void ActionContinuerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionContinuerActionPerformed
        // Si la précédente partie était terminée, on essaie de passer au niveau au dessus
        if (partieTerminee) {
            if (option < 3) {
                try{
                    lotj = ll.piocheLot(option + 1); // essaye de piocher un lot adapté au niveau de jeu
                    option++;// si rien ne foire, on augmente le niveau de jeu
                    // on affiche le nouveau lot
                    LabCadeau.setText("Cadeau : " + lotj.toString());
                    lotj.afficheLot(Cadeau);
                    // on affiche les nouvelles optopns de jeu
                    LabOption.setText(option == 2 ? "Double Quine" : "Carton plein");
                    partieTerminee = false; // la partie n'est pas finie et peu continuer
                    Historique.append("\nPartie continuée\n"); // on affiche les logs
                }catch(RuntimeException e){
                    // en cas d'erreur, on affiche cette dernière
                    javax.swing.JOptionPane.showMessageDialog(this, e.toString(), "Erreur",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                // informe l'utilisateur que l'on ne peut continuer la partie
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Impossible de continuer (carton plein).", "Erreur",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // si la partie peut continuer, on active les composants nécéssaires au jeu
        if (!partieTerminee) {
            ActionContinuer.setEnabled(false);
            ActionRecommencer.setEnabled(true);
            Arreter.setEnabled(true);
            NouveauTirage.setEnabled(true);
        }
    }//GEN-LAST:event_ActionContinuerActionPerformed

    private void CadeauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadeauActionPerformed
    }//GEN-LAST:event_CadeauActionPerformed
    private void visuJoueur(int i) {
        // affiche le joueur dont l'id est passé en paramètre dans VisuJoueurDlg
        if (i < lj.getNbJoueurs()) {
            new VisuJoueurDlg(this, lj.getJoueur(i));
        }
    }
    // point d'entrée
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeJeuLoto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActionAcheterCartes;
    private javax.swing.JMenuItem ActionContinuer;
    private javax.swing.JMenuItem ActionDemarrerJeu;
    private javax.swing.JMenuItem ActionOptionJeu;
    private javax.swing.JMenuItem ActionRecommencer;
    private javax.swing.JMenuItem AjoutJoueur;
    private javax.swing.JMenuItem AjoutLot;
    private javax.swing.JButton Arreter;
    private javax.swing.JButton Cadeau;
    private javax.swing.JPanel Carte1;
    private javax.swing.JPanel Carte2;
    private javax.swing.JPanel Carte3;
    private javax.swing.JPanel Carte4;
    private javax.swing.JPanel Carte5;
    private javax.swing.JPanel Carte6;
    private javax.swing.JPanel Carte7;
    private javax.swing.JPanel Carte8;
    private javax.swing.JTextArea Historique;
    private javax.swing.JButton Joueur1;
    private javax.swing.JButton Joueur2;
    private javax.swing.JButton Joueur3;
    private javax.swing.JButton Joueur4;
    private javax.swing.JLabel LabCadeau;
    private javax.swing.JLabel LabCentre;
    private javax.swing.JLabel LabHistorique;
    private javax.swing.JLabel LabOption;
    private javax.swing.JLabel LabTirage;
    private javax.swing.JPanel LesCartons;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu MenuAction;
    private javax.swing.JMenu MenuAjout;
    private javax.swing.JButton NouveauTirage;
    private javax.swing.JPanel PanCentre;
    private javax.swing.JPanel PanHistorique;
    private javax.swing.JPanel PanJoueurs;
    private javax.swing.JPanel PanOption;
    private javax.swing.JPanel PanSSud;
    private javax.swing.JPanel PanSud;
    private javax.swing.JPanel PanTirage;
    private javax.swing.JPanel Sop;
    private javax.swing.JScrollPane spHistorique;
    // End of variables declaration//GEN-END:variables
}
