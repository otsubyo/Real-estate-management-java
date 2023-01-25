package vue.insertion;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controlleur.gestionInsertion.GestionInsertionLogement;

public class FenetreInsertionLogement extends JInternalFrame {
	private GestionInsertionLogement gestionnaire;
	private static final long serialVersionUID = 1L;
	private JTextField textFieldIdBien;
	private JTextField textFieldSurface;
	private JTextField textFieldIdLog;
	private JTextField textFieldNumEtage;
	private JTextField textFieldPrixM2;
	private JTextField textFieldNbPiece;
	private JButton btnAjouter;
	private JComboBox<Object> comboBoxTypeLog;

	/**
	 * Create the frame.
	 */
	public FenetreInsertionLogement() {
		this.gestionnaire = new GestionInsertionLogement(this);
		setTitle("Ajout d'un logement");
		setFrameIcon(new ImageIcon(FenetreInsertionLogement.class.getResource("/data/add-button.png")));
		setBackground(new Color(2, 69, 163));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 450, 418);
		getContentPane().setLayout(null);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this.gestionnaire);
		btnAjouter.setIcon(new ImageIcon(FenetreInsertionLogement.class.getResource("/data/arrow-down.png")));
		btnAjouter.setBackground(new Color(255, 255, 255));
		btnAjouter.setBounds(88, 330, 103, 21);
		getContentPane().add(btnAjouter);
		
		JLabel lblAjoutDunLogement = new JLabel("Ajouter un logement");
		lblAjoutDunLogement.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjoutDunLogement.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblAjoutDunLogement.setBounds(10, 10, 418, 34);
		getContentPane().add(lblAjoutDunLogement);
		
		textFieldIdBien = new JTextField();
		textFieldIdBien.setColumns(10);
		textFieldIdBien.setBounds(213, 79, 178, 19);
		getContentPane().add(textFieldIdBien);
		
		textFieldSurface = new JTextField();
		textFieldSurface.setColumns(10);
		textFieldSurface.setBounds(213, 137, 178, 19);
		getContentPane().add(textFieldSurface);
		
		textFieldIdLog = new JTextField();
		textFieldIdLog.setColumns(10);
		textFieldIdLog.setBounds(213, 108, 178, 19);
		getContentPane().add(textFieldIdLog);
		
		textFieldNumEtage = new JTextField();
		textFieldNumEtage.setColumns(10);
		textFieldNumEtage.setBounds(213, 166, 178, 19);
		getContentPane().add(textFieldNumEtage);
		
		textFieldPrixM2 = new JTextField();
		textFieldPrixM2.setColumns(10);
		textFieldPrixM2.setBounds(213, 195, 178, 19);
		getContentPane().add(textFieldPrixM2);
		
		JLabel lblIdentifiantBien = new JLabel("Identifiant bien");
		lblIdentifiantBien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdentifiantBien.setBounds(50, 80, 153, 15);
		getContentPane().add(lblIdentifiantBien);
		
		JLabel lblIdentifiantLogement = new JLabel("Identifiant logement");
		lblIdentifiantLogement.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdentifiantLogement.setBounds(50, 109, 153, 15);
		getContentPane().add(lblIdentifiantLogement);
		
		JLabel lblSurfaceEnM = new JLabel("Surface en m²");
		lblSurfaceEnM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurfaceEnM.setBounds(50, 138, 153, 15);
		getContentPane().add(lblSurfaceEnM);
		
		JLabel lblNumroDeLtage = new JLabel("Numéro de l'étage");
		lblNumroDeLtage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumroDeLtage.setBounds(50, 167, 153, 15);
		getContentPane().add(lblNumroDeLtage);
		
		JLabel lblPrixDuM = new JLabel("Prix du m²");
		lblPrixDuM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrixDuM.setBounds(50, 196, 153, 15);
		getContentPane().add(lblPrixDuM);
		
		textFieldNbPiece = new JTextField();
		textFieldNbPiece.setColumns(10);
		textFieldNbPiece.setBounds(213, 224, 178, 19);
		getContentPane().add(textFieldNbPiece);
		
		JLabel lblNombreDePices = new JLabel("Nombre de pièces");
		lblNombreDePices.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreDePices.setBounds(50, 225, 153, 15);
		getContentPane().add(lblNombreDePices);
		
		JLabel lblTypeDeLogement = new JLabel("Type de logement");
		lblTypeDeLogement.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeDeLogement.setBounds(50, 255, 153, 15);
		getContentPane().add(lblTypeDeLogement);
		
		JButton btnAnnuler_1 = new JButton("Annuler");
		btnAnnuler_1.setIcon(new ImageIcon(FenetreInsertionLogement.class.getResource("/data/marque-de-croix.png")));
		btnAnnuler_1.setBackground(Color.WHITE);
		btnAnnuler_1.setBounds(251, 330, 103, 21);
		getContentPane().add(btnAnnuler_1);
		
		comboBoxTypeLog = new JComboBox<Object>();
		comboBoxTypeLog.setModel(new DefaultComboBoxModel<Object>(new String[] {"T1", "T2", "T3", "T4", "T5"}));
		comboBoxTypeLog.setEditable(true);
		comboBoxTypeLog.setBounds(213, 253, 45, 21);
		getContentPane().add(comboBoxTypeLog);	
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(2, 69, 163));
		separator.setBackground(new Color(2, 69, 163));
		separator.setBounds(10, 54, 418, 15);
		getContentPane().add(separator);

	}

	public JComboBox<Object> getComboBoxTypeLog() {
		return comboBoxTypeLog;
	}

	public JTextField getTextFieldIdBien() {
		return textFieldIdBien;
	}

	public JTextField getTextFieldSurface() {
		return textFieldSurface;
	}

	public JTextField getTextFieldIdLog() {
		return textFieldIdLog;
	}

	public JTextField getTextFieldNumEtage() {
		return textFieldNumEtage;
	}

	public JTextField getTextFieldPrixM2() {
		return textFieldPrixM2;
	}

	public JTextField getTextFieldNbPiece() {
		return textFieldNbPiece;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}
}