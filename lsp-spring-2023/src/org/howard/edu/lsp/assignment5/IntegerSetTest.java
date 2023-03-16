package org.howard.edu.lsp.assignment5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
	private IntegerSet integerSet;
	private IntegerSet integerSet2;
	
	
	@BeforeEach
	void setUp() {
		integerSet = new IntegerSet();
		integerSet2 = new IntegerSet();
	}
	
	@Test
	@DisplayName("Testing Clear Method")
	public void testClear() {
		integerSet.clear();
		assertEquals("Testing clearing an empty set",integerSet.length(), 0);
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		integerSet.add(4);
		integerSet.clear();
		assertEquals("Testing clearing a set",integerSet.length(), 0);
	}
	
	
	@Test
	@DisplayName("Testing Length Method")
	public void testLength() {
		assertEquals("Testing length of an empty set", integerSet.length(),0);
		integerSet.add(1);
		integerSet.add(2);
		assertEquals("Testing length of a set", integerSet.length(),2);
		integerSet.add(3);
		integerSet.add(4);
		assertEquals("Testing length of a larger set", integerSet.length(),4);
		
	}
	
	@Test
	@DisplayName("Testing Equal Method")
	public void testEquals() {
		integerSet.add(1);
		integerSet.add(2);
		integerSet2.add(1);
		integerSet2.add(2);
		assertTrue("Testing two sets are equal", integerSet.equals(integerSet2));
		integerSet.add(5);
		assertFalse("Testing two sets are not equal", integerSet.equals(integerSet2));
	}
	
	@Test
	@DisplayName("Testing Contains Method")
	public void testContains() {
		assertFalse("Testing on an empty set", integerSet.contains(1));
		integerSet.add(1);
		integerSet.add(2);
		assertTrue("Testing if a set contains a given value", integerSet.contains(1));
		assertFalse("Testing if a set does not contain a given value", integerSet.contains(5));
	}
	
	@Test
	@DisplayName("Testing Largest Method")
	public void testLargest() throws IntegerSetException {
		IntegerSetException message = assertThrows(IntegerSetException.class, () -> {integerSet.largest();});
		assertTrue("Testing IntegerSetException on empty sets", message.getMessage().contentEquals("The intergerSet is empty"));
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(6);
		integerSet.add(10);
		assertEquals("Testing finding the largest value", integerSet.largest(), 10);
		integerSet.add(22);
		integerSet.add(24);
		integerSet.add(18);
		assertEquals("Testing finding the largest value", integerSet.largest(), 24);
	}
	
	@Test
	@DisplayName("Testing Smallest Method")
	public void testSmallest() throws IntegerSetException {
		IntegerSetException message = assertThrows(IntegerSetException.class, () -> {integerSet.smallest();});
		assertTrue("Testing IntegerSetException on empty sets", message.getMessage().contentEquals("The intergerSet is empty"));
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(6);
		integerSet.add(10);
		assertEquals("Testing finding the smallest value", integerSet.smallest(), 1);
		integerSet.add(-3);
		integerSet.add(24);
		integerSet.add(18);
		assertEquals("Testing finding the smallest value of negative number", integerSet.smallest(), -3);
	}
	
	@Test
	@DisplayName("Testing Add Method")
	public void testAdd() {
		assertEquals("Testing an empty set", integerSet.ToString().toString(), "[]");
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		assertEquals("Testing if values are added to a set", integerSet.ToString().toString(), "[1, 2, 3]");
		integerSet.add(4);
		assertEquals("Testing if values are added to a set", integerSet.ToString().toString(), "[1, 2, 3, 4]");
	}
	
	@Test
	@DisplayName("Testing Remove Method")
	public void testRemove() {
		integerSet.remove(3);
		assertEquals("Testing removing from an empty set", integerSet.ToString().toString(), "[]");
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		integerSet.remove(3);
		assertEquals("Testing if values are removes from a set", integerSet.ToString().toString(), "[1, 2]");
		integerSet.remove(1);
		assertEquals("Testing if values are removed from a set", integerSet.ToString().toString(), "[2]");
	}
	
	@Test
	@DisplayName("Testing Union Method")
	public void testUnion() {
		integerSet.union(integerSet2);
		assertEquals("Testing the union of two empty sets", integerSet.ToString(), "[]");
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		integerSet.union(integerSet2);
		assertEquals("Testing the union of one empty sets", integerSet.ToString(), "[1, 2, 3]");
		integerSet2.add(4);
		integerSet2.add(5);
		integerSet2.add(6);
		integerSet.union(integerSet2);
		assertEquals("Testing the union of two sets", integerSet.length(), 6);
		assertEquals("Testing the union of two sets", integerSet.ToString(), "[1, 2, 3, 4, 5, 6]");
	}
	
	@Test
	@DisplayName("Testing Intersection Method")
	public void testIntersection() {
		integerSet.intersect(integerSet2);
		assertEquals("Testing the intersection of two empty sets", integerSet.ToString(), "[]");
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		integerSet2.add(1);
		integerSet2.add(2);
		integerSet2.add(6);
		integerSet.intersect(integerSet2);
		assertEquals("Testing the intersection of two sets", integerSet.ToString(), "[1, 2]");
	}
	
	@Test
	@DisplayName("Testing Difference Method")
	public void testDifference() {
		assertEquals("Testing the difference of two empty sets", integerSet.diff(integerSet2), 0);
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		integerSet2.add(1);
		integerSet2.add(2);
		integerSet2.add(6);
		assertEquals("Testing the difference of two empty sets", integerSet.diff(integerSet2), -3);
		assertEquals("Testing the difference of two empty sets", integerSet2.diff(integerSet), 3);
		
	}
	
	@Test
	@DisplayName("Testing IsEmpty Method")
	public void testIsEmpty() {
		assertTrue("Testing IsEmpty on an empty set", integerSet.isEmpty());
		integerSet.add(1);
		assertFalse("Testing IsEmpty on a nonempty set", integerSet.isEmpty());
		integerSet.clear();
		assertTrue("Testing IsEmpty after clearing a set", integerSet.isEmpty());
		
	}
	
	@Test
	@DisplayName("Testing ToString Method")
	public void testToString() {
		assertEquals("Testing converting empty set to String", integerSet.ToString(), "[]");
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		assertEquals("Testing converting set to String", integerSet.ToString(), "[1, 2, 3]");
		integerSet.add(10);
		integerSet.add(20);
		integerSet.add(60);
		assertEquals("Testing converting set to String", integerSet.ToString(), "[1, 2, 3, 10, 20, 60]");
	}
	
	
}
