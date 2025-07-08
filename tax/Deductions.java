package tax;

/**
 * Abstract class for all tax deduction classes.
	It defines an abstract method that must be overridden by each tax deduction class.
 */

// Abstract class for other tax deduction classes.

public abstract class Deductions {

  abstract void calculateTax(double grossSalary);
  
}
