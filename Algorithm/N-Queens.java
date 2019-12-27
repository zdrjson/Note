class Solution {
    private List<String> board_;
    private int[] cols_;
    private int[] diag1_;
    private int[] diag2_;
    List<List<String>> sols_;
    public List<List<String>> solveNQueens(int n) {
        sols_ = new ArrayList<List<String>>();
        sols_.clear();
        board_ = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            String item = "";
            for (int j = 0; j < n; ++j) {
                item += ".";
            }
            board_.add(item);
        }
        
        cols_ = new int[n];
        diag1_ = new int[2 * n - 1];
        diag2_ = new int[2 * n - 1];
        
        nqueens(n, 0);
        
        return sols_;
    }
    
    private boolean available(int x, int y, int n) {
        return cols_[x] == 0
            && diag1_[x + y] == 0
            && diag2_[x - y + n - 1] == 0;
    }
    
    private void updateBoard(int x, int y, int n, boolean is_put) {
        cols_[x] = is_put ? 1 : 0;
        diag1_[x + y] = is_put ? 1 : 0;
        diag2_[x - y + n - 1] = is_put ? 1 : 0;
        StringBuilder strb = new StringBuilder(board_.get(y));
        strb.setCharAt(x, is_put ? 'Q' : '.');
        board_.set(y, strb.toString());
    }
    // Try to put the queen on y-th row
    private void nqueens(int n, int y) {
        if (y == n) {
            // found one solution, add to the ans set
            sols_.add(new ArrayList<String>(board_)); // Java 需要这样写
            return;
        }
        
        // Try every column
        for (int x = 0; x < n; ++x) {
            if (!available(x, y, n)) continue;
            updateBoard(x, y, n, true);
            nqueens(n, y + 1);
            updateBoard(x, y, n, false);
        }
    }
}
