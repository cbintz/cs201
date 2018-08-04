//Corinne Bintz & Courtenay Roche
// Mortgage.java
// CS 201 HW 1 problem 2
public class FindPrincipal {
    //mortgage - given mortgage for budget
    //interest - given interest rate
    // years - given years for mortgage
    // mid - midpoint used in binary search for desired principal
    // Q - upperbound for principal in binary search
    // returns desired principal for given mortgage

    public static double find(double mortgage, double interest,
    double years) {
        //runs findBetween using parameters calculcated in upperBound

        return findBetween(mortgage, interest, years,
        0, upperBound(mortgage, interest, years));
    }

    public static double findBetween(double mortgage, double interest,
    double years, double lo, double hi) {
        //returns desired principal for given mortgage using binary search
        double mid=(hi+lo)/2;
        while ((Math.abs(Mortgage.mortgage(mid, interest, years)-mortgage))>1){
            if
            (Mortgage.mortgage(mid, interest, years)>mortgage) {
                hi=mid;

            }
            else  {
                lo=mid;

            }
            mid=(hi+lo)/2;
        }
        return mid;
    }



    public static double upperBound(double mortgage, double interest,
    double years) {
        //determines an upper bound for finding desired principal in findBetween 
        double Q=1;
        while (Mortgage.mortgage(Q, interest, years)<mortgage) {
            Q=Q*2;
        }

        return Q;
    }





    public static void testFind(double m, double i, double y) {
        System.out.println("find(" + m + ", " + i + ", " + y + ") = "
        + find(m, i, y));
    }

    public static void main(String [] args) {
        testFind(1200.00, 7.00, 30.0);
    }

}
