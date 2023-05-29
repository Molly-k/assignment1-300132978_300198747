public class EmployeeTest{
	public static void main(String[] args) {
		//create the address array

		Address first = new Address("Queen",48,"K1P1N2");
		Address second = new Address("King Edward",800,"K1N6N5");
		Address [] addressArray = new Address[] {first,second};

		//employee 
		Employee employee = new Employee ("Falcao", 40, 15.50,addressArray);
		employee.toString();
		first.toString();
		second.toString();
		
	}
}