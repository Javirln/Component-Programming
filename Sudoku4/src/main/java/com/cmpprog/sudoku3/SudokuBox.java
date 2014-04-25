package com.cmpprog.sudoku3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 *
 */
public class SudokuBox implements Cloneable, Comparable, Serializable {

    private int box;
    private List<Integer> elementsInBox = new ArrayList<Integer>();

    public SudokuBox() {

    }

    public List<Integer> getElementsInBox() {
        return this.elementsInBox;
    }

    public List<Integer> getBox(Map<Integer, List<Integer>> map, int column, int row) {
        while (row % 3 != 0) {
            row--;
        }
        while (column % 3 != 0) {
            column--;
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                elementsInBox.add(map.get(row).get(column));
                column++;
            }
            column -= 3;
            row++;
        }
        return elementsInBox;
    }

    @Override
    public SudokuBox clone() throws CloneNotSupportedException {
        SudokuBox res = null;
        try {
            res = (SudokuBox) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return res;
    }

    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
