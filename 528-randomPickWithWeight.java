class Solution {
    int[] cumulativeSum ;
    Random r = new Random(); 
    int totalSum;
    int size ;
    public Solution(int[] w) {
        
        size = w.length; 
        cumulativeSum = new int[w.length];
        cumulativeSum[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            cumulativeSum[i] = cumulativeSum[i-1] + w[i] ;
        }
        totalSum = cumulativeSum[w.length-1] ;
        
    }
    
    public int pickIndex() {
        
        int num = r.nextInt(totalSum) + 1; 
        int low = 0, high = size-1, mid = 0;
        System.out.println(num) ;
        
        while(low <= high) {
            
            if(high == low) 
                return low; 
            
            mid = low + (high-low)/2 ;
            
            if(cumulativeSum[mid] == num) {
                
                return mid ;
                
            } else if(cumulativeSum[mid] > num) {
                
                if(mid == 0 || cumulativeSum[mid-1] < num)
                    return mid;
                
                else 
                    high = mid-1;
                
            } else if (cumulativeSum[mid] < num) {
                
                low = mid+1;
                
            }
            
        }
        return mid;  
    }
}
