package cs146F20.dang.project1;

public class CircularLinkedList {
	
	int size; 
	Node head = null;
	Node tail = null;
	
	// This method takes in n (number of prisoners) and k steps. Will return the winner's value. 
	public int eliminatePrisoners(int n, int k) {
		long startFindWinner = System.currentTimeMillis();
		long startMakeList = System.currentTimeMillis();
		
		// Create Prisoner Circular Linked List with size n
		for (int i = 1; i <= n; i++) {
			int val = i;
			insertNode(val);
		}
		
		long endMakeList = System.currentTimeMillis();
		System.out.println("Time to make linked list of size " + size + ": " + (endMakeList - startMakeList) + " ms");
		

		Node pointer1 = head;
		Node pointer2 = pointer1.next;
		
		while (size != 1) {
			
			// find the node to delete and store into pointer2
			for (int i = 1; i < k; i++) {
				pointer1 = pointer2;
				pointer2 = pointer2.next;
			}
			
			long startDeleteNode = System.currentTimeMillis();
			
			// node to delete is the head
			if (pointer2.equals(head)) {		
				head = pointer2.next;
				tail.next = pointer2.next;		
				
			// node to delete is the tail
			} else if (pointer2.equals(tail)) { 
				tail = pointer1;				// set pointer1 as the new tail
			}
			
			pointer1.next = pointer2.next;		// setting pointer1's new next (deleting pointer2)
			pointer1 = pointer2.next;			// new position for pointer1
			pointer2 = pointer2.next.next;		// new position for pointer2
			
			long endDeleteNode = System.currentTimeMillis();
			System.out.println("Time to delete a Node: " + (endDeleteNode - startDeleteNode) + " ms");
			
			// decrement the size of the list
			size--;

		}
		
		long endFindWinner = System.currentTimeMillis();
		System.out.println("To find winner: " + (endFindWinner - startFindWinner) + " ms \n");
		
		return head.value;
		
	}
	
	
	// Insert Node into LinkedList to the end of the list
	public void insertNode(int val) {
		size++;
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode; 
		} else {
			tail.next = newNode;
			tail = newNode; 			
			tail.next = head;
		}
	}
	
	
	public boolean isEmpty() {
		if (size == 0) 
			return true; 
		return false; 
	}
	

}
