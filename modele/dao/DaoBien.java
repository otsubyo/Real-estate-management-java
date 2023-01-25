package modele.dao;

import modele.Bien;
import modele.dao.requetes.select.RequeteSelectBien;
import modele.dao.requetes.select.RequeteSelectBienById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutBien;
import modele.dao.requetes.update.RequeteUpdateBien;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controlleur.CictOracleDataSource;

public class DaoBien extends DaoModele<Bien> implements Dao<Bien> {
    private static Iterateur<Bien> iterateurBien;

    @Override
    public void create(Bien data) throws SQLException {
    	SousProgramme<Bien> sp = new SpAjoutBien();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
    }

    @Override
    public void update(Bien data) throws SQLException {
        miseAJour(new RequeteUpdateBien(), data);
    }

    @Override
    public void delete(Bien data) throws SQLException {
        delete(data);
    }

    @Override
    public Bien findById(String... id) throws SQLException {
        List<Bien> biens = find(new RequeteSelectBienById(), id);
        if (biens.isEmpty()) {
            return null;
        }
        return biens.get(0);
    }

    @Override
    public List<Bien> findAll() throws SQLException {
        return find(new RequeteSelectBien());
    }

    public Iterateur<Bien> findAllIterateur() throws SQLException {
        RequeteSelectBien req = new RequeteSelectBien();
        PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
        req.parametres(st);
        ResultSet res = st.executeQuery();

        iterateurBien = new Iterateur<>(res, this);
        return DaoBien.iterateurBien;
    }

    @Override
    protected Bien createInstance(ResultSet cursor) throws SQLException {
        Bien bien = null;
        try {
            bien = new Bien(
            		cursor.getString("IDIM"),
                    cursor.getString("ADRESSE"),
                    cursor.getString("CODEPOSTAL"),
                    cursor.getString("VILLE"),
                    cursor.getString("DESCRIPTION"),
                    cursor.getInt("NBLOGEMENTSMAX")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bien;
    }
}
