/**
 * Assignment 8: Linked List (Hurricane Data)
 * @author Elysium "Pixie" Jones
 * 3/8/26
 * 
 * Instructions: use a Node (aka link) class with methods such as:
 * getValue, hasNext, setNext, getNext, hasPrevious, setPrevious,
 * getPrevious, and possibly toString.
 * 
 * Source(s):
 * Original Hurricane Data: N/A - DoublyLinkedSortedList was not in original
 * Linked List Hurricane Data:
 * 
 * Notes: 
 */
public class Node
{
	
	private HurricaneRowData data;
	private Node next = null;
	private Node prev = null;

	public Node(HurricaneRowData data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public HurricaneRowData getData() { return this.data; }
	public void setNext(Node next) { this.next = next; } 
	public Node getNext() { return next; }	
	public boolean hasNext() { return next != null; }
	public void setPrevious(Node prev) { this.prev = prev; } 
	public Node getPrevious() { return prev; }	
	public boolean hasPrevious() { return prev != null; }
} // END Node class