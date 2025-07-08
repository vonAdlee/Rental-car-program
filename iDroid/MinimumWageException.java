package iDroid;

/**
	Class defines a minimum wage exception. 
 */

// Exception for wages under the legal amount which is $15.75.

public class MinimumWageException extends Exception
{
	
	public MinimumWageException()
	{
		super("Hourly wage is below the legal wage ($15.75)");
	}
	
	
	
}
