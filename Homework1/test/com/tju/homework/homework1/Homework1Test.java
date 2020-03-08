package com.tju.homework.homework1;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

public class Homework1Test {
	
	private Homework1 hw=null;
	
	@Before
	public void setUp() {
		hw=new Homework1();
	}

	@Test
	public void testSolve() {
		int[] T = {0,1,2,5,8,30,80,93};
		for (int i:T) {
			assertTrue(hw.solve(i));
		}
		int[] F = {-1,4,19,94};
		for (int i:F) {
			assertFalse(hw.solve(i));
		}
	}

}
