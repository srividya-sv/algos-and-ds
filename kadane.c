#include<stdio.h>

int kadane(int a[], int n, int *max_start, int *max_end) {
	int sum = 0, maxSum = 0;
	int i = 0, start_i = 0 ;
	for(i = 0; i < n; i++) {
		if (sum < 0) {
			sum = 0;
			start_i = i; 
		}
		sum += a[i] ; 
		if(maxSum < sum) {
			*max_start = start_i;
			*max_end = i;
			maxSum = sum;
		}
	}
		
	return maxSum;

}

int main(){
	
	int a[] = { -2, -12, -4, 5,-19, 10, 12}; 
	int n = sizeof(a)/sizeof(a[0]);
	int max_start = 0, max_end = 0, max_sum = 0; 
	max_sum = kadane(a, n, &max_start, &max_end);
	printf("%d %d %d \n", max_sum, max_start, max_end);
	return 0;
}
