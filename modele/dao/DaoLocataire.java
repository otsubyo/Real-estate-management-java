package modele.dao;

import modele.Locataire;
import modele.dao.requetes.select.RequeteSelectLocataire;
import modele.dao.requetes.select.RequeteSelectLocataireById;
import modele.dao.requetes.sousProgramme.SousProgramme;
import modele.dao.requetes.sousProgramme.SpAjoutLocataire;
import modele.dao.requetes.update.RequeteUpdateLocataire;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controlleur.CictOracleDataSource;

public class DaoLocataire extends DaoModele<Locataire> implements Dao<Locataire> {
    @Override
    public void create(Locataire data) throws SQLException {
    	SousProgramme<Locataire> sp = new SpAjoutLocataire();
		CallableStatement st = CictOracleDataSource.getConnexion().prepareCall(sp.appelSousProgramme());
		sp.parametres(st, data);
		st.execute();
    }

    @Override
    public void update(Locataire data) throws SQLException {
        miseAJour(new RequeteUpdateLocataire(), data);
    }

    @Override
    public void delete(Locataire data) throws SQLException {
    	//super.delete(null, data)
    }

    @Override
    public Locataire findById(String... id) throws SQLException {
        List<Locataire> locataires = find(new RequeteSelectLocataireById());
        if (locataires.isEmpty()) {
            return null;
        }
        return locataires.get(0);
    }

    @Override
    public List<Locataire> findAll() throws SQLException {
        return find(new RequeteSelectLocataire());
    }

    @Override
    protected Locataire createInstance(ResultSet cursor) throws SQLException {
        Locataire locataire = null;
        try {
            locataire = new Locataire(
            		cursor.getString("IDLOC"),
            		cursor.getString("CIVILITE").toUpperCase(),
                    cursor.getString("NOM"),
                    cursor.getString("PRENOM"),
                    cursor.getString("ADRESSE"),
                    cursor.getString("CODEPOSTAL"),
                    cursor.getString("VILLE"),
                    cursor.getString("COURRIEL"),
                    cursor.getString("NUM_TEL"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locataire;
    }
}
