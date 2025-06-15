package com.features;

import java.util.Scanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataParametarizationStepDef {
	double x,y,result;
	private int marks1;
	@Given("Please pass two numbers, {double} and {double} for to perform the addition")
	public void inputTwoNumbers(double int1, double int2) {
		this.x=int1;
		this.y=int2;

		System.out.println("First value is:- " + int1);
		System.out.println("Second value is:- " + int2);

	}

	@When("perform the addition of above numbers")
	public void additionOfTwoNumbers() {
		result=x+y;
		System.out.println("Addition of two number is " +result);

	}

	@Then("check addition result is even or odd")
	public void verifyEvenOrOdd() {
		if(result%2==0) {
			System.out.println("Addition result is Even ");
		}else {
			System.out.println("Addition result is Odd ");
		}
	}
	
	@Given("Enter your marks")
	public int inputMarks() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter your marks");
		int marks=sc.nextInt();
		this.marks1=marks;
		return marks;
	}
	
//	@When("")
//	public void () {
//		
//	}
	//cucumber does not have boolean data type
}
