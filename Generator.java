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
 * Generates objects based on the function
 */
public class Generator<T> implements Iterable<T>, Iterator<T>, Function<T,T>
{
	private T firstEven; //first object being generated
	private T intEven; //current object being generated
	private int counter; //amount of objects to be generated
	private Function<T,T> func; //function that applies an arbitrary formula to calculate the 
							   //next object being generated
	
	/**
	 * Initializes a new Generator to return a single object
	 * each time it's next() method is called.  The first object returned
	 * in this way is firstEven.  Subsequent objects returned in this way
	 * will be subject to the function.
	 * <p>
	 * After numberOfEvens objects have been generated and returned from this 
	 * next() method, the generator will end: its hasNext() method will return 
	 * false, and its next() method will throw a NoSuchElementException when 
	 * called after this point.
	 * 
	 * @param numberOfEvens - the number of objects that can be generated
	 * @param firstEven - the first object that will be generated
	 * @param func - function that calculates the next object to be generated
	 */
	public Generator(int numberOfEvens, T firstEven, Function<T,T> func) 
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
	 * Generates the next object in regards to the function
	 * 
	 * @throws NoSuchElementException - when there are no more objects to generate
	 * @return n - next object that is generated
	 */
	@Override
	public T next() 
	{
		if (counter == 0) 
		{
			throw new NoSuchElementException();
		}
		else 
		{
			counter--;
			T n = intEven;
			intEven = apply(n);
			return n;
		}
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new Generator<T>(counter, intEven, func);
	}

	@Override
	public T apply(T t) 
	{
		return func.apply(t);
	}
}

