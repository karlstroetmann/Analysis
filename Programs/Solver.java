import java.util.*;
import static java.lang.Math.*;

public class Solver {
	double mXn,  mXnMinus1;
	double mFXn, mFXnMinus1;
	double mA,  mB,  mC;
	double mFA, mFB, mFC;
	double mEps;
	int    mCount;    // count the number of function invocations

	public Solver(double a, double b, double eps) {
		assert a < b            : "a has to be less than b";
		mA     = a;
		mB     = b;
		mEps   = eps;
		mCount = 0;
		mFA    = f(a); ++mCount;
		mFB    = f(b); ++mCount;
		assert mFA <= 0 : "f(a) is positive";
		assert mFB >= 0 : "f(b) is negative";
		mXnMinus1  = mA; 
		mXn        = mB;
		mFXnMinus1 = mFA;
		mFXn       = mFB;
	}
	

	// This function locates the zero of the function f in the intervall [mA, mB].
	// The algorithm used is a combination of the secant method and the
	// bisection algorithm which guarantess that the algorithm does not diverge.
	double findZero() {
		for (int i = 1; mFXn != 0.0 && mB - mA > mEps; ++i) {
			mC = (mFXn * mXnMinus1 - mFXnMinus1 * mXn) / (mFXn - mFXnMinus1);
			// Use the secant method if the new value is within the bounds of 
			// the intervall [ma, mB].
			if (mA < mC && mC < mB) { 
				System.out.println("Secant method:  x = " + mC);
				mFC = f(mC); ++mCount;
				updateIntervall();
				continue;
			}
			// Otherwise, use bisection.
			mC  = 0.5 * (mA + mB);
			mFC = f(mC); ++mCount;
			System.out.println("Bisection:      c = " + mC);				
			updateIntervall();
		}
		System.out.println("number of function evaluations: " + mCount);
		return -mFA < mFB ? mA : mB;
	}

	void updateIntervall() {
		mXnMinus1  = mXn;
		mXn        = mC;
		mFXnMinus1 = mFXn;
		mFXn       = mFC;
		if (mFC <= 0.0) {
			mA = mC; mFA = mFC;
		} else {
			mB = mC; mFB = mFC;
		}
	}

	static double f(double x) {
		return x - cos(x);
		// return x * x * x * x - 1;
		// return x * x - 2;
		// return 1 - 2 / (x * x + 1);
	}

	public static void main(String args[]) {
		Solver solver = new Solver(0.0, 10.0, 1e-10);
		System.out.println("Zero is: " + solver.findZero() );
	}
	
}

			