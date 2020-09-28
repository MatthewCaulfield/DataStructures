package proj4;
/**
 * the code that runs the converter using an input file
 * it creates a new converter and for each input file used and
 * prints the converted equations
 * 
 * @author Matthew Caulfield
 * @version 10/23/17
 */

public class Client
{
    public static void main(String[] args)
    {
    String inputFile = "C:/Users/Matt/eclipse-workspace/Caulfieldproj4/src/proj4/proj4_input.txt";	
    Converter aConverter = new Converter(inputFile);  
    aConverter.convert();
    }
}
