public class Employee{

	//private instances 
	private String name;
	private int hours;
	private double rate;
	private  Address [] address;

	//constructor 
	public Employee (String name, int hours, double rate, Address[] address) {
		this.name = name;
		this.hours = hours;
		this.rate = rate;
		this.address = address;
	}

	//getters 
	public String getName(){
		return name;
	}

	public int getHours(){
		return hours;
	}

	public double getRate(){
		return rate;
	}

	public Address[] getAddress(){
		return address;
	}


	//toString method
	public String toString(){
		System.out.println("This employee name is : " +getName() + " The employee  is working  : "+getHours()+" hours per week , The employee is paid "+ getRate() + "$ per hour,The employee address (es) is (are) : ");
		return "the address is ";

	}

}