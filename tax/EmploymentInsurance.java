package tax;

/**
 * Class inherits from Deduction class and calculates employment insurance deduction.
 */

public class EmploymentInsurance extends Deductions{
	
	
	final double EI_RATE = 0.0164;
	double deduction;
	

// Constructor.
	
	public EmploymentInsurance(double grossSalary)
	{
		this.calculateTax(grossSalary);
	}
	

// method for calculating Employment Insurance deduction.
	
	void calculateTax(double grossSalary)
	{ 
		if(grossSalary >=65700)
		{
			deduction = 1077.48;
		}
		
		else
		{
				
			deduction = grossSalary * EI_RATE;
		}
	}
	 
// method for returning Employment Insurance deduction.
	
	 public double getDeduction()
	 {
		 return deduction;
	 }
	 
	
	 
	 
}
