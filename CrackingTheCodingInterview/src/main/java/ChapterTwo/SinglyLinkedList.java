package main.java.ChapterTwo;

public class SinglyLinkedList {
	Node headNode;
	public SinglyLinkedList() {
		headNode = null;
	}
	
	public SinglyLinkedList(Node headNode) {
		this.headNode = headNode;
	}
	
	public void deleteNode(Node node) {
		Node nodeToDelete = headNode;
		Node previousNode = null;
		//iterate through nodes until you find one that matches
		// the supplied node
		while(nodeToDelete.data != node.data) {
			//keep track of the node that came before
			previousNode = nodeToDelete;
			//Move to the next node
			nodeToDelete = nodeToDelete.next;
		}
		//Once found, set the previous nodes 'next' reference
		//to the Node that comes after the node we plan to delete
		//The node is effectively delete by being dropped from the LinkedList. 
		previousNode.next = nodeToDelete.next;
	}
	
}
