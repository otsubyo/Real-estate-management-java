package vue.insertion.intern;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controlleur.gestionInsertion.intern.GestionInsertionDiagnostic;
import controlleur.others.Boite;
import modele.Logement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class FenetreAjoutDiagnostic extends JInternalFrame {
	private GestionInsertionDiagnostic gestionnaire;
	private static final long serialVersionUID = 1L;
	private JTextField textFieldIDImm;
	private JTextField textFieldIDLog;
	private JTextField textFieldIDDateRe;
	private JComboBox<Object> comboBoxRealisation;
	
	public FenetreAjoutDiagnostic() {
		this.gestionnaire = new GestionInsertionDiagnostic(this);
		setTitle("Diagnostics du logement");
		setFrameIcon(new ImageIcon(FenetreAjoutDiagnostic.class.getResource("/data/add-button.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 485, 312);
		getContentPane().setLayout(null);
		
		JLabel lblAjoutDunDiagnostic = new JLabel("Ajouter un diagnostic logement");
		lblAjoutDunDiagnostic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutDunDiagnostic.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblAjoutDunDiagnostic.setBounds(10, 10, 453, 34);
		getContentPane().add(lblAjoutDunDiagnostic);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this.gestionnaire);
		btnAjouter.setIcon(new ImageIcon(FenetreAjoutDiagnostic.class.getResource("/data/arrow-down.png")));
		btnAjouter.setBackground(Color.WHITE);
		btnAjouter.setBounds(200, 233, 103, 21);
		getContentPane().add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this.gestionnaire);
		btnAnnuler.setIcon(new ImageIcon(FenetreAjoutDiagnostic.class.getResource("/data/marque-de-croix.png")));
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(333, 233, 103, 21);
		getContentPane().add(btnAnnuler);
		
		textFieldIDImm = new JTextField();
		textFieldIDImm.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIDImm.setText(((Logement) Boite.getItem("Logement")).getIdbien());
		textFieldIDImm.setForeground(new Color(0, 0, 160));
		textFieldIDImm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textFieldIDImm.setEditable(false);
		textFieldIDImm.setColumns(10);
		textFieldIDImm.setBounds(228, 88, 178, 19);
		getContentPane().add(textFieldIDImm);
		
		textFieldIDLog = new JTextField();
		textFieldIDLog.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIDLog.setText(((Logement) Boite.getItem("Logement")).getIdLog());
		textFieldIDLog.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textFieldIDLog.setForeground(new Color(0, 0, 160));
		textFieldIDLog.setEditable(false);
		textFieldIDLog.setColumns(10);
		textFieldIDLog.setBounds(228, 117, 178, 19);
		getContentPane().add(textFieldIDLog);
		
		textFieldIDDateRe = new JTextField();
		textFieldIDDateRe.setColumns(10);
		textFieldIDDateRe.setBounds(228, 146, 178, 19);
		getContentPane().add(textFieldIDDateRe);
		
		JLabel lblIdDeLimmeuble = new JLabel("ID de l'immeuble");
		lblIdDeLimmeuble.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdDeLimmeuble.setBounds(65, 92, 153, 15);
		getContentPane().add(lblIdDeLimmeuble);
		
		JLabel lblIdDuLogemen = new JLabel("ID du logement");
		lblIdDuLogemen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdDuLogemen.setBounds(65, 120, 153, 15);
		getContentPane().add(lblIdDuLogemen);
		
		JLabel lblDateDeRenouvellement = new JLabel("Date de renouvellement");
		lblDateDeRenouvellement.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateDeRenouvellement.setBounds(65, 149, 153, 15);
		getContentPane().add(lblDateDeRenouvellement);
		
		JLabel lblRalisation = new JLabel("Réalisation");
		lblRalisation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRalisation.setBounds(65, 175, 153, 15);
		getContentPane().add(lblRalisation);
		
		comboBoxRealisation = new JComboBox<Object>();
		comboBoxRealisation.setBackground(Color.WHITE);
		comboBoxRealisation.setModel(new DefaultComboBoxModel<Object>(new String[] {"Oui", "Non"}));
		comboBoxRealisation.setBounds(228, 176, 63, 21);
		getContentPane().add(comboBoxRealisation);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(2, 69, 163));
		separator.setBackground(new Color(2, 69, 163));
		separator.setBounds(20, 54, 443, 7);
		getContentPane().add(separator);
		
		JButton btnLierUnFichier = new JButton("Lier un fichier");
		btnLierUnFichier.addActionListener(this.gestionnaire);
		btnLierUnFichier.setIcon(new ImageIcon(FenetreAjoutDiagnostic.class.getResource("/data/add-button.png")));
		btnLierUnFichier.setBackground(Color.WHITE);
		btnLierUnFichier.setBounds(20, 233, 151, 21);
		getContentPane().add(btnLierUnFichier);

	}

	public JComboBox<Object> getComboBox() {
		return comboBoxRealisation;
	}

	public JTextField getTextFieldIDImm() {
		return textFieldIDImm;
	}

	public JTextField getTextFieldIDLog() {
		return textFieldIDLog;
	}

	public JTextField getTextFieldIDDateRe() {
		return textFieldIDDateRe;
	}
}