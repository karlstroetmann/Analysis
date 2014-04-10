import java.util.*;
import static java.lang.Math.*;

public class SecantMethod {
	// This function locates the zero of the function f in the intervall [a, b]
	// using the secant method.
	static double findZero(double a, double b, double eps) {
		int    count = 0;
		double fa  = f(a); ++count;
		double fb  = f(b); ++count;
		for (int i = 1; abs(b - a) > eps; ++i) {
			double c  = (fb * a - fa * b) / (fb - fa);
			System.out.printf(java.util.Locale.ENGLISH,
							  "%3d: b = %-13.11g, f(b) = %+10.8e\n",
							  i, b, f(b));
			a = b; b = c; fa = fb; fb = f(c); ++count;
		}
		System.out.println("number of function evaluations: " + count);
		return b;
	}

	static double f(double x) {
		// return x - cos(x);
		// return x * x * x - 1;
		return cos(x);
	}

	public static void main(String args[]) {
		System.out.println("Zero is: " + findZero(2.0, 0.713661915, 1e-12) );
	}
	
}

			