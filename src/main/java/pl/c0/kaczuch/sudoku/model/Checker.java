package pl.c0.kaczuch.sudoku.model;

import pl.c0.kaczuch.sudoku.view.BoardPanel;
import pl.c0.kaczuch.sudoku.view.NumberBox;
import pl.c0.kaczuch.sudoku.view.NumberField;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Checker
{
    public static boolean check_input(JTextField tf)
    {
        String[] numbers = {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if (!Arrays.asList(numbers).contains(tf.getText()))
        {
            tf.setText("");
            JOptionPane.showMessageDialog(null, "Insert number from 0-9");
            tf.requestFocus();
            return false;
        }

        return true;
    }

    public static boolean check_box(JTextField tf)
    {
        NumberBox nm = (NumberBox) tf.getParent();

        NumberField[][] nf = nm.getNf();

        for (NumberField[] row : nf)
        {
            for (NumberField x : row)
            {
                if (tf.getText().equals(x.getText()) && !tf.getText().equals("") && !tf.equals(x))
                {
                    tf.setText("");

                    JOptionPane.showMessageDialog(null, "There is his same number in box");

                    tf.requestFocus();

                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check_row(NumberField testedNumberField)
    {

        NumberBox parentNumberBox = (NumberBox) testedNumberField.getParent();
        BoardPanel bp = (BoardPanel) parentNumberBox.getParent();
        bp.getX();
        int x = parentNumberBox.getXX();
        int y = parentNumberBox.getYY();

        NumberBox[][] nbt = bp.getNumberBoxes();

        NumberBox[] nbtInLine = new NumberBox[3];

        switch (y)
        {
            case 0:
                nbtInLine[0] = parentNumberBox;
                nbtInLine[1] = nbt[x][1];
                nbtInLine[2] = nbt[x][2];
                break;
            case 1:
                nbtInLine[0] = nbt[x][0];
                nbtInLine[1] = parentNumberBox;
                nbtInLine[2] = nbt[x][2];
                break;
            case 2:
                nbtInLine[0] = nbt[x][0];
                nbtInLine[1] = nbt[x][1];
                nbtInLine[2] = parentNumberBox;
                break;
        }

        NumberField temp;
        String text;


        for (int h = 0; h < 3; h++)
        {
            for (int i = 0; i < 3; i++)
            {

                temp = nbtInLine[h].getNf()[testedNumberField.getXX()][i];
                if (!temp.getText().equals("")
                        && temp.getText().equals(testedNumberField.getText())
                        && temp != testedNumberField)
                {
                    {
                        testedNumberField.setText("");
                        JOptionPane.showMessageDialog(null, "There is this same number in row");
                        testedNumberField.requestFocus();

                        return false;
                    }
                }

            }


        }
        return true;
    }

    public static boolean check_column(NumberField testedNumberField)
    {
        NumberBox parentNumberBox = (NumberBox) testedNumberField.getParent();
        BoardPanel bp = (BoardPanel) parentNumberBox.getParent();
        bp.getX();
        int x = parentNumberBox.getXX();
        int y = parentNumberBox.getYY();
        int numberFieldY = testedNumberField.getYY();

        NumberBox[][] nbt = bp.getNumberBoxes();

        NumberBox[] nbtInLine = new NumberBox[3];

        switch (x)
        {
            case 0:
                nbtInLine[0] = parentNumberBox;
                nbtInLine[1] = nbt[1][y];
                nbtInLine[2] = nbt[2][y];
                break;
            case 1:
                nbtInLine[0] = nbt[0][y];
                nbtInLine[1] = parentNumberBox;
                nbtInLine[2] = nbt[2][y];
                break;
            case 2:
                nbtInLine[0] = nbt[0][y];
                nbtInLine[1] = nbt[1][y];
                nbtInLine[2] = parentNumberBox;
                break;
        }

        NumberField temp;
        for (int h = 0; h < 3; h++)
        {
            for (int j = 0; j < 3; j++)
            {
                temp = nbtInLine[h].getNf()[j][numberFieldY];


                if (!temp.getText().equals("")
                        && temp.getText().equals(testedNumberField.getText())
                        && temp != testedNumberField)
                {
                    testedNumberField.setText("");
                    JOptionPane.showMessageDialog(null, "There is this same number in column");
                    testedNumberField.requestFocus();
                    return false;
                }
            }
        }
        return true;
    }


}