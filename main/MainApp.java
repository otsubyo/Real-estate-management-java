package main;

import java.util.ArrayList;
import java.util.List;
import controlleur.CictOracleDataSource;
import modele.ViewLocations;
import modele.dao.DaoViewLocation;
import modele.dao.Iterateur;

public class MainApp {

	// Test de chaque Dao
	public static void main(String[] args) throws Exception {
		CictOracleDataSource.creerAcces("nrm4206a", "9dfe351b");
		DaoViewLocation daoViewLocation = new DaoViewLocation();
		List<ViewLocations> viewLocations = new ArrayList<>();
		Iterateur<ViewLocations> iterateur = daoViewLocation.findAllIterateur();
		
		while (iterateur.hasNext()) {
			viewLocations.add(iterateur.next());
		}
		
		for (ViewLocations viewLocations2 : viewLocations) {
			System.out.println(viewLocations2.toString());
		}
		
		CictOracleDataSource.deconnecter();
	}
}