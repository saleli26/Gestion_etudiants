import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class AffichageNotesEtudiant extends JFrame {
    private JTextField matriculeField;
    private JButton validerButton;
    private JPanel panel;
    private JTable table;
    
    // Connexion à la base de données (modifiez ces variables selon votre configuration)
    private static final String URL = "jdbc:postgresql://localhost:5432/etudiants_notes";
    private static final String USER = "saleli26";
    private static final String PASSWORD = "elloco";
    
    public AffichageNotesEtudiant() {
        setTitle("Récupérer les Notes d'un Etudiant");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Initialisation du panneau principal
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Panel pour les champs de saisie et le bouton
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        
        JLabel matriculeLabel = new JLabel("Matricule:");
        matriculeField = new JTextField(15);
        validerButton = new JButton("Valider");
        
        inputPanel.add(matriculeLabel);
        inputPanel.add(matriculeField);
        inputPanel.add(validerButton);
        
        // Ajouter le panneau d'entrée à la fenêtre
        panel.add(inputPanel, BorderLayout.NORTH);
        
        // Action du bouton de validation
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricule = matriculeField.getText().trim();
                if (!matricule.isEmpty()) {
                    afficherNotes(matricule);
                } else {
                    JOptionPane.showMessageDialog(AffichageNotesEtudiant.this, "Veuillez entrer un matricule.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Panel pour afficher les résultats sous forme de tableau
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        
        // Ajouter un tableau vide au début
        table = new JTable();
        resultPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        
        // Ajouter le panneau de résultats
        panel.add(resultPanel, BorderLayout.CENTER);
        
        // Ajouter le panneau principal à la fenêtre
        add(panel);
        setLocationRelativeTo(null); // Centrer la fenêtre
    }
    
    // Méthode pour afficher les notes de l'étudiant dans un tableau
    private void afficherNotes(String matricule) {
        // Créer un modèle de tableau vide
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Matière");
        model.addColumn("Devoir 1");
        model.addColumn("Devoir 2");
        
        // Connexion à la base de données et récupération des notes
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT m.nom_matiere, n.devoir1, n.devoir2 "
                       + "FROM notes n "
                       + "JOIN matieres m ON n.id_matiere = m.id_matiere "
                       + "WHERE n.matricule = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, matricule);  // Passer le matricule comme paramètre
                ResultSet rs = stmt.executeQuery();
                
                // Ajouter les résultats au modèle de tableau
                while (rs.next()) {
                    String nomMatiere = rs.getString("nom_matiere");
                    double devoir1 = rs.getDouble("devoir1");
                    double devoir2 = rs.getDouble("devoir2");
                    model.addRow(new Object[]{nomMatiere, devoir1, devoir2});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des notes : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        // Appliquer le modèle au tableau
        table.setModel(model);
    }
    
    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        // Création de l'interface
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AffichageNotesEtudiant().setVisible(true);
            }
        });
    }
}
