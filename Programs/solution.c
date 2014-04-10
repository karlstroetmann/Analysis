#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main() {
	float x;
	x = 0.7;
	for (int i = 0; i < 50; ++i) {
		x = cos(x);
		printf("x%-2d = %f\n", i+1, x);
	}
}
