import javax.swing.JOptionPane;

public class Logarithm {

	public static void main(String[] args) {
		
		int value = 0;
		int base = 0;
		
		while (value < 1 || base < 2) {
			value = Integer.parseInt(JOptionPane.showInputDialog("Enter the value for which you want to calculate the log: "));
			base = Integer.parseInt(JOptionPane.showInputDialog("Enter the base value: "));
		}
		
		if(value == 1) {
			JOptionPane.showMessageDialog(null, 0);
		}
		
		else {
			int count = 1;
			
			while (value / base >= base) {
				value = (int) Math.floor(value / base);
				count++;
			}
			
			JOptionPane.showMessageDialog(null, count);
		}
		
	}

}