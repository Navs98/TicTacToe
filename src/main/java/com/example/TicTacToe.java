package com.example;

import java.util.Arrays;

public class TicTacToe {
    final char[][] board = new char[3][3];
    int currentPlayer = 1;
    final String player1Name;
    final String player2Name;

    public TicTacToe(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(board[i][j] + (j < 2 ? " | " : ""));
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean makeMove(int row, int column) {
        if (row < 0 || row >= 3 || column < 0 || column >= 3 || board[row][column] != ' ') {
            return false;
        }
        board[row][column] = (currentPlayer == 1) ? 'X' : 'O';
        currentPlayer = 3 - currentPlayer;
        return true;
    }

    public boolean checkWinner() {
        for (int i = 0; i < 3; ++i) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    public int[] getPositionFromInput(String input) {
        input = input.toLowerCase();
        if (input.length() != 2 || !Character.isLetter(input.charAt(0)) || !Character.isDigit(input.charAt(1))) {
            return new int[]{-1, -1}; // Invalid input
        }
        int row = input.charAt(0) - 'a';
        int column = input.charAt(1) - '1';
        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            return new int[]{-1, -1}; // Out of bounds
        }
        return new int[]{row, column};
    }
}
