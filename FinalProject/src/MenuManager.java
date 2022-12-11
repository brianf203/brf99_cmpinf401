

/**
 * Class MenuManager
 * @author Brian Fang
 * @created: 11/04/2022
 */

import java.util.*;

public class MenuManager {
	private ArrayList<Entree> entrees = new ArrayList<Entree>();
	private ArrayList<Side> sides = new ArrayList<Side>();
	private ArrayList<Salad> salads = new ArrayList<Salad>();
	private ArrayList<Dessert> desserts = new ArrayList<Dessert>();

	public MenuManager(String dishesFile) {
		/**
		 * Method MenuManager
		 */
		ArrayList<MenuItem> menuItems = FileManager.readItems(dishesFile);
        for(MenuItem menuItem : menuItems) {
            if(menuItem instanceof Entree) {
                entrees.add((Entree) menuItem);
            }
            else if(menuItem instanceof Side) {
                sides.add((Side) menuItem);
            }
            if(menuItem instanceof Salad) {
                salads.add((Salad) menuItem);
            }
            if(menuItem instanceof Dessert) {
                desserts.add((Dessert) menuItem);
            }
        }
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

    public Menu minCaloriesMenu(String name){
    	/**
		 * Method minCaloriesMenu
		 * @return Menu
		 */
    	int calories = Integer.MAX_VALUE;
    	Entree entree = new Entree();
    	for(int i = 0; i < entrees.size(); i++) {
    		if(entrees.get(i).getCalories() < calories) {
    			entree = entrees.get(i);
    			calories = entrees.get(i).getCalories();
    		}
    	}
    	calories = Integer.MAX_VALUE;
    	Side side = new Side();
    	for(int i = 0; i < sides.size(); i++) {
    		if(sides.get(i).getCalories() < calories) {
    			side = sides.get(i);
    			calories = sides.get(i).getCalories();
    		}
    	}
    	calories = Integer.MAX_VALUE;
    	Salad salad = new Salad();
    	for(int i = 0; i < salads.size(); i++) {
    		if(salads.get(i).getCalories() < calories) {
    			salad = salads.get(i);
    			calories = salads.get(i).getCalories();
    		}
    	}
    	calories = Integer.MAX_VALUE;
    	Dessert dessert = new Dessert();
    	for(int i = 0; i < desserts.size(); i++) {
    		if(desserts.get(i).getCalories() < calories) {
    			dessert = desserts.get(i);
    			calories = desserts.get(i).getCalories();
    		}
    	}
        return new Menu(name, entree, side, salad, dessert);
    }
    
    public Menu maxCaloriesMenu(String name){
    	/**
		 * Method maxCaloriesMenu
		 * @return Menu
		 */
    	int calories = Integer.MIN_VALUE;
    	Entree entree = new Entree();
    	for(int i = 0; i < entrees.size(); i++) {
    		if(entrees.get(i).getCalories() > calories) {
    			entree = entrees.get(i);
    			calories = entrees.get(i).getCalories();
    		}
    	}
    	calories = Integer.MIN_VALUE;
    	Side side = new Side();
    	for(int i = 0; i < sides.size(); i++) {
    		if(sides.get(i).getCalories() > calories) {
    			side = sides.get(i);
    			calories = sides.get(i).getCalories();
    		}
    	}
    	calories = Integer.MIN_VALUE;
    	Salad salad = new Salad();
    	for(int i = 0; i < salads.size(); i++) {
    		if(salads.get(i).getCalories() > calories) {
    			salad = salads.get(i);
    			calories = salads.get(i).getCalories();
    		}
    	}
    	calories = Integer.MIN_VALUE;
    	Dessert dessert = new Dessert();
    	for(int i = 0; i < desserts.size(); i++) {
    		if(desserts.get(i).getCalories() > calories) {
    			dessert = desserts.get(i);
    			calories = desserts.get(i).getCalories();
    		}
    	}
        return new Menu(name, entree, side, salad, dessert);
    }
    

	public ArrayList<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}

	public ArrayList<Side> getSides() {
		return sides;
	}

	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}

	public ArrayList<Salad> getSalads() {
		return salads;
	}

	public void setSalads(ArrayList<Salad> salads) {
		this.salads = salads;
	}

	public ArrayList<Dessert> getDesserts() {
		return desserts;
	}

	public void setDesserts(ArrayList<Dessert> desserts) {
		this.desserts = desserts;
	}

}