package main;

import calculator.ImpeCalculator;
import calculator.RecCalculator;
import measure.MeasureFactorial;

public class MeasureMain {

	public static void main(String[] args) {
		
		MeasureFactorial mf = new MeasureFactorial(new ImpeCalculator());
		mf.factorial(100000);
		
		mf = new MeasureFactorial(new RecCalculator());
		mf.factorial(100000);
		
	}
	
}
