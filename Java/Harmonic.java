import java.util.*;

public class Harmonic {
    public static void main(String[] args) {
	harmonic();
    }

    public static float harmonic() {
	float oldSum = 0.0F;
	float sum    = 1.0F;
	int   n      = 1;
	while (oldSum < sum) {
	    oldSum = sum;
	    n += 1;
	    sum += 1.0/n;
	    if (n % 100000 == 0) {
		System.out.println("n = " + n + ", sum = " + sum);
	    }
	}
	System.out.println("n = " + n + ", sum = " + sum);
	return sum;
    };
}
