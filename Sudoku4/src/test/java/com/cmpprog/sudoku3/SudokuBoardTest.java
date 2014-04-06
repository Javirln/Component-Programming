/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmpprog.sudoku3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Javier
 */
public class SudokuBoardTest {

    public SudokuBoardTest() {
    }

    /**
     * Test of getList method, of class SudokuBoard.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        int i = 0;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<Integer> expResult = new ArrayList<Integer>();
        expResult.add(1);
        expResult.add(2);
        map.put(i, expResult);
        SudokuBoard instance = new SudokuBoard(map);
        List<Integer> result = instance.getList(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of setConditions method, of class SudokuBoard.
     */
    @Test
    public void testSetConditions() {
        System.out.println("setConditions");
        int row = 0;
        int col = 1;
        int num = 1;
        SudokuBoard instance = new SudokuBoard();
        boolean expResult = false;
        boolean result = instance.setConditions(row, col, num);
        assertEquals(expResult, result);
        row = 0;
        col = 0;
        num = 9;
        expResult = true;
        result = instance.setConditions(row, col, num);
        assertEquals(expResult, result);
    }

}
