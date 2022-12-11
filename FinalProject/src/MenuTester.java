

/**
 * Class MenuTester
 * @author Brian Fang
 * @created: 11/04/2022
 */

public class MenuTester{
	
	public static void main(String[] args){
		MenuManager randomize = new MenuManager("data/dishes.txt");
		Menu myMenu = randomize.randomMenu();
		System.out.println(myMenu.description() + "\nTotal calories: " + myMenu.totalCalories());
	}
	
}