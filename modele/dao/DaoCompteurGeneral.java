package modele.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controlleur.CictOracleDataSource;
import modele.CompteurGeneral;
import modele.dao.requetes.select.RequeteSelectCompteurGeneral;
import modele.dao.requetes.select.RequeteSelectCompteurGeneralById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutCompteurGeneral;
import modele.dao.requetes.update.RequeteUpdateCompteurGeneral;

public class DaoCompteurGeneral extends DaoModele<CompteurGeneral> implements Dao<CompteurGeneral>{

	@Override
	public void create(CompteurGeneral data) throws SQLException {
		SousProgramme<CompteurGeneral> sp = new SpAjoutCompteurGeneral();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
	}

	@Override
	public void update(CompteurGeneral data) throws SQLException {
		miseAJour(new RequeteUpdateCompteurGeneral(), data);
	}

	@Override
	public void delete(CompteurGeneral data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CompteurGeneral findById(String... id) throws SQLException {
		List<CompteurGeneral> compteurGenerals = find(new RequeteSelectCompteurGeneralById());
		if (compteurGenerals.isEmpty()) {
			return null;
		}
		return compteurGenerals.get(0);
	}

	@Override
	public List<CompteurGeneral> findAll() throws SQLException {
		return find(new RequeteSelectCompteurGeneral());
	}

	@Override
	protected CompteurGeneral createInstance(ResultSet cursor) throws SQLException {
		CompteurGeneral compteurGeneral = null;
		try {
			compteurGeneral = new CompteurGeneral(
					cursor.getString("matricule"),
					cursor.getString("idbien"),
					cursor.getString("ancien_indice"),
					cursor.getString("nouvel_indice"),
					cursor.getString("typec")
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compteurGeneral;
	}

}
