
// https://leetcode.com/problems/valid-sudoku/description/

class Solution {
    private int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public boolean isValidSudoku(char[][] board) {
        
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            
            if (!validateRow(board[rowIndex])) {
                return false;
            }
        }

        if (!validateColumn(board)) {
            return false;
        }

        return true;
    }

    private boolean validateRow(char[] row) {
        
        clearDigits();
        
        for (int index = 0; index < row.length; index++) {
            
            int number = Character.getNumericValue(row[index]);
            if (number == -1) {
                index++;
                continue;

            }
            
            digits[number] += 1;
        }

        for (int validate = 0; validate < digits.length; validate++) {
            
            if (digits[validate] > 1) {
                return false;
            }
        }

        return true;
    }

    private boolean validateColumn(char[][] board) {

        for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
            
            clearDigits();
            
            for (int rowIndex = 0; rowIndex < board[rowIndex].length - 1; rowIndex++) {
                int number = Character.getNumericValue(board[rowIndex][columnIndex]);
                if (number == -1) {
                    continue;
                }
                digits[number] += 1;
            }

            for (int validate = 0; validate < digits.length; validate++) {
                if (digits[validate] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void clearDigits() {
        
        for (int clear = 0; clear < digits.length; clear++) {
            digits[clear] = 0;
        }
    }
}
