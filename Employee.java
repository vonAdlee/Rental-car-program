package iDroid;

/**
 	*Class Employee created an employee object.
 	
 	*An employee contains an employee number , first and last name , worked hours and hourly wage.
 	
 	*An exception is thrown if the hourly wage is below the legal wage which is $15.75/hour.
 	
 	*Gross salary is calculated in the creating of the employee object.
 	
 	*The class contains accessors and mutators, toString and equals methods.
 	
 */


public class Employee {

// Employees' attributes.
	
	long employeeNumber;
	String firstName;
	String lastName;
	double hoursWorked;
	double hourlyWage;
	
	final int WEEKS_PER_YEAR = 52;
	double grossSalary;
	
	
// Employee constructor.
	
	public Employee(long employeeNumber , String firstName , String lastName , double hoursWorked , double hourlyWage) throws MinimumWageException
	{
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = hoursWorked;
		
		if(hourlyWage < 15.75)
		{
			throw new MinimumWageException();
		}
		
		else
		{
			this.hourlyWage = hourlyWage;
		}
		
		
		this.grossSalary  = hoursWorked * hourlyWage * WEEKS_PER_YEAR;
	}
	
	
// Default constructor.
	
	public Employee() throws MinimumWageException
	{
		this(0000 , "unknown" , "unknown" , 0.0 , 15.75);
	}
	
	
// Copy constructor
	
	public Employee(Employee employee) throws MinimumWageException
	{
		this(employee.employeeNumber, employee.firstName , employee.lastName , employee.hoursWorked , employee.hourlyWage);
	}
	

// Accessors.
	
	public long getEmployeeNumber()
	{
		return employeeNumber;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public double getHoursWorked()
	{
		return hoursWorked;
	}
	
	public double getHourlyWage()
	{
		return hourlyWage;
	}
	
	public double getGrossSalary()
	{
		return grossSalary;
	}
	
	
// Mutators.
	
	public void setEmployeeNumber(long employeeNumber)
	{
		this.employeeNumber = employeeNumber;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setHoursWorked(double hoursWorked)
	{
		this.hoursWorked = hoursWorked;
	}
	
	public void setHourlyWage(double hourlyWage)
	{
		this.hourlyWage = hourlyWage;
	}
	
	
// toString method.
	
	@Override
	
	public String toString()
	{
		return("Employee Number: " + employeeNumber +"\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nHours Worked: " 
	+ hoursWorked + "\nHourly Wage: " + hourlyWage + "\n\n" );
	}

	
// Equals method. (Two employees are equal if they have the same employee number , first name and last name.)
	
	@Override
	
	public boolean equals(Object otherObject)
	{
		if(otherObject == null)
		{
			return false;
		}
		
		if(this.getClass() != otherObject.getClass())
		{
			return false;
		}
		
		else
		{
			Employee employee = (Employee) otherObject;
			
			return(this.getEmployeeNumber() == employee.getEmployeeNumber() && this.getFirstName().equals(employee.getFirstName()) && 
					this.lastName.equals(employee.getLastName()));
					
		}
	}
	
	
	
	

	
}
