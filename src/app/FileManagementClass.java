package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
//import java.util.Scanner;
import java.util.Scanner;



public class FileManagementClass implements FileManagement{

	@Override
	public void save(String filename, BMIUtregning calc, Person p) throws IOException {
		File file = new File(filename);		
		PrintWriter output = new PrintWriter(new FileWriter(file, true));
		String Navn = p.getNavn();
		double BMI = calc.getBmi();
		output.printf("BMI-en til " + Navn + " er " + BMI +".");
		output.printf("\r\n");
		output.close();
	}

	@Override
	public String load(String filename) throws IOException {
		String text = "";
		try {
			Scanner s = new Scanner(new File(filename));
			while(s.hasNextLine()) {
				text = text + s.nextLine() + "\r\n";
			}
			s.close();}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
		}
		return text;
		}
	
	public void save(OutputStream out){
		String<Name>
	      
	   }

}
