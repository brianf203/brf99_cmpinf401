import java.io.*;

public class RecordList {
	
	/**
	 * The node class represents a single list element with a data item and
	 * reference to the next node in the list
	 */
	private class Node {
		Record data;
		Node next;
		/**
		 * Creates a node with the given data
		 * @param dataValue data to hold in this node
		 */
		public Node(Record dataValue) {
			next = null;
			data = dataValue;
		}
	}
	
	private Node head;
	
	/**
	 * Initializes a linked list with a single "dummy" node (contains no real data)
	 * to simplify code for the case of an empty list
	 */
	public RecordList() {
		head = new Node(null);
	}
	
	/**
	 * Finds the index of the record with the given name in the list
	 * @param name name to search for
	 * @return index of name in list if found, -1 otherwise
	 */
	public int indexOf(String name) {
		Node currentNode = head;
		int index = 0;
		while (currentNode.next != null && !currentNode.next.data.getName().equals(name)) {
			currentNode = currentNode.next;
			index++;
		}
		if (currentNode.next == null) return -1;
		else return index;
	}
	
	/**
	 * Adds the given item to the list, sorted by time (lowest to highest)
	 * @param data data to add
	 * @return the index the data was inserted at
	 */
	public int add(Record data) {
        int index = 0;
        if(head == null) {
        	head = new Node(data);
        	return index;
        }
        Node currentNode = head;
        while (currentNode.next != null && currentNode.next.data.getTime() < data.getTime()) {
            currentNode = currentNode.next;
            index++;
        }
        Node temp = currentNode.next;
        currentNode.next = new Node(data);
        currentNode.next.next = temp;
        return index;
	}
	
	/**
	 * Prints out each record in the list, one per line
	 */
	public void print() {
		Node currentNode = head.next;
		while (currentNode != null) {
			System.out.println(currentNode.data.getName() + ", " + currentNode.data.getTime());
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	/**
	 * @param filename name of the file to write the list to
	 */
	public void writeToFile(String filename) {
		Node currentNode = head.next;
		try {
            FileWriter fr = new FileWriter(filename);
            while (currentNode != null) {
                fr.append(currentNode.data.getName() + ", " + (currentNode.data.getTime() + "") + "\n");
                currentNode = currentNode.next;
            }
            fr.close();
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
	}
}