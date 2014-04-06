/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmpprog.sudoku3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Javier
 */
public class FileSudokuBoardDaoImplTest {

    public FileSudokuBoardDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of write method, of class FileSudokuBoardDaoImpl.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        //SudokuBoard sudoku = new SudokuBoard();
        Dao<SudokuBoard> dao = DaoFactory.createFileSudokuBoardDao("sudokuSolved");
        //dao.write(sudoku);
        Dao<SudokuBoard> dao2 = DaoFactory.createFileSudokuBoardDao("sudokuSolved2");

        SudokuBoard sudoku1 = dao2.read();

        SudokuBoard sudoku2 = dao.read();
        assertTrue(sudoku1.equals(sudoku2));

    }

    /**
     * Test of read method, of class FileSudokuBoardDaoImpl.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        FileSudokuBoardDaoImpl instance = null;
        SudokuBoard expResult = null;
        SudokuBoard result = instance.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
