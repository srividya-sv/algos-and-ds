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
        if (k > nums.length) return -1; 
        
        Queue<Integer> pq = new PriorityQueue<>(k); 
        // Add the numbers into a min-heap of size-k 
        // and return the topmost element in the min-heap 
        for(int num: nums) {
            pq.offer(num);
            if(pq.size() > k)
                pq.poll(); 
        }
      
        return !pq.isEmpty() ?  pq.poll() : -1 ;
    }
}
