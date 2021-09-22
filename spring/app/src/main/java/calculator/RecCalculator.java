package calculator;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		
		if (num==0) {
			return (long)1;
		}
		
		return num * factorial(num-1);
		
	}
	
}
