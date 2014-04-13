package com.cmpprog.sudoku3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 *
 */
public class SudokuRow implements Cloneable, Serializable {

    private int row;
    private List<Integer> elementsInRow = new ArrayList<Integer>();
    private List<List<Integer>> rowsValues = new ArrayList<List<Integer>>();
    private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    /*public SudokuRow(int row, List<Integer> elementsInRow, List<List<Integer>> rowsValues) {
     this.row = row;
     this.elementsInRow = elementsInRow;
     this.rowsValues = rowsValues;
     }*/
    /*public SudokuRow(Map<Integer, List<Integer>> map) {
    this.map = map;
    }*/

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public List<Integer> getElementsInRow(Map<Integer, List<Integer>> map, int row) {
        return elementsInRow = map.get(row);
    }

    public List<List<Integer>> getRowsValues(Map<Integer, List<Integer>> map) {
        for (List<Integer> list : map.values()) {
            Collections.addAll(rowsValues, list);
        }
        return rowsValues;
    }
}
