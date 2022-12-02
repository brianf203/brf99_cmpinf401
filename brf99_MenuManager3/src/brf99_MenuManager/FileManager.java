package brf99_MenuManager;

/**
 * Class FileManager
 * @author Brian Fang
 * @created: 11/04/2022
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	public static ArrayList<MenuItem> readItems(String fileName) {
		/**
		 * Method readEntrees
		 * @param fileName
		 * @return ArrayList
		 */
		ArrayList<MenuItem> menuItems = new ArrayList<>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				String[] temp = line.split("@@");
				MenuItem menuItem;
				if(temp[1].equals("entree")){
					 menuItem = new Entree(temp[0],temp[2],Integer.parseInt(temp[3]),Double.parseDouble(temp[4]));
				}
				else if(temp[1].equals("side")){
					 menuItem = new Side(temp[0],temp[2],Integer.parseInt(temp[3]),Double.parseDouble(temp[4]));
				}
				else if(temp[1].equals("salad")){
					 menuItem = new Salad(temp[0],temp[2],Integer.parseInt(temp[3]),Double.parseDouble(temp[4]));
				}
				else{
					 menuItem = new Dessert(temp[0],temp[2],Integer.parseInt(temp[3]),Double.parseDouble(temp[4]));
				}
				menuItems.add(menuItem);
			}
			br.close();
			fr.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return menuItems;
	}
	
	public static void writeMenu(String fileName, ArrayList<Menu> menus) throws IOException{
		FileWriter fw = new FileWriter(fileName);
		for(Menu menu : menus){
			fw.append(menu.toString() + "\n" + menu.description() + "\n" + menu.totalCalories() + "\n" + menu.totalPrice() + "\n");
		}
		fw.close();
	}

}