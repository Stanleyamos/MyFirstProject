package com.calculator;

import java.util.Scanner;

public class CalculatorMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a calulator application");
		System.out.println("\n");
		System.out.println("You're required to input your arithemetic operations in the following format; \n 'a+b-c or b-a*c etc' you can only supply 3 numbers with the arithemetic operators");

		try {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Please enter the question: ");
			String question = scanner.nextLine();

			System.out.println("You entered: " + question);

			scanner.close();

			// Execute the question

			int result = (int) new Executor(question).validateInput();


			System.out.println("Result= "+result);


		} 
		catch (NumberFormatException e) {
			System.out.println("An invalid integer was entered");
		}
		catch (ArithmeticException e) {
			System.out.println("Bad arithimetic operation");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Illegal arithimetic operations");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


