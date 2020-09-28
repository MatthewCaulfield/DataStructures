package proj4;

/**
 * The right paren class is a token for the right parenthesis
 * it contains information on how to process the right parenthesis
 * when called by the converter
 * @author Matthew Caulfield 
 * @version 10/22/17
 */
public class RightParen implements Token{
	
	/**
	 * returns the left parenthesis as a string
	 * @return returns a string of right Parenthesis
	 */
	public String toString() {
		return ")";
	}
	
	/**
	 * process the right parenthesis token and returns 
	 * all tokens between this parenthesis and the next 
	 * left parenthesis
	 * @param the stack of values to handle
	 * @return returns all tokens between this parenthesis 
	 * and the next left parenthesis
	 */
	public String handle(Stack<Token> aStack) {
		String toReturn = "";
		while(!aStack.peek().toString().equals("(")) {
			toReturn += aStack.pop();
		}
		aStack.pop();
		return toReturn;
	}
}
