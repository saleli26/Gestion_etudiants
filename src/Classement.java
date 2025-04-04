import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Classement extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    
    public Classement() {
        setTitle("Moyenne des Étudiants");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création du modèle de table
        model = new DefaultTableModel();
        model.addColumn("Matricule");
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Moyenne Générale");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        chargerDonnees();
    }

    private void chargerDonnees() {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/etudiants_notes", "saleli26", "elloco")) {
            String sql = "SELECT e.matricule, e.nom, e.prenom, m.moyenne_generale "+"FROM etudiants e "+
                            "JOIN moyenne_generale m ON e.matricule = m.matricule "+"ORDER BY m.moyenne_generale DESC;";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("matricule"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getDouble("moyenne_generale")
                });
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage(), "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
