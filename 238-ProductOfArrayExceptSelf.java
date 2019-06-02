class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        
        int countZeros = 0;
        
        for(int i = 0; i < len; i++) {
            if (nums[i] == 0) 
                countZeros++;
        }
        
        if (countZeros > 1) {
            return new int[len];
        }
                
        int left[] = new int[len];
        int right[] = new int[len];
        left[0] = 1;
        right[len-1] = 1;
        // Product of everything from the left excluding itself
        for(int i = 1; i < len; i++) {
            left[i] = left[i-1] * nums[i-1];
            right[len-1-i] = right[len-i] * nums[len-i];
        }
        
        // Backwards, product of everything from the right is 
        // maintained in right, and its multiplied with output
        // to get the final values
        // For the last value, right = 1
        
        for(int i = 0; i < len ; i++) {
            left[i] *= right[i];
        }
        
        return left;
        
    }
}
