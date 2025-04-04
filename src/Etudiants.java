import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class Etudiants extends javax.swing.JFrame {

    private static final String URL = "jdbc:postgresql://localhost:5432/etudiants_notes";
    private static final String USER = "saleli26";
    private static final String PASSWORD = "elloco";
    public Etudiants() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        afficheNom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        affichePrenom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        afficheMatricule = new javax.swing.JTextField();
        BoutonAnnuler = new javax.swing.JButton();
        BoutonValider = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        infoMatricule = new javax.swing.JTextField();
        Bouton_valider_matricule = new javax.swing.JButton();
        Bouton_valider_matricule1 = new javax.swing.JButton();
        Bouton_classement = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom:");

        afficheNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficheNomActionPerformed(evt);
            }
        });

        jLabel2.setText("Prénom:");

        affichePrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affichePrenomActionPerformed(evt);
            }
        });

        jLabel3.setText("Matricule:");

        BoutonAnnuler.setText("Annuler");
        BoutonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnulerActionPerformed(evt);
            }
        });

        BoutonValider.setText("Valider");
        BoutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonValiderActionPerformed(evt);
            }
        });

        jLabel4.setText("Renseigner les notes d'un étudiant:");

        jLabel5.setText("Matricule:");

        Bouton_valider_matricule.setText("Valider le matricule");
        Bouton_valider_matricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_valider_matriculeActionPerformed(evt);
            }
        });

        Bouton_valider_matricule1.setFont(new java.awt.Font("Berenis ADF Pro Math", 3, 15)); // NOI18N
        Bouton_valider_matricule1.setText("Afficher les notes d'un etudiant");
        Bouton_valider_matricule1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_valider_matricule1ActionPerformed(evt);
            }
        });

        Bouton_classement.setText("Classement");
        Bouton_classement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_classementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BoutonAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BoutonValider))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(76, 76, 76)
                        .addComponent(infoMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bouton_valider_matricule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(106, 106, 106)
                        .addComponent(afficheNom))
                    .addComponent(Bouton_valider_matricule1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton_classement, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(86, 86, 86)
                        .addComponent(affichePrenom))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(76, 76, 76)
                        .addComponent(afficheMatricule)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(afficheNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(affichePrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(afficheMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonAnnuler)
                    .addComponent(BoutonValider))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(infoMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton_valider_matricule))
                .addGap(18, 18, 18)
                .addComponent(Bouton_valider_matricule1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bouton_classement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afficheNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficheNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afficheNomActionPerformed

    private void Bouton_valider_matriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_valider_matriculeActionPerformed
        // TODO add your handling code here:
        String matricule = infoMatricule.getText().trim();

        if (matricule.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un matricule !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            String url = "jdbc:postgresql://localhost:5432/etudiants_notes";
            String user = "saleli26";
            String password = "elloco";

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT COUNT(*) FROM etudiants WHERE matricule = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, matricule);
                    ResultSet rs = stmt.executeQuery();

                    rs.next(); 
                        if(rs.getInt(1) > 0){
                            Notes_etudiants fenetre = new Notes_etudiants(matricule);
                            fenetre.setVisible(true);
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "Etudiant non trouvé!", "Erreur", JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
        
    }//GEN-LAST:event_Bouton_valider_matriculeActionPerformed

    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        // TODO add your handling code here:
        afficheNom.setText("");
        affichePrenom.setText("");
        afficheMatricule.setText("");
    }//GEN-LAST:event_BoutonAnnulerActionPerformed

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed
        // TODO add your handling code here:
        String matricule = afficheMatricule.getText().trim();
        String nom = afficheNom.getText().trim();
        String prenom = affichePrenom.getText().trim();

        if (matricule.isEmpty() || nom.isEmpty() || prenom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO etudiants (matricule, nom, prenom) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, matricule);
                stmt.setString(2, nom);
                stmt.setString(3, prenom);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Étudiant ajouté avec succès !");
                afficheMatricule.setText("");
                afficheNom.setText("");
                affichePrenom.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage(), "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BoutonValiderActionPerformed

    private void affichePrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affichePrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_affichePrenomActionPerformed

    private void Bouton_valider_matricule1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_valider_matricule1ActionPerformed
        // TODO add your handling code here:
        AffichageNotesEtudiant frame = new AffichageNotesEtudiant();
        frame.setVisible(true);
    }//GEN-LAST:event_Bouton_valider_matricule1ActionPerformed

    private void Bouton_classementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_classementActionPerformed
        // TODO add your handling code here:
        Classement frame = new Classement();
        frame.setVisible(true);
    }//GEN-LAST:event_Bouton_classementActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Etudiants().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAnnuler;
    private javax.swing.JButton BoutonValider;
    private javax.swing.JButton Bouton_classement;
    private javax.swing.JButton Bouton_valider_matricule;
    private javax.swing.JButton Bouton_valider_matricule1;
    private javax.swing.JTextField afficheMatricule;
    private javax.swing.JTextField afficheNom;
    private javax.swing.JTextField affichePrenom;
    private javax.swing.JTextField infoMatricule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
