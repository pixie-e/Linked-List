/**
 * Assignment 8: Linked List (Hurricane Data)
 * @author Elysium "Pixie" Jones
 * 3/8/26
 * 
 * Purpose: Creates a HurricaneRowData object with its own private instance
 * variables for the year of record, ACE index value, number of tropical storms
 * in that year, total number of hurricanes in that year, and number of major 
 * hurricanes (categories 3-5) in that year. Also has getter methods for a
 * HurricaneRowData's year and ACE index value, and overridden toString method
 * for writing the data out. 
 * 
 * Given Instructions (Original assignment, not Linked List):
 * HurricaneRowData must have 5 private instance variables (one for each of the
 * columns of data in ace.csv). The class must also have a constructor and a 
 * toString method. You should add any getter or setter methods that you need.
 * 
 * Source(s):
 * Original Hurricane Data:
 * I used /2260_all_content/module10_objects_and_fileio/070_fileio_unemployment
 * /object_oriented/Unemployment.java as a reference for setting the 
 * HurricaneRowData class up
 * Linked List Hurricane Data:
 * 
 * Notes: The only thing that has changed in this version compared to the
 * original Assignment 3 is the formatting for the toString.
 */


public class HurricaneRowData
{
	// initializing variables. note none of their values should be 0
	// after HurricaneRowData object(s) are instantiated, since no data 
	// contained will be 0 EXCEPT for majorHurricanes 
	// (some years have 0 major hurricanes)
	// year of record
	private int year;
	// accumulated cyclone energy (ACE) index 
	// is the measure of intensity of a hurricane season
	// I am calling it aceValue to indicate this is the value for the ACE index
	// so that the term index can be reserved for array indexing or similar use
	private int aceValue;
	// number of tropical storms that occurred in that year of record
	private int tropicalStorms;
	// number of total hurricanes (categories 1-5) that occurred in that year
	private int totalHurricanes;
	// number of major hurricanes (categories 3-5) that occurred in that year
	private int majorHurricanes;

	/**
	 * Constructor for HurricaneRowData object
	 * 
	 * @param year year of record
	 * @param aceValue accumulated cyclone energy (ACE) index
	 * @param tropicalStorms number of tropical storms that occurred in that
	 * year of record
	 * @param totalHurricanes number of total hurricanes (categories 1-5) that
	 * occurred in that year
	 * @param majorHurricanes number of major hurricanes (categories 3-5) that
	 * occurred in that year
	 */
	
	public HurricaneRowData(int year, int aceValue, int tropicalStorms, 
								int totalHurricanes, int majorHurricanes)
	{
		this.year = year;
		this.aceValue = aceValue;
		this.tropicalStorms = tropicalStorms;
		this.totalHurricanes = totalHurricanes;
		this.majorHurricanes = majorHurricanes;
	}

	/**
	 * gets the year of record from a particular HurricaneRowData object
	 * 
	 * @return the year of record from a HurricaneRowData object
	 */ 
	public int getYear() { return this.year; }

	/**
	 * gets the aceValue from a particular HurricaneRowData object
	 * 
	 * @return the aceValue from a HurricaneRowData object
	 */ 
	public int getAceValue() { return this.aceValue; }

	/**
	 * overridden toString to write out and return all HurricaneRowData items.
	 * 
	 * @return the formated String containing a HurricaneRowData object's
	 * data.
	 */
	// 
	@Override
	public String toString()
	{
		return String.format("%10d%11d%11d%11d%11d\n", 
			this.year, this.aceValue, this.tropicalStorms, 
			this.totalHurricanes, this.majorHurricanes);
	}
} // END HurricaneRowData class