public class Node<T>
{
	private T value = null;
	private Node<T> head = null;
	private Node<T> tail = null;

	public Node(T value)
	{
		this.value = value;
		this.head = head;
		this.tail = tail;
	}

	public T getValue() { return value; }
	public void setNext(Node<T> next) { this.head = next; } 
	public Node<T> getNext() { return head; }	
	public boolean hasNext() { return head != null; }
	public void setPrevious(Node<T> previous) { this.tail = previous; } 
	public Node<T> getPrevious() { return tail; }	
	public boolean hasPrevious() { return tail != null; }
} // END Node class