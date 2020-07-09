package pl.c0.kaczuch.sudoku;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.c0.kaczuch.sudoku.controller.Checker;


import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest
{
    @Nested
    class CheckerTest
    {
        @Test
        void check_input_Test()
        {
            JTextField tf = new JTextField("4");
            String expected = "4";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(),"should write " + expected);

            tf.setText("0");
            expected = "0";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(),"should write " + expected);

            tf = new JTextField("9");
            expected = "9";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(),"should write " + expected);

            tf = new JTextField("10");
            expected = "";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(),"should write " + expected);

            tf = new JTextField("abc");
            expected = "";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(),"should write " + expected);
        }

        void check_box_Test()
        {

        }

    }
}
