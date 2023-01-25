package vue.insertion.intern;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import controlleur.gestionInsertion.intern.GestionInsertionEtatLieux;
import controlleur.others.Boite;
import modele.Logement;

import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class FenetreAjoutEtatLieux extends JInternalFrame {
	GestionInsertionEtatLieux gestionnaire; 
	private static final long serialVersionUID = 1L;
	private JTextField textFieldIDBien;
	private JTextField textFieldIDLogement;
	private JTextField textFieldIDAnalyse;
	private JTextField textFieldIDElem;
	private JTextField textFieldEtatGen;
	private JTextField textFieldLienFichier;
	private JTextPane textPAneObservations;

	public FenetreAjoutEtatLieux() {
		this.gestionnaire = new GestionInsertionEtatLieux(this);
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Etat du logement");
		setFrameIcon(new ImageIcon(FenetreAjoutEtatLieux.class.getResource("/data/add-button.png")));
		setBorder(new LineBorder(new Color(0, 0, 160), 2));
		setBounds(100, 100, 385, 424);
		getContentPane().setLayout(null);
		
		JButton btnConfirmer = new JButton("Ajouter");
		btnConfirmer.addActionListener(this.gestionnaire);
		btnConfirmer.setIcon(new ImageIcon(FenetreAjoutEtatLieux.class.getResource("/data/arrow-down.png")));
		btnConfirmer.setBackground(Color.WHITE);
		btnConfirmer.setBounds(155, 352, 103, 21);
		getContentPane().add(btnConfirmer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this.gestionnaire);
		btnAnnuler.setIcon(new ImageIcon(FenetreAjoutEtatLieux.class.getResource("/data/marque-de-croix.png")));
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(268, 352, 103, 21);
		getContentPane().add(btnAnnuler);
		
		JLabel lblAjoutDuntat = new JLabel("Ajout d'un état des lieux");
		lblAjoutDuntat.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutDuntat.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblAjoutDuntat.setBounds(10, 10, 379, 34);
		getContentPane().add(lblAjoutDuntat);
		
		textFieldIDBien = new JTextField();
		textFieldIDBien.setText(((Logement) Boite.getItem("Logement")).getIdbien());
		textFieldIDBien.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIDBien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textFieldIDBien.setForeground(new Color(0, 0, 160));
		textFieldIDBien.setBackground(new Color(255, 255, 255));
		textFieldIDBien.setEditable(false);
		textFieldIDBien.setColumns(10);
		textFieldIDBien.setBounds(178, 67, 178, 19);
		getContentPane().add(textFieldIDBien);
		
		textFieldIDLogement = new JTextField();
		textFieldIDLogement.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIDLogement.setText(((Logement) Boite.getItem("Logement")).getIdLog());
		textFieldIDLogement.setBackground(new Color(255, 255, 255));
		textFieldIDLogement.setForeground(new Color(0, 0, 160));
		textFieldIDLogement.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textFieldIDLogement.setEditable(false);
		textFieldIDLogement.setColumns(10);
		textFieldIDLogement.setBounds(178, 96, 178, 19);
		getContentPane().add(textFieldIDLogement);
		
		textFieldIDAnalyse = new JTextField();
		textFieldIDAnalyse.setColumns(10);
		textFieldIDAnalyse.setBounds(178, 125, 178, 19);
		getContentPane().add(textFieldIDAnalyse);
		
		textFieldIDElem = new JTextField();
		textFieldIDElem.setColumns(10);
		textFieldIDElem.setBounds(178, 154, 178, 19);
		getContentPane().add(textFieldIDElem);
		
		textFieldEtatGen = new JTextField();
		textFieldEtatGen.setColumns(10);
		textFieldEtatGen.setBounds(178, 183, 178, 19);
		getContentPane().add(textFieldEtatGen);
		
		textFieldLienFichier = new JTextField();
		textFieldLienFichier.setColumns(10);
		textFieldLienFichier.setBounds(178, 212, 178, 19);
		getContentPane().add(textFieldLienFichier);
		
		JLabel lblIdentifiantDuBien = new JLabel("Identifiant  du bien");
		lblIdentifiantDuBien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdentifiantDuBien.setBounds(24, 68, 153, 15);
		getContentPane().add(lblIdentifiantDuBien);
		
		JLabel lblIdentifiantDuLogement = new JLabel("Identifiant du logement");
		lblIdentifiantDuLogement.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdentifiantDuLogement.setBounds(24, 97, 153, 15);
		getContentPane().add(lblIdentifiantDuLogement);
		
		JLabel lblDateDeLanalyse = new JLabel("Date de l'analyse");
		lblDateDeLanalyse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateDeLanalyse.setBounds(24, 126, 153, 15);
		getContentPane().add(lblDateDeLanalyse);
		
		JLabel lblElementsObservs = new JLabel("Élements observés");
		lblElementsObservs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblElementsObservs.setBounds(24, 155, 153, 15);
		getContentPane().add(lblElementsObservs);
		
		JLabel lblObservations = new JLabel("Observations");
		lblObservations.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservations.setBounds(24, 241, 153, 15);
		getContentPane().add(lblObservations);
		
		JLabel lblLienDuFichier = new JLabel("Lien du fichier");
		lblLienDuFichier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLienDuFichier.setBounds(24, 215, 153, 15);
		getContentPane().add(lblLienDuFichier);
		
		JLabel lblEtatGnral = new JLabel("État général");
		lblEtatGnral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEtatGnral.setBounds(24, 186, 153, 15);
		getContentPane().add(lblEtatGnral);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 160));
		separator.setBounds(74, 50, 251, 2);
		getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Lier un fichier");
		btnNewButton.addActionListener(this.gestionnaire);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(FenetreAjoutEtatLieux.class.getResource("/data/add-button.png")));
		btnNewButton.setBounds(10, 352, 135, 21);
		getContentPane().add(btnNewButton);
		
		textPAneObservations = new JTextPane();
		textPAneObservations.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPAneObservations.setBackground(new Color(200, 227, 255));
		textPAneObservations.setBounds(178, 241, 178, 93);
		getContentPane().add(textPAneObservations);

	}
	
	public JTextField getTextFieldIDBien() {
		return textFieldIDBien;
	}

	public JTextField getTextFieldIDLogement() {
		return textFieldIDLogement;
	}

	public JTextField getTextFieldIDAnalyse() {
		return textFieldIDAnalyse;
	}

	public JTextField getTextFieldIDElem() {
		return textFieldIDElem;
	}

	public JTextField getTextFieldEtatGen() {
		return textFieldEtatGen;
	}

	public JTextField getTextFieldLienFichier() {
		return textFieldLienFichier;
	}

	public JTextPane getTextPaneObservations() {
		return textPAneObservations;
	}
}