package com.cmpprog.sudoku3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 */
public class SudokuBoard implements Serializable {

    private Map<Integer, List<Integer>> mapBoard;

    public SudokuBoard() {
        this.mapBoard = new HashMap<Integer, List<Integer>>();
        initBoard();
    }

    public SudokuBoard(Map<Integer, List<Integer>> mapBoard) {
        this.mapBoard = mapBoard;
    }

    public Map<Integer, List<Integer>> getMapBoard() {
        return this.mapBoard;
    }

    public void setMapBoard(Map<Integer, List<Integer>> mapBoard) {
        this.mapBoard = mapBoard;
    }

    public List<Integer> getList(int i) {
        return mapBoard.get(i);
    }

    public boolean setConditions(int row, int col, int num) {
        return checkConditions(row, col, num);
    }

    private void initBoard() {
        // Clear all cells
        mapBoard.clear();

        List<List<Integer>> allLists = new ArrayList<List<Integer>>();
        for (int i = 0; i <= 8; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>(9);
            list.clear();
            for (int j = 0; j < 9; j++) {
                list.add(0);
            }
            allLists.add(list);
        }
        List<Integer> row0 = allLists.get(0);
        List<Integer> row1 = allLists.get(1);
        List<Integer> row2 = allLists.get(2);
        List<Integer> row3 = allLists.get(3);
        List<Integer> row4 = allLists.get(4);
        List<Integer> row5 = allLists.get(5);
        List<Integer> row6 = allLists.get(6);
        List<Integer> row7 = allLists.get(7);
        List<Integer> row8 = allLists.get(8);

        // Create the initial situation
        row0.set(0, 9);
        row0.set(4, 2);
        row0.set(6, 7);
        row0.set(7, 5);
        row1.set(0, 6);
        row1.set(4, 5);
        row1.set(7, 4);
        row2.set(1, 2);
        row2.set(3, 4);
        row2.set(7, 1);
        row3.set(0, 2);
        row3.set(2, 8);
        row4.set(1, 7);
        row4.set(3, 5);
        row4.set(5, 9);
        row4.set(7, 6);
        row5.set(6, 4);
        row5.set(8, 1);
        row6.set(1, 1);
        row6.set(5, 5);
        row6.set(7, 8);
        row7.set(1, 9);
        row7.set(4, 7);
        row7.set(8, 4);
        row8.set(1, 8);
        row8.set(2, 2);
        row8.set(4, 4);
        row8.set(8, 6);

        mapBoard.put(0, row0);
        mapBoard.put(1, row1);
        mapBoard.put(2, row2);
        mapBoard.put(3, row3);
        mapBoard.put(4, row4);
        mapBoard.put(5, row5);
        mapBoard.put(6, row6);
        mapBoard.put(7, row7);
        mapBoard.put(8, row8);

    }

    private boolean checkConditions(int row, int col, int num) {
        boolean bRow = true, bCol = true, bBox = true;
        int myRow = row;
        int myCol = col;
        if (mapBoard.get(row).contains(num)) {
            bRow = false;
        }
        List<Integer> elements = new ArrayList<Integer>();
        for (List<Integer> aux2 : mapBoard.values()) {
            elements.add(aux2.get(col));
            if (elements.contains(num)) {
                bCol = false;
            }
        }
        elements.clear();

        while (myRow % 3 != 0) {
            myRow--;
        }
        while (myCol % 3 != 0) {
            myCol--;
        }
        List<Integer> aux3 = new ArrayList<Integer>();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                aux3.add(mapBoard.get(myRow).get(myCol));
                myCol++;
            }
            myCol -= 3;
            myRow++;
        }
        if (aux3.contains(num)) {
            bBox = false;
        }

        return (bRow && bCol && bBox);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j < 9) {
                    System.out.print(res.concat(" " + getList(i).get(j).toString()));
                    res = res.concat(" " + getList(i).get(j).toString());
                } else {
                    System.out.print(res.concat("\n"));
                    res = res.concat("\n");
                }
            }
        }
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.mapBoard != null ? this.mapBoard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (obj instanceof SudokuBoard) {
            SudokuBoard sudokuBoard = (SudokuBoard) obj;
            res = getMapBoard().equals(sudokuBoard.getMapBoard());
        }
        return res;
    }

}
