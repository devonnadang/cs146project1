package cs146F20.dang.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.*;



public class DataShuffling {
	
	
	String [] dataPair = new String [7515];
	
	/* 
	 * Given n elements, start from the last element, swap with  randomly 
	 * selected element from the whole data set
	 * In the next step, you will consider the rows 0 to n-2 (size reduced by 1)
	 * 
	 */
	
	// read the ErdosCA.txt file and add them into the array
	public void dataToArr() {
		try {

			BufferedReader br = new BufferedReader (new FileReader("data/ErdosCA.txt"));
			
			String s;
			int index = 0;
			while ((s = br.readLine()) != null) {
				if (!s.contains("%")) {
					dataPair[index] = s;
					index++;
				}
			}
			br.close();
		} catch (Exception e) {
			return;
		}
	}
	
	// This method shuffles file data
	public void dataShuffle(String [] dataPair) {
		Random rand = new Random();
		rand.setSeed(20);
		for (int i = dataPair.length-1; i > 1; i--) {
			
			int rand_index = rand.nextInt(i+1);	// Random range: 0 <= rand_index <= i	
			
			// Exchange dataPair[rand_index] and dataPair[i]
			String temp = dataPair[rand_index];
			dataPair[rand_index] = dataPair[i];
			dataPair[i] = temp;
		}
	}
	
	//Write the shuffled data into a new file
	public void writeShuffledFile() {
		try {

			BufferedWriter bw = new BufferedWriter (new FileWriter ("data/DangDevonnaShuffled.txt"));
			
			for (int i = 0; i < dataPair.length; i++) {
				bw.write(dataPair[i]);
				bw.newLine();
			}
			
			bw.close();
		} catch (Exception e) {
			return;
		}
	}
	
	
}
	
	
	


