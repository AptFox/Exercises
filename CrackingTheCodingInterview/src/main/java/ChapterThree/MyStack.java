package main.java.ChapterThree;

import java.util.EmptyStackException;

public class MyStack<T> {
	private static class StackNode<T>{
		private T data;
		private StackNode<T> nextNode;
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> topNode;
	public T pop() {
		if (topNode == null) throw new EmptyStackException();
		T item = topNode.data;
		topNode = topNode.nextNode;
		return item;
	}
	
	public void push(T nodeData) {
		StackNode<T> node = new StackNode<T>(nodeData);
		node.nextNode = topNode;
		topNode = node;
	}
	
	public T peek() {
		if(topNode == null) throw new EmptyStackException();
		return topNode.data;
	}
	
	public boolean isEmpty() {
		return topNode == null;
	}
}
