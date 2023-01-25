package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import controlleur.CictOracleDataSource;
import modele.ViewLocations;
import modele.dao.requetes.select.RequeteSelectViewLocationsLogements;

public class DaoViewLocation extends DaoModele<ViewLocations> implements Dao<ViewLocations>{
	private static Iterateur<ViewLocations> iterateur;

	@Override
	public void create(ViewLocations data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ViewLocations data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ViewLocations data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ViewLocations findById(String... id) throws SQLException {
		return null;
	}

	@Override
	public List<ViewLocations> findAll() throws SQLException {
		return find(new RequeteSelectViewLocationsLogements());
	}
	
	public Iterateur<ViewLocations> findAllIterateur() throws SQLException {
		RequeteSelectViewLocationsLogements req = new RequeteSelectViewLocationsLogements();
        PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
        req.parametres(st);
        ResultSet res = st.executeQuery();

        iterateur = new Iterateur<>(res, this);
        return iterateur;
	}

	@Override
	protected ViewLocations createInstance(ResultSet cursor) throws SQLException {
		// TODO Auto-generated method stub
		return new ViewLocations(cursor.getString(1),
														cursor.getString(2), 
														cursor.getString(3),
														cursor.getDate(4).toString(),
														cursor.getFloat(5),
														cursor.getDate(6).toString());
	}

}
