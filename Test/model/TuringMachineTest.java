package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TuringMachineTest {

	TuringMachine tm;
	
	public void septUp1() {
		tm= new TuringMachine();
	}
	
	public void septUp2() {
	 tm= new TuringMachine();
		
		tm.addFirst('A');
		tm.addMedium('Z');
		tm.addLast('S');
	}
	
	public void septUp3() {
		 tm= new TuringMachine();
		 	
		 	tm.addFirst('Y');
			tm.addFirst('A');
			tm.addMedium('Z');
			tm.addLast('S');
			tm.addLast('E');
		}
	
	
	@Test
	public void addTest() {
		septUp1();
		assertEquals( tm.addFirst('A'),'A',"this correct");
		assertEquals( tm.addMedium('F'),'A',"this correct");
		assertEquals( tm.addLast('X'),'X',"this correct");
		
	}
	
	@Test
	public void readTest() {
		septUp2();
		assertEquals(tm.read('0'),'A',"this correct");
		assertEquals(tm.read('1'),'Z',"this correct");
		assertEquals(tm.read('2'),'S',"this correct");
	}
	
	@Test
	public void removeTest() {
		septUp3();
		
		assertEquals(tm.remove('0'),'A',"this correct");
		assertEquals(tm.remove('1'),'S',"this correct");
		assertEquals(tm.remove('2'),'E',"this correct");
	}
	
	
}
