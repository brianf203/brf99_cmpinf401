import javax.swing.JOptionPane;
import java.util.*;

public class UnitConverter {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Input a distance or a weight: ");
		double value = Double.parseDouble(input.split(" ")[0]);
		String unit = input.split(" ")[1];
		if (unit.equalsIgnoreCase("cm")) {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 0.393701) + " in"));
		}
		else if (unit.equalsIgnoreCase("in")) {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 2.54) + " cm"));	
		}
		else if (unit.equalsIgnoreCase("yd")) {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 0.9144) + " m"));
		}
		else if (unit.equalsIgnoreCase("m")) {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 1.09361) + " yd"));
		}
		else if (unit.equalsIgnoreCase("oz")) {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 28.3495) + " gm"));
		}
		else if (unit.equalsIgnoreCase("gm")) {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 0.035274) + " oz"));
		}
		else if (unit.equalsIgnoreCase("lb")) {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 0.453592) + " kg"));
		}
		else {
			JOptionPane.showMessageDialog(null, (value + "") + "cm = " + ((value * 2.20462) + " lb"));
		}
	}

}
