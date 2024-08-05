package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, Integer> map = new HashMap<>();
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int vote = Integer.parseInt(fields[1]);
				
				map.put(name, map.getOrDefault(name, 0) + vote);
				line = br.readLine();
			}
			
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}