/**
 * Assignment 8: Linked List (Hurricane Data)
 * @author Elysium "Pixie" Jones
 * 3/8/26
 * 
 * Instructions: create a doubly-linked, self-sorting list that can be used in
 * place of the ArrayList used in the Hurricane assignment. Then, write 2 test
 * methods for your DoublyLinkedSortedList. These methods should each test a
 * different aspect of the correctness of the doubly linked list implementation.
 * The test methods are: testLength and testLowestInsertion, and get called
 * in Main.
 * 
 * Source(s):
 * Original Hurricane Data: N/A - DoublyLinkedSortedList was not in original
 * Linked List Hurricane Data:
 * <a href="https://www.geeksforgeeks.org/dsa/introduction-to-doubly-linked-lists-in-java/">This site helped me somewhat with doubly-linked lists. I definitely faced a learning curve.</a>
 * 
 * Notes: method toRemove from interface is never implemented in this program,
 * but I left it because I simply ran out of time and was unsure if it was
 * required to be included or not. toRemove only returns null.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface
{
	private Node head;
	private Node tail;
	private int length = 0;
	
	// Constructor
	public DoublyLinkedSortedList()
	{
		this.head = null;
		this.tail = null;
		this.length = length;
	}

	/**
	 * Take an already prepared File to read in the hurricane row data
	 * as individual objects per row, then insert them into the
	 * doubly-linked list
	 * 
	 * @param file file to read in
	 */
	public void readData(File file)
	{
		// try to write the file data into new objects for each row of data
		try 
		{	Scanner read = new Scanner(file);
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
				// add the new data into the doubly-linked list
				insert(temp);
			}
			read.close(); // close the Scanner
		}
		// catch IOException for reading the file
		catch (IOException e)
		{
			System.out.println("ERROR:something went wrong when reading file");
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Return a reference to the first Node in the list
	 * 
	 * @return the first Node in the list
	 */
	public Node getFirst()
	{
		if (this == null)
			return null;
		return head;
	} // END getFirst method
	
	/**
	 * Return a reference to the last Node in the list
	 * 
	 * @return the last Node in the list
	 */
	public Node getLast()
	{
		if (this == null)
			return null;
		return tail;
	} // END getLast method
	
	//Remove the Node that has toRemove as its value
	/*Note this was never implemented, nor written. I ran out of time and did
	not find a purpose for this method despite it being included in the
	interface. I wasn't sure if it was required to be kept or not.
	I would've taken it out otherwise.
	*/
	public Node remove(HurricaneRowData toRemove)
	{
		return null; //placeholder setup
	} // END remove method
	
	/**
	 * Insert a new Node with the given newValue into the list in order.
	 * 
	 * @param dataToInsert the HurricaneRowObject that will be inserted in list
	 */
	public void insert(HurricaneRowData dataToInsert)
	{
		Node toInsert = new Node(dataToInsert);
		//CHECK CASE: List is empty; start with the first insertion
		if (head == null)
		{
			head = toInsert;
			tail = toInsert;
			//System.out.println(toInsert.getData().getAceValue());
			//System.out.print(head.getData());
			length++;
			return;
		}
		// if toInsert has ACE larger than the head's ACE, place toInsert as new head
		else if (toInsert.getData().getAceValue() > head.getData().getAceValue())
		{
			head.setPrevious(toInsert);
			toInsert.setNext(head);
			head = toInsert;
			length++;
	       
	        //System.out.print(head.getData());
	        return;
	        
	    }
	    //CHECK CASE that head is only item in list, and toInsert was
	    //already checked and failed for greater ACE, make toInsert new tail
	    else if (!head.hasNext())
	    {
	    	head.setNext(toInsert); //update head's next toInsert
	    	toInsert.setPrevious(head); //toInsert's previous is now head
	    	tail = toInsert; //tail is now toInsert
	    	length++;
	    	return;
	    }
	    /*List should have at least two items in it, so set currentNode to 
		head and check current's next. Iterate over list until there is no
		next (tail is reached).
		*/
	    Node currentNode = head;
	    while (currentNode.hasNext())
	    {
	    	/*
	    	This step seems somewhat unnecessary but is a holdover from when I
	    	was trying to solve the logical issue mentioned in Notes (see
	    	header). Check if toInsert ACE is the same as current's ACE, and
	    	if they are the same insert toInsert behind current (this way
	    	years will also be in order, i.e. 1960 was written first but
	    	1985's ACE matches, so it gets sorted behind 1960). 
	    	*/
	    	if (toInsert.getData().getAceValue() == currentNode.getData().getAceValue())
	    	{
	    		//should be safe as loop would not enter if there was not a next
	    		Node afterNode = currentNode.getNext(); //Node behind current
	    		toInsert.setNext(afterNode); //toInsert's next is after
	    		toInsert.setPrevious(currentNode);//toInsert's prev is current
	    		afterNode.setPrevious(toInsert);//after's prev updates toInsert
	    		currentNode.setNext(toInsert);//current's next updates toInsert
	    		length++;
	    		return;
	    	}
	    	/*Check if toInsert's ACE is greater than current's ACE, and if
	    	it is greater insert toInsert ahead of current*/
	    	else if (toInsert.getData().getAceValue() > currentNode.getData().getAceValue())
	    	{	
	    		Node beforeNode = currentNode.getPrevious();//Node ahead of current
	    		toInsert.setPrevious(beforeNode); //toInsert's prev is before
	    		toInsert.setNext(currentNode); //toInsert's next is current
	    		beforeNode.setNext(toInsert); //before's next is toInsert
	    		currentNode.setPrevious(toInsert); //current's prev is toInsert
	    		length++;
	    		return;
	    	}
	    	currentNode = currentNode.getNext();
	    }
	    //otherwise, all other conditions have failed which means all that
	    //is left is the tail, so update the tail and its links.
	    tail.setNext(toInsert);
	    toInsert.setPrevious(tail);
	    tail = toInsert;
	    length++;
	} // END insert method
	
	/**
	 * Return the entire list as a multi-line String
	 * 
	 * @return doubly-linked list of HurricaneRowData
	 */
	@Override
	public String toString()
	{
		// 3/5/26 live demo by Neal Holtschulte
		String s = "";
		// if empty
		if (head == null)
			return s;
		//otherwise not empty
		Node n = head;
		s += n.getData().toString();
		while (n.hasNext())
		{
			n = n.getNext();
			s += n.getData().toString();
		}
		return s;
		
	} // END overridden toString method

	/**
	 * testLength checks if the length counted of the list matches the number
	 * of rows of data from the original input file
	 * 
	 * @param expectedLength is the int value representing the total length/
	 * number of rows from the original input file
	 * 
	 * @return boolean if the lengths match or not
	 */
	public boolean testLength(int expectedLength)
	{
		return length == expectedLength;
	}

	/**
	 * testLowestInsertion checks if a very low ACE value (the lowest possible
	 * for a given list) correctly sorts to be the last item in the list
	 * 
	 * @param testLowAce a HurricaneRowData object containing a low ACE to
	 * be inserted into the list
	 * 
	 * @return boolean if the low ACE was correctly sorted to be the last
	 * in the list.
	 */
	public boolean testLowestInsertion(HurricaneRowData testLowAce)
	{
		insert(testLowAce);
		return (getLast().getData()) == (testLowAce);
		
	}

	/* commented out if needed for testing again later
	public void printNodesByNext()
	{
		System.out.println("\nBY NEXT:");
		Node printNode = head;
	    for (int i=0; i<length; i++)
	    {
	    	System.out.print(printNode.getData());
	    	printNode = printNode.getNext();
	    }
	}
	public void printNodesByPrevious()
	{
		System.out.println("\nBY PREVIOUS");
		Node printNode = tail;
	    for (int i=0; i<length; i++)
	    {
	    	System.out.print(printNode.getData());
	    	printNode = printNode.getPrevious();
	    }
	}
	*/

} // END DoublyLinkedSortedList class