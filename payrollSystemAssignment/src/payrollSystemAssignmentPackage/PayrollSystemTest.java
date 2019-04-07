package payrollSystemAssignmentPackage;

public class PayrollSystemTest {
	
	public static void main(String[] args) {
		// Create subclass objects objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, new Date(3, 3, 1991));
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, new Date(4, 4, 1992));
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06, new Date(5, 5, 1993));
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300, new Date(6, 6, 1994));
		PieceWorker pieceWorker = new PieceWorker("Sean", "Bean", "555-55-555", 3.00, 200, new Date(4, 8, 1995));
		Invoice invoice1 = new Invoice("01234", "seat", 2, 375.00);
		Invoice invoice2 = new Invoice("56789", "tire", 4, 79.95);
		
		// Create four-element employee array
		Payable[] payableObjects = new Payable[7];
		
		// Initialize array with Employee
		payableObjects[0] = salariedEmployee;
		payableObjects[1] = hourlyEmployee;
		payableObjects[2] = commissionEmployee;
		payableObjects[3] = basePlusCommissionEmployee;
		payableObjects[4] = pieceWorker;
		payableObjects[5] = invoice1;
		payableObjects[6] = invoice2;
		
		System.out.printf("Employees and Invoices processed polymorphically:%n%n");
		
		int CurrentMonth = 4; // Current Month is April.
		
		for (Payable currentPayable : payableObjects) {
			// "if" statement determines whether payableObjects Object is an employee or invoice.
			if(currentPayable instanceof Employee) {
				System.out.println(currentPayable);
			// Determine whether element is a BasePlusCommissionEmployee
			if (currentPayable instanceof BasePlusCommissionEmployee) {
				// Downcast Employee reference to BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentPayable;
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				System.out.printf("new base salary 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
			// Question 10.12: Determines whether employee's birthday is in the current month (April). Adds $100 to employee's earnings if it is.
			if (((Employee) currentPayable).getBirthMonth() == CurrentMonth) { 
				System.out.println("Employee recieved $100 Birthday Bonus.");
				System.out.printf("earned $%,.2f%n", (currentPayable.getPaymentAmount() + 100));
			}
			else {
				System.out.printf("earned $%,.2f%n", (currentPayable.getPaymentAmount()));
			}
				
			System.out.println("birthdate " + ((Employee) currentPayable).getBirthDate());
			System.out.println();
			
			}
			else {
			
	         System.out.printf("%n%s %n%s: $%,.2f%n", currentPayable.toString(), "payment due", currentPayable.getPaymentAmount());
			}
		}
	}
}