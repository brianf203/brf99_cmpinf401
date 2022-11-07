public class Lab8 {

	public static void main(String[] args) {
		
		String input = "";
		RecordList list = new RecordList();
		
		do {
			input = javax.swing.JOptionPane.showInputDialog("Please enter new record (name, time).\nHit cancel to quit.");
			if (input != null) {
				double time;
				String name;
				try {
					String [] parts = input.split(",");
					name = parts[0].trim();
					String timeStr = parts[1].trim();
					time = Double.parseDouble(timeStr);
				} 
				catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					javax.swing.JOptionPane.showMessageDialog(null, "Invalid input, please try again!");
					continue; 
				}
				Record r = new Record(name, time);
				int result = list.add(r);
				if (result == 0) {
					javax.swing.JOptionPane.showMessageDialog(null, "Congratulations! " + name + " has the fastest time so far");
				}
			}
		} 
		while (input != null);

		list.writeToFile("data/recordList.txt");
		
	}
}