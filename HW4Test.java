package com.mycompany.hw4;
import java.util.NoSuchElementException;

/**
 *
 * @author Luis Reynoso
 */
public class HW4Test {
    // Displays the contents of a LinkedList from head to last and last to head
	public static void displayLinkedList(LinkedList<?> lst){
		
		System.out.println("Display from 1st to last: ");
		lst.display();
		System.out.println("\nDisplay from last to first: ");
		lst.displayReverse();
	}

	public static void main(String[] args) {
		
		
		LinkedList<String> list = new LinkedList<>();
		try {
			list.moveLastToHead();
		}
		catch(NoSuchElementException n) {
			System.out.println("empty list: can't move last to head");
		}
		
		try {
			list.moveHeadToLast();
		}
		catch(NoSuchElementException n) {
			System.out.println("empty list: can't move head to last");
		}
		
		try {
			list.removeFirst();
		}
		catch(NoSuchElementException n) {
			System.out.println("empty list: can't removeFirst");
		}
		
		list.add("cat");
		list.add("dog");
		list.add("zebra");
		System.out.println("\nDisplay after adding items to the LinkedList:");
		displayLinkedList(list);
		
		System.out.println("\nTest moveLastToHead:");
		list.moveLastToHead();
		displayLinkedList(list);
		
		System.out.println("\nTest moveHeadToLast:");
		list.moveHeadToLast();
		displayLinkedList(list);
		
		System.out.println("\nTest removedFirst:");
		System.out.println("Removed item: " + list.removeFirst());
		displayLinkedList(list);
		
		String[] arr = {"flower", "ballon", "pour", "great", "ten", "hello", "ess",
				        "under", "na", "names", "is", "to", "too"};
                for (String s:arr) {
			list.add(s);
		}
		System.out.println("\nDisplay after adding items to the LinkedList:");
		displayLinkedList(list);
		
		LinkedList<String> tmp = new LinkedList<>();
		tmp.add("a");
		tmp.add("b");
		System.out.println("\nTest containsAtLeastOne:");
		if (list.containsAtLeastOne(tmp)) {   //false
			System.out.println("list and tmp contain at least one common element");
		}
		else {
			System.out.println("list and tmp do not contain common elements");
		}
	
		tmp.add(new String("na"));
		if (list.containsAtLeastOne(tmp)) {  //true
			System.out.println("list and tmp contain at least one common element");
		}
		else {
			System.out.println("list and tmp do not contain common elements");
		}
		
		tmp = null;
		if (list.containsAtLeastOne(tmp)) { //false
			System.out.println("list and tmp contain at least one common element");
		}
		else {
			System.out.println("list and tmp do not contain common elements");
		}
		tmp = new LinkedList<>(); // size = 0
		if (list.containsAtLeastOne(tmp)) {  //false
			System.out.println("list and tmp contain at least one common element");
		}
		else {
			System.out.println("list and tmp do not contain common elements");
		}
		
		tmp = new LinkedList<>();
		tmp.add(new String("is"));
		tmp.add(new String("ballon"));
		tmp.add(new String("hello"));
		
		System.out.println("\nTest containsAll");
		if (list.containsAll(tmp)) {
			System.out.println("Every element of tmp is contained in list");
		}
		else {
			System.out.println("tmp contains an element that is not in list");
		}
	
		tmp.add(new String("34"));
		if (list.containsAll(tmp)) {    //false
			System.out.println("Every element of tmp is contained in list");
		}
		else {
			System.out.println("tmp contains an element that is not in list");
		}
		
		tmp = null;
		if (list.containsAll(tmp)) {//true
			System.out.println("Every element of tmp is contained in list");
		}
		else {
			System.out.println("tmp contains an element that is not in list");
		}
		
		tmp = new LinkedList<>(); // size = 0
		if (list.containsAll(tmp)) {  //true
			System.out.println("Every element of tmp is contained in list");
		}
		else {
			System.out.println("tmp contains an element that is not in list");
		}
                System.out.println("\nTest lessThan");
		System.out.println("If argument = null the size of list.lessThan(null) = " + list.lessThan(null).size());
		System.out.println("\nContents of list.lessThan(\"m\"): ");
		list.lessThan("m").display();
		
		System.out.println("\nTest greaterThan");
		System.out.println("If argument = null the size of list.greaterThan(null) = " + list.greaterThan(null).size());
		System.out.println("\nContents of list.greaterThan(\"m\"): ");
		list.greaterThan("m").display();
		
		

	}
}
