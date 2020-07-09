package pl.c0.kaczuch.sudoku.controller;

import pl.c0.kaczuch.sudoku.view.BoardPanel;
import pl.c0.kaczuch.sudoku.view.NumberBox;
import pl.c0.kaczuch.sudoku.view.NumberField;

import javax.swing.*;

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

    public static void check_line_horizontally(JTextField tf)
    {

        NumberBox parentNumberBox = (NumberBox) tf.getParent();
        BoardPanel bp = (BoardPanel) parentNumberBox.getParent();

        int x  = parentNumberBox.getX();
        int y  = parentNumberBox.getY();

        NumberBox[][] nbt = bp.getNumberBoxes();

        NumberBox[] nbtInLine = new NumberBox[3];

        switch (x)
        {
            case 0:
                nbtInLine[0] = parentNumberBox;
                nbtInLine[1] = nbt[y][1];
                nbtInLine[2] = nbt[y][2];
            case 1:
                nbtInLine[0] = nbt[y][0];
                nbtInLine[1] = parentNumberBox;
                nbtInLine[2] = nbt[y][2];
            case 2:
                nbtInLine[0] = nbt[y][0];
                nbtInLine[1] = nbt[y][1];
                nbtInLine[2] = parentNumberBox;
        }

        NumberField[][][] nft = new NumberField[3][3][3];

        for (int i = 0; i < nbtInLine.length; i++)
        {
            nft[i] = nbtInLine[i].getNf();
        }

        NumberField[] nfInLine = new NumberField[9];

        for (int i = 0; i < nbtInLine.length; i++)
        {

        }

    }


}