import java.util.Random;

import javax.swing.JOptionPane;

public class Dice {

	public static void main(String[] args) {

		Random rand = new Random();

		while (true) {
			int[] frequency = new int[11];
			int rolls = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rolls: "));
			RollDice(rolls, rand, frequency);
			JOptionPane.showMessageDialog(null, "2: " + frequency[0]/((float) rolls) + "\n3: " + frequency[1]/((float) rolls) + "\n4: " + frequency[2]/((float) rolls) + "\n5: " + frequency[3]/((float) rolls) + "\n6: " + frequency[4]/((float) rolls) + "\n7: " + frequency[5]/((float) rolls) + "\n8: " + frequency[6]/((float) rolls) + "\n9: " + frequency[7]/((float) rolls) + "\n10: " + frequency[8]/((float) rolls) + "\n11: " + frequency[9]/((float) rolls) + "\n12: " + frequency[10]/((float) rolls));
			String stop = JOptionPane.showInputDialog("Do you want to continue? (yes/no): ");
			if (stop.equals("no")) {
				break;
			}
		}
		
	}

	public static void RollDice(int rolls, Random rand, int[] frequency) {
		for (int i = 0; i < rolls; i++) {
			int roll = rand.nextInt(6) + rand.nextInt(6);
			frequency[roll]++;
		}
	}

}