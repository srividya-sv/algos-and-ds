#include<stdio.h>

int findIndexofZero(int arr[], int n) {
	int prevStartOfOne = -1; 
	int i = 0;
	int count = 0, maxCount = 0, prevCount = 0; 
	int maxIndex = 0;
	int prevZero = -1, zeroIndex = -1;  
	for(i = 0 ; i < n; i++) {

		if(arr[i] == 1) {
			if(i == 0 || arr[i-1] == 0) {
				prevStartOfOne = i;
			}
			count++; 
		} else { 
			if(maxCount < count + prevCount + 1) {
				maxCount = count + prevCount + 1;
				zeroIndex = i;	
			}
 			prevZero = i; 
			prevCount = count; 
			count = 0; 
		}	
	}

	if(count+prevCount+1 > maxCount) {
		return prevZero; 
	} 

	return zeroIndex; 

}


// main function
int main(void)
{

	int arr[] = { 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1 };
	
	int n = sizeof(arr) / sizeof(arr[0]);

	int index = findIndexofZero(arr, n);

	if (index != -1)
		printf("Index to be replaced is %d", index);
	else
		printf("Invalid input");

	return 0;
}
