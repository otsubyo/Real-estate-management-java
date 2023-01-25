package modele.dao;

import modele.Garage;
import modele.dao.requetes.select.RequeteSelectGarage;
import modele.dao.requetes.select.RequeteSelectGarageById;
import modele.dao.requetes.select.RequeteSelectGarageByIdBien;
import modele.dao.requetes.update.RequeteUpdateGarage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controlleur.CictOracleDataSource;

public class DaoGarage extends DaoModele<Garage> implements Dao<Garage> {
    private static Iterateur<Garage> iterateurGarage;

    @Override
    public void create(Garage data) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(Garage data) throws SQLException {
        miseAJour(new RequeteUpdateGarage(), data);
    }

    @Override
    public void delete(Garage data) throws SQLException {
        delete(data);
    }
    
    public List<Garage> findByIdBien(String... id) throws SQLException {
		return find(new RequeteSelectGarageByIdBien(),id);
	}

    @Override
    public Garage findById(String... id) throws SQLException {
        List<Garage> garages = find(new RequeteSelectGarageById(),id);
        if (garages.isEmpty()) {
            return null;
        }
        return garages.get(0);
    }

    @Override
    public List<Garage> findAll() throws SQLException {
        return find(new RequeteSelectGarage());
    }

    public Iterateur<Garage> findAllIterateur() throws SQLException {
        RequeteSelectGarage req = new RequeteSelectGarage();
        PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
        req.parametres(st);
        ResultSet res = st.executeQuery();

        iterateurGarage = new Iterateur<>(res, this);
        return DaoGarage.iterateurGarage;
    }

    @Override
    protected Garage createInstance(ResultSet cursor) throws SQLException {
        Garage garage = null;
        try{
            garage = new Garage(
            		cursor.getString("ID_GAR"),
                    cursor.getString("IDIM_N"),
                    cursor.getDouble("SURFACE"),
                    cursor.getDouble("PRIX_M2"),
                    cursor.getString("IDIM"),
                    cursor.getString("IDLOG")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return garage;
    }
}
