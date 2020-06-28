package pl.c0.kaczuch.sudoku.controller;

import pl.c0.kaczuch.sudoku.model.SudokuModel;
import pl.c0.kaczuch.sudoku.view.SudokuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuController
{
    SudokuModel model;
    SudokuView view;

    public SudokuController(SudokuModel model,SudokuView view)
    {
        this.model = model;
        this.view = view;
        this.view.addStatementListener(new GenListener());
    }

    private class GenListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int[][] numbers;
            numbers = model.get_numbers_from_file();
            view.genNumbers(numbers);
        }
    }

}
