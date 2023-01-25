package vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("unused")
public class FenetreChargesLocation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public FenetreChargesLocation() {
		setBackground(new Color(0, 0, 128));
		setTitle("Gestion charges");
		setFrameIcon(new ImageIcon(FenetreChargesLocation.class.getResource("/data/calculatrice.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 904, 342);
		getContentPane().setLayout(null);
		
		JLabel lblGestionDesCharges = new JLabel("Gestion des charges d'une location");
		lblGestionDesCharges.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesCharges.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblGestionDesCharges.setBounds(10, 10, 872, 34);
		getContentPane().add(lblGestionDesCharges);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(13, 89, 869, 146);
		getContentPane().add(scrollPane1);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID Location", "Date de relev\u00E9", "Nouvel Indice", "Ancien Indice", "Consommation", "Prix Consommation", "Partie fixe", "Total"
			}
		));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(716, 257, 99, 21);
		getContentPane().add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setIcon(new ImageIcon(FenetreChargesLocation.class.getResource("/data/arrow-down.png")));
		btnValider.setBackground(Color.WHITE);
		btnValider.setBounds(600, 257, 106, 21);
		getContentPane().add(btnValider);
		
		JButton btnCrerUneCharge = new JButton("Ajouter une charge");
		btnCrerUneCharge.setIcon(new ImageIcon(FenetreChargesLocation.class.getResource("/data/add-button.png")));
		btnCrerUneCharge.setBackground(Color.WHITE);
		btnCrerUneCharge.setBounds(78, 257, 163, 21);
		getContentPane().add(btnCrerUneCharge);
		
		JButton btnModCharge = new JButton("Modifier une charge");
		btnModCharge.setIcon(new ImageIcon(FenetreChargesLocation.class.getResource("/data/controls.png")));
		btnModCharge.setBackground(Color.WHITE);
		btnModCharge.setBounds(251, 257, 163, 21);
		getContentPane().add(btnModCharge);
		
		JButton btnSup = new JButton("Supprimer une charge");
		btnSup.setIcon(new ImageIcon(FenetreChargesLocation.class.getResource("/data/marque-de-croix.png")));
		btnSup.setBackground(Color.WHITE);
		btnSup.setBounds(427, 257, 163, 21);
		getContentPane().add(btnSup);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 160));
		separator.setBounds(347, 63, 193, 16);
		getContentPane().add(separator);
		
		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"eau", "électricité", "gaz", "ordures ménagères"}));
		comboBox.setBounds(10, 54, 106, 21);
		getContentPane().add(comboBox);

	}
}