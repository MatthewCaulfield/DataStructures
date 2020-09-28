package proj5;
/**
 * Queue class of integers only
 * operates on the first in first out principle
 * @author Matt
 *@version 11/12/2017
 */
public class Queue {
	//index of the first element in the queue
	//only remove will change this
	private int front;
	//index of the last element in the queue +1
	//only insert will change this
	private int rear;
	//the number of elements in the queue
	//only insert and remove will change it
	private int count;
	//how many ints the queue could potentially hold
	//the queue needs to bee made bigger when the 
	//count is the capacity
	//only ensure capacity can change it
	private int capacity;
	//If the capacity is full the amount to increase the capacity
	//setCapacityIncrement can change it
	private int capacityIncrement;
	//array holding all integers in the queue
	private int[] itemArray;
	
	public Queue(int cap) {
		front = 0;
		rear = 0; 
		count = 0;
		capacity = cap;
		capacityIncrement = 5;
		itemArray = new int[capacity];
	}
	
	/**
	 * @return the number of elements in the queue
	 */
	public int size() {
		return count;
	}
	
	/**
	 * 
	 * @return whether the queue is empty
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	/**
	 * inserts an integer into the back of the queue
	 * @param element to be inserted
	 */
	public void insert(int element) {
		ensureCapacity();
		itemArray[rear] = element;
		count++;
		rear = (rear+1)%capacity;
	}
	
	/**
	 * changes the capacity increment
	 * @param num the new capacity increment
	 */
	public void setCapacityIncrement(int num) {
		capacityIncrement = num;
	}
	
	/**
	 * removes and returns the first item in
	 * the queue
	 * @return the first item in the queue
	 */
	public int remove() {
		if(!isEmpty()) {
			int toRemove = itemArray[front];
			front = (front+1)%capacity;
			count--;
			return toRemove;
		}
		else {
			return -1;
		}
		
	}
	
	/**checks if the queue contains an integer
	 * @return true if it does contain false otherwise
	 */
	public boolean contains(int target) {
		if(front<rear) {
			for(int i = front; i <= rear; i++) {
				if(itemArray[i]==target) {
					return true;
				}
			}
		}
		else {
			for(int i = 0; i<= rear; i++) {
				if(itemArray[i]==target) {
					return true;
				}
			}
			for(int i = front; i<count; i++) {
				if(itemArray[i]==target) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * ensures that the queue size will not be larger than
	 * the capacity if it will be makes the capacity larger by the
	 * capacity increment
	 * 
	 */
	private void ensureCapacity() {
		if(count+1 == capacity) {
			int[] cloneArray = itemArray.clone();
			capacity += capacityIncrement;
			itemArray = new int[capacity];
			for(int i = 0; i<count; i++) {
				itemArray[i] = cloneArray[i];
			}
		}
	}
	
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return the queue as a string in form {1, 2, 3, ..., etc}
	 */
	public String toString() {
		if(isEmpty()) {
			return "";
		}
		else {
			String toReturn = "{"+ itemArray[front];
			if(front<rear) {
				for(int i = front+1; i < rear; i++) {
					toReturn += ", " + itemArray[i];
				}
			}
			else {
				for(int i = front+1; i<count; i++) {
					toReturn += ", " + itemArray[i];
				}
				for(int i = 0; i< rear; i++) {
					toReturn += ", " + itemArray[i];
				}
				
			}
			toReturn += "}";
			return toReturn;
		}
	}
		
}
