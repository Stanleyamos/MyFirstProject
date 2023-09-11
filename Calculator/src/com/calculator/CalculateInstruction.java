package com.calculator;

public abstract class CalculateInstruction {
	private String question;
	private String[] result;
	
	public abstract double validateInput();
	
	public abstract void checkInputTokens();

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getResult() {
		return result;
	}

	public void setResult(String[] result) {
		this.result = result;
	}

}
