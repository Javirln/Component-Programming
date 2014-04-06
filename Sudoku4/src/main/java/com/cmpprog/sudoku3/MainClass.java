/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmpprog.sudoku3;

/*
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 *
 */
public class MainClass {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Dao<SudokuBoard> file = DaoFactory.createFileSudokuBoardDao("sudokuToRead");
        BacktrackingSudokuSolver backtrackingSolver = new BacktrackingSudokuSolver();
        backtrackingSolver.solve(file.read());
        
    }
}
