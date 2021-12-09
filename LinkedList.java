
package com.mycompany.hw4;
import java.util.NoSuchElementException;

/*

Author: Luis

Date: 04/24/21

Purpuse: To manipulate created Linked Lists from the main method.

*/

/*
 *  The class passed to E must implement Comparable interface.
 *  Therefore the item stored in a Node defines the compareTo method
 */

public class LinkedList<E extends Comparable<E>> {
    
    private Node head;
    private Node last;
    private int size;
    
    
    private class Node { // private inner class
        
        private E item;
        private Node next;
        private Node prev;

    private Node(E item) { //
	this.item = item;
	}
    }

	//**   Don't edit code above this statement --------------
	
	
	
	
	
	// Don't edit the code below this line ----------------------------------------------------------------
	
	/* Purpose: Displays the items from head to last 
	 * Parameters: No parameters
	 * Return:  Returns void
	 */
	public void display() {
		Node ptr = head;
		while (ptr != null) {
			System.out.println(ptr.item);
			ptr = ptr.next;
		}
	}

	/*
	 * Purpose: Remove the last Node in the linked list. Return the item stored in the
	 * removed Node object. Throw a NoSuchElementException if size = 0.
	 * Parameters: No parameters
	 * Return:  The item stored in the removed Node
	 */
	public E removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E tmp = last.item;
		if (size == 1) {
			head = last = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		size--;
		return tmp;
	}
	
	/*
	 * Purpose: Add a Node at the head containing the specified item.
	 * Parameters: The specified item that will be stored in the linked list
	 * Return: return void
	 */

	public void addFirst(E item) {
		Node node = new Node(item); // create the Node object
		if (head == null) { // if size = 0
			head = last = node; // size = 1
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++; // critical
	}

        /*
	 * Purpose: Determines if the specific item is contained in the linked list.
	 * Parameters: The specified item 
	 * Return: Return true if the item is stored in the linked list; otherwise return false
	 */

	public boolean contains(Object item) {
		boolean flag = false; // assume item is not in the Linked List

		Node ptr = head;
		while (ptr != null && !flag) {
			flag = equals(ptr.item, item);
			ptr = ptr.next; // advance to the next node in the linked list
		}

		return flag;
	}

	/*
	 * Purpose: Determine if the input parameters are equal.  The input arguments can 
	 * be equal to null.
	 * Parameters: Two Object values
	 * Return: Return true if the input arguments are equal; otherwise return false
	 */
	private boolean equals(Object target, Object src) {
		boolean flag = false;
		if (target == null) { 
			if (src == null) {
				flag = true; //
			} else { // src != null and target = null
				flag = false;
			}
		} else { // target != null
			flag = target.equals(src); // false if src is null target.equals(null) is false
		}
		return flag;
	}

	/*
	 * Purpose: Update the item at the specified index. Throws an
	 * exception if index is negative or greater than or equal to size.
	 * Parameters: The item that will be stored in the Node at the specified index.
	 * Return: Return the item previous stored in the Node at the specified index.
	 */
	public E set(int index, E item) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node ptr = head;
		for (int i = 0; i < index; i++) { // advance to node index
			ptr = ptr.next;
		}
		E tmp = ptr.item;
		ptr.item = item; // assign parameter to ptr.item
		return tmp;
	}

        /*
	 * Purpose: Retrieve the item in the Node at the specified index. Throws an
	 * exception if index is negative or greater than or equal to size.
	 * Parameters: The specified index.
	 * Return: Return the item stored in the Node at the specificied index.
	 */

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node ptr = head;
		for (int i = 0; i < index; i++) { // advance to node index
			ptr = ptr.next;
		}

		return ptr.item;
	}

	/*
	 * Purpose: Obtain the number of Node objects in the Linked List.
	 * Parameters: No parameters
	 * Return: Return the number of Node objects in the Linked List.
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Purpose: Add a Node object that contains the specified item at the end of
	 * the linked list.
	 * Parameters: The specified item.
	 * Return: Always returns true.
	 */

	public boolean add(E item) { 
		Node node = new Node(item); // create the Node object
		if (head == null) { // if size = 0
			head = last = node; // size = 1
		} else { // if size > 0
			last.next = node;
			node.prev = last;
			last = node;
		}
		size++; // increase size by 1
		return true;
	}
        
        /*
	 * Purpose: Remove the first Node in the linked list. Return the item stored in the removed Node object. Throw a NoSuchElementException if size = 0.
	 * Parameters: No parameters
	 * Return:  The item stored in the removed Node
	 */
        
        public E removeFirst() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            
            E tmp = head.item;
            
            if (size == 1) {
		last = head = null;
                } 
            
            else {
		head = head.next;
		head.prev = null;
            }
            
		size--;
		return tmp; 
        }
        
        /*
         * Purpose: Displays the items from last to head 
	 * Parameters: No parameters
	 * Return:  Returns void
	 */
        
        public void displayReverse() {
            Node ptr = last;
		while (ptr != null) {
			System.out.println(ptr.item);
			ptr = ptr.prev;
		}
        }
        
        /*
         * Purpose: Moves the items from head to last 
	 * Parameters: No parameters
	 * Return:  Returns void
	 */
        
        public void moveHeadToLast() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            
            E tmp = removeFirst();
            add(tmp);
        }
        
        /*
         * Purpose: Moves the items from last to head 
	 * Parameters: No parameters
	 * Return:  Returns void
	 */
        
        public void moveLastToHead() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            
            E tmp = removeLast();
            addFirst(tmp);
        }
        
        /*
         * Purpose: To obtain LinkedList object that contains every item in the current LinkedList that is greater than the item from the parameter 
	 * Parameters: The specified item.
	 * Return:  Returns the LinkedList object that follows the purpuse criteria.
	 */
        
        public LinkedList<E> greaterThan(E item) {
            LinkedList<E> tmp = new LinkedList<>();  // tmp.size = 0
            if (item != null) {
                Node ptr = head;
                while (ptr != null) {   // compare ptr to null
                    if (ptr.item.compareTo(item) > 0) {
                        tmp.add(ptr.item);
                        
                    }
                    ptr = ptr.next;  // advance ptr in every iteration.
                }
            }
            return tmp;
        }
        
        /*
         * Purpose: To obtain LinkedList object that contains every item in the current LinkedList that is less than the item from the parameter 
	 * Parameters: The specified item.
	 * Return:  Returns the LinkedList object that follows the purpuse criteria.
	 */
        
        public LinkedList<E> lessThan(E item) {
             LinkedList<E> tmp = new LinkedList<>();
             if (item == null) {
                size = 0;
            }
             else {
                Node ptr = head;
                while (ptr != head) {
                    if (ptr.item.compareTo(item) < 0) {
                        tmp.add(ptr.item);
                        ptr = ptr.next;
                    }
                }
            }
             return tmp;
        }
        
        /*
         * Purpose: Loop over every element in the parameter. The loop should stop if it determines that the method returns false. 
	 * Parameters: The specified LinkedList.
	 * Return:  Returns true if the list is is null. Returns true if every item contained in the parameter is also in the current LinkedList; otherwise it returns false.
	 */ 
        
        public boolean containsAll(LinkedList<E> list) {
            boolean flag = true;
            if (list == null) {
                flag = true;
            }
            else {
                Node ptr = list.head;
                while (ptr != null && flag) {
		flag = contains(ptr.item);
		ptr = ptr.next; 
                }
            }

            return flag;
        }
        
        /*
         * Purpose: Loop over every element in the parameter. The loop should stop if it determines that the method returns true. 
	 * Parameters: The specified LinkedList.
	 * Return:  Returns false if the list is is null. Returns true if at least one item contained in the parameter is also in the current LinkedList; otherwise it returns false.
	 */ 
        
        public boolean containsAtLeastOne(LinkedList<E> list) {
            boolean flag = false;
            if (list == null) {
                flag = false;
            }
            
            else {
                Node ptr = list.head;
                while (ptr != null && !flag) {
		flag = contains(ptr.item);
                ptr = ptr.next;
                }
            }

            return flag;
        }
            
            
}

