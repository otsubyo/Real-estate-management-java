package vue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlleur.GestionFenetreBiens;
import controlleur.gestiontables.GestionTableBiens;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class FenetreBiens extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private GestionFenetreBiens gestionnaire;
	private GestionTableBiens gestionnaireTableaux;
	private JTable tableLogements;
	private JTable tableAssurer;
	private JComboBox<Object> comboBoxLogGar;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public FenetreBiens() {
		setResizable(true);
		setBorder(new LineBorder(new Color(3, 102, 235), 3));
		getContentPane().setBackground(Color.WHITE);
		setTitle("Mes biens");
		setFrameIcon(new ImageIcon(FenetreBiens.class.getResource("/data/immeuble-de-bureaux.png")));
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPaneBiens = new JScrollPane();
		scrollPaneBiens.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneBiens.setBounds(10, 54, 668, 199);
		getContentPane().add(scrollPaneBiens);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null}
			},
			new String[] {
				"Identifiant", "Adresse", "Code postal", "Ville", "Description", "Nombre logements"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(4).setPreferredWidth(113);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPaneBiens.setViewportView(table);
		
		// Gestionnaires
		this.gestionnaire = new GestionFenetreBiens(this);
		this.gestionnaireTableaux = new GestionTableBiens(this);
		this.table.getSelectionModel().addListSelectionListener(this.gestionnaireTableaux);
		
		
		JButton btnCharger = new JButton("Charger");
		btnCharger.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCharger.setBackground(Color.WHITE);
		btnCharger.addActionListener(this.gestionnaire);
		btnCharger.setBounds(26, 514, 85, 21);
		getContentPane().add(btnCharger);
		
		JButton btnInserer = new JButton("Insérer");
		btnInserer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnInserer.addActionListener(this.gestionnaire);
		btnInserer.setBackground(Color.WHITE);
		btnInserer.setBounds(152, 514, 85, 21);
		getContentPane().add(btnInserer);
		
		JButton btnMiseAJour = new JButton("Mise à jour");
		btnMiseAJour.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMiseAJour.addActionListener(this.gestionnaire);
		btnMiseAJour.setBackground(Color.WHITE);
		btnMiseAJour.setBounds(272, 514, 127, 21);
		getContentPane().add(btnMiseAJour);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setToolTipText("Vous ne pouvez pas supprimer un bien pour le moment !");
		btnSupprimer.setEnabled(false);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSupprimer.addActionListener(this.gestionnaire);
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setBounds(428, 514, 105, 21);
		getContentPane().add(btnSupprimer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAnnuler.addActionListener(this.gestionnaire);
		btnAnnuler.setBackground(new Color(255, 255, 255));
		btnAnnuler.setBounds(561, 514, 85, 21);
		getContentPane().add(btnAnnuler);
		
		JScrollPane scrollPaneLogements = new JScrollPane();
		scrollPaneLogements.setBounds(10, 329, 244, 135);
		getContentPane().add(scrollPaneLogements);
		
		tableLogements = new JTable();
		tableLogements.setEnabled(false);
		tableLogements.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableLogements.setBackground(Color.WHITE);
		tableLogements.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Surface", "Etage"
			}
		));
		scrollPaneLogements.setViewportView(tableLogements);
		
		JScrollPane scrollPaneAssurer = new JScrollPane();
		scrollPaneAssurer.setBounds(272, 329, 406, 135);
		getContentPane().add(scrollPaneAssurer);
		
		tableAssurer = new JTable();
		tableAssurer.setEnabled(false);
		tableAssurer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAssurer.setBackground(Color.WHITE);
		tableAssurer.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Police", "Assureur", "Protection juridique", "Prime", "Quotite", "Date d\u00E9but", "Date fin"
			}
		));
		scrollPaneAssurer.setViewportView(tableAssurer);
		
		JLabel lblLogements = new JLabel("Logements");
		lblLogements.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		lblLogements.setBounds(10, 275, 74, 21);
		getContentPane().add(lblLogements);
		
		JLabel lblAssurance = new JLabel("Assurances");
		lblAssurance.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		lblAssurance.setBounds(288, 298, 111, 21);
		getContentPane().add(lblAssurance);
		
		comboBoxLogGar = new JComboBox<>();
		comboBoxLogGar.setBackground(Color.WHITE);
		comboBoxLogGar.setModel(new DefaultComboBoxModel<>(new String[] {"Logements", "Garages"}));
		comboBoxLogGar.setBounds(10, 298, 97, 21);
		getContentPane().add(comboBoxLogGar);
		
		JLabel lblNewLabel = new JLabel("MES BIENS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblNewLabel.setBounds(288, 10, 127, 34);
		getContentPane().add(lblNewLabel);

	}

	public JComboBox<Object> getComboBoxLogGar() {
		return comboBoxLogGar;
	}

	public GestionFenetreBiens getGestionnaire() {
		return gestionnaire;
	}

	public JTable getTableLogements() {
		return tableLogements;
	}

	public JTable getTableAssurer() {
		return tableAssurer;
	}

	public JTable getTable() {
		return table;
	}
}
