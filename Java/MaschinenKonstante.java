import java.util.*;

public class MaschinenKonstante {
    public static void main(String[] args) {
	float  eps1 = singlePrecisionEps();
	double eps2 = doublePrecisionEps();
	System.out.println("eps single precission = " + eps1);	
	System.out.println("eps double precission = " + eps2);	
    }

    public static float singlePrecisionEps() {
	float eps = 1.0F;
        float old = eps;
        while (1.0F + eps > 1.0F) {
            old  = eps;
            eps *= 0.5F;
        }
        return old;
    };
    public static double doublePrecisionEps() {
	double eps = 1.0;
        double old = eps;
        while (1.0 + eps > 1.0) {
            old  = eps;
            eps *= 0.5;
        }
        return old;
    };
}
