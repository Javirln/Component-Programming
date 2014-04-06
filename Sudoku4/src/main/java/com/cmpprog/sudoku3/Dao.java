/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmpprog.sudoku3;

/**
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 * @param <T>
 */
public interface Dao<T>  {

    T read();

    void write(T obj);
}
