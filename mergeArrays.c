#include<stdio.h>

void merge_arrays(int X[], int Y[], int m, int n) {
	int rd = 0, wr = 0; 
	while(rd < m) {
		if(X[rd] != 0) {
			X[wr++] = X[rd];
		}
		rd++;	
	}
	rd = wr-1; 
	int rd_y = n-1; 
	wr = m-1;
	while(wr >= 0) {
		if(X[rd] <= Y[rd_y] ) {
			X[wr--] = Y[rd_y--];
		} else {
			X[wr--] = X[rd--]; 
		}
	}
}

// main function
int main()
{
	// vacant cells in X[] is represented by 0
	int X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0};
	int Y[] = { 1, 8, 9, 10, 15 };

	int m = sizeof(X) / sizeof(X[0]);
	int n = sizeof(Y) / sizeof(Y[0]);

	// validate input before calling rearrange()
	// 1. Both arrays X[] and Y[] should be sorted (ignore 0's in X[])
	// 2. size of array X[] >= size of array Y[] (i.e. m >= n)
	// 3. Number of vacant cells in array X[] = size of array Y[]

	merge_arrays(X, Y, m, n);	

	// print merged array
	for (int i = 0; i < m; i++) {
		printf("%d ", X[i]);
	}

	return 0;
}
