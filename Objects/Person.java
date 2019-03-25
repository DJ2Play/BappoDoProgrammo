package Objects;

public class Person {
	private String name;
	private String dni;
	private String employment;
	public Person(String dni, String name, String employment) {
		this.dni = dni;
		this.name = name;
		this.employment = employment;
	}
	public String getName() {
		return name;
	}
	public void setNom(String name) {
		this.name = name;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
}
