import java.util.*;
import static java.lang.Math.*;

public class RegulaFalsi {
	// This function locates the zero of the function f in the intervall [a, b].
	// It is assumed that a < b and f(a) < f(b) holds initially.
	// The argument n specifies the number of iterations.
	static double findZero(double a, double b, int n) {
		assert a < b                : "Error: a < b";
		assert f(a) < 0 && f(b) > 0 : "Error: f(a) < 0 && f(b) > 0";
		int    count = 0;
		double fa  = f(a); ++count;
		double fb  = f(b); ++count;
		for (int i = 1; fa != 0.0 && fb != 0.0 && i <= n; ++i) {
			double c  = (fb * a - fa * b) / (fb - fa);
			double fc = f(c); ++count;
			System.out.printf(java.util.Locale.ENGLISH,
							  "%3d: a = %-13.11f, b = %-13.11f, c = %-13.11f, " +
                              "f(a) = %-10.8e, f(b) = %-10.8e, f(c) = %-10.8e\n",
							  i, a, b, c, f(a), f(b), f(c));
			if (fc <= 0.0) {
				a = c; fa = fc; 
			} else {
				b = c; fb = fc; 
			}
		}
		System.out.println("number of function evaluations: " + count);
		return -fa < fb ? a : b;
	}

	static double f(double x) {
		return -cos(x);
		// return x * x * x * x - 1;
	}

	public static void main(String args[]) {
		System.out.println("Zero is: " + findZero(1.0, 2.0, 4) );
	}
	
}

			