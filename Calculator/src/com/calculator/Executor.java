package com.calculator;

public class Executor extends CalculateInstruction {
	public Executor(String question) {
		this.setQuestion(question);
	}
	@Override
	public double validateInput() {

		String[] tokenResult = this.getQuestion().replaceAll("\\s+", "").split("(?=[-+*/])|(?<=[-+*/])");

		//Set extracted tokens
		this.setResult(tokenResult);

		//Throws exception for invalid integer values
		this.checkInputTokens();

		// Evaluate the result
		return  this.evaluateExpression( this.getResult());
	}

	@Override
	public void checkInputTokens() {
		// TODO Auto-generated method stub

		for(String token: this.getResult()) {

			switch(token) {

			case "+":
			case "-":
			case "*":
			case "/":
				break;
			default: {

				//				try {
				// Attempt to parse the string as an integer
				Integer.parseInt(token);

				//				} catch (NumberFormatException e) {
				//					// If parsing fails, pr is not an instance of Integer
				//					System.out.println(token+" is not an instance of Integer");
				//				}

				break;
			}

			}


		}
	}

	private double performOperation(double operand1, double operand2, char operator) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			if (operand2 == 0) {
				throw new ArithmeticException("Division by zero is not allowed.");
			}
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	private double evaluateExpression(String[] tokens) {

		double result = 0;
		char operator = 0;

		char fr = tokens[0].charAt(0);
		if(fr == '-') {
			tokens[1] = String.valueOf(Integer.parseInt(tokens[1])* (-1));


			int indexToDelete = 0;

			if (indexToDelete >= 0 && indexToDelete < tokens.length) {
				// Create a new array with one less element
				String[] updatedNames = new String[tokens.length - 1];

				// Copy elements before the deleted index
				for (int i = 0; i < indexToDelete; i++) {
					updatedNames[i] = tokens[i];
				}

				// Copy elements after the deleted index
				for (int i = indexToDelete + 1; i < tokens.length; i++) {
					updatedNames[i - 1] = tokens[i];
				}

				// Now, updatedNames contains the "deleted" element removed
				tokens = updatedNames;
			} 
		}

		//comment this to allow more operands
		if(tokens.length > 5) {
			throw new ArithmeticException("Calculator only limited to max of 3 operands.");
		}

		for(int i =0; i< tokens.length; i++) {

			if(i == 0) {
				result = Integer.parseInt(tokens[i]);
				continue;
			}
			
			char checker = tokens[i].charAt(0);
			
			if(Character.isDigit(checker)) {
				if(operator != 0)
				result = this.performOperation(result, Integer.parseInt(tokens[i]), operator);
			}else {
				operator = checker;
			}
		}


		return result;
	}

}
