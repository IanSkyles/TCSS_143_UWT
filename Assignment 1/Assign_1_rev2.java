/*
 * Course: TCSS143 – Fundamentals of Object-Oriented Programming Autumn 2014
 * File Name: Assign1_rev2.java
 * Assignment: 1
 * Due Date: September 30, 2014
 * Instructor: Mr. Schuessler
 * Author: IAN SKYLES
 */ 
import java.util.Scanner;

/** 
 * This program reads the population for towns and then outputs a population graph using stars
 * @Author: Ian Skyles
 * @version September 30, 2014
 */ 

public class Assign_1_rev2{

   public static void main(String[] theArgs) {
      
      Scanner console = new Scanner(System.in);
      
      //the variables below will store the towns population of the corresponding town number
      int town_One = 0, town_Two = 0, town_Three = 0, town_Four = 0, town_Five = 0;
       town_One = getPopulation(1, console);
       town_Two = getPopulation(2, console);
       town_Three = getPopulation(3, console);
       town_Four = getPopulation(4, console);
       town_Five = getPopulation(5, console);      
       System.out.println();
       
       System.out.println("POPULATION GRAPH:");
       drawPopulationBar(1, town_One);
       drawPopulationBar(2, town_Two);
       drawPopulationBar(3, town_Three);
       drawPopulationBar(4, town_Four);
       drawPopulationBar(5, town_Five);
   }
    /**
     *Purpose: takes user input for current towns population
     *Input: Scanner console, the town number
     *Output: integer that represents towns population
     */

   public static int getPopulation(int the_Town_Number, Scanner console){
      int town_population = 0;
      System.out.print("Please enter the population of town " + the_Town_Number + ": ");
      town_population = console.nextInt();
      return town_population;
   }
    /**
     *Purpose: Draw a population graph using stars: 1 star = 1000 people... prints to console
     *Input: the towns number and its population
     *Output: prints *s to screen
     */

   public static void drawPopulationBar(int the_Town_Number, int the_Town_Population) {
      int number_of_stars = 0;
      number_of_stars = (the_Town_Population / 1000);
      System.out.print("Town " + the_Town_Number +": ");
      for(int i = number_of_stars; i > 0; i--) {
         System.out.print("*");
      }
      System.out.println();
   }
}