package com.cmpprog.sudoku3;

import java.io.Serializable;

/*
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 *
 */
public class SudokuField implements Cloneable, Serializable, Comparable<SudokuField> {

    private Integer value;
    private Integer posX, posY;

    public SudokuField(Integer value, int posX, int posY) {
        this.value = value;
        this.posX = posX;
        this.posY = posY;
    }

    public SudokuField(Integer value) {
        this.value = value;
    }

    public boolean isEmpty() {
        boolean res = true;
        if (this.getValue() != 0) {
            res = false;
        }
        return res;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 17 * hash + this.posX;
        hash = 17 * hash + this.posY;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SudokuField other = (SudokuField) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        if (this.posX != other.posX) {
            return false;
        }
        if (this.posY != other.posY) {
            return false;
        }
        return true;
    }

    public int compareTo(SudokuField i) {
        int res = getValue().compareTo(i.getValue());
        if (res == 0) {
            res = getPosY().compareTo(i.getPosY()) + getPosX().compareTo(i.getPosX());
        }
        return res;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
