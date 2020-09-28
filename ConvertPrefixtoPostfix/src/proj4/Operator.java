package proj4;

/** 
 * describes the method that is needed to be an operator
 * every operator is a token
 * the method is getPrecedence
 * 
 * @author Matthew Caulfield
 * @version 10/22/17
 *
 */
public interface Operator extends Token{
	/**
	 * returns the precedence of the operator
	 * @return the precedence
	 */
	public int getPrecedence();
}
