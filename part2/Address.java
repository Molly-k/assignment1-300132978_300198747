public class Address{
	//private instances 
	private String street;
	private int number;
	private String postal;

	//constructor 
	public Address(String street, int number, String postal){
		this.street = street;
		this.number = number;
		this.postal = postal;
	}

	//getters
	public String getStreet(){
		return street;
	}

	public int getNumber(){
		return number;
	}

	public String getPostal(){
		return postal;
	}

	//toString method
	public String toString(){
		System.out.println( getStreet() + " " +getNumber()+ " "+ getPostal()+" ");
		return "the adress is : ";
}
}