import javax.swing.JOptionPane;

public class AreaPerimeter {

	public static void main(String[] args) {
	
		double r = Double.parseDouble(JOptionPane.showInputDialog("Input the radius: "));
		double perimeter = Math.round(100 * 2 * Math.PI * r) / 100.0;
		double area = Math.round(100 * Math.PI * r * r) / 100.0;
		JOptionPane.showMessageDialog(null, "The circle with radius " + (r + "") + " has an area of " + (area + "") + " and a perimeter of " + (perimeter + ""));
		
	}

}