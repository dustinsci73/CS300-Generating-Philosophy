//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (Generating Philosophy)
// Files:           (Main.java, Generator.java, NumberGenerator.java, EvenNumberGenerator.java, 
//					NextWikiLinkFunction.java)
// Course:          (CS300 Fall 2017)
//
// Author:          (Dustin Li)
// Email:           (dli284@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (Brennan Fife)
// Partner Email:   (bfife@wisc.edu)
// Lecturer's Name: (Gary Dahl)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (NONE)
// Online Sources:  (NONE)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Generates consecutive even numbers following the first even number.
 */
public class EvenNumberGenerator implements Iterable<Integer>, Iterator<Integer>
{
	private Integer firstEven;	// first even number generated
	private Integer intEven;		//current even number being generated
	private int counter; 		//count of even numbers left to be generated
	
	/**
	 * Initializes a new EvenNumberGenerator to return a single even number
	 * each time it's next() method is called.  The first even number returned
	 * in this way is firstEven.  Subsequent even numbers returned in this way
	 * will be the smallest even number that is larger than the previous.
	 * <p>
	 * After numberOfEvens numbers have been generated and returned from this 
	 * next() method, the generator will end: its hasNext() method will return 
	 * false, and its next() method will throw a NoSuchElementException when 
	 * called after this point.
	 * 
	 * @param numberOfEvens - the number of evens that can be generated
	 * @param firstEven - the first and smallest even that will be generated
	 * @throws IllegalArgumentException - when numberOfEvens is negative, or
	 *                                    when firstEven is not an even number
	 */
	public EvenNumberGenerator(int numberOfEvens, Integer firstEven) throws IllegalArgumentException 
	{
	   if (numberOfEvens < 0 || firstEven%2 != 0)
	   {
		   throw new IllegalArgumentException();
	   }
	   else 
	   {
		   this.firstEven = firstEven;
		   intEven = firstEven;
		   counter = numberOfEvens;
	   }
	}
	
	/*
	 * Checks to see if counter equals 0, and if it does, returns false, ending the generator.
	 */
	@Override
	public boolean hasNext() 
	{
		if (counter == 0)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	/*
	 * Generates the consecutive even number to the previous even number
	 * 
	 * @throws NoSuchElementException - when there are no more even numbers to generate
	 * @return n - consecutive even number that is generated
	 */
	@Override
	public Integer next() 
	{
		if (counter == 0)
		{
			throw new NoSuchElementException();
		}
		else 
		{
			counter--;
			int n = intEven;
			intEven += 2;
			return n;
		}
	}
	
	@Override
	public Iterator<Integer> iterator() 
	{
		return new EvenNumberGenerator(counter, firstEven);
	}
}
