package proj4;

/**
 * The semicolon class is a token for the semicolon
 * it contains information on how to process the semicolon
 * when called by the converter
 * @author Matthew Caulfield 
 * @version 10/22/17
 */
public class Semicolon implements Token{
	/**
	 * returns the semicolon as a string
	 * @return returns a string of right semicolon
	 */
	public String toString() {
		return ";";
	}
	
	/**
	 * process the semicolon token and returns 
	 * all tokens left in the stack as a string
	 * @param the stack of values to handle
	 * @return returns all tokens left in stack as a 
	 * string
	 */
	public String handle(Stack<Token> aStack) {
		String toReturn = "";
		while(!aStack.isEmpty()) {
			toReturn += aStack.pop().toString();
		}
		return toReturn;
	}
}
