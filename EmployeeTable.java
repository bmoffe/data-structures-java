import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
//Brianna Moffett
//12.04.19
//CS 272
//EmployeeTable.java
public class EmployeeTable {
	private boolean [] used;
	private int num;
	Employee data[];
	public static void main(String[] args) throws IOException{
		EmployeeTable table = new EmployeeTable(); //new table
		
		Employee e1 = new Employee(); //objects to add to hash table
		e1.setName("Corina Vasquez");
		e1.setAge(20);
		e1.setEmployeeNum(5555);
		e1.setState("NM");
		e1.setZip(88003);
		e1.setAdvisors(new int [] {1335,2990,1898});
		System.out.println(e1.toString());
			
		Employee e2 = new Employee();
		e2.setName("Brianna Moffett");
		e2.setAge(20);
		e2.setEmployeeNum(4444);
		e2.setState("TX");
		e2.setZip(79902);
		e2.setAdvisors(new int [] {1111,2222,3333});
		System.out.println(e2.toString());
		
		Employee e3 = new Employee();
		e3.setName("Guillermo Avitia");
		e3.setAge(21);
		e3.setEmployeeNum(7601);
		e3.setState("TX");
		e3.setZip(79938);
		e3.setAdvisors(new int [] {1111,2222,3333});
		System.out.println(e3.toString());
		
		table.put(e1); //adding e1 to table
		table.put(e2); //adding e2 to table
		table.put(e3); //adding e3 to table
		
		System.out.println("Searching for hash value of e1: " + table.search(e1.getEmployeeNum())); //should print hash value of first object
		System.out.println("Searching for hash value of e2: " + table.search(e2.getEmployeeNum())); //should print hash value of second object
		System.out.println("Searching for hash value of e3: " + table.search(e3.getEmployeeNum())); //should print hash value of third object
		
		table.remove(e2.getEmployeeNum());
		
		System.out.println("Searching for hash value of e2 after removal: " + table.search(e2.getEmployeeNum())); //will print -1
		
		System.out.println("Reading core_dataset.csv read into hashmap: ");
		String filePath = "/home/ugrad11/bmoffett/workspace/lab2_272/src/core_dataset.csv";
	    String line = "";
	    String header = "Employee name, number, state, ZIP code, and age";
	    String csvSplitBy = ","; //file is split by comma, so we set the delimiter to be the "," character
	    try { //reading file into the hashmap
	    	FileReader fr = new FileReader(filePath);
	    	BufferedReader br = new BufferedReader(fr);
	    	br.readLine();
	    	HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
	    	while((line = br.readLine()) != null) {
	    		String [] dataset = line.split(csvSplitBy);
	    		if (dataset.length > 0) {
	    			String name = dataset[0].concat(dataset[1]);
	    			Employee temp = new Employee(name, Integer.parseInt(dataset[2]), dataset[3], Integer.parseInt(dataset[4]), Integer.parseInt(dataset[6]));
	    			map.put(Integer.parseInt(dataset[2]), temp);
	    		}
	    	}
	    	System.out.println(" ");
	    	System.out.println("Size of map after addition is " + map.size() + ".");
	    	System.out.println(" ");
	    	System.out.println("Removed " + map.remove(1112030816) + " from map."); //removal tests
	    	System.out.println("Removed " + map.remove(1111030148) + " from map.");
	    	System.out.println("Removed " + map.remove(602000312) + " from map.");
	    	System.out.println("Size after removal is " + map.size() + ".");
	    	System.out.println("Search for employeeID 1112030816: " + map.get(1111030148)); //search tests
	    	System.out.println("Removed " + map.remove(1111030148) + " from map.");
	    	System.out.println("Search for employeeID 1112030816: " + map.get(1111030148));
	    	System.out.println("Size after removals is " + map.size() + ".");
	    	System.out.println(" ");
	    	System.out.println("Search for employeeID 1501072093: " + map.get(1501072093));
	    	System.out.println("Size after all searches is " + map.size() + ".");
	    	br.close();
	    }
	    catch(FileNotFoundException e) { //file not found, throw error
	    	System.out.println("Cannot open file.");
	    }
	    catch(IOException e) { //file cannot be read, throw error
	    	System.out.println("Error reading file.");
	    }
	}
	private int hash(Employee e) { //determines hash value of object
		return Math.abs(e.getEmployeeNum() % used.length);
	}
	public EmployeeTable() { //constructor for the Employee hash table
		used = new boolean [701]; //not sure how many spaces there needs to be, so using a value seen in lecture notes
		data = new Employee[701];
		num = 0;
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
			data[i] = null;
		}
	}
	public void put(Employee e) { //adds data to the hash table
		int employeeHash = hash(e);
		while (data[employeeHash] != null) {
			employeeHash++;
		}
		data[employeeHash] = e;
		num++;
		System.out.println("Item successfully added to hash table.");
	}
	public boolean remove(int employeeNum) { //removes data from the hash table
		if (search(employeeNum) == -1) {
			return false;
		}
		int index = search(employeeNum);
		used[index] = true;
		data[index] = null;
		num--;
		System.out.println("Item successfully removed from hash table.");
		return true;
	}
	public int search(int employeeNum) { //searches for object within the table; if found, return the hash value, if not, return -1
		int employeeHash = employeeNum % used.length;
		if(data[employeeHash] != null) {
			return employeeHash;
		}
		while(true) {
			if (data[employeeHash] == null) {
				return -1;
			}
			if (data[employeeHash].getEmployeeNum() == employeeNum) {
				return employeeHash;
			}
			employeeHash++;
		}
	}
}
