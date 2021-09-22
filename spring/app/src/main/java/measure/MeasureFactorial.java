package measure;

import calculator.Calculator;

public class MeasureFactorial {

	private Calculator cal;
	
	public MeasureFactorial(Calculator cal) {
		
		this.cal = cal;
		
	}
	
	public long factorial(long n) {
		
		long start = System.currentTimeMillis();
		long ret = cal.factorial(n);
		long end = System.currentTimeMillis();
		
		System.out.println((double)(end-start)/1000);
		
		return ret;
		
	}
	
}
