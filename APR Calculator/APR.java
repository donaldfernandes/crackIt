
public class APR {
	
	
	
    static int numPay = 24;
    static float payment = 344.0f;
	static int amount = 7500;

	
	
public static void main ( String args[]){
	
	double error = Math.pow(11,-6);
	double approx = 0.25/12; // let's start with a guess that the APR is 5% 
	double prev_approx;

			for (int k=0;k<20;++k) {
			       prev_approx = approx;
			       approx = prev_approx - F(prev_approx)/F_1(prev_approx);
			      double diff = Math.abs(approx-prev_approx);
			       System.out.println( "new guess" + approx +"diff is" + diff);
			       if (diff < error) break;
			}

			double apr = approx * 24 * 10000/100; // this way we get APRs like 7.5% or 6.55%
			System.out.println( "APR is "+ apr + "final approx"  +approx) ;	



}



public static double F(double x) {
  return amount * x * Math.pow(1 + x,numPay)/(Math.pow(1 + x,numPay) - 1) - payment;
}

public static double  F_1( double x) {
  return amount * ( Math.pow(1 + x,numPay)/(-1 + Math.pow(1 + x,numPay)) - numPay * x * Math.pow(1 + x,-1 + 2*numPay)/Math.pow(-1 + Math.pow(1 + x,numPay),2) + numPay * x * Math.pow(1 + x,-1 + numPay)/(-1 + Math.pow(1 + x,numPay))); 
}


}
