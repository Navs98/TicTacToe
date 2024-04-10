package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

    @Test
    public void testMakeMove_ValidMove() {
        TicTacToe game = new TicTacToe("Player 1", "Player 2");
        assertTrue(game.makeMove(0, 0)); // Player 1 makes a move
        assertEquals('X', game.board[0][0]); // Check if the move is 'X'
        assertTrue(game.makeMove(1, 1)); // Player 2 makes a move
        assertEquals('O', game.board[1][1]); // Check if the move is 'O'
    }

    @Test
    public void testMakeMove_InvalidMove() {
        TicTacToe game = new TicTacToe("Player 1", "Player 2");
        game.makeMove(0, 0); // Player 1 makes a move
        assertFalse(game.makeMove(0, 0)); // Player 2 tries to make the same move, should be invalid
        assertEquals('X', game.board[0][0]); // Check if the first move is still 'X'
    }

    @Test
    public void testCheckWinner_RowWin() {
        TicTacToe game = new TicTacToe("Player 1", "Player 2");
        game.makeMove(0, 0); // Player 1
        game.makeMove(1, 0); // Player 2
        game.makeMove(0, 1); // Player 1
        game.makeMove(1, 1); // Player 2
        assertFalse(game.checkWinner()); // No winner yet
        game.makeMove(0, 2); // Player 1 wins
        assertTrue(game.checkWinner()); // Player 1 should win
    }

    @Test
    public void testCheckWinner_ColumnWin() {
        TicTacToe game = new TicTacToe("Player 1", "Player 2");
        game.makeMove(0, 0); // Player 1
        game.makeMove(0, 1); // Player 2
        game.makeMove(1, 0); // Player 1
        game.makeMove(1, 1); // Player 2
        assertFalse(game.checkWinner()); // No winner yet
        game.makeMove(2, 0); // Player 1 wins
        assertTrue(game.checkWinner()); // Player 1 should win
    }

    @Test
    public void testCheckWinner_DiagonalWin() {
        TicTacToe game = new TicTacToe("Player 1", "Player 2");
        game.makeMove(0, 0); // Player 1
        game.makeMove(0, 1); // Player 2
        game.makeMove(1, 1); // Player 1
        game.makeMove(0, 2); // Player 2
        assertFalse(game.checkWinner()); // No winner yet
        game.makeMove(2, 2); // Player 1 wins
        assertTrue(game.checkWinner()); // Player 1 should win
    }

    @Test
    public void testIsBoardFull_BoardNotFull() {
        TicTacToe game = new TicTacToe("Player 1", "Player 2");
        assertFalse(game.isBoardFull()); // Initial state, board is not full
        game.makeMove(0, 0); // Player 1
        assertFalse(game.isBoardFull()); // After one move, board is not full
    }

    @Test
    public void testIsBoardFull_BoardFull() {
        TicTacToe game = new TicTacToe("Player 1", "Player 2");
        game.makeMove(0, 0); // Player 1
        game.makeMove(0, 1); // Player 2
        game.makeMove(0, 2); // Player 1
        game.makeMove(1, 0); // Player 2
        game.makeMove(1, 1); // Player 1
        game.makeMove(1, 2); // Player 2
        game.makeMove(2, 0); // Player 1
        game.makeMove(2, 1); // Player 2
        game.makeMove(2, 2); // Player 1
        assertTrue(game.isBoardFull()); // Board is full
    }
}