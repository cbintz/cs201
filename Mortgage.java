//Corinne Bintz & Courtenay Roche
// Mortgage.java
// CS 201 HW 1 problem 1

public class Mortgage {

    // Calculates monthly mortgage from parameters:
    //   P - the principal in dollars
    //   i  - the interest in percent
    //   y  - the duration of the mortgage in years
    //   M - monthly mortgage payment
    // Returns M, the monthly mortagage payment.
    public static double mortgage(double P, double i,
                                  double y) {
    // uses an equation to return monthly mortgage payment using given principal, interest, and years


        double M= (P*(i/1200))/(1-(Math.pow((1/(1+(i/1200))), (12*y))));


        return M;
    }

    public static void print(double P, double i, double y) {

        System.out.printf("principal=%.0f; interest=%.2f; years=%.0f; mortgage=%.2f; total=%.0f; \n", P, i, y, mortgage(P, i, y), (mortgage(P, i, y)*360));

    }

    public static void main (String[] args) {
      for (double i = 5; i <10; i+=0.25) {
	       print(250000, i, 30);
	}


    }
}
