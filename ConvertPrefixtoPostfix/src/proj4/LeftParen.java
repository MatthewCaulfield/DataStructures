package proj4;

/**
 * The left paren class is a token for the left parenthesis
 * it contains information on how to process the left parenthesis
 * when called by the converter
 * @author Matthew Caulfield 
 * @version 10/22/17
 */
public class LeftParen implements Token{

	/**
	 * returns the left parenthesis as a string
	 * @return returns a string of left Parenthesis
	 */
	public String toString() {
		return "(";
	}
	
	/**
	 * process the left parenthesis token
	 * it returns null and it pushes the
	 * left parenthesis to the top of the stack
	 * @param the stack of values to handle
	 * @return  null because nothing should be popped
	 */
	public String handle(Stack<Token> aStack) {
		aStack.push(this);
		return null;
	}

}
