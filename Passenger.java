package usecase;

public class Passenger {

	private int age;
	private String name;
	private char gender;
	
	public Passenger(String name,int age, char gender) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}
	
	

	

}
