/*
 * prompt: implement a MyQueue class which implements a queue using stacks
 */

package main.java.ChapterThree.Q4;

import java.util.NoSuchElementException;
import java.util.Stack;


/*
 * Queues use FIFO
 * Stacks use LIFO
 */
public class QueueViaStacks<T> {
	
	private Stack<T> newest;
	private Stack<T> oldest;
	
	public QueueViaStacks() {
		newest = new Stack<T>();
		oldest = new Stack<T>();
	}
	
	public void add(T item) {
		newest.add(item);
	}
	
	private void transferStacks() {
		if(oldest.isEmpty()) {
			while(!newest.isEmpty()){
				oldest.push(newest.pop());
			}
		}
	}
	
	public T remove() { 
		transferStacks();
		return oldest.pop();
	}
	
	public T peek() {
		transferStacks();
		return oldest.peek();
	}
}
