package modele.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controlleur.CictOracleDataSource;
import modele.Logement;
import modele.dao.requetes.select.RequeteSelectLogementById;
import modele.dao.requetes.select.RequeteSelectLogementByIdBien;
import modele.dao.requetes.select.RequeteSelectLogements;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutLogement;
import modele.dao.requetes.update.RequeteUpdateLogement;

public class DaoLogement extends DaoModele<Logement> implements Dao<Logement>{
	private static Iterateur<Logement> iterateurLogement;

	@Override
	public void create(Logement data) throws SQLException {
		SousProgramme<Logement> sp = new SpAjoutLogement();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
	}

	@Override
	public void update(Logement data) throws SQLException {
		miseAJour(new RequeteUpdateLogement(), data);
	}

	@Override
	public void delete(Logement data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Logement findById(String... id) throws SQLException {
		List<Logement> logements = find(new RequeteSelectLogementById(),id);
		if (logements.isEmpty()) {
			return null;
		}
		return logements.get(0);
	}
	
	public List<Logement> findByIdBien(String... id) throws SQLException {
		return find(new RequeteSelectLogementByIdBien(),id);
	}

	@Override
	public List<Logement> findAll() throws SQLException {
		return find(new RequeteSelectLogements());
	}
	
	public Iterateur<Logement> findAllIterateur() throws SQLException {
		RequeteSelectLogements req = new RequeteSelectLogements();
		PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
		
		req.parametres(st);
		ResultSet res = st.executeQuery();
		
		DaoLogement.iterateurLogement = new Iterateur<>(res, this);
		return DaoLogement.iterateurLogement;
	}

	@Override
	protected Logement createInstance(ResultSet cursor) throws SQLException {
		Logement log = null;
		try {
			log = new Logement(
								cursor.getString("IDIM"), 
								cursor.getString("IDLOG"),
								cursor.getFloat("SURFACE"),
								cursor.getInt("NUM_ETAGE"),
								cursor.getFloat("PRIX_M2"),
								cursor.getInt("NBPIECES"),
								cursor.getString("TYPELOG"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return log;
	}

	public static Iterateur<Logement> getIterateurLogement() {
		return iterateurLogement;
	}
}
