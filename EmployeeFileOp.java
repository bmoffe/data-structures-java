package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFileOp {
	public static void main(String[] args) {
        //declare variables
        String csvFile = "core_dataset.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        //call the methods to write to the file
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] info = line.split(cvsSplitBy);
                //write switch statements for cases where age < 25, where age is stored in index 6 of array
                switch (info[6]) {
                case "Sex":
                	writeArray("young_employee.csv",info);
					writeString("young_employee.csv", "\n");
					break;
				case "25":
					writeArray("young_employee.csv",info);
					writeString("young_employee.csv", "\n");
					break;
				case "26":
					writeArray("young_employee.csv",info);
					writeString("young_employee.csv", "\n");
					break;
				case "27":
					writeArray("young_employee.csv",info);
					writeString("young_employee.csv", "\n");
					break;
				case "28":
					writeArray("young_employee.csv",info);
					writeString("young_employee.csv", "\n");
					break;
				case "29":
					writeArray("young_employee.csv",info);
					writeString("young_employee.csv", "\n");
					break;
				case "30":
					writeArray("young_employee.csv",info);
					writeString("young_employee.csv", "\n");
					break;

				default:
					break;
				}
            }

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //method for writing to the array
    public static void writeArray(String fname, String [] data){
		try {
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0;i<data.length;i++){
				bw.write(data[i]+",");
			}bw.close();
			 fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finish writing info to file "+ fname);
	}
    //method for writing to the String
    public static void writeString(String fname, String data){
		try {
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			
				bw.write(data);
				bw.close();
			    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//display that the file has finished writing the line
		System.out.println("Finish writing info to file "+ fname);
	}
}
