package vue.insertion;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlleur.gestionInsertion.GestionInsertionLocation;
import controlleur.others.Boite;
import modele.Bien;
import modele.dao.DaoBien;
import modele.dao.Iterateur;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FenetreInsertionLocation extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldSearchLogement;
	private GestionInsertionLocation gestionnaire;
	private JTable tableLogement;
	private JTextField textFieldIdLoc;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldCP;
	private JTextField textFieldVille;
	private JTextField textFieldCourriel;
	private JTextField textFieldNumTel;
	private JComboBox<Object> comboBoxBien;
	private static JButton btnAjoutBail;
	private static JButton btnAjouterUnDiagnostic;
	private static JButton btnAjouterEtatLieux;
	private JButton btnValiderLaSlction;
	private JComboBox<Object> comboBoxCivilite;
	private static JButton btnInsererLocation;
	private DaoBien daoBien;
	private Iterateur<Bien> iterateur;
	private JButton btnIndex;
	private JButton btnColoc;
	

	/**
	 * Create the frame.
	 */
	public FenetreInsertionLocation() {
		Boite.initializeChest();
		comboBoxBien = new JComboBox<>();
		comboBoxCivilite = new JComboBox<>();
		comboBoxCivilite.setBackground(Color.WHITE);
		try {
			this.daoBien = new DaoBien();
			this.iterateur = this.daoBien.findAllIterateur();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<String> liste = new ArrayList<>();
		while (this.iterateur.hasNext()) {
			liste.add(this.iterateur.next().getIdbien());
		}
		Object[] items = liste.toArray();
		
		setTitle("Nouvelle location");
		setBorder(new LineBorder(new Color(3, 102, 235), 3));
		getContentPane().setBackground(Color.WHITE);
		setFrameIcon(new ImageIcon(FenetreInsertionLocation.class.getResource("/data/key-set_blue_px.png")));
		setBounds(100, 100, 835, 550);
		getContentPane().setLayout(null);
		this.gestionnaire = new GestionInsertionLocation(this);
		
		JLabel lblNewLabel = new JLabel("Ajouter une location");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 809, 33);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(240, 53, 16, 343);
		getContentPane().add(separator);
		
		JLabel lblLocataire = new JLabel("Locataire");
		lblLocataire.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		lblLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocataire.setBounds(10, 68, 207, 18);
		getContentPane().add(lblLocataire);
		
		JLabel lblLogement = new JLabel("Logement");
		lblLogement.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		lblLogement.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogement.setBounds(271, 68, 207, 18);
		getContentPane().add(lblLogement);
		
		JScrollPane scrollPaneLogement = new JScrollPane();
		scrollPaneLogement.setBounds(271, 152, 207, 229);
		getContentPane().add(scrollPaneLogement);
		
		tableLogement = new JTable();
		tableLogement.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null}
			},
			new String[] {
				"ID", "Etage"
			}
		));
		
		scrollPaneLogement.setViewportView(tableLogement);
		
		JButton btSearchLogement = new JButton("l");
		btSearchLogement.setEnabled(false);
		btSearchLogement.setToolTipText("Rechercher");
		btSearchLogement.addActionListener(this.gestionnaire);
		btSearchLogement.setBackground(Color.WHITE);
		btSearchLogement.setIcon(new ImageIcon(FenetreInsertionLocation.class.getResource("/data/search.png")));
		btSearchLogement.setBounds(426, 123, 52, 21);
		getContentPane().add(btSearchLogement);
		
		textFieldSearchLogement = new JTextField();
		textFieldSearchLogement.setEnabled(false);
		textFieldSearchLogement.setColumns(10);
		textFieldSearchLogement.setBounds(272, 125, 144, 19);
		getContentPane().add(textFieldSearchLogement);
		
		btnInsererLocation = new JButton("Insérer");
		btnInsererLocation.setEnabled(false);
		btnInsererLocation.addActionListener(this.gestionnaire);
		btnInsererLocation.setIcon(new ImageIcon(FenetreInsertionLocation.class.getResource("/data/arrow-down.png")));
		btnInsererLocation.setBackground(Color.WHITE);
		btnInsererLocation.setBounds(347, 469, 97, 21);
		getContentPane().add(btnInsererLocation);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon(FenetreInsertionLocation.class.getResource("/data/marque-de-croix.png")));
		btnAnnuler.addActionListener(this.gestionnaire);
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(473, 469, 105, 21);
		getContentPane().add(btnAnnuler);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(10, 53, 809, 18);
		getContentPane().add(separator1);
		
		comboBoxBien = new JComboBox<>();
		comboBoxBien.setModel(new DefaultComboBoxModel<>(items));
		comboBoxBien.setToolTipText("Afficher les logements non loués de chaque bien");
		comboBoxBien.setBackground(Color.WHITE);
		comboBoxBien.setBounds(274, 96, 115, 21);
		getContentPane().add(comboBoxBien);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(504, 53, 16, 353);
		getContentPane().add(separator2);
		
		JLabel lblDocuments = new JLabel("Documents");
		lblDocuments.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocuments.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		lblDocuments.setBounds(514, 68, 305, 18);
		getContentPane().add(lblDocuments);
		
		btnAjoutBail = new JButton("Ajouter un bail");
		btnAjoutBail.setEnabled(false);
		btnAjoutBail.addActionListener(this.gestionnaire);
		btnAjoutBail.setBackground(Color.WHITE);
		btnAjoutBail.setBounds(566, 312, 207, 21);
		getContentPane().add(btnAjoutBail);
		
		btnAjouterUnDiagnostic = new JButton("Ajouter un diagnostic");
		btnAjouterUnDiagnostic.setEnabled(false);
		btnAjouterUnDiagnostic.addActionListener(this.gestionnaire);
		btnAjouterUnDiagnostic.setBackground(Color.WHITE);
		btnAjouterUnDiagnostic.setBounds(566, 343, 207, 21);
		getContentPane().add(btnAjouterUnDiagnostic);
		
		btnAjouterEtatLieux = new JButton("Ajouter l'etat des lieux");
		btnAjouterEtatLieux.setEnabled(false);
		btnAjouterEtatLieux.addActionListener(this.gestionnaire);
		btnAjouterEtatLieux.setBackground(Color.WHITE);
		btnAjouterEtatLieux.setBounds(566, 374, 207, 21);
		getContentPane().add(btnAjouterEtatLieux);
		
		JLabel lblNewLabelDoc = new JLabel("");
		lblNewLabelDoc.setIcon(new ImageIcon(FenetreInsertionLocation.class.getResource("/data/key-set_blue_126px.png")));
		lblNewLabelDoc.setBounds(601, 123, 133, 141);
		getContentPane().add(lblNewLabelDoc);
		
		JSeparator separator3 = new JSeparator();
		separator3.setBounds(543, 284, 256, 18);
		getContentPane().add(separator3);
		
		btnValiderLaSlction = new JButton("Valider la séléction");
		btnValiderLaSlction.setIcon(new ImageIcon(FenetreInsertionLocation.class.getResource("/data/cliquez-sur.png")));
		btnValiderLaSlction.setBackground(Color.WHITE);
		btnValiderLaSlction.setBounds(163, 438, 168, 21);
		btnValiderLaSlction.addActionListener(this.gestionnaire);
		getContentPane().add(btnValiderLaSlction);
		
		textFieldIdLoc = new JTextField();
		textFieldIdLoc.setColumns(10);
		textFieldIdLoc.setBounds(86, 136, 144, 19);
		getContentPane().add(textFieldIdLoc);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(128, 0, 0));
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblID.setBounds(10, 136, 66, 19);
		getContentPane().add(lblID);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(86, 168, 144, 19);
		getContentPane().add(textFieldNom);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNom.setBounds(10, 168, 66, 19);
		getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrenom.setBounds(10, 197, 66, 19);
		getContentPane().add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(86, 197, 144, 19);
		getContentPane().add(textFieldPrenom);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(86, 226, 144, 19);
		getContentPane().add(textFieldAdresse);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdresse.setBounds(10, 226, 66, 19);
		getContentPane().add(lblAdresse);
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		textFieldCP.setBounds(86, 255, 144, 19);
		getContentPane().add(textFieldCP);
		
		JLabel lblCodePostal = new JLabel("CP");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodePostal.setBounds(10, 255, 66, 19);
		getContentPane().add(lblCodePostal);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		textFieldVille.setBounds(86, 285, 144, 19);
		getContentPane().add(textFieldVille);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVille.setBounds(10, 285, 66, 19);
		getContentPane().add(lblVille);
		
		textFieldCourriel = new JTextField();
		textFieldCourriel.setColumns(10);
		textFieldCourriel.setBounds(86, 314, 144, 19);
		getContentPane().add(textFieldCourriel);
		
		JLabel lblCourriel = new JLabel("Courriel");
		lblCourriel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCourriel.setBounds(10, 314, 66, 19);
		getContentPane().add(lblCourriel);
		
		textFieldNumTel = new JTextField();
		textFieldNumTel.setColumns(10);
		textFieldNumTel.setBounds(86, 343, 144, 19);
		getContentPane().add(textFieldNumTel);
		
		JLabel lblNumtel = new JLabel("N° Tél");
		lblNumtel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumtel.setBounds(10, 343, 66, 19);
		getContentPane().add(lblNumtel);
		
		comboBoxCivilite.setModel(new DefaultComboBoxModel<>(new String[] {"M", "MME", "MLLE", "IEL"}));
		comboBoxCivilite.setBounds(86, 105, 52, 21);
		getContentPane().add(comboBoxCivilite);
		
		JLabel lblCivilit = new JLabel("Civilité");
		lblCivilit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCivilit.setBounds(10, 107, 66, 19);
		getContentPane().add(lblCivilit);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRefresh.setBackground(new Color(255, 255, 255));
		btnRefresh.setBounds(399, 94, 79, 21);
		btnRefresh.addActionListener(this.gestionnaire);
		getContentPane().add(btnRefresh);
		
		btnIndex = new JButton("Index compteur");
		btnIndex.setIcon(new ImageIcon(FenetreInsertionLocation.class.getResource("/data/controls.png")));
		btnIndex.setBackground(Color.WHITE);
		btnIndex.setBounds(297, 391, 147, 21);
		btnIndex.addActionListener(this.gestionnaire);
		getContentPane().add(btnIndex);
		
		btnColoc = new JButton("Ajouter un colocataire");
		btnColoc.setBackground(Color.WHITE);
		btnColoc.setBounds(49, 391, 168, 21);
		getContentPane().add(btnColoc);
	}
	
	public void enableItems(boolean val) {
		btnAjoutBail.setEnabled(val);
		btnAjouterUnDiagnostic.setEnabled(val);
		btnAjouterEtatLieux.setEnabled(val);
	}
	
	public static void enableBtnInsert(boolean val) {
		try {
			btnInsererLocation.setEnabled(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public JTextField getTextFieldSearchLogement() {
		return textFieldSearchLogement;
	}

	public JTable getTableLogement() {
		return tableLogement;
	}

	public JTextField getTextFieldIdLoc() {
		return textFieldIdLoc;
	}

	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}

	public JTextField getTextFieldAdresse() {
		return textFieldAdresse;
	}

	public JTextField getTextFieldCP() {
		return textFieldCP;
	}

	public JTextField getTextFieldVille() {
		return textFieldVille;
	}

	public JTextField getTextFieldCourriel() {
		return textFieldCourriel;
	}

	public JTextField getTextFieldNumTel() {
		return textFieldNumTel;
	}

	public JComboBox<Object> getComboBoxBien() {
		return comboBoxBien;
	}

	public JComboBox<Object> getComboBoxCivilite() {
		return comboBoxCivilite;
	}

	public static JButton getBtnAjouterUnDiagnostic() {
		return btnAjouterUnDiagnostic;
	}

	public static JButton getBtnAjouterEtatLieux() {
		return btnAjouterEtatLieux;
	}
	
	public static JButton getBtnBail() {
		return btnAjoutBail;
	}

	public JButton getBtnValiderLaSlction() {
		return btnValiderLaSlction;
	}
}
