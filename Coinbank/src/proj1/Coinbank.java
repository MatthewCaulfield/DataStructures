package proj1;  // Don't change the package name.  Gradescope expects this.

/**
 * This is the Coin bank class it holds different coins and allows a person to insert or remove a coin
 * and tells the amount of money and coins in the bank
 * @author Matthew Caulfield
 * @version 9/20/17
 *
 * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 */
public class Coinbank {
	
	// Denominations
	public static final int PENNY_VALUE = 1;
	public static final int NICKEL_VALUE = 5;
	public static final int DIME_VALUE = 10;
	public static final int QUARTER_VALUE = 25;
	
	// give meaningful names to holder array indices
	private final int PENNY = 0;
	private final int NICKEL = 1;
	private final int DIME = 2;
	private final int QUARTER = 3;
	
	// how many types of coins does the bank hold?
	private final int COINTYPES = 4;
	
	private int[] holder;
	
	/**
	 * Default constructor
	 */
	public Coinbank() {
		holder = new int[COINTYPES];
		for(int i = 0; i < COINTYPES; i++) {
			holder[i] = 0;
		}
	}
	
	/**
	 * getter
	 * @param coinType denomination of coin to get. Valid denominations are 
	 * 1,5,10,25
	 * @return number of coins that bank is holding of that type, or -1 
	 * if denomination not valid
	 */
	public int get(int coinType){
		if(isBankable(coinType)) {
			return holder[getCoinIndex(coinType)];
		}
		else {
			return -1;
		}
	}
	
	/**
	 * setter
	 * @param coinType denomination of coin to set
	 * @param numCoins number of coins
	 */
	private void set(int coinType, int numCoins) {
		if(isBankable(coinType)) {
			holder[getCoinIndex(coinType)] = numCoins;
		}
	}
	
	/**
	 * takes the value of a coin and returns its index in the holder array
	 * the coin value must be a valid value 1, 5, 10, 25
	 * @param coinType
	 * @return Constant that is the index of the coin in the holder array
	 */
	private int getCoinIndex(int coinType) {
        if(coinType == PENNY_VALUE) {
    	   	return PENNY;
    	}
    	else if (coinType == NICKEL_VALUE) {
    	  	return NICKEL;
    	}
    	else if (coinType == DIME_VALUE) {
    	  	return DIME;
    	}
    	else{
    	   	return QUARTER;
    	}
	}
	
	/**
	 * Return true if given coin can be held by this bank.  Else false.
	 * @param coin penny, nickel, dime, or quarter is bankable. All others are not.
	 * @return true if bank can hold this coin, else false
	 */
	private boolean isBankable(int coin){
		switch (coin) {
		case PENNY_VALUE: case NICKEL_VALUE: 
		case DIME_VALUE: case QUARTER_VALUE:
			return true;
		default: 
			return false;
		}
	}
	
	/** 
	 * insert valid coin into bank.  Returns true if deposit
	 * successful (i.e. coin was penny, nickel, dime, or quarter).
	 * Returns false if coin not recognized
	 * 
	 * @param coinType either 1, 5, 10, or 25 to be valid
	 * @return true if deposit successful, else false
	 */
	public boolean insert(int coinType){
		if (!isBankable(coinType)) {
			return false;
		}
		else {
			set(coinType, get(coinType)+1);
			return true;
		}
	}
	
	/**
	 * returns the requested number of the requested coin type, if possible.
	 * Does nothing if the coin type is invalid.  If bank holds
	 * fewer coins than is requested, then all of the coins of that
	 * type will be returned.
	 * @param coinType either 1, 5, 10, or 25 to be valid
	 * @param requestedCoins number of coins to be removed
	 * @return number of coins that are actually removed
	 */
	public int remove(int coinType, int requestedCoins) {
		int coinsHave = get(coinType);
		int coinsLeft = numLeft(requestedCoins, coinsHave);
		if(requestedCoins >= 0 && isBankable(coinType)) {	
			set(coinType, coinsLeft);
			if(coinsLeft > 0) {
				return requestedCoins;
			}
			else{
				return coinsHave;
			}
		}
		else {
			return 0;
		}
	}
	

	/**
	 * returns number of coins remaining after removing the
	 * requested amount.  Returns zero if requested amount > what we have
	 * @param numWant number of coins to be removed
	 * @param numHave number of coins you have
	 * @return number of coins left after removal
	 */
	private int numLeft(int numWant, int numHave){
		return Math.max(0, numHave-numWant);
	}
	
	/**
	 * Returns bank as a printable string
	 */
	public String toString() {
		double total = (get(PENNY_VALUE) * PENNY_VALUE +
				get(NICKEL_VALUE) * NICKEL_VALUE + 
				get(DIME_VALUE) * DIME_VALUE +
				get(QUARTER_VALUE) * QUARTER_VALUE) / 100.0;
				
		String toReturn = "The bank currently holds $" + total + " consisting of \n";
		toReturn+=get(PENNY_VALUE) + " pennies\n";
		toReturn+=get(NICKEL_VALUE) + " nickels\n";
		toReturn+=get(DIME_VALUE) + " dimes\n";
		toReturn+=get(QUARTER_VALUE) + " quarters\n";
		return toReturn;
	}
}