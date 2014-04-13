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
public class SudokuColumn implements Cloneable, Serializable {

    private int column;
    private List<Integer> elementsInColumn = new ArrayList<Integer>();

    public SudokuColumn(int column, List<Integer> elementsInColumn) {
        this.column = column;
        this.elementsInColumn = elementsInColumn;
    }

    public int getColum() {
        return this.column;
    }

    public List<Integer> getElementsInColumn(Map<Integer, List<Integer>> map, int col) {
        for (List<Integer> aux2 : map.values()) {
            elementsInColumn.add(aux2.get(col));
        }
        return elementsInColumn;
    }
}
