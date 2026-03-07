/**
 * Assignment 3: Hurricane Data
 * @author Elysium "Pixie" Jones
 * 1/30/26
 * 
 * Purpose: Stores and manages each HurricaneRowData object in an array-list.
 * 
 * Given Instructions: You may optionally create a class to store the ArrayList
 * of HurricaneRowData objects and manage its access.
 * 
 * Source(s):
 * I used /2260_all_content/module10_objects_and_fileio/070_fileio_unemployment
 * /object_oriented/UnemploymentData.java as a reference for setting the
 * HurricaneDataList class up
 */


import java.util.ArrayList;

public class HurricaneDataList
{
	private ArrayList<HurricaneRowData> dataList;

	/**
	 * Constructor for HurricaneDataList object
	 */ 
	public HurricaneDataList()
	{
		//create array list to countain each HRData object
		dataList = new ArrayList<HurricaneRowData>();
	}

	/** 
	 * addRowData method to add a HurricaneRowData object to 
	 * the HurricaneDataList array-list
	 * 
	 * @param row a single row from the data, 
	 * stored as a HurricaneRowData object
	 */

	public void addRowData(HurricaneRowData row){ dataList.add(row); }
	/**
	 * get access to a HurricaneRowData object from HurricaneDataList 
	 * through the array-list's index
	 * 
	 * @param index the index for accessing the HurricaneDataList array-list
	 * 
	 * @return HurricaneRowData object at the provided index
	 */

	public HurricaneRowData getRowData(int index){ return dataList.get(index);}
	/**
	 * retrieve the size of the HurricaneDataList array-list
	 * 
	 * @return the size of the HurricaneDataList array-list
	 */

	public int getSize() { return dataList.size(); }
	
} // END HurricaneDataList class