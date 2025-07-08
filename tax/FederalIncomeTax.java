package tax;

/**
 * Class inherits from Deduction class and calculates Federal Income Tax deduction.
 */

public class FederalIncomeTax extends Deductions {

	double grossSalary;
	double deduction;

// Federal Income Tax rates.
	
	final double RATE_15 = 0.15;
	final double RATE_205 = 0.205;
	final double RATE_26 = 0.26;
	final double RATE_29 = 0.29;
	final double RATE_33 = 0.33;
	
// Constructor.
	
	public FederalIncomeTax(double grossSalary)
	{
		this.calculateTax(grossSalary);
	}
	
// Method for calculating Federal Income Tax.
	
	void calculateTax(double grossSalary)
	{
		double firstTier = (57375 - 16129) * RATE_15;
		double secondTier = (114750 - 57376) * RATE_205;
		double thirdTier = (177882 - 114751) * RATE_26;
		double fourthTier = (253414 - 177883) * RATE_33;
		
		if(grossSalary < 16129)
		{
			deduction = 0;
		}
		
		else
			if(grossSalary >= 16129 && grossSalary <= 57375)
			{
				deduction = (grossSalary - 16129) * RATE_15;
			}
		
			else
				if(grossSalary > 57376 && grossSalary <= 114750)
				{
					deduction = ((grossSalary - 57376) * RATE_205) + firstTier;
				}
		
				else
					if(grossSalary > 114751 && grossSalary <= 177882)
					{
						deduction = ((grossSalary - 114751) * RATE_26) + firstTier + secondTier;
					}
		
					else
						if(grossSalary > 177883 && grossSalary <= 253414)
						{
							deduction = ((grossSalary - 177883) * RATE_29) + firstTier + secondTier + thirdTier;
						}
		
						else
							if(grossSalary > 253414)
							{
								deduction = ((grossSalary - 253414) * RATE_33) + firstTier + secondTier + thirdTier + fourthTier;
							}
	}
	
// Method for returning Federal Income Tax deduction.
	
	public double getDeduction()
	{
		return deduction;
	}
	
}
