package pl.c0.kaczuch;

import pl.c0.kaczuch.sudoku.controller.SudokuController;
import pl.c0.kaczuch.sudoku.model.SudokuModel;
import pl.c0.kaczuch.sudoku.view.SudokuView;

public class Main
{
    public static void main(String[] args)
    {
        SudokuView sv = new SudokuView();
        SudokuModel sm = new SudokuModel();
        SudokuController sc = new SudokuController(sm,sv);
    }
}
