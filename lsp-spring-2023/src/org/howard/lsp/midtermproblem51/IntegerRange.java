package org.howard.lsp.midtermproblem51;

public class IntegerRange implements Range{
	private int lower;
   	private int upper;

	// Hint: implement getters for lower and upper
   	public int getLower() {
   		return lower;
   	}
   	
   	public int getUpper() {
   		return upper;
   	}

   	 IntegerRange(int lower, int upper) { 	// Constructor
        		this.lower = lower;
        		this.upper = upper;
   	 }
	public boolean contains(int value) {
		return value >= lower && value <= upper;
	}
	
public boolean overlaps(Range other) throws EmptyRangeException {

		if (other == null) {
			throw new EmptyRangeException("The range is empty");
		}
		
		int other_lower = other.getLower();
		int other_upper = other.getUpper();
		if (other_lower <= lower && other_upper >= upper) {
			return true;
		}
		else {return false;}
	}

public int size()  {
		return upper - lower +1;
	}

}
