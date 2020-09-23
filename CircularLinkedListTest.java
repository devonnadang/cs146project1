package cs146F20.dang.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularLinkedListTest {

	CircularLinkedList prisoners;

	
	@BeforeEach
	void setUp() {
		prisoners = new CircularLinkedList();
	}
	
	
	@Test
	void test() {
		assertTrue(prisoners.isEmpty());		//before inserting, list is empty
		assertEquals(0, prisoners.size);		//size is 0
		prisoners.insertNode(5);
		assertFalse(prisoners.isEmpty());		// after inserting element, list is not empty
		assertEquals(1, prisoners.size); 		//size is 1
	}
	
	@Test
	void testN6K2() {
		int n6k2Winner = prisoners.eliminatePrisoners(6,2);
		assertEquals(1, n6k2Winner);
	}
	
	@Test
	void testN1K9() {
		int n1k9Winner = prisoners.eliminatePrisoners(1,9);
		assertEquals(1, n1k9Winner);
	}
	
	@Test
	void testN7K7() {
		int n7k7Winner = prisoners.eliminatePrisoners(7,7);
		assertEquals(4, n7k7Winner);
	}
	
	@Test
	void testN12K8() {
		int n12k8Winner = prisoners.eliminatePrisoners(12,8);
		assertEquals(2, n12k8Winner);
	}
	
	@Test
	void testN5K1() {
		int n5k1Winner = prisoners.eliminatePrisoners(5,1);
		assertEquals(3, n5k1Winner);	
		}
	
	 
}
