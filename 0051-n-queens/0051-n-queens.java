class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        // Create the chessboard
        char[][] board = new char[n][n];

        // Fill the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start backtracking from row 0
        backtrack(board, 0, result);

        return result;
    }

    private void backtrack(char[][] board, int row,
                           List<List<String>> result) {

        // All queens are placed
        if (row == board.length) {

            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        // Try placing queen in every column
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                backtrack(board, row + 1, result);

                // Backtrack: remove queen
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}