import java.util.Arrays;
//Brianna Moffett
//12.04.19
//CS 272
//Employee.java
public class Employee {

	//declaring variables
	private String name;
	private int age;
	private int employeeNum;
	private String state;
	private int zip;
	private static int [] advisors;
	//creating employee objects
	public static void main(String[] args) {
		//e1
		Employee e1 = new Employee();
			e1.setName("Test case");
			e1.setAge(45);
			e1.setEmployeeNum(1234);
			e1.setState("NM");
			e1.setZip(88002);
			e1.setAdvisors(new int [] {5404,4415,1243});
			System.out.println(e1.toString());
		//e2
		Employee e2 = new Employee();
			e2.setName("e2");
			e2.setAge(44);
			e2.setEmployeeNum(5525);
			e2.setState("NY");
			e2.setZip(12574);
			e2.setAdvisors(new int [] {2829,5446,3151});
			System.out.println(e2.toString());
		//Test case
		Employee employee = new Employee();
			employee.setName("Corina Vasquez");
			employee.setAge(45);
			employee.setEmployeeNum(100);
			employee.setState("TX");
			employee.setZip(79902);
			employee.setAdvisors(new int [] {1335,2990,1898});
			System.out.println(employee.toString());
			
			//testing for unique advisors; if found, print
			employee.getAllAdvisors(e1, e2);
	}

	//no argument constructor
	public Employee() {
		super();
		this.name = null;
		this.age = 0;
		this.employeeNum = 0;
		this.state = null;
		this.zip = 0;
		this.advisors = null;
	}
	public Employee(String name, int age, String state, int employeeNum, int zip) { //created specifically for Hash lab
		super();
		this.name = name;
		this.age = age;
		this.state = state;
		this.employeeNum = employeeNum;
		this.zip = zip;
	}
	//copy constructor
	public Employee (Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof Employee) {
			Employee e = (Employee) obj;
			name = e.name;
			age = e.age;
			employeeNum = e.employeeNum;
			state = e.state;
			zip = e.zip;
			advisors = e.advisors;
		}
	}
    
	//getters and setters for instance variables
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
    //getAllAdvisors method that detects unique advisors and prints them
	public static int [] getAllAdvisors(Employee e1, Employee e2) {
        if (advisors[0] != advisors[1] && advisors[0] != advisors[2] && advisors[1] != advisors[2]) {
        	System.out.print("advisors: " + advisors[0] + advisors[1] + advisors[2]);
        }
        if (advisors[0] == advisors[1]) {
        	System.out.print("Non-unique advisors detected." + " Unique advisors: " + advisors[2]);
        }
        if (advisors[0] == advisors[2]) {
        	System.out.print("Non-unique advisors detected." + " Unique advisors: " + advisors[1]);
        }
        if (advisors[1] == advisors[2]) {
        	System.out.print("Non-unique advisors detected." + " Unique advisors: " + advisors[0]);
        }
        if (advisors[0] == advisors[1] || advisors [0] == advisors[2] || advisors[1] == advisors[2]){
        	System.out.println(" Non-unique advisors detected.");
        }
		return advisors;
	}
    //setAdvisors
	public void setAdvisors(int[] advisors) {
		this.advisors = advisors;
	}
    //toString method
	public String toString() {
		return "Employee name: " + name + ", age: " + age + ", employeeNum: " + employeeNum + ", state: " + state
				+ ", zip: " + zip + ", advisors: " + Arrays.toString(advisors) + "";
	}
    //equals method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeNum != other.employeeNum)
			return false;
		return true;
	}
	
}