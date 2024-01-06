package store;
import java.net.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * HTMLParser
 * @author Youssef
 * Work Cited:
 * https://www.tutorialspoint.com/Java-String-substring-Method-example#
 */
public class HTMLParser {

	public static void main(String[] args) throws Exception {
				 
			 Scanner keyboard = new Scanner(System.in);
			 System.out.println("Enter a full web page address (URL) and press the Enter key: ");
			 String webPageAddress = keyboard.nextLine();
			 
			 Scanner scan = new Scanner((new URL(webPageAddress)).openStream()); // openStream to read the URL

			 String title = null;
			 
			 while (scan.hasNextLine())
			 {
				 String line = scan.nextLine();
				 if (line.toLowerCase().indexOf("<title") > 0 || line.toLowerCase().startsWith("<title>"))
				 {	
					 int index = line.indexOf("<title"); // locate the <title
					 String tempTitle = line.substring(index); // cut off text before <title
					 int tagIndex = tempTitle.indexOf(">"); // find index of >
					 tempTitle = tempTitle.substring(tagIndex+1); // cut text before > and the >
					 int endIndex = tempTitle.indexOf("</title>"); // find the index of the end tag: "</title>"
					 if (endIndex < 0) // if the end tag is not on the same line as the <title enter the statement
					 {
						 line = scan.nextLine().trim();
						 if (line.contains("</title>")) // if the line after the <title contained the end tag </title>
						 {
							 endIndex = line.indexOf("</title>"); //find the index of the end tag </title>
							 title = line.substring(0, endIndex); // cut off the end tag </title>
						 }
						 else {
							 title = line;
						 } 
					 }
					 
					 else { // if the end tag is on the same line as the title cut off the end tag </title>
						 title = tempTitle.substring(0, endIndex);
					 }
					 System.out.println("Title: " + title);
					 System.out.println();
					 System.out.println("Thank You");
					 break;
				 }
			 }
			 
			 if (title == null) // if there is no title
			 {
				 System.out.println("Title not found");
			 }
			 
			 
	}

}
