package proj4;

/**
 * this class is an ADT that can hold objects and operates
 * on a last in first out basis 
 * the last object added is the next object to be able to leave 
 * 
 * @author Matthew Caulfield
 * @version 10/22/17
 */
public class Stack<T>
{
	//contents holds all objects in the LinkedList the
	//only way to add objects to contents is through push
	//and the only way to remove an object is through pop
	private LinkedList contents;
    
	/**
	 * default constructor for the stack method
	 * initializes the stack with an empty LinkedList
	 */
    public Stack() {
       contents = new LinkedList();
       
    }
   
    /**
     * returns whether or not the stack is empty
     * @return if the stack is empty
     */
    public boolean isEmpty() {  
    	return contents.isEmpty();  
    }

    /**
     * adds a value to the top of the stack
     * @param toPush the value to push on top of the stack
     */
    public void push(T toPush) {
    	contents.insertAtHead(toPush);
    }
  
    /**
     * removes and returns the value from the top of the stack
     * @return the removed first value in the stack
     */
    public T pop() {
    	return (T) contents.removeHead();  
    } 
  
    /**
     * returns the first value in the stack without removing it
     * @return the first value in the stack
     */
    public T peek() {
    	return (T) contents.returnByIndex(0);  
    } 
    
    /**
     * @return the size of the stack
     */
    public int size() {
    	return contents.getLength();   
    }
     
    /**
     * @return the stack as a string with a pointer to the top value
     * of the stack
     */
    public String toString() {
        String toReturn = "{>";  
        int stackSize = this.size();
        for(int i = 0; i < stackSize; i++) {
        	toReturn += contents.returnByIndex(i).toString();
        	if(i<stackSize-1) {
        		toReturn += ",";
        	}
        }
        toReturn+="}";
        return toReturn;
    }
    
} 
   

