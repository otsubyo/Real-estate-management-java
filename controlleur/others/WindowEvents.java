package controlleur.others;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlleur.CictOracleDataSource;

public class WindowEvents implements WindowListener{
	private JFrame window;
	
	public WindowEvents(JFrame window) {
		this.window = window;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int res = JOptionPane.showConfirmDialog(this.window,"Etes-vous sûr de vouloir quitter ?");
	    
	    if(res == JOptionPane.YES_OPTION) {
	    	try {
				CictOracleDataSource.deconnecter();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	    	this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
