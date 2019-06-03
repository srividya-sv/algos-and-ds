#include<stdio.h>

void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
}
 
int partition(int a[], int start , int end) {
	
	int pIndex = start; 

	for(int i = start; i < end; i++) {
		if(a[i] < a[end]) {
			swap(a, pIndex, i);		
			pIndex++;
		}
	}	

	swap(a, pIndex, end);
	return pIndex; 
}


int kthLargestInteger(int a[], int start, int end, int k) {
	
	if(start >= end)
		return 0; 
	int pivot = 0;
	int n = end ;

	do {
		pivot = partition(a, start, end); 
		if (pivot == n-k+1) 
			return a[pivot]; 
		else if (pivot < n-k+1) {
			start = pivot+1; 
		} else {
			end = pivot-1 ;
		}
	} while(start < end);

	return a[end];
	
}

int main(){
	int a[] = { 1, 33, 12, 9, -1, 3, -22, 5, 7, 11, 22 }; 
	int n = sizeof(a)/ sizeof(a[0]);
	int i = 0;
	int k = 4; 
	int value = kthLargestInteger(a, 0, n-1, k);

	printf("%d\n", value); 
	return 0;
}
