import javax.swing.JOptionPane;

public class DecomposingMoney {

	public static void main(String[] args) {
		
		int money = Integer.parseInt(JOptionPane.showInputDialog("Enter amount of money: "));
		String grands = (money / 1000) + "";
		String benjamins = ((money % 1000) / 100) + "";
		String sawbucks = ((money % 100) / 10) + "";
		String bucks = (money % 10) + "";
		JOptionPane.showMessageDialog(null, grands + " grands" + "\n" + benjamins + " Benjamins" + "\n" + sawbucks + " sawbucks" + "\n" + bucks + " bucks");

	}

}
