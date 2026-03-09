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
import java.util.Objects;
import java.util.Comparator;

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


//LAST MINUTE tried throwing these in, but i'm not so sure they work
//apologies for the terrible commenting out; this really was last minute.
/*	// Overriding equals() to compare two Person objects
    @Override
    public boolean equals(Object o) {
    	//if Object o is null then return false
    	if (o == null)
    		return false;

        // If the object is compared with itself then return true 
        // (if Object o == this then return true)
        if (o == this) 
            return true;

        //if Object o is not an instance of Person then return false
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
//        if (!(o instanceof HurricaneRowData)) {
//            return false;
//        }
//
//        
//    	//NOTICE I copy-pasted this from my human resources assignment and
//  	//only making necessary corrections
//		//Declare a new variable of type HurricaneRowData (perhaps named d) 
//		//	and assign it to Object o cast as type HurricaneRowData
//		// (typecast o to Person so that we can compare data members)
//		
//		/*HurricaneRowData d = (HurricaneRowData) o;
//
//		/*if d has the same year, aceValue, tropicalStorms, 
//			totalHurricanes, majorHurricanes as 
//			this then return true
//		*/
//		return Integer.compare(this.year, d.year) == 0 && 
//              Integer.compare(this.aceValue, d.aceValue) == 0 &&
//               Integer.compare(this.tropicalStorms, d.tropicalStorms) == 0 &&
//               Integer.compare(this.totalHurricanes, d.totalHurricanes) == 0 &&
//               Integer.compare(this.majorHurricanes, d.totalHurricanes) == 0;
//
//	    } // END overridden equals method

	   // /** Overridden hashCode method, recommended at the end of
	   //  * <a href="https://www.geeksforgeeks.org/java/overriding-equals-method-in-java/">this website.</a>
	    // * <a href="https://mkyong.com/java/java-how-to-overrides-equals-and-hashcode/">I also referenced this site to help set up the overridden hashCode.</a>
	     //* <a href="https://www.w3schools.com/java/ref_string_compareto.asp">Reviewed String compareTo method.</a>
	     //* 
	     //* @return integer value of hashCode
	     //*/
//	    @Override
//	    public int hashCode()
//	    {
//	        return Objects.hash(year, aceValue,tropicalStorms,totalHurricanes,majorHurricanes);
//	    } // END overridden hashCode method

} // END HurricaneRowData class