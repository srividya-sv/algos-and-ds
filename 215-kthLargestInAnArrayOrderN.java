/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
     
        int len = nums.length; 
        int low = 0, high = len-1; 
        int pivot = len-1 ;
        int i = 0, j = 0; 
        
        while(low <= high) {
            j = low-1; i = low; pivot = nums[high]; 
            do {
                if(nums[i] > pivot) {
                    int temp = nums[++j] ;
                    nums[j] = nums[i] ;
                    nums[i] = temp;
                }
                i++; 
            } while(i < high);
            int temp = nums[high] ;
            j++;
            nums[high] = nums[j];
            nums[j] = temp; 
            
            if (j == k-1) 
                return nums[j] ;
            else if (j < k-1) {
                low = j+1; 
            } else 
                high = j-1;
        }
        return -1;
        
    }
    
}
