/*
 * Prompt: How would you design a stack which, in addition to push and pop, has a function 'min' 
 * which returns the minimum element?
 * 
 * Push, pop and min should all operate in O(1) time. 
 */

package main.java.ChapterThree.Q2;

public class StackMin {
	
	private static class StackNode<Integer>{
		private Integer data;
		private StackNode<Integer> nextNode;
		private Integer min; 
		public StackNode(Integer data) {
			this.data = data;
		}
	}
	
	private StackNode<Integer> topNode;
	public Integer pop() {
		//TODO find an elegant way of finding smallest node on removal. 
		//if smallestNode == topNode
			// find new smallestNode
		//else
			// do nothing
		Integer item = topNode.data;
		topNode = topNode.nextNode;
		return item;
	}
	
	public void push(Integer nodeData) {
		StackNode<Integer> node = new StackNode<Integer>(nodeData);
		if(nodeData < topNode.min || topNode.min == null) {
			topNode.min = nodeData;
		}
		node.nextNode = topNode;
		node.min = topNode.min;
		topNode = node;
	}
	
	
	public Integer min() {
		return topNode.min;
	}
}
