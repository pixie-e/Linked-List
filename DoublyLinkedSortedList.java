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
	}

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
				// add the new object of the row of data into an array list
				insert(temp); // array list contained in
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
	}

	//Return a reference to the first Node in the list
	public Node getFirst()
	{
		/*
		if (this == null)
			return null;
		Node<T> current = this.getData();
		//i think this won't work because the first inserted refers to itself as head. it is not null
		while (current.hasPrevious())
		{
			current = current.getPrevious();
		}
		return current; //placeholder setup
		*/
		return null; //placeholder setup
	} // END getFirst method
	
	//Return a reference to the last Node in the list
	public Node getLast()
	{
		/*
		Node<T> current = this.getData();
		while (current.hasNext())
		{
			current = current.getNext();
		}
		return current; //placeholder setup
		*/
		return null; //placeholder setup
	} // END getLast method
	
	//Remove the Node that has toRemove as its value
	public Node remove(HurricaneRowData toRemove)
	{
		return null; //placeholder setup
	} // END remove method
	
	//Insert a new Node with the given newValue into the list in order.
	public void insert(HurricaneRowData dataToInsert)
	{
		Node toInsert = new Node(dataToInsert);
		//CORNER CASE: List is empty; start with the first insertion
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
	    //CASE that head/tail is only item in list, and toInsert was
	    //already checked and failed for greater ACE, make toInsert as new tail
	    else if (!head.hasNext())
	    {
	    	head.setNext(toInsert);
	    	toInsert.setPrevious(head);
	    	//System.out.println(toInsert.getData());
	    	tail = toInsert;
	    	length++;
	    	return;
	    }
	    Node currentNode = head;
	    while (currentNode.hasNext())
	    {
	    	//System.out.println("loop entered");
	    	//currentNode = currentNode.getNext();
	    	if (toInsert.getData().getAceValue() == currentNode.getData().getAceValue())
	    	{
	    		//should be safe as loop would not enter if there were no next
	    		Node afterNode = currentNode.getNext();
	    		toInsert.setNext(afterNode);
	    		toInsert.setPrevious(currentNode);
	    		afterNode.setPrevious(toInsert);
	    		currentNode.setNext(toInsert);
	    		length++;
	    		return;
	    	}
	    	else if (toInsert.getData().getAceValue() > currentNode.getData().getAceValue())
	    	{	
	    		Node beforeNode = currentNode.getPrevious();
	    		toInsert.setPrevious(beforeNode);
	    		toInsert.setNext(currentNode);
	    		beforeNode.setNext(toInsert);
	    		currentNode.setPrevious(toInsert);
	    		length++;
	    		//System.out.println("Loop + "+currentNode.getData());
	    		//currentNode = tail; //skip to tail to exit loop
	    							//(tail has no next)
	    		return;
	    	}
	    	currentNode = currentNode.getNext();
	    }
	    tail.setNext(toInsert);
	    toInsert.setPrevious(tail);
	    tail = toInsert;
	    length++;
	   // System.out.println(tail.getData());

	    
		
		//incomplete pseudocode. You need to finish it and make sure it is solid
		// DO NOT ASSUME THIS IS CORRECT YET
		//compare ace of newValue to ace of FIRST IN LIST
		// if new > head, insert new as first's head and first is new's tail
		// 								else if new < first (and list only contains first), insert new as first's head
		// ( new < current node) WHILE current node hasNext , 
		// iterate through list and compare new to this node
		// if and until new > this node then insert new as this node's head and this node is new's tail
		// otherwise new is never more than an item already in the list, insert it at the very end
		//int newAce = newValue.getAceValue();

		
	} // END insert method
	
	//Return the entire list as a multi-line String
	@Override
	public String toString()
	{
		return "placeholder";

		/* 3/5/26 live demo
		@Override
		public String toString()
		{
			String s = "";
			// if empty
			if (head == null)
				return s;
			//otherwise not empty
			Node n = head;
			s += n.toString();
			while (n.hasNext)
			{
				n = n.getNext();
				s += n.toString();
			}
			

			return s;
		}
		*/
	} // END toString method

	/* Extras for if you want to include a list length counter 
	//TAKEN FROM 5400_singly_linked_list
	public int getLength()
	{
		//checking it isn't length 0/null
		if(start == null)
			return 0;
		// like getLast but counts up all the nexts until reaches end
		Node<T> current = start;
		int count = 1;
		while(current.hasNext()){
			current = current.getNext();
			count++;
		}
		return count;
	}

	//TAKEN FROM 5400_singly_linked_list_SKIP THIS
	// like a line, first person says "i'm 1", next person says
	// i'm next, I take your 1 and add mine, and onwards
	//(i see your two, add one for me, now i'm 3)
	public int getLength()
	{
		if(data == null)
		{
			return 0;
		}
		if(!hasNext())
		{
			return 1;
		}
		return 1 + next.getLength();
	}
	*/

	public void printNodesByNext()
	{
		Node printNode = head;
	    for (int i=0; i<length; i++)
	    {
	    	System.out.println(printNode.getData());
	    	printNode = printNode.getNext();
	    }
	}
	public void printNodesByPrevious()
	{
		Node printNode = tail;
	    for (int i=0; i<length; i++)
	    {
	    	System.out.println(printNode.getData());
	    	printNode = printNode.getPrevious();
	    }
	}

} // END DoublyLinkedSortedList class