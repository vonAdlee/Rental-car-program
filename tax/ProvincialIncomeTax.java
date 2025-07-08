package tax;

/**
 * Class inherits from Deduction class and calculates Provincial Income Tax deduction.
 */

public class ProvincialIncomeTax extends Deductions {

	double deduction;
	
// Provincial Income Tax rates.
	
	final double RATE_14 = 0.14;
	final double RATE_19 = 0.19;
	final double RATE_24 = 0.24;
	final double RATE_2575 = 0.2575;
	
// Constructor.
	
	public ProvincialIncomeTax(double grossSalary)
	{
		this.calculateTax(grossSalary);
	}
	
// Method for calculating Provincial Income Tax.
	
	void calculateTax(double grossSalary)
	{
		double firstTier = (53255 - 18571) * RATE_14;
		double secondTier = (106495 - 53255) * RATE_19;
		double thirdTier = (129500 - 106495) * RATE_24;
		
		
		if(grossSalary > 18571 && grossSalary <= 53255)
		{
			deduction = (grossSalary - 18571) * RATE_14;
		}
		
		else
			if(grossSalary > 53255 && grossSalary <= 106495)
			{
				deduction = ((grossSalary - 53255) * RATE_19) + firstTier;
			}
		
			else
				if(grossSalary > 106495 &&  grossSalary <= 129590)
				{
					deduction = ((grossSalary - 106595) * RATE_24) + firstTier + secondTier;
				}
		
				else
					if(grossSalary > 129590)
					{
						deduction = ((grossSalary - 129590) * RATE_2575) + firstTier +secondTier + thirdTier;
					}
	}
	
// Method for returning the Provincial Income Tax deduction.
	
	public double getDeduction()
	{
		return deduction;
	}
	
	
	
	
}
