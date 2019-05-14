package com.travel.farecontroller;

import static org.junit.Assert.*;

import org.junit.Test;

public class FareServiceIbrahimTest {

	@Test
	public void test1() {
		FareServiceIbrahim fareService = new FareServiceIbrahim();
		double actual = fareService.calculateTaxiFares(500,	 2, 0, false, false);
		assertEquals(2, actual,0.0);
	}
	
	@Test
	public void test2() {
		FareServiceIbrahim fareService = new FareServiceIbrahim();
		double actual = fareService.calculateTaxiFares(5525, 7, 2, true, true);
		assertEquals(7.1145, actual,0.0);
	}

}
