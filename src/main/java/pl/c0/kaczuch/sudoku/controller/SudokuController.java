package pl.c0.kaczuch.sudoku.controller;

import org.w3c.dom.Text;
import pl.c0.kaczuch.sudoku.model.SudokuModel;
import pl.c0.kaczuch.sudoku.view.NumberBox;
import pl.c0.kaczuch.sudoku.view.NumberField;
import pl.c0.kaczuch.sudoku.view.SudokuView;
import sun.jvm.hotspot.HelloWorld;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            JTextField tf = (NumberField) e.getSource();

            Checker.check_input(tf);
            if(tf.isEditable())
                Checker.check_box(tf);
        }
    }

    private static class Checker
    {
        public static void check_input(JTextField tf)
        {

            String[] numbers = {"","0","1","2","3","4","5","6","7","8","9"};
            if(!Arrays.asList(numbers).contains(tf.getText()))
            {
                tf.setText("");
                JOptionPane.showMessageDialog(null, "Insert number from 0-9");
                tf.requestFocus();
            }
        }

        public static void check_box(JTextField tf)
        {
            NumberBox nm = (NumberBox) tf.getParent();

            NumberField[][]  nf = nm.getNf();

            for (NumberField[] row : nf)
            {
                for (NumberField x: row)
                {
                    System.out.printf("%2s",x.getText());
                    if(tf.getText().equals(x.getText()) && !tf.getText().equals("") && !tf.equals(x))
                    {
                        tf.setText("");
                        JOptionPane.showMessageDialog(null, "There is this same number in box");
                        tf.requestFocus();
                    }
                }
                System.out.println();
            }
        }

    }

}
