package proj4;

/**
 * The divider class is both a token and an operator 
 * it contains information on how to process the divider
 * when called by the converter
 * @author Matthew Caulfield 
 * @version 10/22/17
 */
public class Divide implements Token, Operator{
	//the precedence of the divide operator and token
	//it should never be changed by any method
	private final int precedence = 2;
	
	/**
	 * returns the precedence of divide
	 * @return the precedence of the divide class
	 */
	public int getPrecedence() {
		return precedence;
	}
	
	/**
	 * @return divide as a string "/"
	 */
	public String toString() {
		return "/";
	}
	
	/**
	 * processes the divide token by popping any operator with a 
	 * greater than or equal to precedence until the stack is
	 * empty or you the top of the stack is a left parenthesis
	 * @param the stack of values to handle
	 * @return the string containing all of the tokens that were popped
	 */
	public String handle(Stack<Token> aStack) {
		String toReturn = "";
		boolean stillPop = true;
		while(stillPop) {
			if(aStack.isEmpty()) {
				stillPop = false;  
			}
			else if(aStack.peek().toString().equals("(")){
				stillPop = false;
			}
			else if(((Operator)aStack.peek()).getPrecedence() < this.getPrecedence()){
				stillPop = false;
			}
			else{
				toReturn += aStack.pop();
			}
		}
		aStack.push(this);
		return toReturn;
	}
}
