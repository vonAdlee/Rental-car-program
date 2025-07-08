package tax;

/**
 * Class inherits from Deduction class and calculates Quebec Pension Plan deduction.
 */

public class QuebecPensionPlan extends Deductions {

	double grossSalary;
	double deduction;

// Quebec Pension Plan rate.
	
	final double QPP_RATE = 0.108;
	
// Constructor.
	
	public QuebecPensionPlan(double grossSalary)
	{
		this.calculateTax(grossSalary);
	}

// Method for calculating Quebec Pension Plan deduction.
	
	void calculateTax(double grossSalary)
	{
		if(grossSalary >= 71300)
		{
			deduction = 7700.40;
		}
		
		else
		{
			deduction = grossSalary * QPP_RATE;
		}	
	}

// Method for returning Quebec Pension Plan deduction.
	
	public double getDeduction()
	{
		return deduction;
	}
	
	
	
	
}
