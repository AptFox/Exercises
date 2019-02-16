package main.java.ChapterTwo;


/*
 * This class exists as a starting point for creating a LinkedList Data structure. 
 */
public class Node {
	
	Node next = null;
	int data;
	
	//LinkedList constructor
	public Node(int data) {
		this.data = data;
	}
	
	//Adding values to the LinkedList
	void appendToTail(int data) {
		Node end = new Node(data);
		Node node = this;
		//This while finds the end of the list and sets 'node' to it
		while(node.next != null) {
			node = node.next;
		}
		//Now that we've found the end of the list,
		//the next node (the last node overall), is set
		//to the node.next
		//So that on future calls, 'node' will become 'end'
		node.next = end;
	}

}
