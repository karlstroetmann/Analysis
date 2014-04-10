#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main() {
    double x     = 0.0;
    double alpha = sin(0.0);
    for (int i = 1; i <= 50; ++i) {
        alpha = sin(x);
        x     = 1 / (1 + alpha) * (cos(x) + alpha * x);
        printf("x%-2d = %17.15f\n", i, x);
    }
}
