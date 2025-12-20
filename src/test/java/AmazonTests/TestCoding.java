package AmazonTests;
import com.github.javafaker.Faker;
public class TestCoding {

	public static void main(String[] args) {
		
		//Reverse a string "Today is Monday Tomorrow is tuesday" keeping the space intact
		//Add 1,2,3,4,5 as String in Array list and find sum of all elements
		//Find no of duplicates in ArrayList
		//Java program to reverse characters in a string
		//Convert aaBBBccd to a2B3c2d1 in java
		//Write a program to print reverse of fibnocci series of n numbers
		//Write a program to find if a string is palindrome
		//Input array [1,1,2,2,3,4,5,5,6,6] o/p [3,4] find elements which are unique
		//Reverse a no and check if no is palindrome? I/p 12321  O/P 12321
		//Sorting of array in java
		//Print the repeated characters and times in a string without String builder or string buffer class 
		//Reverse each word of a string and keep space between them
		//Duplicate characters in word “India i my country ” without maps , find vowels count

//       System.out.println("test");
		
		
	        Faker faker = new Faker();

	        String name = faker.name().fullName(); // Generates a random full name
	        String address = faker.address().streetAddress(); // Generates a random street address

	        System.out.println("Name: " + name);
	        System.out.println("Address: " + address);

	}

}
