package vue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class FenetreTravaux extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public FenetreTravaux() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(3, 102, 235), 3));
		setFrameIcon(new ImageIcon(FenetreTravaux.class.getResource("/data/mur-de-briques.png")));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 850, 470);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("TRAVAUX");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 824, 32);
		getContentPane().add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 818, 244);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Numéro Fac", "Entreprise", "Date", "Nature", "Montant", "Montant ND", "Montant D", "Réduction", "RefLog", "Logement", "Immeuble"
			}
		));
		scrollPane.setViewportView(table);
		
		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setToolTipText("Affichage");
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Travaux Immeuble", "Travaux Logements", "Travaux Garages"}));
		comboBox.setBounds(10, 69, 125, 21);
		getContentPane().add(comboBox);
		
		JButton btnInserer = new JButton("Insérer");
		btnInserer.setIcon(new ImageIcon(FenetreTravaux.class.getResource("/data/arrow-down.png")));
		btnInserer.setBackground(Color.WHITE);
		btnInserer.setBounds(229, 372, 85, 21);
		getContentPane().add(btnInserer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(591, 372, 85, 21);
		getContentPane().add(btnAnnuler);
		
		JButton btnCharger = new JButton("Charger");
		btnCharger.setBackground(Color.WHITE);
		btnCharger.setBounds(99, 372, 85, 21);
		getContentPane().add(btnCharger);
		
		JButton btnMiseJour = new JButton("Mise à jour");
		btnMiseJour.setBackground(Color.WHITE);
		btnMiseJour.setBounds(345, 372, 85, 21);
		getContentPane().add(btnMiseJour);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setBounds(467, 372, 85, 21);
		getContentPane().add(btnSupprimer);

	}
}
