package proj3;  // Gradescope needs this.
import proj3.LinkedList;
/**
 * This is the sequence class it stores strings 
 * @author Matthew Caulfield
 * @version 10/13/17
 *
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 */
public class Sequence
{
	// contents is a linked list that holds the strings in the sequence.
	//some of the nodes in the LL may be empty and empty nodes have null in the data section
	//The linked list is filled starting with the first node and there can be no gaps of nodes
	//nodes storing objects between nodes that are actively storing objects
	private LinkedList contents;
	//numItems is the number of objects actively being stored in the sequence
	private int numItems;
	//current index is the index of the current object in the sequence
	private int currentIndex;
	private final int DEFAULT_CAPACITY = 10;
	
	
    /**
     * Creates a new sequence with initial capacity 10.
     */
    public Sequence() {
    	contents = new LinkedList();
    	for(int i = 0; i<DEFAULT_CAPACITY; i++) {
    		contents.insertAtHead(null);
    	}
    }
    

    /**
     * Creates a new sequence.
     * 
     * @param initialCapacity the initial capacity of the sequence.
     */
    public Sequence(int initialCapacity){
    	contents = new LinkedList();
    	for(int i = 0; i<initialCapacity; i++) {
    		contents.insertAtHead(null);
    	}
    }
    

    /**
     * Adds a string to the sequence in the location before the
     * current element. If the sequence has no current element, the
     * string is added to the beginning of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addBefore(String value)
    {
    	Sequence copy = this.clone();
    	if (this.numItems + 1 > contents.getLength()) {
    		this.doubleCapacity();
    	}
    	if(this.currentIndex == this.numItems) {
    		this.currentIndex = 0;
    	}
    	for(int i = 0; i < currentIndex; i++){
    		this.contents.changeAtIndex(copy.contents.returnByIndex(i), i);
    	}
    	this.contents.changeAtIndex(value, this.currentIndex);
    	this.numItems++;
    	for(int i = this.currentIndex + 1; i < this.numItems; i++) {
    		this.contents.changeAtIndex(copy.contents.returnByIndex(i-1), i);
    	}
 
    }
    
    
    /**
     * Adds a string to the sequence in the location after the current
     * element. If the sequence has no current element, the string is
     * added to the end of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addAfter(String value)
    {
    	Sequence copy = this.clone();
    	if (this.numItems + 1 > contents.getLength()) {
    		this.doubleCapacity();
    	}
    	if(this.currentIndex == this.numItems) {
    		this.currentIndex = this.numItems - 1;
    	}
    	for(int i = 0; i <= currentIndex; i++){
    		this.contents.changeAtIndex(copy.contents.returnByIndex(i), i);
    	}
    	this.currentIndex++;
    	this.contents.changeAtIndex(value, this.currentIndex);
    	this.numItems++;
    	for(int i = this.currentIndex + 1; i < this.numItems; i++) {
    		this.contents.changeAtIndex(copy.contents.returnByIndex(i-1), i);
    	}
    }
    

    /**
     * doubles and adds one to the capacity of a sequence
     * 
     */
    private void doubleCapacity() {
    	int capacity = 2*this.contents.getLength()+1;
		contents  = new LinkedList();
		for(int i = 0; i < capacity; i++) {
			contents.insertAtHead(null);;
    	}
    }
    
    /**
     * @return true if and only if the sequence has a current element.
     */
    public boolean isCurrent()
    {
    	return(currentIndex < numItems);
    }
    
    
    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()
    {
    	return this.contents.getLength();
    }

    
    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {
    	if(currentIndex != numItems) {
    		return(this.contents.returnByIndex(currentIndex));
    	}
    	else {
    		return null;
    	}
    	
    	
    }
    
    
    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {
    	int capacity = this.getCapacity();
    	if(capacity < minCapacity) {
    		int spaceNeeded = minCapacity - capacity;
    		capacity = minCapacity;
        	for(int i = 0; i<spaceNeeded; i++) {
        		contents.insertAtTail(null);
        	}
        	
    	}
    }

    
    /**
     * Places the contents of another sequence at the end of this sequence.
     *
     * If adding all elements of the other sequence would exceed the
     * capacity of this sequence, the capacity is changed to make (just enough) room for
     * all of the elements to be added.
     * 
     * Postcondition: NO SIDE EFFECTS!  the other sequence should be left
     * unchanged.  The current element of both sequences should remain
     * where they are. (When this method ends, the current element
     * should refer to the same element that it did at the time this method
     * started.)
     *
     * @param another the sequence whose contents should be added.
     */
    public void addAll(Sequence another)
    {
    	int totalItems = this.numItems + another.numItems;
    	this.ensureCapacity(totalItems);
    	Sequence anotherCopy =  another.clone();
    	for(int i = this.numItems; i < totalItems; i++) {
    		this.contents.changeAtIndex(anotherCopy.contents.returnByIndex(i-this.numItems), i);
    	}
    	if (this.currentIndex == this.numItems) {
    		this.currentIndex = totalItems;
    	}
    	this.numItems = totalItems;
    	
    }

    
    /**
     * Move forward in the sequence so that the current element is now
     * the next element in the sequence.
     *
     * If the current element was already the end of the sequence,
     * then advancing causes there to be no current element.
     *
     * If there is no current element to begin with, do nothing.
     */
    public void advance()
    {
    	if(isCurrent()) {
    		currentIndex++;
    	}
    }

    
    /**
     * Make a copy of this sequence.  Subsequence changes to the copy
     * do not affect the current sequence, and vice versa.
     * 
     * Postcondition: NO SIDE EFFECTS!  This sequence's current
     * element should remain unchanged.  The clone's current
     * element will correspond to the same place as in the original.
     *
     * @return the copy of this sequence.
     */
    public Sequence clone()
    {
    	Sequence duplicate = new Sequence(this.getCapacity());
    	duplicate.numItems = this.numItems;
    	duplicate.currentIndex = this.currentIndex;
    	duplicate.contents = contents.clone();
    	return(duplicate);
    }
   
    
    /**
     * Remove the current element from this sequence.  The following
     * element, if there was one, becomes the current element.  If
     * there was no following element (current was at the end of the
     * sequence), the sequence now has no current element.
     *
     * If there is no current element, does nothing.
     */
    public void removeCurrent()
    {
    	Sequence copy = this.clone();
    	for(int i = 0; i<this.currentIndex; i++) {
    		this.contents.changeAtIndex(copy.contents.returnByIndex(i), i);
    	}
    	if(this.currentIndex < this.numItems) {
    		this.numItems = this.numItems-1;
    	}
    	for(int i = this.currentIndex; i<this.numItems;  i++) {
    		this.contents.changeAtIndex(copy.contents.returnByIndex(i+1), i);
    	}	
    		
    }

    
    /**
     * @return the number of elements stored in the sequence.
     */
    public int size()
    {
    	return numItems;
    }

    
    /**
     * Sets the current element to the start of the sequence.  If the
     * sequence is empty, the sequence has no current element.
     */
    public void start()
    {
    	currentIndex = 0;
    }

    
    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize()
    {
    	Sequence copy = this.clone();
    	this.contents = new LinkedList();
    	for(int i =0; i < this.numItems; i++){
    		this.contents.insertAtTail(copy.contents.returnByIndex(i));
    	}   	
    }
    
    
    /**
     * Produce a string representation of this sequence.  The current
     * location is indicated by a >.  For example, a sequence with "A"
     * followed by "B", where "B" is the current element, and the
     * capacity is 5, would print as:
     * 
     *    {A, >B} (capacity = 5)
     * 
     * The string you create should be formatted like the above example,
     * with a comma following each element, no comma following the
     * last element, and all on a single line.  An empty sequence
     * should give back "{}" followed by its capacity.
     * 
     * @return a string representation of this sequence.
     */
    public String toString() 
    {
    	String output = "{";
    	for(int i = 0; i<numItems; i++) {
    		if(i>0) {
    			output += ", "; 	
    		}
    		if(i == currentIndex) {
    			output += ">";
    		}
    		output += this.contents.returnByIndex(i);
    	}
    	output += "} (capacity = " + this.contents.getLength() +")"; 
    	return output;
    }
    
    /**
     * Checks whether another sequence is equal to this one.  To be
     * considered equal, the other sequence must have the same size
     * as this sequence, have the same elements, in the same
     * order, and with the same element marked
     * current.  The capacity can differ.
     * 
     * Postcondition: NO SIDE EFFECTS!  this sequence and the
     * other sequence should remain unchanged, including the
     * current element.
     * 
     * @param other the other Sequence with which to compare
     * @return true iff the other sequence is equal to this one.
     */
    public boolean equals(Sequence other) 
    {
    	if(this.numItems != other.numItems) {
    		return false;
    	}
    	else if(this.currentIndex != other.currentIndex) {
    		return false;
    	}
    	else {
    		for(int i = 0; i < this.numItems; i++) {
    			if (this.contents.returnByIndex(i)!=other.contents.returnByIndex(i)){
    				return false;
    			}
    		}
    		return true;
    	}
    	
    }
    
    
    /**
     * 
     * @return true if Sequence empty, else false
     */
    public boolean isEmpty()
    {
    	return(size() == 0);
    }
    
    
    /**
     *  empty the sequence.  There should be no current element.
     */
    public void clear()
    {
    	numItems = 0;
    	currentIndex = 0;
    }

}
