import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
public class ct
{

	public static HashMap<String, String> readDictionary(String dictionaryName)
	{	
		try
		{
			File dictionaryFile = new File(dictionaryName);
			FileReader fr = new FileReader(dictionaryFile);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line = "";
			HashMap<String, String> characterMap = new HashMap<String, String>();
			String separator = " : ";
			while((line=br.readLine()) != null)
			{
				String[] splitLine = line.split(Pattern.quote(separator));
				String key = splitLine[0];
				String value = splitLine[1];
				characterMap.put(key, value);
			}
			fr.close();
			return characterMap;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new HashMap<String, String>();
	}

	public static void main(String[] argv)
	{
		int argc = argv.length;
		if(argc < 2)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("You have to provide argument 1 = color and argument 2 = text to apply color to.\n");
			System.out.println("\nPress ENTER to continue ");
			scanner.nextLine();
			System.exit(0);
		}
		
		// Build the map for color names to hex codes
		String dictionaryName = "C:\\Users\\jjara\\OneDrive\\Desktop\\Programming\\colortag\\colordictionary.txt";
		HashMap<String, String> colorMap = readDictionary(dictionaryName);
		//colorMap.put("orange", "#ff7f24");
		//colorMap.put("mint", "#8eb398");
		//colorMap.put("red", "#cc3333");
		//colorMap.put("yellow", "#e4c514");
		//colorMap.put("pink", "#ef9ed2");
		//colorMap.put("cyan", "#51ADD5");
		//colorMap.put("lime", "#74ee15");
		//colorMap.put("green", "#00FF00");
		//colorMap.put("magenta", "#f923b3");
		//colorMap.put("blue", "#0563C1");
		
		// If the color provided is in the map, then return the hex code
		boolean bg = false;
		String color = "";
		String bgSubstring = argv[1].substring(0, argv[1].length()-2); 
		if(colorMap.containsKey(argv[1]))
		{
			color = colorMap.get(argv[1]);
		}
		else if(colorMap.containsKey(bgSubstring))
		{
			color = colorMap.get(bgSubstring);
			bg = true;
		}
		else //otherwise, just put the color provided
		{
			color = argv[1];
		}

		// Add all the text to between the span tags
		String result = "";
		String fg = "white";
		if(bg)
		{
			if(bgSubstring.equals("yellow"))
			{
				fg = "black";
			}
			result = "<span style = \"color: " + fg + "; background-color: ";
		}
		else
		{
			result = "<span style = \"color: ";
		}
		result = result + color;
		result = result + "\">";
		for(int i = 2; i < argc; i++)
		{
			result = result + argv[i];
			if(i < argc-1)
			{
				result = result + " ";
			}
		}
		result = result + "</span>";

		// Copy result to clipboard
		StringSelection stringSelection = new StringSelection(result);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
	} // end main
} // end class
