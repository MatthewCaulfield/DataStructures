package proj3;

import proj3.ListNode;

/**
 *This is the Linked List class it acts like a list
 *but its data is stored in different nodes
 *@author Matthew Caulfield
 *@version 10/13/17
 *
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 */
public class LinkedList
{
    private int length;          // number of nodes
    private ListNode firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /** insert new String at linked list's head
     * 
     * @param newData the String to be inserted
     */
    public void insertAtHead(String newData)
    {
    	ListNode newnode = new ListNode(newData);
        if (isEmpty())
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
    
    /** remove and return data at the head of the list 
     * 
     *  @return the String the deleted node contains.  Returns null if list empty.
     */
    public String removeHead()
    {
    	if(this.isEmpty()) {
    		return null;
    	}
    	else {
    		String firstNodeString = firstNode.data;
        	firstNode = firstNode.next;
        	length --;
        	return firstNodeString;
    	}
    	 
    }
    
    /** insert data at end of list
     * 
     * @param newData new String to be inserted
     */
    public void insertAtTail(String newData)
    {
    	ListNode newNode = new ListNode(newData);
    	ListNode currentNode = firstNode;
    	if(this.isEmpty() == true) {
    		firstNode = newNode;
    	}
    	else {
    		for(int i = 0; i < this.getLength()-1; i++) {
        		currentNode = currentNode.next;
        	}
        	currentNode.next = newNode;	
    	}
    	length++; 
    }
    

    
    /**
     * Inserts a node into the LL at the index given the following nodes
     * get pushed back an index number. If the number of nodes is less than the index 
     * than the data is added at the tail
     * @param index number of where the new string should be added
     */
    public void insertAtIndex(String newData, int index) {
    	ListNode newNode = new ListNode(newData);
    	ListNode currentNode = firstNode; 
    	if(index == 0) {
    		this.insertAtHead(newData);
    	}
    	else if(this.getLength() > index) {
    		for(int i = 0; i < index - 1; i++) {
    			currentNode = currentNode.next;
    		}
    		newNode.next = currentNode.next;
    		currentNode.next = newNode;
    		length++;
    	}
    	else {
    		this.insertAtTail(newData);
    	}
    }
    
    /**
     * returns the data at a given index
     * if the index does not exist it returns null
     * @param the index that holds the returned data
     * @return data at the given index
     */
    public String returnByIndex(int index) {
    	if(index < 0) {
    		return null;
    	}
    	else if(index < this.getLength()) {
    		ListNode currentNode = firstNode;
    			for(int i = 0; i < index; i++) {
    				currentNode = currentNode.next;
    			}
    			return currentNode.data;
    	}
    	else {
    		return null;
    	}
    }
    
    /**
     * changes the data of the node at the given index
     * @param the new data for the node
     * @param the index at which the data is changed
     */
    public void changeAtIndex(String newData, int index) {
    	if(index >= 0 && index < this.getLength()) {
    		ListNode currentNode = firstNode;
    		for(int i = 0; i < index; i++) {
        		currentNode = currentNode.next;
        	}
        	currentNode.data = newData;
    	}
    }
   
    /**
     * search for first occurrence of value and return index where found
     * 
     * @param value string to search for
     * @return index where string occurs (first node is index 0).  Return -1 if value not found.
     */
    public int indexOf(String value)
    {
    	boolean found = false;
    	int i = 0;
    	ListNode currentNode = firstNode;
    	while(found == false && i < this.getLength()) {
    		if(currentNode.data.equals(value)) {
    			found = true;
    			return i;
    		}
    		i++;
    		currentNode = currentNode.next;
    	}
    	return -1;
    }
    
    
    /**
     *  @return return linked list as printable string
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode runner=firstNode;
    	while (runner!=null)
    	{
    		toReturn = toReturn + runner;  //call node's toString automatically
    		runner=runner.next;
    		if (runner!=null)
    		{
    			toReturn = toReturn + ",";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /**
     * @return returns a copy of the Linked List
     */
    public LinkedList clone(){
    	LinkedList aClone = new LinkedList();
    	for(int i = 0; i < this.getLength(); i++) {
    		aClone.insertAtTail(this.returnByIndex(i));
    	}
    	return aClone;
    }
    
    /**
     * 
     * @return length of LL
     */
    public int getLength() {return length;}
    
    /**
     * 
     * @return true if LL empty or false if not
     */
    public boolean isEmpty() {return getLength()==0;}
}


