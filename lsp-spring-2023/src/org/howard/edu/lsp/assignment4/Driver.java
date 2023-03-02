package org.howard.edu.lsp.assignment4;

/**
 * 
 * @author Lauren Guthrie
 * Test cases for functions within IntegerSet Class
 */
public class Driver {
	
	/**
	 * Test cases for functions within IntegerSet Class
	 * @param args
	 * @throws IntegerSetException
	 */
	public static void main(String[] args) throws IntegerSetException {
		
		IntegerSet first_set = new IntegerSet();
		
		System.out.println("Testing Set Manipulation:");
		// Adding to the set
		first_set.add(1);
		first_set.add(2);
		first_set.add(3);
		first_set.add(4);
		first_set.add(5);
		
		System.out.println("\ntoString Test");
		System.out.println("The set is: " + first_set.toString());
		
		// Removing from the set
		System.out.println("\nRemove Test");
		first_set.remove(4);
		System.out.println("The set after removal of 4 is: " + first_set.toString());
		
		//Length of set
		System.out.println("\nLength Test");
		System.out.println("The length is " +first_set.length() + "\n");
		
		//Searching for Values in the Set
		System.out.println("Testing Searching For Values:");
		System.out.println("Does this set contain 3?: " + String.valueOf(first_set.contains(3)));
		System.out.println("Does this set contain 10?: " + String.valueOf(first_set.contains(10)));
		
		// Largest and Smallest Values
		System.out.println("\nLargest and Smallest Values Test");
		System.out.println("The largest value is: " + first_set.largest());
		System.out.println("The smallest value is: " + first_set.smallest()+ "\n");
		
		
		System.out.println("Testing Comparing and Manipulating Sets:");
		
		IntegerSet second_equal_set = new IntegerSet();
		IntegerSet third_set = new IntegerSet();
				
		second_equal_set.add(1);
		second_equal_set.add(2);
		second_equal_set.add(3);
		second_equal_set.add(5);
		
		third_set.add(1);
		third_set.add(10);
		third_set.add(3);
		third_set.add(5);
		
		//Checking if the sets are equal
		System.out.println("\nEqual Test");
		System.out.println("Are set one and set two equal? " + String.valueOf(first_set.equals(second_equal_set)));
		System.out.println("Are set one and set two equal? " + String.valueOf(first_set.equals(third_set)));
		
		
		
		//Union Sets 
		System.out.println("\nUnion Test");
		first_set.union(third_set);
		System.out.println("The union of set one and two is: " + first_set.toString());
		System.out.println("The union of set two and three is: " + second_equal_set.toString());
		
		//Intersections of Sets
		System.out.println("\nIntersect Test");
		third_set.intersect(first_set);
		first_set.intersect(second_equal_set);
		System.out.println("The intersection of set three and one is: " + third_set.toString());
		System.out.println("The intersection of set one and two is: " + first_set.toString());
						
		//Difference of sets 
		System.out.println("\nDiff Test");
		System.out.println("Difference in sets one and three: " + first_set.diff(third_set));
		System.out.println("Difference in sets one and two: " + first_set.diff(second_equal_set));
		
		//Clearing Set
		System.out.println("\nClear Test");
		second_equal_set.clear();
		System.out.println("Clearing Set 2: " + second_equal_set.toString());
		
		System.out.println("\nisEmpty Test");
		System.out.println("Is set 2 empty?: " + second_equal_set.isEmpty());
		
		
	
		
		
		
		
		
		
		
		
	}

}
