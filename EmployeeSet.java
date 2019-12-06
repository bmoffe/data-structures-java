import java.util.Arrays;
//Brianna Moffett
//CS 272
//09.13.19
//EmployeeSet.java
//input: Employee objects
//output: array of Employee objects
public class EmployeeSet {
	
	public static void main(String[] args) {
		EmployeeSet group1 = new EmployeeSet();
		EmployeeSet group2 = new EmployeeSet();
		
		Employee test1 = new Employee();
			test1.setName("Test case 1");
			test1.setAge(45);
			test1.setEmployeeNum(1);
			test1.setState("NM");
			test1.setZip(88002);
			test1.setAdvisors(new int [] {2,4,1});
			System.out.println(test1.toString());
			
			Employee test2 = new Employee();
			test2.setName("Test case 2");
			test2.setAge(45);
			test2.setEmployeeNum(2);
			test2.setState("NM");
			test2.setZip(88002);
			test2.setAdvisors(new int [] {2,4,1});
			System.out.println(test2.toString());
			
			Employee test3 = new Employee();
			test3.setName("Test case 3");
			test3.setAge(45);
			test3.setEmployeeNum(3);
			test3.setState("NM");
			test3.setZip(88002);
			test3.setAdvisors(new int [] {2,4,1});
			System.out.println(test3.toString());
			
			Employee test4 = new Employee();
			test4.setName("Test case 4");
			test4.setAge(45);
			test4.setEmployeeNum(4);
			test4.setState("NM");
			test4.setZip(88002);
			test4.setAdvisors(new int [] {2,4,1});
			System.out.println(test4.toString());
			
			Employee test5 = new Employee();
			test5.setName("Test case 5");
			test5.setAge(45);
			test5.setEmployeeNum(5);
			test5.setState("NM");
			test5.setZip(88002);
			test5.setAdvisors(new int [] {2,4,1});
			System.out.println(test5.toString());
			
			//testing methods written
			group1.Add(test2); //add method
			group1.Add(test3);
			group1.Add(test4);
			System.out.println(group1.toString()); //printing to ensure objects were added
			System.out.println("Group 1 size: " + group1.Size()); //printing size of group 1
			System.out.println("Group 1 capacity: " + group1.Capacity());
			group1.Remove(test3.getEmployeeNum()); //remove one employee
			System.out.println("Group 1 size after removal: " + group1.Size()); //printing group size after removal
			System.out.println("Does group1 contain the input employee? " + group1.Contains(test2)); //testing contains
			group1.ensureCapacity(12); //testing capacity
			System.out.println(group1.Capacity()); //printing capacity after increasing minimum capacity
			group1.addOrdered(test1); //adding new employee in order based on employee number
			System.out.println(group1); //printing set after ordered addition
			group1.EmployeeSet(group2); //copying contents of group 1 to group 2
			System.out.println(group2.toString()); //printing group 2 to ensure contents of group 1 were copied to it
	}
	
	//declaring variables
	private Employee[] employeeSet;
	private int count = 0;
	private int INITIAL_CAPACITY;
	
	//no-argument constructor
	public EmployeeSet() {
		INITIAL_CAPACITY = 10;
		int manyitems = 0;
		employeeSet = new Employee[INITIAL_CAPACITY];
	}
	
	//copy constructor
	public void EmployeeSet(Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof EmployeeSet) {
			EmployeeSet e = (EmployeeSet) obj;
			count = e.count;
			this.employeeSet = new Employee [e.employeeSet.length];
			System.arraycopy(e.employeeSet, 0, this.employeeSet, 0, e.count);
		}
	}

	//size method (different from capacity in that it counts how many objects are actually *in* the set, as opposed to the capacity of the set
	public int Size() { //tested
		int counter = 0;
		for (int i = 0; i < count; i++) {
			if (employeeSet[i] instanceof Employee) {
				counter = counter + 1;
			}
		}
		return counter;
		
	}
	
	//method to return capacity
	public int Capacity() { //tested
		int length = employeeSet.length;
		return length;
	}
	
	//add method
	public void Add(Employee a) { //tested
		employeeSet[count] = a;
		count++;
		
	}
	
	//contains method
	public boolean Contains(Employee a) { //tested
		if (a == null) {
			return false;
		}
		for (int i =0; i < count; i++) {
			if (employeeSet[i] == a) {
				return true;
			}
		}
		return false;
	}
	
	//remove method
	public boolean Remove(int eno) { //tested
		for (int i = 0; i < employeeSet.length; i++) {
			if (employeeSet[i].getEmployeeNum() == eno) {
				employeeSet[i] = employeeSet[count-1];
				count--;
				return true;
			}
		}
		return false;
	}
	
	//method to ensure capacity; if minimum capacity is larger than initial capacity, modify capacity
	private void ensureCapacity(int minimumCapacity) { //tested
		if (minimumCapacity >= Capacity()) {
			Employee [] biggerSet = new Employee[(minimumCapacity+ 1)*2];
			System.arraycopy(employeeSet, 0, biggerSet, 0, count);
			employeeSet = biggerSet;
		}
	}
	
	//add method (adds employee to set in order based on employee number)
	private void addOrdered(Employee a) {
		for (int i = 0; i < count; i++) {
			if (a.getEmployeeNum() <= employeeSet[i].getEmployeeNum()) {
				shiftRight(i, count, employeeSet);
				ensureCapacity(count - 1);
				employeeSet[i] = a;
				return;
			}
		}
		Add(a);
	}
	//method to shift objects to right, required for addOrdered, but not needed anywhere else
	private void shiftRight(int index, int count, Employee [] newSet) {
		ensureCapacity(count-1);
		for (int i = 0; i > index; i--) {
			newSet[i-1] = newSet[i];
		}
	}

	//toString method
	public String toString() {
		return "EmployeeSet [employeeSet=" + Arrays.toString(employeeSet) + ", count=" + count + ", INITIAL_CAPACITY="
				+ INITIAL_CAPACITY + ", Size()=" + Size() + ", Capacity()=" + Capacity() + "]";
	}
	
}

