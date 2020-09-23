package cs146F20.dang.project1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cs146F20.dang.project1.DataShuffling;

class DataShufflingTest {

	DataShuffling dataShuffle1;
	long start;
	
	@BeforeEach
	void setUp() {
		start = System.currentTimeMillis();
		dataShuffle1 = new DataShuffling();
		dataShuffle1.dataToArr();
		dataShuffle1.dataShuffle(dataShuffle1.dataPair);
		dataShuffle1.writeShuffledFile();
		long end = System.currentTimeMillis();
		System.out.println("Time to read from file, shuffle lines and create the output file: " + (end-start) + " ms");
	}
	
	@Test 
	void testOutput() throws IOException {
		
		BufferedReader out = new BufferedReader (new FileReader("data/DangDevonnaShuffled.txt"));
		BufferedReader in = new BufferedReader (new FileReader("data/Target3.txt"));
		
		String metadata = in.readLine();
		String expectedLine = "";
		String actualLine = "";
		
		while ( (expectedLine = in.readLine()) != null && (actualLine = out.readLine()) != null) {
			assertNotEquals(expectedLine, actualLine);
		}
		
		in.close();
		out.close();

	}
	

	
}