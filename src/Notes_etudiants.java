import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Notes_etudiants extends javax.swing.JFrame {

    public void chargerInformationsEtudiant(String matricule) {
        String url = "jdbc:postgresql://localhost:5432/etudiants_notes";
        String user = "saleli26";
        String password = "elloco";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT nom, prenom FROM etudiants WHERE matricule = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, matricule);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    afficheNom.setText(rs.getString("nom"));
                    affichePrenom.setText(rs.getString("prenom"));
                    afficheMatricule.setText(matricule);

                } else {
                    JOptionPane.showMessageDialog(this, "Etudiant non trouvé!", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void chargerNotesEtudiants(String matricule){
        String url = "jdbc:postgresql://localhost:5432/etudiants_notes";
        String user = "saleli26";
        String password = "elloco";
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            String sqlrecup = "SELECT m.nom_matiere, n.devoir1, n.devoir2 "+ "FROM notes n "+ "JOIN matieres m ON n.id_matiere = m.id_matiere "+ "WHERE n.matricule = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sqlrecup)) {
                stmt.setString(1, matricule);  // Passer le matricule comme paramètre
                ResultSet rs = stmt.executeQuery();
                int i=0;
                while(rs.next()){
                    double devoir1 = rs.getDouble("devoir1");
                    double devoir2 = rs.getDouble("devoir2");
                    String devoir01 = Double.toString(devoir1);
                    String devoir02 = Double.toString(devoir2);
                    tableau_de_notes.setValueAt(devoir01,0, i + 1);
                    tableau_de_notes.setValueAt(devoir02,1, i + 1);
                    i++;
                    if(i == tableau_de_notes.getColumnCount() - 1)
                        break;
                }
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Erreur lors de la mise à jour des notes"+ex.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
        } 
        }catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erreur lors de la connection " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    }
    public Notes_etudiants(String matricule) {
        initComponents();
        chargerInformationsEtudiant(matricule);
        chargerNotesEtudiants(matricule);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_de_notes = new javax.swing.JTable();
        Bouton_calcul_moyenne = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        afficheNom = new javax.swing.JLabel();
        affichePrenom = new javax.swing.JLabel();
        afficheMatricule = new javax.swing.JLabel();
        Bouton_calculer_moyenne_generale = new javax.swing.JButton();
        affiche_moyenne_generale = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notes_etudiants");

        jLabel2.setText("Nom:");

        jLabel3.setText("Prenom:");

        jLabel4.setText("Matricule:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Notes et moyennes par maitières");
        jLabel1.setToolTipText("");

        tableau_de_notes.setModel(new javax.swing.table.DefaultTableModel(
            new String [][] {
                {"Devoir 1", null, null, null, null, null, null, null},
                {"Devoir 2", null, null, null, null, null, null, null},
                {"Moyenne ", null, null, null, null, null, null, null}
            },
            new String [] {
                "Notes", "Java", "Conception web", "Python", "Probabilité", "Modélisation avec UML", "SE", "SDA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex > 0 && rowIndex < getRowCount() - 1;
            }
        });
        tableau_de_notes.setEditingColumn(1);

        tableau_de_notes.setEditingRow(1);
        tableau_de_notes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableau_de_notes);

        Bouton_calcul_moyenne.setText("Valider les notes");
        Bouton_calcul_moyenne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_calcul_moyenneActionPerformed(evt);
            }
        });

        afficheNom.setText(" ");

        affichePrenom.setText(" ");

        afficheMatricule.setText(" ");

        Bouton_calculer_moyenne_generale.setText("Calculer la moyenne générale");
        Bouton_calculer_moyenne_generale.setVisible(false);
        Bouton_calculer_moyenne_generale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_calculer_moyenne_generaleActionPerformed(evt);
            }
        });

        affiche_moyenne_generale.setVisible(false);
        affiche_moyenne_generale.setText("Moyenne générale:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Bouton_calcul_moyenne, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(affiche_moyenne_generale, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(60, 60, 60)
                        .addComponent(afficheNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(affichePrenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(afficheMatricule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton_calculer_moyenne_generale, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 2, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 3, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(afficheNom))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(affichePrenom))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(afficheMatricule))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bouton_calcul_moyenne, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bouton_calculer_moyenne_generale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(affiche_moyenne_generale)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bouton_calcul_moyenneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_calcul_moyenneActionPerformed
        // TODO add your handling code here:
    String url = "jdbc:postgresql://localhost:5432/etudiants_notes";
    String user = "saleli26";
    String password = "elloco";

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        
        String matricule = afficheMatricule.getText();
        // Parcourir chaque matière et mettre à jour les notes dans la base
        for (int i = 0; i < tableau_de_notes.getColumnCount() - 1; i++) { // On ignore la première colonne "Notes"
            String nomMatiere = (String) tableau_de_notes.getColumnName(i + 1); // Nom de la matière à partir de l'en-tête du tableau
            // Récupérer les notes des devoirs
            String devoir1 = (String) tableau_de_notes.getValueAt(0, i + 1); // Devoir 1
            String devoir2 = (String) tableau_de_notes.getValueAt(1, i + 1); // Devoir 2
            
            // Récupérer l'ID de la matière à partir de son nom
            String sqlMatiere = "SELECT id_matiere FROM matieres WHERE nom_matiere = ?";
            try (PreparedStatement stmtMatiere = conn.prepareStatement(sqlMatiere)) {
                stmtMatiere.setString(1, nomMatiere);
                ResultSet rsMatiere = stmtMatiere.executeQuery();
                
                if (rsMatiere.next()) {
                    int idMatiere = rsMatiere.getInt("id_matiere");
                    
                    // Insérer ou mettre à jour les notes de l'étudiant pour cette matière
                    String sqlUpdate = "INSERT INTO notes (matricule, id_matiere, devoir1, devoir2) " +
                                       "VALUES (?, ?, ?, ?) " +
                                       "ON CONFLICT (matricule, id_matiere) " +
                                       "DO UPDATE SET devoir1 = EXCLUDED.devoir1, devoir2 = EXCLUDED.devoir2";
                    try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                        stmtUpdate.setString(1, matricule);
                        stmtUpdate.setInt(2, idMatiere);

                        // Vérifier si les devoirs sont vides
                        if (devoir1 != null && !devoir1.isEmpty() && devoir2 != null && !devoir2.isEmpty()) {
                            // Convertir les notes en double et les insérer dans la base de données
                            double devoir1Val = Double.parseDouble(devoir1);
                            double devoir2Val = Double.parseDouble(devoir2);

                            stmtUpdate.setDouble(3, devoir1Val); // Insérer devoir1 en tant que double
                            stmtUpdate.setDouble(4, devoir2Val); // Insérer devoir2 en tant que double
                            Bouton_calculer_moyenne_generale.setVisible(true);
                        } else {
                            // Si une des notes est vide, mettre des valeurs NULL dans la base de données
                            stmtUpdate.setNull(3, java.sql.Types.DOUBLE);
                            stmtUpdate.setNull(4, java.sql.Types.DOUBLE);
                        }
                        stmtUpdate.executeUpdate();
                    }
                    
                    // Calculer la moyenne pour cette matière
                    if (devoir1 != null && !devoir1.isEmpty() && devoir2 != null && !devoir2.isEmpty()) {
                        double noteDevoir1 = Double.parseDouble(devoir1);
                        double noteDevoir2 = Double.parseDouble(devoir2);
                        double moyenne = (noteDevoir1*0.4 + noteDevoir2*0.6);
                        // Afficher la moyenne dans la cellule correspondante
                        tableau_de_notes.setValueAt(String.format("%.2f", moyenne), 2, i + 1); // La ligne "Moyenne" est la 3ème ligne (index 2)
                        
                        // Insérer ou mettre à jour la moyenne dans la table `moyennes`
                        String sqlMoyenne = "INSERT INTO moyennes (matricule, id_matiere, moyenne) " +
                                            "VALUES (?, ?, ?) " +
                                            "ON CONFLICT (matricule, id_matiere) " +
                                            "DO UPDATE SET moyenne = EXCLUDED.moyenne";
                        try (PreparedStatement stmtMoyenne = conn.prepareStatement(sqlMoyenne)) {
                            stmtMoyenne.setString(1, matricule);
                            stmtMoyenne.setInt(2, idMatiere);
                            stmtMoyenne.setDouble(3, moyenne);
                            stmtMoyenne.executeUpdate();
                        }

                        } else {
                            // Si une des notes est vide, afficher "défaillant"
                            tableau_de_notes.setValueAt("défaillant", 2, i + 1);
                        }
                }
            }
        }
        
        JOptionPane.showMessageDialog(this, "Les notes et moyennes ont été mises à jour avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour des notes : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_Bouton_calcul_moyenneActionPerformed

    private void Bouton_calculer_moyenne_generaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_calculer_moyenne_generaleActionPerformed
        // TODO add your handling code here:
        String url = "jdbc:postgresql://localhost:5432/etudiants_notes";
        String user = "saleli26";
        String password = "elloco";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Requête pour calculer et insérer ou mettre à jour la moyenne générale
            String sqlMoyenneGenerale = "INSERT INTO moyenne_generale (matricule, moyenne_generale) " +
                                        "SELECT m.matricule, " +
                                        "       SUM(m.moyenne * mat.coefficent) / 30 AS moyenne_generale " +
                                        "FROM moyennes m " +
                                        "JOIN matieres mat ON m.id_matiere = mat.id_matiere " +
                                        "GROUP BY m.matricule " +
                                        "HAVING COUNT(m.id_matiere) = (SELECT COUNT(*) FROM matieres) " +
                                        "ON CONFLICT (matricule) " +
                                        "DO UPDATE SET moyenne_generale = EXCLUDED.moyenne_generale " +
                                        "RETURNING moyenne_generale";

            try (PreparedStatement stmt = conn.prepareStatement(sqlMoyenneGenerale)) {
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Moyenne générale calculée. ", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    String matricule = afficheMatricule.getText();
                    String sqlRecupererMoyenne = "SELECT moyenne_generale FROM moyenne_generale WHERE matricule = ?";
                    PreparedStatement stmt1 = conn.prepareStatement(sqlRecupererMoyenne);
                    stmt1.setString(1, matricule);
                    ResultSet rs1 = stmt1.executeQuery();
                    if (rs1.next()) {
                    double moyenne_generale = rs1.getDouble("moyenne_generale");
                    String moyenne_generales = Double.toString(moyenne_generale);
                    affiche_moyenne_generale.setText("Moyenne générale de l'étudiant : " + moyenne_generales);
                    affiche_moyenne_generale.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Aucune moyenne générale calculée.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors du calcul de la moyenne générale : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Bouton_calculer_moyenne_generaleActionPerformed

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Notes_etudiants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notes_etudiants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notes_etudiants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notes_etudiants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String matricule = null;
                new Notes_etudiants(matricule).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bouton_calcul_moyenne;
    private javax.swing.JButton Bouton_calculer_moyenne_generale;
    private javax.swing.JLabel afficheMatricule;
    private javax.swing.JLabel afficheNom;
    private javax.swing.JLabel affichePrenom;
    private javax.swing.JLabel affiche_moyenne_generale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableau_de_notes;
    // End of variables declaration//GEN-END:variables
}
