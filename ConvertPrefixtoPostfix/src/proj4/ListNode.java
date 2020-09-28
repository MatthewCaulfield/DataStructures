package proj4;

/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to an object. 
 *
 * This is the only class where I'll let you use public instance variables.
 * 
 */
public class ListNode<T>
{
	//data is stored here and can not be changed
    public T data;
    //points to the next list node
    public ListNode next;

    /**
     * default constructor takes an object that is 
     * the data to be stored in the node
     * @param the data to be stored
     */
    public ListNode(T new_data)
    {
        data = new_data;
        next = null;
    }
    
    /**
     * returns the data as a string
     */
    public String toString(){
    	return data.toString();
    }

}
