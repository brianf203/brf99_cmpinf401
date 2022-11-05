package brf99_MenuManager;

/**
 * Class FileManager
 * @author Brian Fang
 * @created: 11/04/2022
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	public static ArrayList<Entree> readEntrees(String fileName) {
		/**
		 * Method readEntrees
		 * @param fileName
		 * @return ArrayList
		 */
		ArrayList<Entree> entree = new ArrayList<Entree>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				String[] temp = line.split("@@");
				entree.add(new Entree(temp[0],temp[1],Integer.parseInt(temp[2])));
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
		return entree;
	}

	public static ArrayList<Side> readSides(String fileName){
		/**
		 * Method readSides
		 * @param fileName
		 * @return ArrayList
		 */
		ArrayList<Side> side = new ArrayList<Side>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				String[] temp = line.split("@@");
				side.add(new Side(temp[0],temp[1],Integer.parseInt(temp[2])));
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
		return side;
	}

	public static ArrayList<Salad> readSalads(String fileName){
		/**
		 * Method readSalads
		 * @param fileName
		 * @return ArrayList
		 */
		ArrayList<Salad> salad = new ArrayList<Salad>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				String[] temp = line.split("@@");
				salad.add(new Salad(temp[0],temp[1],Integer.parseInt(temp[2])));
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
		return salad;
	}

	public static ArrayList<Dessert> readDesserts(String fileName){
		/**
		 * Method readDesserts
		 * @param fileName
		 * @return ArrayList
		 */
		ArrayList<Dessert> dessert = new ArrayList<Dessert>();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				String[] temp = line.split("@@");
				dessert.add(new Dessert(temp[0],temp[1],Integer.parseInt(temp[2])));
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
		return dessert;
	}

}