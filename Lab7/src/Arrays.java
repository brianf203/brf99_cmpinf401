import java.util.*;

import javax.swing.JOptionPane;

public class Arrays {

	public static void main(String[] args) {
		int size = Integer.parseInt(JOptionPane.showInputDialog("Enter number of items: "));
		double[] data = new double[size];
		for(int i = 0; i < size; i++) {
			data[i] = Math.random() * 10;
		}
		JOptionPane.showMessageDialog(null, "Max: " + max(data) + "\nMin: " + min(data) + "\nSum: " + sum(data) + "\nAve: " + ave(data));
	}
	
	public static double max(double[] data) {
		double max = Double.MIN_VALUE;
		for(int i = 0; i < data.length; i++) {
			max = Math.max(max, data[i]);
		}
		return max;
	}
	
	public static double min(double[] data) {
		double min = Double.MAX_VALUE;
		for(int i = 0; i < data.length; i++) {
			min = Math.min(min, data[i]);
		}
		return min;
	}

	public static double sum(double[] data) {
		double sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	public static double ave(double[] data) {
		double sum = sum(data);
		return sum / data.length;
	}

}