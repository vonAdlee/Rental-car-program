package tax;

/**
 * Class inherits from Deduction class and calculates Quebec Parental Insurance Plan deduction.
 */

public class QuebecParentalInsurancePlan extends Deductions {
	
	double deduction;
	
// Quebec Parental Insurance Plan rate.
	
	final double  QPIP_RATE = 0.00494;
	
// Constructor.
	
	public QuebecParentalInsurancePlan(double grossSalary)
	{
		this.calculateTax(grossSalary);
	}

// Method for calculating Quebec Parental Insurance Plan deduction.
	
	void calculateTax(double grossSalary)
	{
		if(grossSalary >= 98000)
		{
			deduction = 484.12;
		}
		
		else
		{
			deduction = grossSalary * QPIP_RATE;
		}
	}
	
// Method for returning Quebec Parental Insurance Plan deduction.
	
	public double getDeduction()
	{
		return deduction;
	}
}
