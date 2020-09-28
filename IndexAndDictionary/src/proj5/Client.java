package proj5;

/**
 * Driver for the index maker project
 * 
 * @author  Matthew Caulfield 
 * @version 11/12/2017
 */
public class Client
{
    public static void main(String[] args)
    {
    	makeIndex("C:/Users/Matt/eclipse-workspace/Caulfieldproj5/src/proj5/uscons.txt");
    }
    
    /**
     * Makes an index out of fileName. Gradescope needs this function.
     * 
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
    	Parser aParser = new Parser(fileName);
    	aParser.parse();
    }
}
