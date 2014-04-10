import java.util.*;

public class Seidel 
{
    Double[][] mA;  Double[] mB;  Double[] mX;

    public Seidel(Double[][] A, Double[] b) {
        mA = A;
        mB = b;
        mX = new Double[b.length];
        for (int i = 0; i < b.length; ++i) {
            mX[i] = 0.0;
        }
    }
    public void iterate() {
        int n = mB.length;
        for (int i = 0; i < n; ++i) {
            mX[i] = mB[i];
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    mX[i] -= mA[i][j] * mX[j];
                }
            }
            mX[i] /= mA[i][i];
        }
    }
    public String toString() {
        String result = "(";
        for (int i = 0; i < mX.length - 1; ++i) {
            result += mX[i] + ", ";
        }
        result += mX[mX.length-1] + ")";
        return result;
    }
    public static void main(String args[]) {
        Double[][] A = { { 4.0, 1.0, 0.0}, 
                         { 1.0, 4.0, 1.0},
                         { 0.0, 1.0, 4.0} };
        Double[]   b = { 5.0, 6.0, 5.0 };
        Seidel j = new Seidel(A, b);
        for (int i = 0; i < 30; ++i) {
            j.iterate();
            System.out.println(j.toString());
        }
    }
}

    