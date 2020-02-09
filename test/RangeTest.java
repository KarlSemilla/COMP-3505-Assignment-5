package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RangeTest {

	private Range exampleRange;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@Tag("range")
	public void illegalRange() {
		assertThrows(IllegalArgumentException.class, () -> new Range(5,1));
	}
	
	
	
	//CombineRange method test

	@Test
	@Tag("Combine")
	public void lowertestCombineRange() {


		Range testRangeCase = new Range(-1.0,3.0);
		Range rangeCase = new Range(1.0,5.0);
		
		
		Range expectedRange = new Range(-1, 5);		
		Range actualRange = Range.combine( rangeCase,testRangeCase );
		
		assertAll(
				() -> assertEquals(expectedRange, actualRange ,"Creating a new range from the first and the second range")
				);
	}

	@Test
	@Tag("Combine")
	public void highertestCombineRange1() {


		Range testRangeCase = new Range(5,10);
		Range rangeCase = new Range(20,30);
		
		
		Range expectedRange = new Range(5, 30);		
		Range actualRange = Range.combine( rangeCase,testRangeCase );
		
		assertAll(
				() -> assertEquals(expectedRange, actualRange ,"Creating a new range from the first and the second range")
				);
		 
		

	}

	@Test
	@Tag("Combine")
	public void nulltestCombineRange1() {


		Range testRangeCase = new Range(1.0, 5.0);
		Range rangeCase = null;
		
		
		Range expectedRange = null;	
		Range actualRange = Range.combine( rangeCase,testRangeCase );
		
		assertAll(
				() -> assertEquals(null, actualRange ,"Creating a new range from the first and the second range")
				);
		 
		

	}
	@Test
	@Tag("Combine")
	public void nullRange2testCombineRange1() {


		Range testRangeCase = new Range(5, 30);
		Range rangeCase = null;
		
		
		Range expectedRange = null;
		Range actualRange = Range.combine(testRangeCase, rangeCase );
		
		assertAll(
				() -> assertEquals(null, actualRange ,"Creating a new range from the first and the second range")
				);
		 
		

	}


	@Test
	@Tag("Combine")
	public void negativeValuestestCombineRange1() {


		Range testRangeCase = new Range(-10.0,-4.0);
		Range rangeCase = new Range(-3,0.0);
		
		
		Range expectedRange = new Range(-10.0,0.0);		
		Range actualRange = Range.combine( rangeCase,testRangeCase );
		
		assertAll(
				() -> assertEquals(expectedRange, actualRange ,"Combining range of -10 to -4 with range of -3 to 0 should create a new range of -10 to 0.")
				);
		 

	}

	//--------------------------------------------------------------------------

	// ConstrainRange method tests

	@Test
	@Tag("Constrain")
	public void lowerConstraintestRange2() {

	    double input = 0.5;
		Range testCase = new Range(-2.0 , 1.0);
		
		double expectedValue =testCase.constrain(input) ;  
				 
		
		assertAll(
				() -> assertEquals(expectedValue, input ,"Input of 0.5 falls with in the range of -2.0 to 1.0")
				);	 
	}

	@Test
	@Tag("Constrain")
	public void higherConstraintestRange2() {

	    double input = 3.6;
		Range testCase = new Range(2.0 , 7.0);

		double expectedValue =testCase.constrain(input) ;  
				
		
		assertAll(
				() -> assertEquals(expectedValue, input ,"Input of 3.6 falls with in the range of 2.0 to 7.0")
				);	 
	}


	@Test
	@Tag("Constrain")
	public void ZeroConstraintestRange2() {

	    double input = 0;
		Range testCase = new Range(0.0 , 0.0);

		double expectedValue =testCase.constrain(input) ;    
		
		assertAll(
				() -> assertEquals(expectedValue, input ,"Input of 0 falls with in the range of 0 to 0")
				);	 
	}



	@Test
	@Tag("Constrain")
	public void outofbondryConstraintestRange2() {

	    double input = 7.0;
		Range testCase = new Range(-1.0 , 6.0);

		double expectedValue =testCase.constrain(input) ;    
		

		assertAll(
				() -> assertEquals(expectedValue, input ,"Input of 7.0 falls with in the range of -1.0 to 6.0")
				);	 
	}
			

	@Test
	@Tag("Constrain")
	public void biggerToLowerValuesofRanges() {

	    double input = 6.0;
		Range testCase = new Range(6.0 , -1.0);

		double expectedValue =testCase.constrain(input) ;    
		
		assertAll(
				() -> assertEquals(expectedValue, input ,"Input of 7.0 falls with in the range of -1.0 to 6.0")
				);
				
		//assertEquals(expectedValue, input ,"Input of 7.0 falls with in the range of -1.0 to 6.0");
				
	}

	@Test
	@Tag("Constrain")
	public void smallerToLowerValuesofRanges() {

	    double input = -10.0;
		Range testCase = new Range(-1.0 , 3.0);

		double expectedValue =testCase.constrain(input) ;    
		
		assertAll(
				() -> assertEquals(expectedValue, input ,"Input of 7.0 falls with in the range of -1.0 to 6.0")
				);
				
		//assertEquals(expectedValue, input ,"Input of 7.0 falls with in the range of -1.0 to 6.0");
				
	}
	  
	//-----------------------------------------------------------------------------------------------------




	//equalRange methods tests
	@Test
	@Tag("Equals")
	public void equalsTest() {
		Range r1 = new Range(1.0,5.0);
		Range r2  = new Range(1.0,5.0);

		assertTrue(r1.equals(r2) ," Range of 0.0 to 0.0 should equal to range of ");
				
		 
	}


	@Test
	@Tag("Equals")
	public void negativeEqualsTest() {
		Range r1 = new Range(-1.0,2.0);
		Range r2  = new Range(-1.0,2.0);
		
		assertTrue(r1.equals(r2) ,"Range of 0.0 to 0.0 should equal to range of -1.0 to 2.0 ");
	}

	@Test
	@Tag("Equals")
	public void ZeroEqualsTest() {
		Range r1 = new Range(0.0,0.0);
		Range r2  = new Range(0.0,0.0);
		
		assertTrue(r1.equals(r2) ,"Range of 0.0 to 0.0 should equal to range of 0.0 to 0.0");
		 
	}

	@Test
	@Tag("Equals")
	public void equalToDouble() {
		Range r1 = new Range(1.0,5.0);
		double r2  = 0.0;
		
		assertTrue(r1.equals(r2));
	}
	
	

	//--------------------------------------------------------------------------------------------------------------

	//ContainRange method tests


	@Test
	@Tag("Contains")
	public void lowercontainTest() {
		
		
		Range testContainCase1 = new Range(-2.0,1.0);
		double input = -0.6;
		
		boolean actualValue = testContainCase1.contains(input);     
		
		assertTrue( actualValue, "-0.6 should fall within the range of -2.0 to 1.0" );
		 
	}

	@Test
	@Tag("Contains")
	public void highercontainTest() {
		
		
		Range testContainCase1 = new Range(2.0,10.0);
		double input = 4.0;
		
		boolean actualValue = testContainCase1.contains(input);     
		
		assertTrue( actualValue, "4.0 should fall within the range of 2.0 to 10.0" );
		 
	}

	@Test
	@Tag("Contains")
	public void zeroContainTest() {
		
		
		Range testContainCase1 = new Range(0.0,0.0);
		double input = 0.0;	
		boolean actualValue = testContainCase1.contains(input);     
		
		assertTrue( actualValue, "0.0 should fall within the range of 0.0 to 0.0 " );
		 
		 
	}


	/*
	 * Testing for expand()
	 */
	
	@Test
	@Tag("Expand")
	void expandedRangeByZeroPercent() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expand(exampleRange, 0, 0);
		assertAll(
				() -> assertEquals(2, result.getLowerBound(), .01d, "Expanding lower bound of 2 by 0% should be 2"),
				() -> assertEquals(6, result.getUpperBound(), .01d, "Expanding upper bound of 6 by 0% should be 6")
				);		
	}
	
	@Test
	@Tag("Expand")
	void expandedRangeByTwentyFivePercent() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expand(exampleRange, 0.25, 0.25);
		assertAll(
				() -> assertEquals(1, result.getLowerBound(), .01d, "Expanding lower bound of 2 by 25% should be 1"),
				() -> assertEquals(7, result.getUpperBound(), .01d, "Expanding upper bound of 6 by 25% should be 7")
				);		
	}
	
	@Test
	@Tag("Expand")
	void expandedRangeByFiftyPercent() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expand(exampleRange, 0.5, 0.5);
		assertAll(
				() -> assertEquals(0, result.getLowerBound(), .01d, "Expanding lower bound of 2 by 50% should be 0"),
				() -> assertEquals(8, result.getUpperBound(), .01d, "Expanding upper bound of 6 by 50% should be 8")
				);		
	}
	
	@Test
	@Tag("Expand")
	void expandedRangeBySeventyFivePercent() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expand(exampleRange, 0.75, 0.75);
		assertAll(
				() -> assertEquals(-1, result.getLowerBound(), .01d, "Expanding lower bound of 2 by 75% should be -1"),
				() -> assertEquals(9, result.getUpperBound(), .01d, "Expanding upper bound of 6 by 75% should be 9")
				);		
	}
	
	@Test
	@Tag("Expand")
	void expandedRangeByHundredPercent() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expand(exampleRange, 1, 1);
		assertAll(
				() -> assertEquals(-2, result.getLowerBound(), .01d, "Expanding lower bound of 2 by 100% should be -2"),
				() -> assertEquals(10, result.getUpperBound(), .01d, "Expanding upper bound of 6 by 100% should be 10")
				);		
	}
	
	@Test
	@Tag("Expand")
	void expandedRangeByNegativePercent() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expand(exampleRange, -0.25, -0.25);
		assertAll(
				() -> assertEquals(3, result.getLowerBound(), .01d, "Expanding lower bound of 2 by -25% should be 3"),
				() -> assertEquals(5, result.getUpperBound(), .01d, "Expanding upper bound of 6 by -25% should be 5")
				);		
	}
	
	@Test
	@Tag("Expand")
	void expandedNullRange() {
		
		exampleRange = null;
		//Range result = Range.expand(exampleRange, -0.25, -0.25);
		
		assertThrows(IllegalArgumentException.class, () -> Range.expand(exampleRange, -0.25, -0.25));
	}
	
	/*
	 * Testing for expandToInclude()
	 */
	
	@Test
	@Tag("ExpandToInclude")
	void expandedRangeToIncludeZero() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expandToInclude(exampleRange, 0);
		assertAll(
		() -> assertTrue(result.contains(0), "0 should be part of the range"),
		() -> assertEquals(exampleRange.getLowerBound(), result.getLowerBound(), .01d, "Lower value of result should stay at 2")
		);	
	}
	
	@Test
	@Tag("ExpandToInclude")
	void expandedRangeToIncludeValueAlreadyInRange() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expandToInclude(exampleRange, 5);
		
		assertAll(
				() -> assertTrue(result.contains(5), "5 should be part of the range"),
				() -> assertEquals(exampleRange.getLowerBound(), result.getLowerBound(), .01d, "Lower value of result should stay at 2")
				);	
	}
	
	@Test
	@Tag("ExpandToInclude")
	void expandedRangeToIncludeNegativeValue() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expandToInclude(exampleRange, -1);
		
		assertAll(
				() -> assertTrue(result.contains(-1), "-1 should be part of the range"),
				() -> assertEquals(exampleRange.getLowerBound(), result.getLowerBound(), .01d, "Lower value of result should stay at 2")
				);	
	}
	
	@Test
	@Tag("ExpandToInclude")
	void expandedRangeToIncludePositiveValue() {
		
		exampleRange = new Range(2,6);
		Range result = Range.expandToInclude(exampleRange, 100);
		assertAll(
				() -> assertTrue(result.contains(100), "100 should be part of the range"),
				() -> assertEquals(exampleRange.getLowerBound(), result.getLowerBound(), .01d, "Lower value of result should stay at 2")
				);	
	}
	
	@Test
	@Tag("ExpandToInclude")
	void expandedNullRangeToIncludeValue() {
		
		exampleRange = null;
		Range result = Range.expandToInclude(exampleRange, 5);
		assertAll(
				() -> assertTrue(result.contains(5), "5 should be part of the range"),
				() -> assertEquals(5, result.getLowerBound(), .01d, "Lower value of result should stay at 5")
				);	
	}
	
	/*
	 * Testing for centralValue()
	 */
	
	@Test
	@Tag("CentralValue")
	void centralValueShouldBeZero() {

		exampleRange = new Range(-1,1);
		assertEquals(0, exampleRange.getCentralValue(), .01d, "The central value of -1 and 1 should be 0");
	}
	
	@Test
	@Tag("CentralValue")
	void centralValueShouldBeFifty() {
		
		exampleRange = new Range(0,100);
		assertEquals(50, exampleRange.getCentralValue(), .1d, "The central value of 0 and 100 should be 50");
	}
	
	@Test
	@Tag("CentralValue")
	void centralValueShouldBeNegativeFifty() {
		
		exampleRange = new Range(-100,0);
		assertEquals(-50, exampleRange.getCentralValue(), .01d, "The central value of -100 and 0 should be -50");
	}
	

	/*
	 * Testing for getLength()
	 */
	
	@Test
	@Tag("GetLength")
	void lengthShouldBeZero() {
		
		exampleRange = new Range(1,1);
		assertEquals(0, exampleRange.getLength(), .01d, "The length of range 1 and 1 should be 0");
	}
	
	@Test
	@Tag("GetLength")
	void lengthShouldBeFive() {
		
		exampleRange = new Range(15,20);
		assertEquals(5, exampleRange.getLength(), .01d, "The length of range 15 and 20 should be 5");
	}
	
	@Test
	@Tag("GetLength")
	void lengthShouldBeHundred() {
		
		exampleRange = new Range(0,100);
		assertEquals(100, exampleRange.getLength(), .01d, "The length of range 0 and 100 should be 100");
	}
	
	/*
	 * Testing for getLowerBound()
	 */
	
	@Test
	@Tag("GetLowerBound")
	void lowerBoundShouldBeNegativeFive() {
		
		exampleRange = new Range(-5,1);
		assertEquals(-5, exampleRange.getLowerBound(), .01d, "The lower bound of range -5 and 1 should be -5");
	}
	
	@Test
	@Tag("GetLowerBound")
	void lowerBoundShouldBeZero() {
		
		exampleRange = new Range(0,10);
		assertEquals(0, exampleRange.getLowerBound(), .01d, "The lower bound of range 0 and 10 should be 0");
	}
	
	@Test
	@Tag("GetLowerBound")
	void lowerBoundShouldBeHundred() {
		
		exampleRange = new Range(100,500);
		assertEquals(100, exampleRange.getLowerBound(), .01d, "The lower bound of range 100 and 500 should be 100");
	}
	
	@Test
	@Tag("toString")
	public void toStringTestLower() {
		assertAll(
				() -> assertEquals("Range[-10.0,0.0]", new Range(-10.0, 0.0).toString(), "Should print Range[-10.0,0.0]"),
				() -> assertEquals("Range[-1.0,1.0]", new Range(-1.0, 0.0).toString(), "Should print Range[-1.0,0.0"),
				() -> assertEquals("Range[-50.0,0.0]", new Range(-50.0, 0.0).toString(), "Should print Range[-50.0,0.0]")
				);
	}
	
	@Test
	@Tag("toString")
	public void toStringTestUpper() {
		exampleRange = new Range(0.0, 10.0);
		assertEquals("Range[0.0,10.0]", exampleRange.toString(), "Should print Range[0.0,10.0]");
	}
	
	@Test
	@Tag("toString")
	public void toStringTestZeroAll() {
		exampleRange = new Range(0.0, 0.0);
		assertEquals("Range[0.0,0.0]", exampleRange.toString(), "Should print Range[0.0,0.0]");
	}
	
	@Test
	@Tag("toString")
	public void toStringTestNegative() {
		assertAll(
				() -> assertEquals("Range[-11.0,-10.0]", new Range(-11.0, -10.0).toString(), "Should print Range[-11.0,-10.0]"),
				() -> assertEquals("Range[-51.0,-50.0]", new Range(-51.0, -50.0).toString(), "Should print Range[-51.0,-50.0]"),
				() -> assertEquals("Range[-101.0,-10.0]", new Range(-101.0, -100.0).toString(), "Should print Range[-101.0,-100.0]")
				);
	}
	
	@Test
	@Tag("shift(Range, double)")
	public void shiftRightTestNoDelta() {
		exampleRange = new Range(0.0, 10.0);
		Range expectedRange = new Range(5.0, 10.0);
		assertEquals(expectedRange, Range.shift(exampleRange, 5.0), "exampleRange should be equal to expectedRange");
	}
	
	@Test
	@Tag("shift(Range, double)")
	public void shiftLeftTestNoDelta() {
		exampleRange = new Range(0.0, 0.0);
		Range expectedRange =  new Range(-5.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, -5.0), "exampleRange should be equal to expectedRange");
	}
	
	@Test
	@Tag("shift(Range, double)")
	public void shiftPositiveFalseNoDelta() {
		exampleRange = new Range(-5.0, 0.0);
		Range expectedRange = new Range(0.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, 10.0), "exampleRange should be equal expectedRange");
	}
	
	@Test
	@Tag("shift(Range, double)")
	public void shiftNegativeFalseNoDelta() {
		exampleRange = new Range (0.0, 0.0);
		Range expectedRange = new Range (0.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, -6.0), "exampleRange should be equal to expectedRange");
	}
	
	@Test
	@Tag("shift")
	public void shiftRightTest() {
		exampleRange = new Range(0.0, 10.0);
		Range expectedRange = new Range(5.0, 10.0);
		assertEquals(expectedRange, Range.shift(exampleRange, 5.0, true), "exampleRange should be equal to expectedRange");
	}
	
	@Test
	@Tag("shift")
	public void shiftLeftTest() {
		exampleRange = new Range(0.0, 0.0);
		Range expectedRange =  new Range(-5.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, -5.0, true), "exampleRange should be equal to expectedRange");
	}
	
	@Test
	@Tag("shift")
	public void shiftPositiveFalse() {
		exampleRange = new Range(-5.0, 0.0);
		Range expectedRange = new Range(0.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, 10.0, false), "exampleRange should be equal expectedRange");
	}
	
	@Test
	@Tag("shift")
	public void shiftNegativeFalse() {
		exampleRange = new Range (0.0, 0.0);
		Range expectedRange = new Range (0.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, -6.0, false), "exampleRange should be equal to expectedRange");
	}
	
	@Test
	@Tag("shift")
	public void shiftZeroTest() {
		exampleRange = new Range(0.0, 0.0);
		Range expectedRange = new Range (0.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, 0.0, false), "exampleRange should equal to expectedRange");
	}
	
	@Test
	@Tag("shift(Range, double)")
	public void shiftZeroTestNoDelta() {
		exampleRange = new Range(0.0, 0.0);
		Range expectedRange = new Range (0.0, 0.0);
		assertEquals(expectedRange, Range.shift(exampleRange, 0.0), "exampleRange should equal to expectedRange");
	}
	
	@Test
	@Tag("intersect")
	public void intersectLowerBoundTest() {
		assertAll(
				() -> assertTrue(new Range(0.0, 0.0).intersects(0.0, 0.0), "Should return true"),
				() -> assertTrue(new Range(-10.0,0.0).intersects(-11.0, 0.0), "Should return true")
				);
	}
	
	@Test
	@Tag("intersect")
	public void intersectHigherBoundTest() {
		assertAll(
				() -> assertTrue(new Range(0.0, 0.0).intersects(0.0, 0.0), "Should return true"),
				() -> assertTrue(new Range(0.0, 10.0).intersects(0.0, 11.0), "Should return true")
				);
	}
	
	@Test
	@Tag("intersect")
	public void intersectZeroTest() {
		assertTrue(new Range(0.0, 0.0).intersects(0.0, 0.0), "Should return true");
	}
	
	@Test
	@Tag("intersect")
	public void intersectUpperButEqualToLower() {
		assertAll(
			() -> assertFalse(new Range(-2.0, -1.0).intersects(-1.0,0.0), "Should return false"),
			() -> assertFalse(new Range(0.0, 1.0).intersects(1.0, 2.0), "Should return false")
		);	
	}
	
	@Test
	@Tag("intersect")
	public void intersectUpperButLargerThanUpperLessThanLower() {
		assertFalse(new Range(0.0, 1.0).intersects(1.0, 0.0), "Should return false");
	}
	
	@Test
	@Tag("intersect")
	public void intersectUpperButLessThanUpperGreaterThanLower() {
		assertAll(
				() -> assertFalse(new Range(0.0, 1.0).intersects(1.0, 2.0), "Should return false"),
				() -> assertFalse(new Range(0.0, 0.0).intersects(0.0, -1.0), "Should return false")
		);
	}
	
	@Test
	@Tag("intersect")
	public void intersectFail() {
		assertFalse(new Range(0.0, 0.0).intersects(10.0, 20.0), "Should return false");
	}
	
	@Test
	@Tag("intersect")
	public void testIntersect() {
		exampleRange = new Range(1.0, 5.0);
		
		assertFalse(exampleRange.intersects(2.0, 4.0), "Should return false");
	}
	
	@Test
	@Tag("getUpperBound")
	public void getUpperBoundTestZero() {
		assertEquals(0.0, new Range(0.0, 0.0).getUpperBound(), "Should return 0.0");
	}
	
	
	@Test
	@Tag("getUpperBound")
	public void getUpperBoundTestUpper() {
		assertAll(
				() -> assertEquals(10.0, new Range(0.0, 10.0).getUpperBound(), "Should return 10.0"),
				() -> assertEquals(50.0, new Range(0.0, 50.0).getUpperBound(), "Should return 50.0"),
				() -> assertEquals(100.0, new Range(0.0, 100.0).getUpperBound(), "Should return 100.0")
				);
	}
	
	@Test
	@Tag("getUpperBound")
	public void getUpperBoundTestLower() {
		assertAll(
				() -> assertEquals(-5.0, new Range(-10.0, -5.0).getUpperBound(), "Should return -5.0"),
				() -> assertEquals(-50.0, new Range(-51.0, -50.0).getUpperBound(), "Should return -50.0"),
				() -> assertEquals(-100.0, new Range(-101.0, -100.0).getUpperBound(), "Should return -100.0")
				);
	}
	
	@Test
	@Tag("hashCode")
	public void testHashCode() {
		exampleRange = new Range(1.0,5.0);
		
		assertEquals(2118385664, exampleRange.hashCode());
	}

}
