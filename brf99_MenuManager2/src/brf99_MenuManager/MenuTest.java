package brf99_MenuManager;

/**
 * Class MenuTest
 * @author Brian Fang
 * created: 10/12/2022
 */

public class MenuTest {

	public static void main(String[] args) {
		
		Entree Steak = new Entree("Filet Mignon", "8 ounces of our finest and most tender cut of beef", 270);
        Entree Cod = new Entree("Grilled Cod", "6 ounces of grilled cod cooked to perfection", 160);
        Side Potatoes = new Side("Herb Roasted Potatoes", "Slow roasted potatoes topped with rosemary and parmesan cheese", 140);
        Side Broccoli = new Side("Roasted Broccoli", "Oven roasted golden-brown broccoli", 80);
        Salad Salad = new Salad("Ceaser Salad", "Romaine lettuce and croutons dressed with lemon juice", 100);
        Dessert Dessert = new Dessert("Ice Cream", "Rich and creamy vanilla ice cream", 150);
        Menu MenuOne = new Menu("Menu 1", Steak, Potatoes);
        Menu MenuTwo = new Menu("Menu 2", Cod, Broccoli, Salad, Dessert);
        System.out.println("Menu 1:\nTotal calories: " + MenuOne.totalCalories() + "\n" + MenuOne.description());
        System.out.println("\nMenu 2:\nTotal calories: " + MenuTwo.totalCalories() + "\n" + MenuTwo.description());

	}

}