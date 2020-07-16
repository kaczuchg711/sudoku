package pl.c0.kaczuch.sudoku.controller;

import pl.c0.kaczuch.sudoku.model.Checker;
import pl.c0.kaczuch.sudoku.model.SudokuModel;
import pl.c0.kaczuch.sudoku.view.NumberField;
import pl.c0.kaczuch.sudoku.view.SudokuView;


import java.awt.event.*;
import java.util.Arrays;

public class SudokuController
{
    SudokuModel model;
    SudokuView view;

    public SudokuController(SudokuModel model, SudokuView view)
    {
        this.model = model;
        this.view = view;
        this.view.addStatementListener(new GenListener());

        CheckListener[][] checkListeners = new CheckListener[9][9];

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                checkListeners[i][j] = new CheckListener();
            }
        }

        this.view.addNumberInListener(checkListeners);
    }

    private class GenListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int[][] numbers;
            numbers = model.create_sudoku();
            view.setNumbers(numbers);
        }
    }

    private class CheckListener implements  FocusListener
    {
        @Override
        public void focusGained(FocusEvent e)
        {
        }

        @Override
        public void focusLost(FocusEvent e)
        {
            NumberField numberField = (NumberField) e.getSource();

            Checker.check_input(numberField);
            if (numberField.isEditable())
            {
                if (!Checker.check_box(numberField))
                {}
                else if (!Checker.check_row(numberField))
                {}
                else if (!Checker.check_column(numberField))
                {}
                else
                {
                    model.update_model(numberField);
                }

            }
        }
    }

}

