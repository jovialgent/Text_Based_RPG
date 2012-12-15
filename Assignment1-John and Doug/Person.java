/**
	Class: Person
	
	Description: This class contains basic information on a 
	person. So far a Person contains a name and gender.
	
	@author Doug Walter & John Qualls
	@version 1.0
*/
public class Person extends Thing {
	private String name = "John Doe";
	private Gender gender = Gender.MALE;
	
	public Person() {
		this.name = "John Doe";
		this.gender = Gender.MALE;
	}
	
	public Person(String inn, Gender sex) {
		this.setName(inn);
		this.gender = sex;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String inn) {
		this.name = inn;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public void setGender(Gender newGender) {
		this.gender = newGender;
	}
}
