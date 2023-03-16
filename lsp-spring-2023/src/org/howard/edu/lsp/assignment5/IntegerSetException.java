package org.howard.edu.lsp.assignment5;


/**
 * 
 * Returns a unique string message if the exception of a function is met
 */
@SuppressWarnings("serial")
public class IntegerSetException extends Exception{
	/**
	 *Shows a string message of the exception
	 * @param message : unique message about the exception met
	 */
	public IntegerSetException(String message)
	{
		super(message);
	}
}
