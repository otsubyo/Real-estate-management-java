package controlleur;

import java.sql.Connection;
import java.sql.SQLException ;

import oracle.jdbc.pool.OracleDataSource;

@SuppressWarnings("serial")
public class CictOracleDataSource extends OracleDataSource {
    private static Connection connexion;
    private CictOracleDataSource(String login, String mdp) throws SQLException {
        this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre");
        this.setUser(login);
        this.setPassword(mdp);
    }
    
    public static void creerAcces(String login, String mdp) throws SQLException{
        CictOracleDataSource db = new CictOracleDataSource(login, mdp);
        CictOracleDataSource.connexion = db.getConnection();
    }
    
    public static Connection getConnexion() {
        return connexion;
    }
    
    public static void deconnecter() throws SQLException {
    	if (getConnexionStat()) {
    		connexion.close();
    	}
    }
    
    public static boolean getConnexionStat() {
    	return connexion != null;
    }
    
}