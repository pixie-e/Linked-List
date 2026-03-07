
public interface DoublyLinkedSortedListInterface<T>
{
	//Return a reference to the first Node in the list
	public Node<T> getFirst();
	
	//Return a reference to the last Node in the list
	public Node<T> getLast();
	
	//Remove the Node that has toRemove as its value
	public Node<T> remove(T toRemove);
	
	//Insert a new Node with the given newValue into the list in order.
	public void insert(T newValue);
	
	//Return the entire list as a multi-line String
	public String toString();
}