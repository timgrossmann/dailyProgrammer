package toDoList;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ToDoList implements Serializable {

	//Recognize ID
	private static final long serialVersionUID = 1L;
	
	// Vars
	private LinkedList<String> toDoList;

	// ----------------------------------------------
	// Constructors
	public ToDoList() {
		toDoList = new LinkedList<String>();
	}

	public ToDoList(String... toDos) {
		toDoList = new LinkedList<String>(Arrays.asList(toDos));
	}

	// ----------------------------------------------
	// Methods

	/**
	 * Adding Items... Undefined Number of Items
	 * 
	 * @param toAdd
	 */
	public void addItems(String... toAdd) {
		for (String add : toAdd) {
			toDoList.add(add);
		}
	}

	/**
	 * Printing out the toDo List
	 */
	public void print() {
		for (String item : toDoList) {
			System.out.println(item);
		}
	}

	/**
	 * Removes Items... Undefined number of Items
	 * 
	 * @param items
	 */
	public void removeItem(String item) {
		
		String[] itemStrings = item.split(" ");
		
		int[] items = new int[itemStrings.length]; 
		
		for(int i = 0; i < itemStrings.length; i++) {
			try{
				items[i] = Integer.parseInt(itemStrings[i]);
			} catch(NumberFormatException e) {
				System.err.println("Please use valid Numbers!");
				break;
			}
		}
		
		for (int i = 1; i <= items.length; i++) {
			if (items[i - 1] > 0) {
				if (items[i - 1] < toDoList.size()) {
					toDoList.remove(items[i - 1] - i);
				} else {
					toDoList.removeLast();
				}
			}
		}
	}
	
	/**
	 * Sorting the List Alphabetic
	 */
	public void sort() {
		Collections.sort(toDoList);
	}
	
	/**
	 * Shuffling the List randomly
	 */
	public void shuffle() {
		Collections.shuffle(toDoList);
	}
	
	public void updateItem(String old, String updated) {
		if(toDoList.contains(old)) {
			toDoList.set(toDoList.indexOf(old), updated);
		}else {
			System.out.println("Item not found!");
		}
	}
	
	/**
	 * Clears the list
	 */
	public void clearList() {
		toDoList.clear();
	}
	
	

}
