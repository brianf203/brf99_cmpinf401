package brf99_MenuManager;

/**
 * Class MenuRandomize
 * @author Brian Fang
 * @created: 11/04/2022
 */

import java.util.*;

public class MenuRandomize {
	private ArrayList<Entree> entrees = new ArrayList<Entree>();
	private ArrayList<Side> sides = new ArrayList<Side>();
	private ArrayList<Salad> salads = new ArrayList<Salad>();
	private ArrayList<Dessert> desserts = new ArrayList<Dessert>();

	public MenuRandomize(String entreeFile, String sideFile, String saladFile, String dessertFile) {
		/**
		 * Method MenuRandomize
		 * @param entreeFile
		 * @param sideFile
		 * @param saladFile
		 * @param dessertFile
		 */
		entrees = FileManager.readEntrees(entreeFile);
		sides = FileManager.readSides(sideFile);
		salads = FileManager.readSalads(saladFile);
		desserts = FileManager.readDesserts(dessertFile);
	}

	public Menu randomMenu() {
		/**
		 * Method randomMenu
		 * @return Menu
		 */
		Entree entree = entrees.get((int)(Math.random() * entrees.size()));
		Side side = sides.get((int)(Math.random() * sides.size()));
		Salad salad = salads.get((int)(Math.random() * salads.size()));
		Dessert dessert = desserts.get((int)(Math.random() * desserts.size()));
		return new Menu("Random Menu", entree, side, salad, dessert);
	}

}