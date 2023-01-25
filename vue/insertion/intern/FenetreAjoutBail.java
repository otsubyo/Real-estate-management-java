package vue.insertion.intern;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controlleur.gestionInsertion.intern.GestionInsertionBail;
import controlleur.others.Boite;
import modele.Locataire;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class FenetreAjoutBail extends JInternalFrame {
	private static final long serialVersionUID = 4370689752107337061L;
	private JTextField textFieldDateSignature;
	private JTextField textFieldIDLocation;
	private JTextField textFieldDateDebut;
	private JTextField textFieldDateFin;
	private JTextField textFieldMontantC;
	private JLabel lblIdDeLa;
	private JLabel lblDateDeLa;
	private JLabel lblInsertionDunBailm;
	private JSeparator separator;
	private GestionInsertionBail gestionnaire;
	
	public FenetreAjoutBail() {
		setBorder(new LineBorder(new Color(0, 0, 128), 2));
		this.gestionnaire = new GestionInsertionBail(this);
		setTitle("Ajout d'un bail");
		setFrameIcon(new ImageIcon(FenetreAjoutBail.class.getResource("/data/add-button.png")));
		setBackground(new Color(2, 69, 163));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 424, 303);
		getContentPane().setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this.gestionnaire);
		btnAjouter.setIcon(new ImageIcon(FenetreAjoutBail.class.getResource("/data/arrow-down.png")));
		btnAjouter.setBackground(Color.WHITE);
		btnAjouter.setBounds(186, 229, 103, 21);
		getContentPane().add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this.gestionnaire);
		btnAnnuler.setIcon(new ImageIcon(FenetreAjoutBail.class.getResource("/data/marque-de-croix.png")));
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(299, 229, 103, 21);
		getContentPane().add(btnAnnuler);
		
		JButton btnAjouterFichier = new JButton("Ajouter un fichier");
		btnAjouterFichier.addActionListener(this.gestionnaire);
		btnAjouterFichier.setIcon(new ImageIcon(FenetreAjoutBail.class.getResource("/data/add-button.png")));
		btnAjouterFichier.setBackground(Color.WHITE);
		btnAjouterFichier.setBounds(20, 229, 153, 21);
		getContentPane().add(btnAjouterFichier);
		
		textFieldDateSignature = new JTextField();
		textFieldDateSignature.setToolTipText("Format jj/mm/aaaa");
		textFieldDateSignature.setColumns(10);
		textFieldDateSignature.setBounds(189, 66, 178, 19);
		getContentPane().add(textFieldDateSignature);
		
		textFieldIDLocation = new JTextField();
		textFieldIDLocation.setForeground(new Color(0, 0, 160));
		textFieldIDLocation.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIDLocation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textFieldIDLocation.setText(((Locataire) Boite.getItem("Locataire")).getIdloc().toUpperCase());
		textFieldIDLocation.setEditable(false);
		textFieldIDLocation.setColumns(10);
		textFieldIDLocation.setBounds(189, 95, 178, 19);
		getContentPane().add(textFieldIDLocation);

		textFieldDateDebut = new JTextField();
		textFieldDateDebut.setColumns(10);
		textFieldDateDebut.setBounds(189, 124, 178, 19);
		getContentPane().add(textFieldDateDebut);
		
		textFieldDateFin = new JTextField();
		textFieldDateFin.setColumns(10);
		textFieldDateFin.setBounds(189, 153, 178, 19);
		getContentPane().add(textFieldDateFin);
		
		textFieldMontantC = new JTextField();
		textFieldMontantC.setColumns(10);
		textFieldMontantC.setBounds(189, 182, 178, 19);
		getContentPane().add(textFieldMontantC);
		
		JLabel lblMontantDeLa = new JLabel("Montant de la caution");
		lblMontantDeLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMontantDeLa.setBounds(41, 183, 153, 15);
		getContentPane().add(lblMontantDeLa);
		
		JLabel lblDateDeFin = new JLabel("Date de fin");
		lblDateDeFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateDeFin.setBounds(41, 154, 153, 15);
		getContentPane().add(lblDateDeFin);
		
		JLabel lblDateDeDbut = new JLabel("Date de début");
		lblDateDeDbut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateDeDbut.setBounds(41, 125, 153, 15);
		getContentPane().add(lblDateDeDbut);
		
		lblIdDeLa = new JLabel("ID du locataire");
		lblIdDeLa.setForeground(new Color(0, 0, 0));
		lblIdDeLa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdDeLa.setBounds(41, 96, 153, 15);
		getContentPane().add(lblIdDeLa);
		
		lblDateDeLa = new JLabel("Date de la signature");
		lblDateDeLa.setForeground(new Color(0, 0, 128));
		lblDateDeLa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateDeLa.setBounds(41, 67, 153, 15);
		getContentPane().add(lblDateDeLa);
		
		lblInsertionDunBailm = new JLabel("Lier un bail");
		lblInsertionDunBailm.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertionDunBailm.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblInsertionDunBailm.setBounds(10, 10, 392, 34);
		getContentPane().add(lblInsertionDunBailm);
		
		separator = new JSeparator();
		separator.setForeground(new Color(2, 69, 163));
		separator.setBackground(new Color(2, 69, 163));
		separator.setBounds(10, 54, 392, 2);
		getContentPane().add(separator);

	}
	
	public JTextField getTextFieldDateSignature() {
		return textFieldDateSignature;
	}

	public JTextField getTextFieldIDLocation() {
		return textFieldIDLocation;
	}

	public JTextField getTextFieldDateDebut() {
		return textFieldDateDebut;
	}

	public JTextField getTextFieldDateFin() {
		return textFieldDateFin;
	}

	public JTextField getTextFieldMontantC() {
		return textFieldMontantC;
	}

	public JSeparator getSeparator() {
		return separator;
	}

}