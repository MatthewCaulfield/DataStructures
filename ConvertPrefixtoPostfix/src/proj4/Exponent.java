package proj4;

/**
 * The exponent class is both a token and an operator 
 * it contains information on how to process the exponent
 * when called by the converter
 * @author Matthew Caulfield 
 * @version 10/22/17
 */
public class Exponent implements Token, Operator{    
	//the precedence of the exponent operator and token
	//it should never be changed by any method
	private final int precedence = 3;
	
	/**
	 * returns the precedence of exponent
	 * @return the precedence of the exponent class
	 */
	public int getPrecedence() {
		return precedence;
	}
	
	/**
	 * @return exponent as a string "^"
	 */
	public String toString() {
		return "^";
	}
	
	/**
	 * processes the exponent token by popping any operator with a 
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
			else if(((Operator)aStack.peek()).getPrecedence() < this.getPrecedence()) {
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
