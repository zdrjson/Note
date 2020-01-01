class Solution {
    private int w;
    private int h;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        h = board.length;
        w = board[0].length;
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {
                if (search(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int d, int x, int y) {
        if (x < 0 || x == w || y < 0 || y == h || word.charAt(d)!= board[y][x]) {
            return false;
        }
        
        // Found the last char of the word
        if (d == word.length() - 1) {
            return true;
        }
        
        char cur = board[y][x];
        board[y][x] = 0; // 这里Java居然也可以
        boolean found = search(board, word, d + 1, x + 1, y) 
                     || search(board, word, d + 1, x - 1, y)
                     || search(board, word, d + 1, x, y + 1)
                     || search(board, word, d + 1, x, y - 1);
        board[y][x] = cur;
        return found;
    }
}
