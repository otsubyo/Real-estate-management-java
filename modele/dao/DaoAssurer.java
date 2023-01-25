package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modele.Assurer;
import modele.dao.requetes.select.RequeteSelectAssurerByIdBien;

public class DaoAssurer extends DaoModele<Assurer> implements Dao<Assurer>{

	@Override
	public void create(Assurer data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Assurer data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Assurer data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Assurer findById(String... id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Assurer> findByIdBien(String... id) throws SQLException{
		return find(new RequeteSelectAssurerByIdBien(),id);
	}

	@Override
	public List<Assurer> findAll() throws SQLException {
		return null;
	}

	@Override
	protected Assurer createInstance(ResultSet cursor) throws SQLException {
		Assurer assurer = null;
        try {
        	assurer = new Assurer(
        			cursor.getString("NUM_POLICE"), 
        			cursor.getString("IDBIEN"), 
        			cursor.getString("IDASSURANCE"), 
        			cursor.getFloat("PROT_JURI"), 
        			cursor.getFloat("PRIME"), 
        			cursor.getFloat("QUOTITE"), 
        			cursor.getDate("DATE_DEBUT").toString(), 
        			cursor.getDate("DATE_FIN").toString()
        	);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assurer;
	}

}
