/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        getAllPermutations(nums, result, 0, nums.length-1) ;
        
        return result;
    }
    
    public void getAllPermutations(int[] nums, List<List<Integer>> result, int start, int end) {
        if(start > end) return ;
        
        // When the end of the list is reached, add it to the result list
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for(int elem: nums) {
                list.add(elem) ;
            }
            result.add(list); 
            return; 
        }
        
        // Swap every character with the first character, do it recursively
        for(int i = start; i <= end; i++) {
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            getAllPermutations(nums, result, start+1, end) ;
            temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }
    
    
}
