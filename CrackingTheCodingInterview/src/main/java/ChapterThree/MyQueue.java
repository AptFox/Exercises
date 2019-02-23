package main.java.ChapterThree;

import java.util.NoSuchElementException;

public class MyQueue<T> {
	private static class QueueNode<T>{
		private T data;
		private QueueNode<T> nextNode;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> firstNode;
	private QueueNode<T> lastNode;
	
	public void add(T item) {
		QueueNode<T> newNode = new QueueNode<T>(item);
		if(lastNode != null) {
			lastNode.nextNode = newNode;
		}
		lastNode = newNode;
		if(firstNode == null) {
			firstNode = lastNode;
		}
	}
	
	public T remove() { 
		if(firstNode == null) throw new NoSuchElementException();
		T data = firstNode.data;
		firstNode = firstNode.nextNode;
		if (firstNode == null) {
			lastNode = null;
		}
		return data;
	}
	
	public T peek() {
		if(firstNode == null) throw new NoSuchElementException();
		return firstNode.data;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
}
