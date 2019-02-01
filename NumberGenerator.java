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
import java.util.function.Function;

/*
 * Generates consecutive numbers, after applying the function, to the first number
 */
public class NumberGenerator implements Iterable<Integer>, Iterator<Integer>, Function<Integer, Integer>
{
	private Integer firstEven; //first number 
	private Integer intEven; //consecutive number being generated
	private int counter; //count of numbers left to be generated
	private Function<Integer, Integer> func; //function that applies an arbitrary formula to calculate the 
											//next number being generated
	
	/**
	 * Initializes a new NumberGenerator to return a single number
	 * each time it's next() method is called.  The first number returned
	 * in this way is firstEven.  Subsequent numbers returned in this way
	 * will be the smallest number that is larger than the previous.
	 * <p>
	 * After numberOfEvens numbers have been generated and returned from this 
	 * next() method, the generator will end: its hasNext() method will return 
	 * false, and its next() method will throw a NoSuchElementException when 
	 * called after this point.
	 * 
	 * @param numberOfEvens - the amount of numbers that can be generated
	 * @param firstEven - the first and smallest number that will be generated
	 * @param func - function that calculates the next number to be generated
	 */
	public NumberGenerator(int numberOfEvens, Integer firstEven, Function<Integer,Integer> func) 
	{
	   this.firstEven = firstEven;
	   this.func = func;
	   intEven = firstEven;
	   counter = numberOfEvens;
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
	 * Generates the consecutive number, after applying the function, to the previous number
	 * 
	 * @throws NoSuchElementException - when there are no more numbers to generate
	 * @return n - consecutive number that is generated
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
			intEven = apply(n);
			return n;
		}
	}

	@Override
	public Iterator<Integer> iterator() 
	{
		return new NumberGenerator(counter, intEven, func);
	}

	@Override
	public Integer apply(Integer integer) 
	{
		return func.apply(integer);
	}
}

