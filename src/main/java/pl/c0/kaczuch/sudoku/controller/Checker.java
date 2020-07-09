package pl.c0.kaczuch.sudoku.controller;

import pl.c0.kaczuch.sudoku.view.NumberBox;
import pl.c0.kaczuch.sudoku.view.NumberField;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Checker
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
                if(tf.getText().equals(x.getText()) && !tf.getText().equals("") && !tf.equals(x))
                {
                    tf.setText("");
                    JOptionPane.showMessageDialog(null, "There is his same number in box");
                    tf.requestFocus();
                }
            }
        }
    }

}
