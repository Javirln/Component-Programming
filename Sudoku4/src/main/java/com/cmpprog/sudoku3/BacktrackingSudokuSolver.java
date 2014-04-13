/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmpprog.sudoku3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 *
 */
public class BacktrackingSudokuSolver implements SudokuSolver {

    SudokuBoard sudokuBoard;
    Map<Integer, List<Integer>> board = new HashMap<Integer, List<Integer>>();
    

    int currentRow = 0;
    int currentCol = 0;

    /**
     *
     * @param sudokuBoard
     */
    public void solve(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        this.board = sudokuBoard.getMapBoard();
        System.out.println("Initialization");
        System.out.println(sudokuBoard.toString());
        initializeUiField();
        run();
    }
    
    private void initializeUiField(){
        
    }

    private void run() {
        try {
            // Start to fillBoard the puzzle in the left upper corner
            fillBoard(0, 0);
        } catch (Exception e) {
        }
        System.out.println(currentCol);
        System.out.println(currentRow);
    }

    /**
     * Recursive function to find a valid number for one single cell
     *
     * @param row
     * @param col
     * @throws java.lang.Exception
     */
    public void fillBoard(int row, int col) throws Exception {
        currentCol = col;
        currentRow = row;
        if (row > 8) {
            System.out.println(sudokuBoard.toString());
            FileSudokuBoardDaoImpl file = new FileSudokuBoardDaoImpl("sudokuSolved2");
            file.write(sudokuBoard);
        }

        // If cell is not empty, continue with next cell
        if (board.get(row).get(col) != 0) {
            next(row, col);

        } else {
            List<Integer> ints = new ArrayList<Integer>(9);
            fillList(ints);
            Collections.shuffle(ints);

            // Find valid number for the empty cell
            for (int num = 1; num < 10; num++) {
                int x = ints.get(num - 1);
                if (sudokuBoard.setConditions(row, col, x)) {
                    board.get(row).set(col, x);
                    // Delegate work on the next cell to a recursive call
                    next(row, col);
                }
            }
            // No valid number found, erase and return to caller
            board.get(row).set(col, 0);

        }
    }

    /**
     * Calls fillBoard for the next cell
     *
     * @param row
     * @param col
     * @throws java.lang.Exception
     */
    public void next(int row, int col) throws Exception {
        if (col < 8) {
            fillBoard(row, col + 1);
        } else {
            fillBoard(row + 1, 0);
        }
    }

    private void fillList(List<Integer> ints) {
        if (!ints.isEmpty()) {
            ints.clear();
        }
        for (int i = 1; i <= 9; i++) {
            ints.add(i);
        }

    }
}
