package controlleur.others;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/*
 * Cette classe permet de stocker des éléments
 * lors de l'utilisation de plusieurs fenêtres
 * afin de les assembler à la fin pour une sauvegarde.
 * 
 * Par exemple lors d'une location, on doit fournir un bail, un état des lieux,
 * un diagnostic, etc...
 * Avec cette classe, on pourra stocker ses informations durant l'insertion en y
 * accédant à chaque valeur avec son nom (ex. "Bail" => Renvoie l'objet BailLocataire)
 */
public class Boite {
	private static Map<String, Object> chest;
	// Initialisation du coffre
	public static void initializeChest() {
		if (chest == null) {
			chest = new HashMap<>();
		}
	}

	// Vidage du coffre
	public static void clearChest() {
		if (chest != null && !(chest.isEmpty())) {
				chest.clear();
		}
	}
	
	public static boolean onChest(String name) {
		return chest.containsKey(name);
	}
	
	// Accès au coffre
	public static Map<String, Object> getChest() {
		if (chest != null) {
			return chest;
		}
		return Collections.emptyMap();
	}
	
	// Ajout d'élément au coffre
	public static void addItem(String nom, Object item) {
		if (chest != null) {
			chest.put(nom, item);
		}
	}
	
	// Obtention d'un élément du coffre
	public static Object getItem(String name) {
		if (chest != null && chest.containsKey(name)) {
				return chest.get(name);
		}
		return null;
	}
	
	// Supression d'un élément du coffre
	public static void deleteItem(String name) {
		if (chest != null && chest.containsKey(name)) {
				chest.remove(name);
		}
	}
}
