// Shuffle.java
// Courtenay Roche & Corinne Bintz
// CS 201  HW 1, Problem 3

public class Shuffle {
  // A = identity array
  // L = length of array A
  // P = perfect shuffle of array A
  // B = array A [0...L/2] used to create the perfect shuffle of A
  // C = array A [L/2...L-1] used to create the perfect shuffle of A
  // int lo = the starting shuffle period printed in main
  // int hi = the upper bound of the shuffle periods printed in main
  // k = the length of each array printed in main

  public static void main(String[] args) {
    printShufflePeriods(2,100);
  }


  public static void printShufflePeriods(int lo, int hi) {
    // Prints even shuffle periods between lo and hi.
    // Assume lo and hi are even;

    for(int k=lo; k<=hi; k+=2){
      System.out.println("shufflePeriod(" + k + ")=" + shufflePeriod(k));
    }

  }

  // Computes shuffle period for a deck of size L.
  // (The shuffle period is the smallest number of perfect shuffles
  // necessary to bring the deck back into its originial order.)
  public static int shufflePeriod(int L) {
    // Finds the shuffle period of an identity array A of length L
    // Assume L is even.
    int count = 1;
    int [] A;

    A=identity(L);
    A=perfectShuffle(A);

    while (isIdentity(A)==false) {
      A=perfectShuffle(A);
      count+=1;
    }
    return count;
  }

  // Performs a perfect shuffle.
  // Returns a new array that's a perfect shuffle of A
  public static int[] perfectShuffle(int[] A) {
    // Creates array P, a perfect shuffle of array A
    // Assume A has even length

    int [] B;
    int [] C;
    int [] P;

    B=new int[A.length/2];
    C=new int[A.length/2];

    for(int i=0; i<=(A.length/2)-1; i++){
      B[i] = A[i];
    }

    for(int i=0; i<=(A.length/2)-1; i++){
      C[i] = A[i + (A.length/2)];
    }

    P=new int[A.length];

    for(int i=0; i<=A.length-1; i++){
      if(i%2==0){
        P[i]=B[(i/2)];
      }
      else{
        P[i]=C[i/2];
      }
    }

    return P;

  }

  public static int[] identity(int L) {
    // Returns an identity array of length L
    // creates new array of length L
    // fills it with numbers 0 .. L-1
    // returns it
    int [] A;
    A = new int[L];

    for (int i=0; i < A.length; i++){
      A[i] = i;
    }

    return A;

  }

  public static boolean isIdentity(int[] A) {
    // Returns whether array A is the identity array.

    for (int i=0; i < A.length; i++){
      if (A[i] != i) {
        return false;
      }
    }
    return true;
  }

  public static String intArrayToString(int[] A) {
    // Creates a string representation of integer array A.

    String s = "[";
    if (A.length > 0) {
      s += A[0];
      for (int i = 1; i < A.length; i++) {
        s += (", " + A[i]);
      }
    }
    s += "]";
    return s;
  }
}
