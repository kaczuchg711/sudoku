package pl.c0.kaczuch.sudoku.controller;

import pl.c0.kaczuch.sudoku.model.SudokuModel;
import pl.c0.kaczuch.sudoku.view.NumberField;
import pl.c0.kaczuch.sudoku.view.SudokuView;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;

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
            numbers = model.get_numbers_from_file();
            view.genNumbers(numbers);
        }
    }

    private class CheckListener implements DocumentListener, FocusListener
    {
        @Override
        public void insertUpdate(DocumentEvent e)
        {
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
        }

        @Override
        public void focusGained(FocusEvent e)
        {
        }

        @Override
        public void focusLost(FocusEvent e)
        {
            NumberField tf = (NumberField) e.getSource();

            Checker.check_input(tf);
            if (tf.isEditable())
            {
//                if (Checker.check_box(tf))
//                {}
//                else if (Checker.check_row(tf))
//                {}
//                else if (Checker.check_column(tf))
//                {}

                Checker.check_box(tf);

                Checker.check_row(tf);

                Checker.check_column(tf);


            }
        }
    }

}

