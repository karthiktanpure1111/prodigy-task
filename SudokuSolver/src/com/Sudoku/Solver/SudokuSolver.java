package com.Sudoku.Solver;

import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] inputGrid = new int[9][9];

        System.out.println("Enter the Sudoku grid (0 for empty cells):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                inputGrid[i][j] = scanner.nextInt();
            }
        }

        SudokuBoard board = new SudokuBoard(inputGrid);

        if (board.solve()) {
            board.printBoard();
        } else {
            System.out.println("No solution exists for the given puzzle.");
        }

        scanner.close();
    }
}
