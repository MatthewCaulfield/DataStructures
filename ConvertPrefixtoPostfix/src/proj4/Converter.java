package proj4;

/**
 * Converts a series of prefix equation into postfix equations
 * that are in a given file. It uses the FileReader class to read the file
 * and each token used has its own handle method for how tokens should
 * be added to the postfix
 * 
 * @author Matthew Caulfield
 * @version 10/22/2017
 * 
 */
public class Converter {
	//stack that will hold tokens that are not operands
	//it is changed by the handle methods for tokens
	private Stack<Token> operationStack;
	//the file reader for file that is being converted
	private FileReader aFile;
	// the prefix string of the current equation
	//it is added to for every token parsed by the
	//prefix it is reset for every equation
	private String prefix;
	//the postfix string of the current equation
	//it is added to when ever deemed necessary by the
	//handle method of a token
	//postfix it is reset for every equation
	private String postfix;
	
	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile){
        operationStack = new Stack<Token>();
        aFile = new FileReader(infile);
        postfix = "";
        prefix = "";
    }
    
    /**
     *convert converts equations in aFile instance variable 
     *to postfix equations. It allows each token to handle its 
     *what is added to the postfix string and what is added and removed to 
     *the operationStack the postfix and prefix strings are reset for
     *every equation 
     */
    public void convert(){
    	String currentSymbol = aFile.nextToken();
    	while(currentSymbol != "EOF") {
    		if(!currentSymbol.equals(";")) {
    			prefix += currentSymbol;
    		}
    		if(currentSymbol.equals("(")) {
    			LeftParen aLeftParen = new LeftParen();
    			aLeftParen.handle(operationStack);
    		}
    		else if(currentSymbol.equals(")")){
    			RightParen aRightParen = new RightParen();
    			postfix += aRightParen.handle(operationStack);
    			
    		}
    		else if(currentSymbol.equals(";")) {
    			Semicolon aSemicolon = new Semicolon();
    			postfix += aSemicolon.handle(operationStack);
    			this.printPrefixAndPostfix();
    			postfix = "";
    			prefix = "";
    		}
    		else if(currentSymbol.equals("^")) {
    			Exponent aExponent = new Exponent();
    			postfix += aExponent.handle(operationStack);
    		}
    		else if(currentSymbol.equals("/")) {
    			Divide aDivide = new Divide();
    			postfix += aDivide.handle(operationStack);
    		}
    		else if(currentSymbol.equals("*")) {
    			Multiply aMultiply = new Multiply();
    			postfix += aMultiply.handle(operationStack);
    		}
    		else if(currentSymbol.equals("+")) {
    			Plus aPlus = new Plus();
    			postfix += aPlus.handle(operationStack);
    		}
    		else if(currentSymbol.equals("-")) {
    			Minus aMinus = new Minus();
    			postfix += aMinus.handle(operationStack);
    		}
    		else {
    			postfix += currentSymbol;
    		}
    		currentSymbol = aFile.nextToken();
    	}
    }
    
    /**
     * prints the current postfix and prefix equation
     * in the proper format
     */
    private void printPrefixAndPostfix(){
    	System.out.println(prefix + " --> " + postfix);
    }
}
