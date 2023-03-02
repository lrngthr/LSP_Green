package org.howard.edu.lsp.assignment4;
import java.util.*;


/**
 * Public class with multiple functions for creating and manipulating sets
 * @author Lauren Guthrie
 *
 */
public class IntegerSet {
	
	/**
	 * ArrayList Object containing the values in IntegerSet
	 */
	private ArrayList<Integer> set = new ArrayList<Integer>();

	/**
	 * Default Constructor for IntegerSet
	 */
	public IntegerSet() {};

	/**
	 * Clears all values within a set
	 */
	public void clear() {set.clear();};
	
	/**
	 * Finds the length of a given set.
	 * @return int value of the length of the set
	 */
	public int length() {return set.size();}; // returns the length
	
	/**
	 * Determines if two IntegerSets are equal
	 * @param b IntegetSet
	 * @return boolean value of whether the sets are equal
	 */
	public boolean equals(IntegerSet b) {
		Boolean is_equal= true;
		if(set.size()!= b.set.size()) {
			return false;
		}
		
		for(int i: b.set) {
			if(!set.contains(i)) {
				is_equal = false;
			}
		}
		return is_equal;
	}; 
	
	/**
	 * Searches a set for a given value and determines if the set contains the value
	 * @param value int value of integer to search for
	 * @return boolean value if the set contains the given value
	 */
	public boolean contains(int value) {
		for(int i: set){
			if(i == value){
				return true;
			}
		}
		return false;
		}; 
	
	/**
	 * Finds the largest value in a given set
	 * @return max_num: integer value of the max value in the set
	 * @throws IntegerSetException String message if the given set is empty
	 */
	public int largest() throws IntegerSetException{
		Integer max_num = Integer.MIN_VALUE;
		if(set.size() == 0){
			throw new IntegerSetException("The intergerSet is empty");
		}
		
		for(int i:set) {
			if(i > max_num){
				max_num = i;
			}
		}
		return max_num;
	}; 
	
	/**
	 * Finds the smallest value in a given set
	 * @return min_num: integer value of the minimum value in a set
	 * @throws IntegerSetException String message if the given set is empty
	 */
	public int smallest() throws IntegerSetException {
		Integer min_num = Integer.MAX_VALUE;
		if(set.size() == 0){
			throw new IntegerSetException("The intergerSet is empty");
		}
		
		for(int i:set) {
			if(i < min_num){
				min_num = i;
			}
		}
		return min_num;
	};
	
	/**
	 * Adds a given value to a set and does nothing if it already exists within the set
	 * @param item: integer value to be added to the set
	 */
	 public void add(int item) {
		 if(!set.contains(item)) {
			 set.add((item));
		 }
	 }; 
	 
	/**
	 * Removes a given value from the set
	 * @param item: integer value to remove from a set
	 */
	public void remove(int item) {
		if(set.contains(item)) {
			set.remove(set.indexOf(item));
		}
	}; 
	
	/**
	 * Determines the union of two IntegerSets
	 * @param intSetb: IntegerSet to be combined with the given set
	 */
	public void union(IntegerSet intSetb) {
		for(int i: intSetb.set) {
			if(!set.contains(i)) {
				set.add(i);
			}
		}
	};
	
	/**
	 * Finds the intersection between two IntegerSets
	 * @param intSetb: IntegerSet to intersect with the given set
	 */
	public void intersect(IntegerSet intSetb) {
		this.set.retainAll(intSetb.set);
		Object[] intersection = this.set.toArray();
		this.clear();
		
		for(Object i: intersection) {
			this.add((int) i);
		}
		
	};
	
	/**
	 * Sums each value within the first and second Integer Sets and calculates the difference
	 * @param intSetb Second Integer Set
	 * @return The difference between the first and second integer set.
	 */
	public int diff(IntegerSet intSetb) {
		int set_one_size = 0;
		int set_two_size = 0;
		for(int i: set) {
			set_one_size +=i;
		}
		for(int i: intSetb.set) {
			set_two_size += i;
		}
		return set_one_size - set_two_size;
	}; 
	
	/**
	 * Determines if a set is empty
	 * @return is_empty: boolean value determining if the set is empty
	 */
	boolean isEmpty() {
		boolean is_empty = false;
		if(set.size()==0) {
			is_empty = true;
		}
		return is_empty;
	}; 
	
	/**
	 * Creates the string representation of a given set
	 * @return string_rep: String representation of the set
	 */
	public String toString() {
		String string_rep = "";
		for(int i:set) {
			string_rep += String.valueOf(i) + " ";
		}
		return string_rep;
	};


}
/**
 * 
 * Returns a unique string message if the exception of a function is met
 */
@SuppressWarnings("serial")
class IntegerSetException extends Exception{
	/**
	 *Shows a string message of the exception
	 * @param message : unique message about the exception met
	 */
	public IntegerSetException(String message)
	{
		super(message);
	}
}
