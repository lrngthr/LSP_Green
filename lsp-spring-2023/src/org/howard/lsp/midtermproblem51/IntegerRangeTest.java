package org.howard.lsp.midtermproblem51;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.howard.edu.lsp.assignment4.IntegerSetException;
import org.howard.edu.lsp.assignment5.IntegerSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerRangeTest {
	
	private Range range;
	private Range other_range;
	private Range new_range;
	private Range null_range;
	
	
	
	@BeforeEach
	void setUp() {
		range = new IntegerRange(1, 100);
		other_range = new IntegerRange(20, 40);
		new_range = new IntegerRange(1000,2000);
		null_range = null;
	}

	@Test
	@DisplayName("Testing Contains Method")
	public void testContains() {
		assertTrue("Testing if a range contains a value", range.contains(15));
		assertTrue("Testing if a range contains a value", range.contains(100));
		assertFalse("Testing if a range does not contain a value", range.contains(200));
		assertTrue("Testin if a range contains a value", other_range.contains(25));
		assertTrue("Testing if a range contains a value", other_range.contains(21));
		assertFalse("Testing if a range does not contain a value", other_range.contains(100));
		
	}
	
	@Test
	@DisplayName("Testing Overlaps Method")
	public void testOverlaps() throws EmptyRangeException {
		
		EmptyRangeException message = assertThrows(EmptyRangeException.class, () -> {other_range.overlaps(null_range);});
		assertTrue("Testing IntegerSetException on empty sets", message.getMessage().contentEquals("The range is empty"));
		assertTrue("Testing overlapping of two ranges", other_range.overlaps(range));
		assertFalse("Testing overlapping of two ranges", other_range.overlaps(new_range));
		
		
		
		
	}
	
	@Test
	@DisplayName("Testing Size Method")
	public void testSize() {
		assertEquals("Testing size of a range", range.size(),100);
		assertEquals("Testing size of a range", other_range.size(),21);
	}
}
