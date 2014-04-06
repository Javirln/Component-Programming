package com.cmpprog.sudoku3;

/**
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 */
public class DaoFactory {

    public static Dao<SudokuBoard> createFileSudokuBoardDao(String fileName) {
        return new FileSudokuBoardDaoImpl(fileName);
    }
}
