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

    private Map<Integer, List<SudokuField>> mapBoard;

    public SudokuBoard() {
        this.mapBoard = new HashMap<Integer, List<SudokuField>>();
        initBoard();
    }

    public SudokuBoard(Map<Integer, List<SudokuField>> mapBoard) {
        this.mapBoard = mapBoard;
    }

    public Map<Integer, List<SudokuField>> getMapBoard() {
        return this.mapBoard;
    }

    public void setMapBoard(Map<Integer, List<SudokuField>> mapBoard) {
        this.mapBoard = mapBoard;
    }

    public List<SudokuField> getList(int i) {
        return mapBoard.get(i);
    }

    public boolean setConditions(int row, int col, int num) {
        return checkConditions(row, col, num);
    }

    private void initBoard() {
        // Clear all cells
        mapBoard.clear();

        List<List<SudokuField>> allLists = new ArrayList<List<SudokuField>>();
        for (int i = 0; i <= 8; i++) {
            ArrayList<SudokuField> list = new ArrayList<SudokuField>(9);
            list.clear();
            for (int j = 0; j < 9; j++) {
                list.add(new SudokuField(0));
            }
            allLists.add(list);
        }
        List<SudokuField> row0 = allLists.get(0);
        List<SudokuField> row1 = allLists.get(1);
        List<SudokuField> row2 = allLists.get(2);
        List<SudokuField> row3 = allLists.get(3);
        List<SudokuField> row4 = allLists.get(4);
        List<SudokuField> row5 = allLists.get(5);
        List<SudokuField> row6 = allLists.get(6);
        List<SudokuField> row7 = allLists.get(7);
        List<SudokuField> row8 = allLists.get(8);

        // Create the initial situation
        row0.set(0, new SudokuField(9));
        row0.set(4, new SudokuField(2));
        row0.set(6, new SudokuField(7));
        row0.set(7, new SudokuField(5));
        row1.set(0, new SudokuField(6));
        row1.set(4, new SudokuField(5));
        row1.set(7, new SudokuField(4));
        row2.set(1, new SudokuField(2));
        row2.set(3, new SudokuField(4));
        row2.set(7, new SudokuField(1));
        row3.set(0, new SudokuField(2));
        row3.set(2, new SudokuField(8));
        row4.set(1, new SudokuField(7));
        row4.set(3, new SudokuField(5));
        row4.set(5, new SudokuField(9));
        row4.set(7, new SudokuField(6));
        row5.set(6, new SudokuField(4));
        row5.set(8, new SudokuField(1));
        row6.set(1, new SudokuField(1));
        row6.set(5, new SudokuField(5));
        row6.set(7, new SudokuField(8));
        row7.set(1, new SudokuField(9));
        row7.set(4, new SudokuField(7));
        row7.set(8, new SudokuField(4));
        row8.set(1, new SudokuField(8));
        row8.set(2, new SudokuField(2));
        row8.set(4, new SudokuField(4));
        row8.set(8, new SudokuField(6));

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
        if (mapBoard.get(row).contains(new SudokuField(num))) {
            bRow = false;
        }
        List<SudokuField> elements = new ArrayList<SudokuField>();
        for (List<SudokuField> aux2 : mapBoard.values()) {
            elements.add(aux2.get(col));

            if (elements.contains(new SudokuField(num))) {
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
        List<SudokuField> aux3 = new ArrayList<SudokuField>();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                aux3.add(mapBoard.get(myRow).get(myCol));
                myCol++;
            }
            myCol -= 3;
            myRow++;
        }
        if (aux3.contains(new SudokuField(num))) {
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
                    System.out.print(res.concat(" " + getList(i).get(j)));
                    //res = res.concat(" " + getList(i).get(j).toString());
                } else {
                    System.out.print(res.concat("\n"));
                    //res = res.concat("\n");
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
