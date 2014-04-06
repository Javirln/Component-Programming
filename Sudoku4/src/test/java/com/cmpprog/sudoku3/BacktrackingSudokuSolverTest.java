/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmpprog.sudoku3;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 */
public class BacktrackingSudokuSolverTest {

    public BacktrackingSudokuSolverTest() {
    }

    /**
     * Test of solve method, of class BacktrackingSudokuSolver.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        SudokuBoard sudokuBoard = new SudokuBoard();
        BacktrackingSudokuSolver instance = new BacktrackingSudokuSolver();
        instance.solve(sudokuBoard);
        boolean res = false;
        int cont = 0;
        Collection<List<Integer>> results = sudokuBoard.getMapBoard().values();
        for (List<Integer> list : results) {
            Set<Integer> set = new TreeSet<Integer>(list);
            if (set.size() == list.size()) {
                cont++;
                System.out.println("Checking...");
            }
            if (cont == 9) {
                res = true;
                System.out.println("Checked!");
            }
        }
        assertTrue(res);
    }
}
