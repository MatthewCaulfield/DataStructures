package proj5;
/** This is the BST ADT.  It should contain methods that allow it to
 *  insert new nodes, delete nodes, search, etc. 
 * 
 * @author Matthew Caulfield 
 * @version 11/12/2017
 */
public class BinarySearchTree<T>
{
	//root is a node that is the root of a tree
	//insert and set key can both chang it
     private BSTNode<T> root;
          
     public BinarySearchTree() {
    	 root=null; 
     }
     
     /**
      * inserts recursively.  I include this one so you can
      * make your own trees in your own testing class
      * 
      * @param startingNode inserts into subtree rooted at staringNode
      * @param newNode node to insert
      * @return startingNode with newNode already inserted
      */
     private BSTNode<T> recursiveInsert(BSTNode<T> startingNode, BSTNode<T> newNode) {
    	 if (startingNode == null) {
    		 return newNode;
    	 }
    	 else if (((Comparable) startingNode.key).compareTo(newNode.key) < 0) {
    		 startingNode.rlink = recursiveInsert(startingNode.rlink,newNode);
    		 return startingNode;
    	 }
    	 else {  // startingNode.key bigger than newNode.key, so newNode goes on left
    		 startingNode.llink = recursiveInsert(startingNode.llink,newNode);
    		 return startingNode;
    	 }
     }

     /**
      * @return returns whether or not the function is empty
      */
     public boolean isEmpty() {
    	 return(root == null);
     }
     

     /**
      * inserts recursively. Use this in your JUnit tests to
      * build a starting tree correctly
      * 
      * @param newString String to insert
      */
     public void recursiveInsert(T newComparable){
    	 BSTNode<T> newNode = new BSTNode<T>(newComparable);
    	 root = recursiveInsert(root, newNode);
     }
     
     /**
      * Inserts a string at its correct node
      * traverses the tree iteratively 
      * @param newString the string to be inserted
      */
     public void insert(T newComparable) {
    	 BSTNode<T> newNode = new BSTNode<T>(newComparable);
    	 BSTNode<T> currentNode = root;
    	 boolean isInserted = false;
    	 if(currentNode == null) {
    		 root = newNode;
    	 }
    	 else {
    		 while(!isInserted) {
        		 if(((Comparable) newNode.key).compareTo(currentNode.key)>0) {	
    			 	if(currentNode.rlink == null) {
        			 	currentNode.rlink = newNode;
        			 	isInserted = true;
        		 	}
        		 	else {
        			 	currentNode = currentNode.rlink;
        		 	}
        		 }
        		 else {
        			 if(currentNode.llink == null) {
            			 currentNode.llink = newNode;
            			 isInserted = true;
            		 }
            		 else {
            			 currentNode = currentNode.llink;
            		 }
        		 }
        	 } 
    	 }
     }
    	
   /**
   * deletes an element from the binary search tree in order
   * @param victim is the target to be deleted
   */
     public void delete(T victim) {
    	 root = recursiveDelete(root, victim);
     }
     
     /**
      * deletes a victim from a subtree
      * and returns the new subtree
      * @param subroot
      * @param victim
      * @return new subtree
      */
     private BSTNode recursiveDelete(BSTNode subroot, T victim) {
    	 if(subroot == null) {
    		 return null;
    	 }
    	 else if(((Comparable) subroot.key).compareTo(victim)>0) {
    		 subroot.llink = recursiveDelete(subroot.llink, victim);
    	 }
    	 else if(((Comparable) subroot.key).compareTo(victim)<0) {
    		 subroot.rlink = recursiveDelete(subroot.rlink, victim);
    	 }
    	 else {
    		 if(subroot.isLeaf()) {
    			 return null;
    		 }
    		 else if(subroot.rlink != null && subroot.llink == null) {
    			 return subroot.rlink;
    		 }
    		 else if(subroot.rlink == null && subroot.llink != null) {
    			 return subroot.llink;
    		 }
    		 else {
    			 BSTNode substitute = subroot.llink.getRightMostDescendant();
    			 T substituteKey = (T) substitute.getKey();
    			 subroot = recursiveDelete(subroot, (T) substituteKey);
    			 subroot.setKey(substituteKey);
    			 return subroot;
    		 }
    	 }
    	 return subroot;
 	}
     
     /**
      * Returns the key of an node from 
      * the search tree when given an element that
      * is equivalent in compare to of the node
      * @param element that needs to find key
      * @return the key of the equivalent element    
      */       
     public T getData(T element) {
    	 return (T) recursiveGetData(root, element).key;
     }
     
     /**
      * Recursively searches through a tree for a node and returns the 
      * node if its key matches the target in compare to 
      * @param startingNode of tree to search through
      * @param target to search for
      * @return matching node or null if no match
      */
     private BSTNode recursiveGetData(BSTNode startingNode, T target) {
    	 if (startingNode == null) {
    		 return null;
    	 }
    	 else if(((Comparable) startingNode.key).compareTo(target)>0) {
    		 return recursiveGetData(startingNode.llink, target);
    	 }
    	 else if(((Comparable) startingNode.key).compareTo(target)<0) {
    		 return recursiveGetData(startingNode.rlink, target);
    	 }
    	 else {
    		 return startingNode;
    	 }
     }
     
     /** private helper method that searches the tree from a starting node
      * if the current node is null then the target is not in the tree if the
      * current node is the target return true. otherwise begin searching through a 
      * subtree the right subtree if the target is better than the current node 
      * the left tree if equal to or worse than the current node
      * 
      * @param the target string
      * @param the starting node of the tree to search 
      * @return whether or not the target was in the tree
      */
     private boolean recursiveSearch(T target, BSTNode<T> startingNode) {
    	 if (startingNode == null) {
    		 return false;
    	 }
    	 if (((Comparable) startingNode.key).compareTo(target)== 0) {
    		 return true;
    	 }
    	 else if(((Comparable) startingNode.key).compareTo(target)<0) {
    		 return recursiveSearch(target, startingNode.rlink);
    	 }
    	 else{
    		return recursiveSearch(target, startingNode.llink);
    	 }
     }
     
     /**
      * searches through a tree recursively returns true if the target
      * is in the tree
      * @param target
      * @return the boolean value of if the target is in the tree
      */
     public boolean search(T target) {
    	 return recursiveSearch(target, root);
    	 
     }
      
     
     /**Private helper function for the toString method
      * uses inorder traversal to make turn a binary search tree
      * to a string 
      * @param currentString part of the tree as a string that the method
      * appends to
      * @param the starting node for the to string
      * @return a portion of the tree as a string 
      */
     private String toString(String currentString, BSTNode<T> startingPoint) {
    	 if(startingPoint != null) {
             currentString += "(";
             currentString = toString(currentString, startingPoint.llink);
             currentString += startingPoint.key;
             currentString = toString(currentString, startingPoint.rlink);
             currentString += ")";
    	 }
    	 return currentString;
     }
     
     /**
      *  this is the public toString method it returns a sting
      *  of the complete Binary Search Tree in the form
      *  (( A ) B ( C )) 
      *  B is the parent of A (left kid) and C (right kid).
      * 
      * @return the Binary Search Tree in string form
      */
     public String toString() {
    	 return this.toString("", root);
     }
     
     /**
      * WARNING: CRAPPY METHOD!  I wish I had toString...
      * 
      * Recursive helper method of print.
      * Uses inorder tree traversal algorithm.
      * @param N subroot of tree to print
      */
     private void print(BSTNode<T> N) 
     {   
         if (N != null) {     // stop recursing when N is null       
           System.out.print("(");
           print(N.llink);
           System.out.print("  " + N + "  ");
           print(N.rlink);
           System.out.print(")");
         }
     }
     
     
     /**
      *  WARNING: CRAPPY METHOD!  I wish I had toString...
      *  
      *  prints a parenthesized version of the tree that shows
      *  the subtree structure.  Example: (( A ) B ( C )) means
      *  B is the parent of A (left kid) and C (right kid).
      */
     public void print() 
     {
         print(root);
         System.out.println();
     }
}
