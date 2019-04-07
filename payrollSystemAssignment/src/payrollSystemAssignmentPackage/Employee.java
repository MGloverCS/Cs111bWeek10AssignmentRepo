package payrollSystemAssignmentPackage;

// Parent Class Employee inherited by employee subclasses.
public abstract class Employee implements Payable {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private Date birthDate;
	
	// Constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate =birthDate;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	
	public int getBirthMonth() {
		return birthDate.getMonth();
	}
	
	// return String representation of Employee object
	@Override
	public String toString() {
		return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
	}
	
	// Get Payment method in parent class, for Question 10.16
	@Override
	public double getPaymentAmount() {
		return earnings();
	}
	
	// abstract method must be overridden by concrete subclasses
	public abstract double earnings();
}