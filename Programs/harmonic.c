#include <stdio.h>

int main() {
    double s = 0;
    double i = 1;
    while (1) {
        float oldS = s;
        s += 1/i;
        ++i;
        if (oldS == s) {
            break;
        }
    }
    printf("s = %f\n", s);
    printf("i = %f\n", i);
}

        
    
