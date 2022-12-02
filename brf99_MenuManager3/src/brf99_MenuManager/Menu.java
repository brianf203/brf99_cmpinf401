package brf99_MenuManager;

/**
 * Class Menu
 * @author Brian Fang
 * created: 10/12/2022
 */

public class Menu {

	private String name;
	private Entree entree;
	private Salad salad;
	private Side side;
	private Dessert dessert;
	
	public Menu(String name) {
		this.name = name;
		this.entree = null;
		this.salad = null;
		this.side = null;
		this.dessert = null;
	}
	
	public Menu(String name, Entree entree, Side side) {
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.salad = null;
		this.dessert = null;
	}
	
	public Menu(String name, Entree entree, Side side, Salad salad, Dessert dessert) {
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.salad = salad;
		this.dessert = dessert;
	}
	
	public int totalCalories() {
		int total = 0;
		if(entree != null) {
			total += entree.getCalories();
		}	
		if(side != null) {
			total += side.getCalories();
		}	
		if(salad != null) {
			total += salad.getCalories();
		}	
		if(dessert != null) {
			total += dessert.getCalories();
		}	
		return total;
	}
	
	public int totalPrice() {
		int total = 0;
		if (entree != null) {
			total += entree.getPrice();
		}
		if (side != null) {
			total += side.getPrice();
		}
		if (salad != null) {
			total += salad.getPrice();
		}
		if (dessert != null) {
			total += dessert.getPrice();
		}
		return total;
	}
	
	public String description() {
		String output = "";
		if(entree != null) {
			output += "Entree: " + entree.getName() + ". " + entree.getDescription() + ".";
		}
		else {
			output += "Entree: N/A";
		}
		if(side != null) {
			output += "\nSide: " + side.getName() + ". " + side.getDescription() + ".";
		}
		else {
			output += "\nSide: N/A";
		}
		if(salad != null) {
			output += "\nSalad: " + salad.getName() + ". " + salad.getDescription() + ".";
		}
		else {
			output += "\nSalad: N/A";
		}
		if(dessert != null) {
			output += "\nDessert: " + dessert.getName() + ". " + dessert.getDescription() + ".";
		}
		else {
			output += "\nDessert: N/A";
		}
		return output;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	public Salad getSalad() {
		return salad;
	}

	public void setSalad(Salad salad) {
		this.salad = salad;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
	
}