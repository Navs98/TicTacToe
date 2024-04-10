package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();

        TicTacToe game = new TicTacToe(player1Name, player2Name);

        while (!game.isBoardFull() && !game.checkWinner()) {
            game.printBoard();
            String currentPlayerName = (game.currentPlayer == 1) ? game.player1Name : game.player2Name;
            System.out.print(currentPlayerName + ", enter your move (e.g., a1, b2, c3): ");
            String input = scanner.next();
            int[] position = game.getPositionFromInput(input);

            if (position[0] == -1 || !game.makeMove(position[0], position[1])) {
                System.out.println("Invalid move. Try again.");
            }
        }

        game.printBoard();
        String winnerName = (game.checkWinner()) ? ((game.currentPlayer == 1) ? game.player2Name : game.player1Name) : "Nobody";
        System.out.println("Player " + winnerName + " wins!");

        scanner.close();
    }
}
