class Solution {
    
    List<List<String>> res = new ArrayList<>();
    int size;
    
    public List<List<String>> solveNQueens(int n) {
        
        size = n;
        
        boolean[][] state = new boolean[n][n];
        
        solveNQueensHelper(state, 0);
                
        return res;
    }
    
    public void  buildStringArray(boolean[][] state) {
        
        List<String> currRes = new ArrayList<>();
                        
        for (int i = 0; i < size; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < size; j++) {                    
                if (state[i][j] == false)
                    s.append('.');
                else
                    s.append('Q');
            }                
            currRes.add(s.toString());
        }
        
        res.add(currRes);    
        
    }
    
    public boolean isSafe(boolean[][] state, int row, int col) {
        int diff = col-row;
            
        for(int i = 0; i < size; i++) {
            
            if (i != row && (row+col-i) >= 0 
                    && (row+col-i) < size && state[i][row+col-i] == true)
                return false;
            
            if (i != row && (i + diff) >= 0 && (i+diff) < size && state[i][i+diff] == true)
                return false;
            
            if(col != i && state[row][i] == true)
                return false;
            
            if (row != i && state[i][col] == true)
                return false;
        }
        
        return true;
        
    }
    
    public void solveNQueensHelper(boolean[][] state, int row) {
        
        if (row >= size) {
            
            buildStringArray(state);
            return;
        }
        
        for(int i = 0; i < size; i++) {
            
            state[row][i] = true;
            
            if (isSafe(state, row, i)) 
                solveNQueensHelper(state, row+1);
            
            state[row][i] = false;
        }
        
        
    }
    
    
}
