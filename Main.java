/**
 * Assignment 8: Linked List (Hurricane Data)
 * @author Elysium "Pixie" Jones
 * 3/8/26
 * 
 * Background:
 * The American National Oceanic and Atmospheric Administration (NOAA) measures
 * the intensity of a hurricane season with the accumulated cyclone energy 
 * (ACE) index. The ACE for a season is the sum of the ACE for each tropical 
 * storm with winds exceeding 35 knots (65 km/h). The maximum sustained winds 
 * (measured in knots) in the storm are measured or approximated every six 
 * hour.The values are squared and summed over the duration of the storm. 
 * The total is divided by 10,000, to make the parameter easier to use. 
 * This parameter is related to the energy of the storm, since kinetic energy 
 * is proportional to velocity squared. However, it does not take into account
 * the size of the storm, which would be necessary for a true total energy 
 * estimate. Reliable storm data have been collected in the Atlantic Ocean 
 * since 1959 and are shown in table P.4.5. These data are available to you 
 * as an EXCEL worksheet, ace.csv, and was extracted from the *Accumulated 
 * Cyclone Energy article in Wikipedia 
 * (http://en.wikipedia.org/wiki/Accumulated_cyclone_energy). 
 * It was collected by the National Oceanic and Atmospheric Administration 
 * (http://www.aoml.noaa.gov/hrd/hrd/tcfaq/E11.html).
 * 
 * Purpose: Taking the ace.csv data, with each row of data as its own object
 * containing unique private variables for the year of record, ACE index value,
 * number of tropical storms in that year, total number of hurricanes in that
 * year, and number of major hurricanes (categories 3-5) in that year, and
 * stores each row object as a doubly-linked list, sorted by highest to lowest
 * ACE index value (*see Notes).
 * 
 * The year of highest ACE index and is both printed in the terminal
 * and output into a text file ("maxAce.txt"), as well as the remaining
 * sorted data that was read in from the data file.
 * 
 * Source(s):
 * Original Hurricane Data:
 * I used /2260_all_content/module10_objects_and_fileio/070_fileio_unemployment
 * /object_oriented/Main.java as reference for setting up file reader & writer.
 * Note: I needed this reference as a self-review and template for file reading
 * and to learn about file writing 
 * (I don't think I had done file writing before).
 * Linked List Hurricane Data:
 * 
 * Notes: *There is an unidentified logic issue in insert.
 * The ACE from 1953 and the ACE from 1957 both do not get sorted where they
 * belong. At first I suspected it had something to do with repeat ACE values
 * occurring in the data, but given the explicit set up of my insert method
 * accounting for ACEs that are equal, I am now not so sure. 
 * I also wonder how 1957 did not correctly sort to where 1953 (incorrectly)
 * is, because where 1953 sorts to is where 1957 should be.
 * If I had been able to spend more time with this I would have fixed it.
 * But, I moved on to finish everything else and have now run out of time
 * and energy. I definitely intend on attending office hours to get your
 * perspective on this issue.
 * 
 * Overall, I definitely do not think this is my best work. I had originally
 * tried using generics and clearly had some misunderstandings about using
 * them, so I abandoned generics. Previous commits in the GitHub repo will
 * show some really confused, disastrous versions of this program. I am now
 * turning this in as-is, though definitely disappointed I couldn't get it
 * finished in time. I figured that containing a logic issue was better than
 * being late?
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		// instantiate a Doubly-Linked Sorted List for HurricaneRowData objects
		DoublyLinkedSortedList rowData = new DoublyLinkedSortedList();
		// create the File to be read, and read it into the list
		File hurricaneData = new File("ace.csv");
		rowData.readData(hurricaneData);
		
		//print nodes for testing
		//rowData.printNodesByNext();
		//rowData.printNodesByPrevious();

		//try to write the max ACE year and all sorted ACE data
		//out to a text file
		try 
		{
			FileWriter writer = new FileWriter("maxAce.txt");
			int maxAceYear = rowData.getFirst().getData().getYear();
			writer.write("Year of max ace: ");
			writer.write(Integer.toString(maxAceYear)); //without using
			//Integer.toString, it was outputting ߕ instead of 2005.
			writer.write("\nAll data in order of Ace:\n");
			writer.write(rowData.toString());
			writer.close(); // close the FileWriter
		}
		// catch IOException for writing the file
		catch (IOException e)
		{
			System.out.println("ERROR: something went wrong when writing file");
			System.out.println(e);
			e.printStackTrace();
			System.exit(2);
		}

		//display the max ACE year and all sorted ACE data to terminal
		System.out.println("Year of max ace: "+
									rowData.getFirst().getData().getYear());
		System.out.print("All data in order of Ace:\n"+rowData.toString());
		/*First test: is the length of the list the same as the number of rows
		of data in ace.csv?
		*/
		System.out.println("Does the doubly-linked list hold the same number "+
			"of items as the orignial file? "+rowData.testLength(67));
		/*Second test: testing if a HurricaneRowData object with a low ACE (0)
		will correctly sort to the last item in the DoublyLinkedSortedList
		rowData. All values are arbitrary, except for ACE = 0.
		*/
		HurricaneRowData lowAceData = new HurricaneRowData(2026, 0, 3, 
								2, 1);
		System.out.println("Is an ACE value of 0 correctly sorted to be the "+
			"last item in the list? "+rowData.testLowestInsertion(lowAceData));
		//System.out.println(rowData.getLast().getData());
/*LAST MINUTE extra credit, not so sure that it actually works unfortunately.
		HurricaneRowData sampleData = new HurricaneRowData(1950,243,13,11,8);
		//should be true because this is the same data as the first row in file
		System.out.println("Contains? "+rowData.contains(sampleData));
*/

	} // END main method
} // END Main class