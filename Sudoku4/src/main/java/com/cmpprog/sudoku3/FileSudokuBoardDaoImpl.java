package com.cmpprog.sudoku3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javi Rodriguez <javi.role1@gmail.com>
 *
 */
public class FileSudokuBoardDaoImpl implements Dao<SudokuBoard> {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileSudokuBoardDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    /*public SudokuBoard read() {
     File file = new File("files/" + fileName + ".txt");
     Map<Integer, List<Integer>> sudoku = new HashMap<Integer, List<Integer>>();
     Integer row = 0;
     String lineToProcess;
     try {
     BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
    
     while ((lineToProcess = buffer.readLine()) != null) {
     List<Integer> rows = new ArrayList<Integer>();
     int cont = 0;
     for (String str : Arrays.asList(lineToProcess.split(" "))) {
     if (cont == lineToProcess.length()) {
     break;
     }
     rows.add((Integer.parseInt(str)));
     cont++;
     }
     sudoku.put(row, rows);
     row++;
     }
     buffer.close();
     } catch (UnsupportedEncodingException ex) {
    
     } catch (FileNotFoundException ex) {
     Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
     Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
     return new SudokuBoard(sudoku);
     }*/

    /*public void write(SudokuBoard sudoku) {
     File file = new File("files/" + fileName + ".txt");
     Map<Integer, List<Integer>> board = new HashMap<Integer, List<Integer>>();
     board = sudoku.getMapBoard();
    
     try {
     BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
    
     for (List<Integer> rows : board.values()) {
     for (int i = 0; i < 9; i++) {
     buffer.write(rows.get(i) + " ");
     }
     buffer.newLine();
     }
     buffer.flush();
    
     } catch (UnsupportedEncodingException ex) {
    
     } catch (FileNotFoundException ex) {
     Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
     Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
     }*/
    public void write(SudokuBoard sudoku) {
        FileOutputStream fos = null;
        ObjectOutputStream oss = null;
        try {
            fos = new FileOutputStream("files/" + fileName + ".ser");
            oss = new ObjectOutputStream(fos);
            oss.writeObject(sudoku);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (oss != null) {
                try {
                    oss.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public SudokuBoard read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        SudokuBoard sudokuBoardInstance = null;
        try {
            fis = new FileInputStream("files/" + fileName + ".ser");
            ois = new ObjectInputStream(fis);
            sudokuBoardInstance = (SudokuBoard) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileSudokuBoardDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sudokuBoardInstance;
    }
    /* public static void main(String[] args) throws IOException {
     //read("sudokuToRead");
     SudokuBoard sudokuBoard = new SudokuBoard();
     writeA(sudokuBoard);
     }*/

}
