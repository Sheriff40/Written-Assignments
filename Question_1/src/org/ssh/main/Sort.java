package org.ssh.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		
		//To open the existing file in the current directory
		File file = new File("input_numbers.txt");
		File file2 = new File("output_numbers.txt");
		
		String content = "";
		String temp;
		
		//Reading  from the file object initialized from above
		try {
			Scanner scanner = new Scanner(file);
			content = scanner.nextLine();
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Split the string by commas(,) and store them in an array
		String letters[] = content.split(",");
		
		//Code for sorting the numbers in ascending order
		for(int i = 0; i< letters.length;i++)
		{
			for(int j = i+1; j < letters.length;j++)
			{
				//Interger.parseInt used for type conversion
				if(Integer.parseInt(letters[i]) > Integer.parseInt(letters[j]))
				{
					temp = letters[i];
					letters[i] = letters[j];
					letters[j] = temp;
				}
			}
		}
		
		//Join the sorted members of the sorted array using a delimiter comma(,)
		temp = String.join(",",letters);
		
		
		//Write to file specified by name within the parenthesis ()
		try {
			file2.createNewFile();
			PrintWriter writer = new PrintWriter(file2);
			writer.print(temp);
			System.out.println("Successfully inserted data into output_numbers.txt");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
