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

import java.util.Scanner;
import java.util.function.Function;

/*
 * Prompts the user to enter the name of a Wikipedia page, then attempts to search through various Wikipedia 
 * pages, based on the function to find the Philosophy page on Wikipedia
 */
public class Main 
{
	/*
	 * Runs the program
	 */
	public static void main(String[] args) 
	{
		System.out.println("Please enter a Wikipedia topic: ");
		Scanner scr = new Scanner(System.in);
		String nxt = scr.nextLine();
		String fin = "";
		if (nxt.contains(" "))
		{
			fin = nxt.replaceAll(" ", "_");
		}
		else
		{
			fin = nxt;
		}
		String finTwo = "/wiki/" + fin;
		int j = 0;
		for(String i : new Generator<String>(100, finTwo, new NextWikiLinkFunction()))
		{
			System.out.println(j + ": " + i);
			if (i.equals("/wiki/Philosophy") || i.contains("FAILED"))
			{
				break;
			}
			else 
			{
				j++;
			}
		}
	}
}

/*
 * Function that takes in an Integer as an input and returns twice its initial value
 * 
 * @return t - doubles the input value
 */
class DoubleFunction implements Function<Integer, Integer>
{
	@Override
	public Integer apply(Integer t) 
	{
		t = t * 2;
		return t;
	}
}

/*
 * Function that takes a String a an input and adds an exclamation mark to the end
 * 
 * @return t + "!" - appends a exclamation mark to the string input
 */
class AddExclamationFunction implements Function<String, String>
{
	@Override
	public String apply(String t) 
	{
		return t + "!";
	}
}
