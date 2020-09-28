package proj4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * test all tokens and operators
 * only needs to test one token of precedent 2 or 3 and
 * one token of precedent 1 because 2 or 3 share the same
 * logic and all precedent 1 share the same logic
 * 
 * @author Matthew Caulfield 
 * @version 10/22/17
 */
public class TokenTest {
	private Divide divide;
	private Exponent exponent;
	private LeftParen leftParen;
	private Minus minus;
	private Multiply multiply;
	private Plus plus;
	private RightParen rightParen;
	private Semicolon semicolon;
	private Stack <Token> aStack;
	
	@Before
    public void setUp() throws Exception {
        divide = new Divide();
        exponent = new Exponent();
        leftParen = new LeftParen();
        minus = new Minus();
        multiply = new Multiply();
        plus = new Plus();
        rightParen = new RightParen();
        semicolon = new Semicolon();
        aStack = new <Token>Stack();
    }
	
	@Test
	public void testDivideToString() {
		assertEquals("/", divide.toString());
	}
	
	@Test
	public void testExponentToString() {
		assertEquals("^", exponent.toString());
	}
	
	@Test
	public void testLeftParenToString() {
		assertEquals("(", leftParen.toString());
	}
	
	@Test
	public void testMinusToString() {
		assertEquals("-", minus.toString());
	}
	
	@Test
	public void testMultiplyToString() {
		assertEquals("*", multiply.toString());
	}
	
	@Test
	public void testPlusToString() {
		assertEquals("+", plus.toString());
	}
	
	@Test
	public void testRightParenToString() {
		assertEquals(")", rightParen.toString());
	}
	
	@Test
	public void testSemicolonToString() {
		assertEquals(";", semicolon.toString());
	}

	@Test
	public void testDivideGetPrecedence() {
		assertEquals(2, divide.getPrecedence());
	}
	
	@Test
	public void testExponentGetPrecedence() {
		assertEquals(3, exponent.getPrecedence());
	}
	
	@Test
	public void testMinusGetPrecedence() {
		assertEquals(1, minus.getPrecedence());
	}
	
	@Test
	public void testMultiplyGetPrecedence() {
		assertEquals(2, multiply.getPrecedence());
	}
	
	@Test
	public void testPlusGetPrecedence() {
		assertEquals(1, plus.getPrecedence());
	}
	
	@Test
	public void testPrecedentTwoOrThree() {
		aStack.push(divide);
		aStack.push(exponent);
		aStack.push(leftParen);
		aStack.push(plus);
		aStack.push(multiply);
		assertEquals("*", divide.handle(aStack));
	}
	
	@Test
	public void testPrecedentTOne() {
		aStack.push(divide);
		aStack.push(exponent);
		aStack.push(leftParen);
		aStack.push(plus);
		aStack.push(minus);
		aStack.push(multiply);
		assertEquals("*-+", plus.handle(aStack));
	}

}
