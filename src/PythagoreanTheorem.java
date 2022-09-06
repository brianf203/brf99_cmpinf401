import javax.swing.JOptionPane;

public class PythagoreanTheorem {

	public static void main(String[] args) {
		
		String a = JOptionPane.showInputDialog("Input first number: ");
		String b = JOptionPane.showInputDialog("Input second number: ");
		double c = Math.round(100 * Math.sqrt(Math.pow(Double.parseDouble(a), 2) + Math.pow(Double.parseDouble(b), 2))) / 100.0;
		JOptionPane.showMessageDialog(null, "The hypotenuse is " + (c + "") + ".");
	
	}
	
}
