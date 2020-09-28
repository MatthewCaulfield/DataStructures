package proj4;

/**
 * The plus class is both a token and an operator 
 * it contains information on how to process the plus
 * when called by the converter
 * @author Matthew Caulfield 
 * @version 10/22/17
 */
public class Plus implements Token, Operator{
	//the precedence of the plus operator and token
	//it should never be changed by any method
	private int precedence = 1;
	
	/**
	 * returns the precedence of plus
	 * @return the precedence of the plus class
	 */
	public int getPrecedence() {
		return precedence;
	}
	
	/**
	 * @return plus as a string "+"
	 */
	public String toString() {
		return "+";
	}
	
	/**
	 * processes the plus token by popping any operator until the stack is
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
			else{
				toReturn += aStack.pop();
			}
		}
		aStack.push(this);
		return toReturn;
	}
}