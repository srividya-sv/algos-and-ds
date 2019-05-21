/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/ 

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int cols = board[0].length;
        int rows = board.length; 
        boolean [][] visited = new boolean[rows][cols]; 
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // Start from every element in the board to see if we get a valid word starting from any point
                if (searchBoard(board, visited, word, 0, i, j) == true) 
                    return true;
            }
        }
        return false;
    }
    
    // DFS with backtracking is done in this method
    
    public boolean searchBoard(char[][] board, boolean[][] visited, String word, 
                               int wordIndex, int row, int col) {
        // When we have reached the end of the word through recursion, we return true
        if (wordIndex == word.length()) 
            return true; 
        
        // Invalid board location returns false
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) 
            return false; 
        
        // if this character is valid, check if unvisited neighbors help in forming the word
        
        if(visited[row][col] == false && board[row][col] == word.charAt(wordIndex)) {
            visited[row][col] = true; 
            if( searchBoard(board, visited, word, wordIndex+1, row-1, col) || 
                searchBoard(board, visited, word, wordIndex+1, row, col-1) ||
                searchBoard(board, visited, word, wordIndex+1, row+1, col) ||
                searchBoard(board, visited, word, wordIndex+1, row, col+1)) 
                return true; 
            else
                visited[row][col] = false;
        } 
                
        return false; 
    }
    
}
