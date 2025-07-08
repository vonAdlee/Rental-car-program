package driver;
import iDroid.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import tax.*;
import java.io.PrintWriter;
import java.io.FileOutputStream;


/**
 	*This program is designed to manage the payroll of a company called "iDroid Solution".
 	
 	*The program will process a file named "payroll.txt" that possess employees' numbers and names and their worked hours and salaries.
 	
 	*The program performs data validation to ensure the inputs are valid. Any invalid data in a specific line would result in adding that line to 
 	a file called "payrollError.txt".
 
 	*Valid data lines are added to an employees array for tax calculation.
 	
 	*The program would perform tax calculation for each employee and calculate its net salary.
 	
 	*After deduction, the program would generate a final report in a file "payrollReport.txt" where the report is presented in a clear, tabular form.
 	 
 	* The console would display (the number of line in the "payroll.txt") + (number of invalid lines) + (Confirmation for opening, reading, and calculation deduction) + (Confirmation for the report file generation).
 
 	@author Anis Alouache
*/

public class iDroid {
	
	
// Static method to add an employee to the employees array.
	
	public static Employee[] addEmployee(Employee employee , Employee[] employees)
	{
		Employee[] newEmployees =  new Employee[employees.length + 1];
		
		for(int i = 0 ; i < employees.length ; i++)
		{
			newEmployees[i] = employees[i];
		}
		
		newEmployees[newEmployees.length - 1] = employee;
		
		return newEmployees;
	}
	
	
// Static method to add a deduction to the deductions array.
	
	public static double[] addDeduction(double deduction , double[] deductions)
	{
		double[] newDeductions = new double[deductions.length + 1];
		
		for(int i = 0 ; i < deductions.length ; i++ )
		{
			newDeductions[i] = deductions[i];
		}
		
		newDeductions[newDeductions.length - 1] = deduction;
		
		return newDeductions;
	}
	
	
// Static method to add net salary to the net salaries array.
	
	public static double[] addNetSalary(double netSalary , double[] netSalaries)
	{
		double[] newNetSalaries = new double[netSalaries.length + 1];
		
		for(int i = 0 ; i < netSalaries.length ; i++ )
		{
			newNetSalaries[i] = netSalaries[i];
		}
		
		newNetSalaries[newNetSalaries.length - 1] = netSalary;
		
		return newNetSalaries;
	}
	


	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// Creating an employee array where to store employees
		
		Employee[] employees = new Employee[0];
		
// Open Scanner to read the file.	
		
		Scanner read = null;
		
		try
		{
			read = new Scanner(new FileInputStream("payroll.txt"));
			System.out.println("> Opening file payroll...\n");
			System.out.println("> Reading file payroll...\n");
		}
		
		catch(FileNotFoundException fnfex)  	// Catching file not found exception.
		{
			System.out.println("The provided file has not been found");
			System.exit(0);
		}
		
		catch(IOException ioe)
		{
			System.out.println("File error");
			System.exit(0);		
		}
		
		int numberOfLines = 0;							// Variable calculating the number of lines in payroll file.
			
		int errorLines = 0;								// Variable calculating the number of error lines in payroll file.
		
		PrintWriter writer = null;
		
		
// Opening PrintWriter and creating new file " payrollError.txt" to store error lines.
		
		try
		{
			writer = new PrintWriter(new FileOutputStream("payrollError.txt"));
		}
	
		catch (FileNotFoundException fnfex) 		// Catching file not found exception.
		{
			System.out.println("The provided file has not been found");
			System.exit(0);
		}
		
		catch(IOException ioe)						// catching other IO exception.
		{
			System.out.println("File error");
			System.exit(0);		
		}
		
		
	
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
// Reading payroll file until the last line.
		
		while(read.hasNextLine())	
		{
			if(!read.hasNextLong())   					 // Checking if the first token is of type long and does not contain an error.
			{
					if(numberOfLines == 0)
					{
						String errorLine = read.nextLine();  
						writer.println(errorLine);
						errorLines++;					// Increment the number of error lines.
					}
				
					else
					{
						read.nextLine();
						String errorLine = read.nextLine();  
						writer.println(errorLine);
						errorLines++;
					}
										
			}
			
// If the first token represents a long variable, read the first variable (long variable) and the second and third variable as a String.
			
			else		
			{
				long employeeNumber = read.nextLong();   
				
				if(employeeNumber < 0) 				// Negative long variable (negative employee number) is considered an error and it is stored in "payrollError.txt" file.
				{
				String errorLine = read.nextLine();
				writer.println(employeeNumber + " "+ errorLine);
				
				errorLines++;  						// Increment the number of error lines.
				}
	
// Otherwise, continue reading.
				
				else
				{
					String firstName = read.next();
					String lastName = read.next();
					
					if(!read.hasNextDouble())			// Checking if the fourth token is of type double and does not contain an error.
					{
						
						
// Read the rest of the line and store the previous variables and the rest of the line in the "payrollError.txt" file.
											
						String errorLine = read.nextLine(); 	
						writer.println(employeeNumber + " " + firstName + " " + lastName + " " + errorLine); 
						errorLines++;
					}
										
										
// Otherwise, continue reading as the next token represent double variable.
										
					else
					{
											
						double hoursWorked = read.nextDouble();
											
						if(hoursWorked <= 0)				// Negative double variable (negative hours worked) is considered an error and it is stored in "payrollError.txt" file.
						{
							String errorLine = read.nextLine();
							writer.println(employeeNumber + " " + firstName + " " + lastName + " " + hoursWorked + " " + errorLine);
											
							errorLines++;					// Increment the number of error lines.
						}
											
											
						else
							if(!read.hasNextDouble())				// Checking if the fifth token is of type double and does not contain an error.
							{
								String errorLine = read.nextLine();
								writer.println(employeeNumber + " " + firstName + " " + lastName + " " + hoursWorked + " " + errorLine);
												
								errorLines++;					// Increment the number of error lines.
												
							}

											
// Otherwise, continue reading as the next token represent double variable.
											
							else
							{
								double hourlyWage = read.nextDouble();
												
// Using all the read tokens, create a new employee and add it to the employees array.
												
								try
								{
									employees = addEmployee(new Employee(employeeNumber , firstName , lastName , hoursWorked , hourlyWage), employees);
								}
												
								catch(MinimumWageException mwex)					// Catch the minimum wage exception, if the wage is less than the legal wage $15.75.
								{
									writer.println(employeeNumber + " " + firstName + " " + lastName + " " + hoursWorked + " " + hourlyWage);
									errorLines++;
								}
							}
					 }
			     }
			 }
			numberOfLines++;						// number of lines in the file variable is increment as soon as a the line is completely read. 
		}
			

		
		
		
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Close the PrintWriter and Scanner. 
		
			writer.close();	
			read.close();
			
// Opening another scanner to read "payrollError.txt" file.
			
			try
			{
				read = new Scanner(new FileInputStream("payrollError.txt"));
				System.out.println("> Error lines found in file payroll");
				System.out.println("--------------------------------------\n");
				
			}
			
			catch(FileNotFoundException fnfex)  	// Catching file not found exception.
			{
				System.out.println("The provided file has not been found");
				System.exit(0);
			}
			
			catch(IOException ioe)					// catching other IO exception.
			{
				System.out.println("File error");
				System.exit(0);		
			}
			
	
// Reading errors from "payrollError.txt" file.
			
		while(read.hasNextLine())
		{
			String errorLine = read.nextLine();
			System.out.println(errorLine);
			System.out.println();
		}
					
			
		read.close();		
		
		
// Display the number of lines in the payroll file and the number of error lines.
		
		System.out.println("--------------------------------------\n");
		System.out.println("\n");
		System.out.println("> " + numberOfLines + " lines read from \"payroll\" file\n");
		System.out.println("> " + errorLines + " error lines written to \"payroll error\" file");		
		System.out.println("\n\n\n");
		
		
	
//	Calculating tax deduction for each valid employee from payroll file
		
	double[] employeesDeductions = new double[0]; 					// Deduction array for storing each deduction.
		
		
		for(int i = 0 ; i < employees.length ; i++)
		{
			double employmentInsurance = new EmploymentInsurance(employees[i].getGrossSalary()).getDeduction();
			double federalIncome = new FederalIncomeTax(employees[i].getGrossSalary()).getDeduction();
			double provincialIncome = new ProvincialIncomeTax(employees[i].getGrossSalary()).getDeduction();
			double quebecParentalInsurance = new QuebecParentalInsurancePlan(employees[i].getGrossSalary()).getDeduction();
			double quebecPensionPlan= new QuebecPensionPlan(employees[i].getGrossSalary()).getDeduction();
			
			double deductions = employmentInsurance + federalIncome + provincialIncome + quebecParentalInsurance + quebecPensionPlan;
			deductions = Math.round(deductions * 100.0) / 100.0;
			
			employeesDeductions = addDeduction(deductions , employeesDeductions);
			
			
		}
		
// Calculate net salary for each employee.
		
		double[] netSalaries = new double[0]; 				// net salary array for storing each net salary.
		
		
		for(int i = 0 ; i < employeesDeductions.length ; i++)
		{
			double netSalary = employees[i].getGrossSalary() - employeesDeductions[i];
			
			netSalaries = addNetSalary(netSalary , netSalaries);
		}
		

// Opening a new file to store the payroll report in a tabular form using PrintWriter.
		
		try
		{
			writer = new PrintWriter(new FileOutputStream("payrollReport.txt"));
			
			writer.println("\t\t\t\tiDroid Solutions");
			writer.println("\t\t\t\t------------------");
			writer.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n" , "Employee" , "First Name" , "Last Name" , "Gross Salary" , "Deductions" , "Net Salary");
			writer.println("Number");
			writer.println("--------------------------------------------------------------------------------------");
			
			for(int i = 0 ; i < employees.length ; i++)
			{
				long employeeNumber = employees[i].getEmployeeNumber();
				String firstName = employees[i].getFirstName();
				String lastName = employees[i].getLastName();
				double grossSalary = employees[i].getGrossSalary();
				
				double employeeDeduction = employeesDeductions[i];
				double netSalary = Math.round(netSalaries[i] * 100.0) / 100.0;
				
				writer.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n" , employeeNumber , firstName , lastName , "$" + grossSalary , "$" + employeeDeduction , "$" + netSalary);
			}
			
		}
		
		catch(FileNotFoundException fnfex)  	// Catching file not found exception.
		{
			System.out.println("The provided file is not found");
			System.exit(0);
		}
		
		finally								// Close PrintWriter at the end of the operation.
		{
			writer.close();
		}
		
// Open the payroll report file using scanner	
		try
		{
			read = new Scanner(new FileInputStream("PayrollReport.txt"));
			
			while(read.hasNextLine())					// Reading each line in the payroll report file
			{
				String line = read.nextLine();
				System.out.println(line);
			}
		}
		
		catch(FileNotFoundException fnfex)  	// Catching file not found exception.
		{
			System.out.println("The provided file has not been found");
			System.exit(0);
		}
		
		catch(IOException ioe)				// catching other IO exception.
		{
			System.out.println("File error");
			System.exit(0);		
		}
		
		finally								// Closing the scanner at the end of the operation.
		{
			read.close();
		}
		
		
		
	}
}
