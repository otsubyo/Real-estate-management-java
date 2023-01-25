package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlleur.CictOracleDataSource;
import modele.dao.requetes.Requete;

public abstract class DaoModele<T> implements Dao<T>{
	protected abstract T createInstance(ResultSet cursor) throws SQLException;
	
	protected List<T> select(PreparedStatement prSt)throws SQLException{
        ResultSet res = prSt.executeQuery();
        boolean existe = res.next();
        List<T> liste = new ArrayList<>();
        while (existe) {
            liste.add(createInstance(res));
            existe = res.next();
        }
        return liste;
    }

    public int miseAJour(Requete<T> req, T data)throws SQLException{
        PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
        req.parametres(st, data);
        return st.executeUpdate(); // Nombre de lignes mise à jour
    }

    public int delete(Requete<T> req, T data) throws SQLException{
    	return miseAJour(req, data);
    }

    public List<T> find(Requete<T> req, String... id)throws SQLException{
        PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
        req.parametres(st,id);
        return select(st);
    }

    public T findById(Requete<T> req, String... id)throws SQLException {
        PreparedStatement st = CictOracleDataSource.getConnexion().prepareStatement(req.requete());
        req.parametres(st,id);
        List<T> liste = find(req,id);
        if (liste.isEmpty()) {
            return null;
        }
        return liste.get(0);
    }
}
