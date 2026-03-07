/**
 * Assignment 3: Hurricane Data
 * @author Elysium "Pixie" Jones
 * 1/30/26
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
 * Purpose: Taking the ace.csv data, Main reads each row of data, stores each
 * row of data as its own object containing unique private variables for the
 * year of record, ACE index value, number of tropical storms in that year,
 * total number of hurricanes in that year, and number of major hurricanes 
 * (categories 3-5) in that year, and stores each row object in an array-list.
 * The ace.csv data is processed in order to locate the highest ACE index value
 * in the given data set and the year in which that ACE index value occurred.
 * The highest ACE index and year of occurrence is both printed in the terminal
 * and output into a text file ("maxAce.txt").
 * 
 * Given Instructions:
 * Main must read in the data from the file and save each row of data into a
 * new HurricaneRowData object, which are further organized into an ArrayList.
 * 
 * Furthermore, in Main you must write a private static method that takes the 
 * ArrayList of data as input and returns the year in which the ACE index 
 * (second column) was maximal. In other words, find the row containing the 
 * maximum ACE value and return the corresponding year. 
 * (Hint: the year is 2005, but you need to write code to solve this.)
 * NOTE: it was suggested that we not be constrained by the specificity of this
 * set of instructions, so I took the liberty to have this method return
 * the index of which row the highest ACE index occurs, not only the year.
 * This way, you can use that index to access all the data categories 
 * associated with the highest ACE index.
 * 
 * Display out the year and maximum ACE value BOTH on the command prompt and 
 * also output the information to a text file.
 * 
 * You may optionally create a class to store the ArrayList of HurricaneRowData 
 * objects and manage its access.
 * 
 * Source(s):
 * I used /2260_all_content/module10_objects_and_fileio/070_fileio_unemployment
 * /object_oriented/Main.java as reference for setting up file reader & writer.
 * Note: I needed this reference as a self-review and template for file reading
 * and to learn about file writing 
 * (I don't think I had done file writing before).
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		// instantiate a HurricaneDataList array-list via its constructor
		HurricaneDataList rowData = new HurricaneDataList();

		// try to write the file data into new objects for each row of data
		try 
		{
			File hurricaneData = new File("ace.csv");
			Scanner read = new Scanner(hurricaneData);
			// strip the first line (contains chart header/categories not data)
			read.nextLine();
			// while there is still at least one value left next, 
			// continue to read values into a new HurricaneRowData object
			while(read.hasNext())
			{
				String line = read.nextLine();
				String[] values = line.split(","); 
				// setting each variable at a specific index, and with only
				// up to 5 indices for the array all together
				// is not good or flexible because it demands that the data be
				// organized exactly in the order I have indexed in the array,
				// and that the data only contains these 5 following values,
				// in this exact order every time, every row.
				int year = Integer.parseInt(values[0]);
				int aceValue = Integer.parseInt(values[1]);
				int tropicalStorms = Integer.parseInt(values[2]);
				int totalHurricanes = Integer.parseInt(values[3]);
				int majorHurricanes = Integer.parseInt(values[4]);
				// creates row of data as its own new object
				HurricaneRowData temp = new HurricaneRowData(year, aceValue, 
							tropicalStorms, totalHurricanes, majorHurricanes);
				// add the new object of the row of data into an array list
				rowData.addRowData(temp); // array list contained in
										  // "HurricaneDataList.java"
			}
			read.close(); // close the Scanner
			// for testing, can use any index to check, with 0= data line 1:
			// System.out.println((rowData.getRowData(0)).toString());

			// for testing the getMaxAceYear method which is
			// currently named getRowWithMaxAce
			//System.out.println("Max Ace Year: "+getMaxAceYear(rowData));
		}
		// catch IOException for reading the file
		catch (IOException e)
		{
			System.out.println("ERROR:something went wrong when reading file");
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
		// try to write the max ACE index value and its year out to a text file
		try 
		{
			FileWriter writer = new FileWriter("maxAce.txt");
			writer.write("The year with the highest ACE index value is:\n");
			writer.write(
				(rowData.getRowData(getRowWithMaxAce(rowData))).toString());
			writer.close(); // close the FileWriter
		}
		// catch IOException for wrtiting the file
		catch (IOException e)
		{
			System.out.println("ERROR: something went wrong when writing file");
			System.out.println(e);
			e.printStackTrace();
			System.exit(2);
		}
		// from the rowData (array-list of row data objects), get the data
		// from the row with the max ace value from the rowData, and get the
		// year then aceValue from that row, and then print both out.
		// (Could there be a more straightforward sequence for this?)
		System.out.println("The year with the highest ACE index value is:");
		System.out.println("Year: "+
			(rowData.getRowData(getRowWithMaxAce(rowData))).getYear()+
			", ACE Index: "+
			(rowData.getRowData(getRowWithMaxAce(rowData))).getAceValue());

	} // END main method

	/**
	 * takes the array-list of data as input and returns the row in which the
	 * ACE index (second column) was maximal. In other words, finds the row 
	 * containing the maximum ACE value and returns the corresponding
	 * array-list index of where the object that contains the max ACE index.
	 * 
	 * @param rowData the object managing the array-list of row data objects
	 * 
	 * @return rowOfHighestAce which is the index in the array-list where 
	 * the max ACE index occurs amongst the row data objects
	 */
	public static int getRowWithMaxAce(HurricaneDataList rowData)
	{
		// initializing variables
		int tempAce = 0;
		int highestAce = 0;
		int rowOfHighestAce = 0;
		//int yearOfHighestAce = 0; // for testing
		for (int currentRow=0; currentRow<(rowData.getSize()); currentRow++)
		{
			// retrieve the aceValue from the currentRow and store in tempAce
			tempAce = rowData.getRowData(currentRow).getAceValue();
			// check if current tempAce is greater than the highestAce so far
			if (tempAce > highestAce)
			{
				// update highestAce and store the currentRow it occurs on
				highestAce = tempAce;
				rowOfHighestAce = currentRow;
				// for testing:
				//yearOfHighestAce = rowData.getRowData(currentRow).getYear();
			}
		}
		return rowOfHighestAce;
		// for testing:
		// return yearOfHighestAce
	} // END getMaxAceYear method

} // END Main class