package vue.insertion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlleur.gestionInsertion.GestionInsertionBien;

public class FenetreInsertionBien extends JInternalFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private GestionInsertionBien gestionnaire;
	
	// Bien
	private JTextField textFieldAdresse;
	private JTextField textFieldCP;
	private JTextField textFieldVille;
	private JTextField textFieldDesc;
	private JTextField textFieldNbLogMax;
	
	// Compteur Bien
	private JTextField textFieldMatriculeCB;
	private JTextField textFieldAncienIndiceCB;
	private JTextField textFieldNouvelIndiceCB;
	
	// Logement
	private JTextField textFieldSurface;
	private JTextField textFieldEtage;
	private JTextField textFieldPrixM2;
	private JTextField textFieldNbPieces;
	private JButton btnInsererLog;
	
	// Compteur Logement
	private JTextField textFieldMatriculeCL;
	private JTextField textFieldAncienIndice;
	private JTextField textFieldNouvelIndiceCL;
	private JCheckBox chckbxCompteurLogement;
	private JButton btnAjouterAuBienCB;
	private JButton btnAjouterAuLogement;
	private JComboBox<Object> comboBoxTypeLogGar;
	private JComboBox<Object> comboBoxCL;
	private JComboBox<Object> comboBoxCG;
	private JButton btnAjouterBien;
	private JTextField textFieldIDBIEN;
	private JTextField textFieldIDLOG;
	private JComboBox<Object> comboBoxTypeLOG;

	/**
	 * Create the frame.
	 */
	public FenetreInsertionBien() {
		setBorder(new LineBorder(new Color(2, 69, 163), 3));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		this.gestionnaire = new GestionInsertionBien(this);
		
		JLabel lblBien = new JLabel("Ajouter un bien");
		lblBien.setHorizontalAlignment(SwingConstants.CENTER);
		lblBien.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblBien.setBounds(10, 10, 374, 34);
		getContentPane().add(lblBien);
		
		JLabel lblNewLabel = new JLabel("Adresse");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 118, 52, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCodePostal = new JLabel("Code Postal");
		lblCodePostal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodePostal.setBounds(10, 147, 75, 15);
		getContentPane().add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVille.setBounds(10, 184, 44, 15);
		getContentPane().add(lblVille);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(10, 217, 75, 15);
		getContentPane().add(lblDescription);
		
		JLabel lblNombreDeLogement = new JLabel("Nombre de logement max");
		lblNombreDeLogement.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreDeLogement.setBounds(10, 249, 155, 15);
		getContentPane().add(lblNombreDeLogement);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(186, 117, 178, 19);
		getContentPane().add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		textFieldCP = new JTextField();
		textFieldCP.setColumns(10);
		textFieldCP.setBounds(186, 146, 178, 19);
		getContentPane().add(textFieldCP);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		textFieldVille.setBounds(186, 183, 178, 19);
		getContentPane().add(textFieldVille);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(186, 216, 178, 19);
		getContentPane().add(textFieldDesc);
		
		textFieldNbLogMax = new JTextField();
		textFieldNbLogMax.setColumns(10);
		textFieldNbLogMax.setBounds(186, 248, 178, 19);
		getContentPane().add(textFieldNbLogMax);
		
		btnAjouterBien = new JButton("Ajouter");
		btnAjouterBien.addActionListener(this.gestionnaire);
		btnAjouterBien.setBackground(Color.WHITE);
		btnAjouterBien.setIcon(new ImageIcon(FenetreInsertionBien.class.getResource("/data/arrow-down.png")));
		btnAjouterBien.setBounds(65, 292, 113, 21);
		getContentPane().add(btnAjouterBien);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 323, 724, 2);
		getContentPane().add(separator);
		
		JLabel lblSurface = new JLabel("Surface");
		lblSurface.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurface.setBounds(10, 447, 102, 15);
		getContentPane().add(lblSurface);
		
		textFieldSurface = new JTextField();
		textFieldSurface.setEnabled(false);
		textFieldSurface.setColumns(10);
		textFieldSurface.setBounds(186, 446, 178, 19);
		getContentPane().add(textFieldSurface);
		
		JLabel lblNewLabel_2 = new JLabel("Insertion de logement / garage");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 336, 374, 13);
		getContentPane().add(lblNewLabel_2);
		
		textFieldEtage = new JTextField();
		textFieldEtage.setEnabled(false);
		textFieldEtage.setColumns(10);
		textFieldEtage.setBounds(186, 482, 178, 19);
		getContentPane().add(textFieldEtage);
		
		JLabel lblNumroDtage = new JLabel("Numéro d'étage");
		lblNumroDtage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumroDtage.setBounds(10, 483, 102, 15);
		getContentPane().add(lblNumroDtage);
		
		textFieldPrixM2 = new JTextField();
		textFieldPrixM2.setEnabled(false);
		textFieldPrixM2.setColumns(10);
		textFieldPrixM2.setBounds(186, 520, 178, 19);
		getContentPane().add(textFieldPrixM2);
		
		JLabel lblPrixM2 = new JLabel("Prix du m2");
		lblPrixM2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrixM2.setBounds(10, 521, 102, 15);
		getContentPane().add(lblPrixM2);
		
		textFieldNbPieces = new JTextField();
		textFieldNbPieces.setEnabled(false);
		textFieldNbPieces.setColumns(10);
		textFieldNbPieces.setBounds(186, 559, 178, 19);
		getContentPane().add(textFieldNbPieces);
		
		JLabel lblNbPieces = new JLabel("Nombre de pièces");
		lblNbPieces.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNbPieces.setBounds(10, 560, 102, 15);
		getContentPane().add(lblNbPieces);
		
		btnInsererLog = new JButton("Insérer dans le nouveau bien");
		btnInsererLog.setEnabled(false);
		btnInsererLog.setBackground(Color.WHITE);
		btnInsererLog.addActionListener(this.gestionnaire);
		btnInsererLog.setIcon(new ImageIcon(FenetreInsertionBien.class.getResource("/data/add-button.png")));
		btnInsererLog.setBounds(83, 595, 219, 21);
		getContentPane().add(btnInsererLog);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.addActionListener(this.gestionnaire);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(FenetreInsertionBien.class.getResource("/data/marque-de-croix.png")));
		btnNewButton.setBounds(214, 292, 113, 21);
		getContentPane().add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(386, 10, 14, 632);
		getContentPane().add(separator_1);
		
		comboBoxTypeLogGar = new JComboBox<Object>();
		comboBoxTypeLogGar.setBackground(new Color(255, 255, 255));
		comboBoxTypeLogGar.setEnabled(false);
		comboBoxTypeLogGar.setModel(new DefaultComboBoxModel<Object>(new String[] {"Logement", "Garage"}));
		comboBoxTypeLogGar.setBounds(10, 359, 91, 21);
		getContentPane().add(comboBoxTypeLogGar);
		
		chckbxCompteurLogement = new JCheckBox("Compteur logement");
		chckbxCompteurLogement.setEnabled(false);
		chckbxCompteurLogement.addActionListener(this);
		chckbxCompteurLogement.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCompteurLogement.setBackground(new Color(255, 255, 255));
		chckbxCompteurLogement.setBounds(406, 354, 328, 34);
		getContentPane().add(chckbxCompteurLogement);
		
		textFieldMatriculeCL = new JTextField();
		textFieldMatriculeCL.setEnabled(false);
		textFieldMatriculeCL.setColumns(10);
		textFieldMatriculeCL.setBounds(541, 398, 178, 19);
		getContentPane().add(textFieldMatriculeCL);
		
		JLabel lblMatricule = new JLabel("Matricule");
		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatricule.setBounds(410, 399, 102, 15);
		getContentPane().add(lblMatricule);
		
		textFieldAncienIndice = new JTextField();
		textFieldAncienIndice.setEnabled(false);
		textFieldAncienIndice.setColumns(10);
		textFieldAncienIndice.setBounds(541, 428, 178, 19);
		getContentPane().add(textFieldAncienIndice);
		
		JLabel lblAncienIndice = new JLabel("Ancien indice");
		lblAncienIndice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAncienIndice.setBounds(410, 429, 102, 15);
		getContentPane().add(lblAncienIndice);
		
		textFieldNouvelIndiceCL = new JTextField();
		textFieldNouvelIndiceCL.setEnabled(false);
		textFieldNouvelIndiceCL.setColumns(10);
		textFieldNouvelIndiceCL.setBounds(541, 457, 178, 19);
		getContentPane().add(textFieldNouvelIndiceCL);
		
		JLabel lblNouvelIndice = new JLabel("Nouvel indice");
		lblNouvelIndice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNouvelIndice.setBounds(410, 458, 102, 15);
		getContentPane().add(lblNouvelIndice);
		
		btnAjouterAuLogement = new JButton("Ajouter au logement");
		btnAjouterAuLogement.setEnabled(false);
		btnAjouterAuLogement.setIcon(new ImageIcon(FenetreInsertionBien.class.getResource("/data/add-button.png")));
		btnAjouterAuLogement.setBackground(Color.WHITE);
		btnAjouterAuLogement.setBounds(462, 534, 219, 21);
		getContentPane().add(btnAjouterAuLogement);
		btnAjouterAuLogement.addActionListener(this.gestionnaire);
		
		
		JLabel lblMatricule_1 = new JLabel("Matricule");
		lblMatricule_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatricule_1.setBounds(410, 83, 102, 15);
		getContentPane().add(lblMatricule_1);
		
		textFieldMatriculeCB = new JTextField();
		textFieldMatriculeCB.setEnabled(false);
		textFieldMatriculeCB.setColumns(10);
		textFieldMatriculeCB.setBounds(541, 82, 178, 19);
		getContentPane().add(textFieldMatriculeCB);
		
		textFieldAncienIndiceCB = new JTextField();
		textFieldAncienIndiceCB.setEnabled(false);
		textFieldAncienIndiceCB.setColumns(10);
		textFieldAncienIndiceCB.setBounds(541, 112, 178, 19);
		getContentPane().add(textFieldAncienIndiceCB);
		
		JLabel lblAncienIndice_1 = new JLabel("Ancien indice");
		lblAncienIndice_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAncienIndice_1.setBounds(410, 113, 102, 15);
		getContentPane().add(lblAncienIndice_1);
		
		JLabel lblNouvelIndice_1 = new JLabel("Nouvel indice");
		lblNouvelIndice_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNouvelIndice_1.setBounds(410, 142, 102, 15);
		getContentPane().add(lblNouvelIndice_1);
		
		textFieldNouvelIndiceCB = new JTextField();
		textFieldNouvelIndiceCB.setEnabled(false);
		textFieldNouvelIndiceCB.setColumns(10);
		textFieldNouvelIndiceCB.setBounds(541, 141, 178, 19);
		getContentPane().add(textFieldNouvelIndiceCB);
		
		btnAjouterAuBienCB = new JButton("Ajouter au bien");
		btnAjouterAuBienCB.addActionListener(this.gestionnaire);
		btnAjouterAuBienCB.setEnabled(false);
		btnAjouterAuBienCB.setIcon(new ImageIcon(FenetreInsertionBien.class.getResource("/data/add-button.png")));
		btnAjouterAuBienCB.setBackground(Color.WHITE);
		btnAjouterAuBienCB.setBounds(504, 232, 147, 21);
		getContentPane().add(btnAjouterAuBienCB);
		
		JLabel lblInsertionCL = new JLabel("Insertion de compteur pour un logemement");
		lblInsertionCL.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertionCL.setForeground(Color.BLUE);
		lblInsertionCL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsertionCL.setBounds(394, 336, 340, 13);
		getContentPane().add(lblInsertionCL);
		
		JLabel lblInsertionCG = new JLabel("Insertion de compteur pour le bien");
		lblInsertionCG.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertionCG.setForeground(Color.BLUE);
		lblInsertionCG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsertionCG.setBounds(394, 26, 340, 13);
		getContentPane().add(lblInsertionCG);
		
		JLabel lblTypeC = new JLabel("Type de compteur");
		lblTypeC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeC.setBounds(410, 168, 113, 15);
		getContentPane().add(lblTypeC);
		
		JLabel lblTypeDeCompteur = new JLabel("Type de compteur");
		lblTypeDeCompteur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeDeCompteur.setBounds(410, 487, 102, 15);
		getContentPane().add(lblTypeDeCompteur);
		
		comboBoxCL = new JComboBox<>();
		comboBoxCL.setEnabled(false);
		comboBoxCL.setBackground(new Color(255, 255, 255));
		comboBoxCL.setModel(new DefaultComboBoxModel<>(new String[] {"eau", "électrique", "gaz"}));
		comboBoxCL.setBounds(541, 486, 178, 21);
		getContentPane().add(comboBoxCL);
		
		comboBoxCG = new JComboBox<Object>();
		comboBoxCG.setEnabled(false);
		comboBoxCG.setBackground(new Color(255, 255, 255));
		comboBoxCG.setModel(new DefaultComboBoxModel<>(new String[] {"eau", "électrique", "gaz"}));
		comboBoxCG.setBounds(541, 170, 178, 21);
		getContentPane().add(comboBoxCG);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBackground(Color.BLUE);
		separator_2.setBounds(138, 54, 120, 2);
		getContentPane().add(separator_2);
		
		textFieldIDBIEN = new JTextField();
		textFieldIDBIEN.setBackground(new Color(255, 255, 255));
		textFieldIDBIEN.setColumns(10);
		textFieldIDBIEN.setBounds(186, 81, 91, 19);
		getContentPane().add(textFieldIDBIEN);
		
		JLabel lblIdBien = new JLabel("ID");
		lblIdBien.setForeground(new Color(128, 0, 0));
		lblIdBien.setBackground(new Color(255, 255, 255));
		lblIdBien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdBien.setBounds(10, 82, 52, 15);
		getContentPane().add(lblIdBien);
		
		textFieldIDLOG = new JTextField();
		textFieldIDLOG.setEnabled(false);
		textFieldIDLOG.setColumns(10);
		textFieldIDLOG.setBounds(186, 414, 102, 19);
		getContentPane().add(textFieldIDLOG);
		
		JLabel lblIdLogement = new JLabel("ID LOGEMENT");
		lblIdLogement.setForeground(new Color(128, 0, 0));
		lblIdLogement.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdLogement.setBounds(10, 415, 102, 15);
		getContentPane().add(lblIdLogement);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("6 caractères max");
		lblNewLabel_1.setIcon(new ImageIcon(FenetreInsertionBien.class.getResource("/data/avertissement.png")));
		lblNewLabel_1.setBounds(287, 73, 30, 34);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxTypeLOG = new JComboBox<Object>();
		comboBoxTypeLOG.setBackground(new Color(255, 255, 255));
		comboBoxTypeLOG.setEnabled(false);
		comboBoxTypeLOG.setModel(new DefaultComboBoxModel<Object>(new String[] {"T1", "T2", "T3", "T4", "T5"}));
		comboBoxTypeLOG.setBounds(185, 383, 52, 21);
		getContentPane().add(comboBoxTypeLOG);
		
		JLabel lblTypeDeLogement = new JLabel("Type de logement");
		lblTypeDeLogement.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeDeLogement.setBounds(10, 390, 120, 15);
		getContentPane().add(lblTypeDeLogement);
		setTitle("Ajouter un bien");
		setFrameIcon(new ImageIcon(FenetreInsertionBien.class.getResource("/data/add-button.png")));
		setBounds(100, 100, 750, 682);

	}

	public JComboBox<Object> getComboBoxTypeLog() {
		return comboBoxTypeLOG;
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

	public JTextField getTextFieldDesc() {
		return textFieldDesc;
	}

	public JTextField getTextFieldNbLogMax() {
		return textFieldNbLogMax;
	}

	public JTextField getTextFieldMatriculeCB() {
		return textFieldMatriculeCB;
	}

	public JTextField getTextFieldAncienIndiceCB() {
		return textFieldAncienIndiceCB;
	}

	public JTextField getTextFieldNouvelIndiceCB() {
		return textFieldNouvelIndiceCB;
	}

	public JTextField getTextFieldSurface() {
		return textFieldSurface;
	}

	public JTextField getTextFieldEtage() {
		return textFieldEtage;
	}

	public JTextField getTextFieldPrixM2() {
		return textFieldPrixM2;
	}

	public JTextField getTextFieldNbPieces() {
		return textFieldNbPieces;
	}

	public JButton getBtnInsererLog() {
		return btnInsererLog;
	}

	public JTextField getTextFieldMatriculeCL() {
		return textFieldMatriculeCL;
	}

	public JTextField getTextFieldAncienIndiceCL() {
		return textFieldAncienIndice;
	}

	public JTextField getTextFieldNouvelIndiceCL() {
		return textFieldNouvelIndiceCL;
	}

	public JComboBox<Object> getComboBoxCL() {
		return comboBoxCL;
	}

	public JComboBox<Object> getComboBoxCG() {
		return comboBoxCG;
	}

	public JTextField getTextFieldIDBIEN() {
		return textFieldIDBIEN;
	}

	public JTextField getTextFieldIDLOG() {
		return textFieldIDLOG;
	}

	public JComboBox<Object> getComboBoxTypeLogGar() {
		return comboBoxTypeLogGar;
	}

	public JCheckBox getChckbxCompteurLogement() {
		return chckbxCompteurLogement;
	}

	public void setStatItemsLogement(boolean val) {
		this.comboBoxTypeLOG.setEnabled(val);
		this.textFieldIDLOG.setEnabled(val);
		this.textFieldSurface.setEnabled(val);
		this.textFieldEtage.setEnabled(val);
		this.textFieldPrixM2.setEnabled(val);
		this.textFieldNbPieces.setEnabled(val);
		this.btnInsererLog.setEnabled(val);
		this.comboBoxTypeLogGar.setEnabled(val);
	}
	
	public void setStatItemsCompteurLogement(boolean val) {
		this.textFieldMatriculeCL.setEnabled(val);
		this.textFieldAncienIndice.setEnabled(val);
		this.textFieldNouvelIndiceCL.setEnabled(val);
		this.btnAjouterAuLogement.setEnabled(val);
		this.comboBoxCL.setEnabled(val);

	}
	
	public void setStatItemsCompteurgeneral(boolean val) {
		this.textFieldMatriculeCB.setEnabled(val);
		this.textFieldAncienIndiceCB.setEnabled(val);
		this.textFieldNouvelIndiceCB.setEnabled(val);
		this.btnAjouterAuBienCB.setEnabled(val);
		this.comboBoxCG.setEnabled(val);
	}
	// CHECKBOX
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox ck = (JCheckBox) e.getSource();
		switch (ck.getText()) {
		case "Compteur logement":
			if (ck.isSelected()) {
				setStatItemsCompteurLogement(true);
			} else {
				setStatItemsCompteurLogement(false);
			}
			break;
		default:
			break;
		}
	}
}
