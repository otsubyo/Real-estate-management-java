package vue;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

@SuppressWarnings("unused")
public class FenetreSoldeToutCompte extends JInternalFrame {
    private static final long serialVersionUID = -4065325672037596067L;
    private JPanel contentPane;
    private final JScrollPane scrollPane = new JScrollPane();
    private JTable tableauCharges;
    
    /**
     * Create the frame.
     */
    public FenetreSoldeToutCompte() {
    	setClosable(true);
    	setBorder(new LineBorder(new Color(0, 0, 128), 2));
    	setFrameIcon(new ImageIcon(FenetreSoldeToutCompte.class.getResource("/data/deconnexion.png")));
    	setBackground(new Color(0, 0, 128));
    	setTitle("Solde de tout compte");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 542, 399);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        scrollPane.setBounds(20, 105, 496, 179);
        contentPane.add(scrollPane);
        
        tableauCharges = new JTable();
        tableauCharges.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
            },
            new String[] {
                "Date", "Libelles", "TVA", "Montant"
            }
        ));
        tableauCharges.getColumnModel().getColumn(1).setPreferredWidth(206);
        tableauCharges.getColumnModel().getColumn(2).setPreferredWidth(66);
        tableauCharges.getColumnModel().getColumn(3).setPreferredWidth(102);
        scrollPane.setViewportView(tableauCharges);
        
        JComboBox<Object> comboBox = new JComboBox<>();
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(20, 72, 156, 22);
        contentPane.add(comboBox);
        
        JButton btnGenererRecu = new JButton("Générer le reçu");
        btnGenererRecu.setBackground(Color.WHITE);
        btnGenererRecu.setIcon(new ImageIcon(FenetreSoldeToutCompte.class.getResource("/data/papier.png")));
        //btnGenererRecu.addActionListener(this);
        btnGenererRecu.setBounds(115, 311, 131, 22);
        contentPane.add(btnGenererRecu);
        
        JButton btnAnnulerRecu = new JButton("Annuler");
        btnAnnulerRecu.setBackground(Color.WHITE);
        btnAnnulerRecu.setIcon(new ImageIcon(FenetreSoldeToutCompte.class.getResource("/data/log-out.png")));
        //btnAnnulerRecu.addActionListener(this);
        btnAnnulerRecu.setBounds(260, 311, 115, 22);
        contentPane.add(btnAnnulerRecu);
        
        JLabel lblNewLabel = new JLabel("Solde de tout compte d'un locataire");
        lblNewLabel.setBackground(new Color(0, 0, 128));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 516, 32);
        contentPane.add(lblNewLabel);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 0, 128));
        separator.setBounds(163, 41, 209, 2);
        contentPane.add(separator);
        
        JLabel lblLocataire = new JLabel("Locataire");
        lblLocataire.setBounds(20, 53, 55, 13);
        contentPane.add(lblLocataire);
    }
}
