package proj5;
/**
 * class that parses an input file and makes an Index
 * and dictionary for that file
 * @author Matthew Caulfield
 * @version 11/13/2017
 */
public class Parser {
	//a dictionary of words that have been seen more than
	//four times in alphabetical order
	private Dictionary aDictionary;
	//an index that stores words with their page numbers
	//in alphabetical order
	private Index anIndex;
	//reads in a text file
	private FileReader aFileReader;
	public Parser(String fileName){
		aDictionary = new Dictionary();
		anIndex = new Index();
		aFileReader = new FileReader(fileName); 
	}
	
	/**
	 * parses through a file and creates an index and dictionary
	 * for the text file
	 */
	public void parse() {
		int pageNumber = 1;
		String currentString = aFileReader.nextToken();
		while(currentString != null) {
			if(currentString.equals("#")) {
				pageNumber++;
			}
			else {
				if(currentString.length()>2 && !aDictionary.search(currentString)) {
					if(anIndex.search(currentString)) {
						if(!anIndex.containsPageNumber(currentString, pageNumber)) {
							if(!anIndex.isPageListFull(currentString)) {
								anIndex.addPageNumber(currentString, pageNumber);
							}
							else {
								System.out.println("Deleting '" + anIndex.stringOfIndexEntry(currentString) + "' from index");
								anIndex.delete(currentString);
								aDictionary.insert(currentString);
							}
						}
					}
					else {
						anIndex.insert(currentString, pageNumber);
					}
				}
			}
			currentString = aFileReader.nextToken();
		}
		System.out.println(anIndex.toString());
		System.out.println(aDictionary.toString());
	}
}
