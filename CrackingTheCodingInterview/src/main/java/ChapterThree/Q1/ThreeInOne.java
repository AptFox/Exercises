/*
 * Prompt: Describe how you could use a single array to implement three stacks 
 * 
 * in order for this to work, each call to ThreeInOne must include the target
 * stack. 
 */
package main.java.ChapterThree.Q1;

public class ThreeInOne {
	private int numberOfStacks = 3;
	private int stackCapacity;
	//values[] will be our 'single array'
	// values[] will contain the elements added to our 'single array'
	//values[] will contain all elements added to each of our stacks
	private  int[] values;
	
	//sizes[] will be an array of size 3, each position representing a stack
	// the value at each position in sizes[] will be the size of the stack it represents. 
	private int[] sizes;
	
	public ThreeInOne(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}
	
	public void push(int stackNum, int value) throws Exception {
		if(isFull(stackNum)) {
			System.out.println("Cannot push to this stack, this stack is full.");
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			System.out.println("Cannot pop from this stack, this stack is empty.");
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
		
	}
	
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) { 
			System.out.println("Cannot peek this stack, this stack is empty.");
		}
		return values[indexOfTop(stackNum)];
	}
	
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size-1;
	}

	private boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	private boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
}
