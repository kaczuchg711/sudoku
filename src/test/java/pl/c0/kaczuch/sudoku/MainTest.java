package pl.c0.kaczuch.sudoku;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.c0.kaczuch.sudoku.controller.Checker;
import pl.c0.kaczuch.sudoku.controller.SudokuController;
import pl.c0.kaczuch.sudoku.model.SudokuModel;
import pl.c0.kaczuch.sudoku.view.BoardPanel;
import pl.c0.kaczuch.sudoku.view.NumberBox;
import pl.c0.kaczuch.sudoku.view.NumberField;
import pl.c0.kaczuch.sudoku.view.SudokuView;


import javax.swing.JTextField;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            assertEquals(expected, tf.getText(), "should write " + expected);

            tf.setText("0");
            expected = "0";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(), "should write " + expected);

            tf.setText("9");
            expected = "9";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(), "should write " + expected);

            tf.setText("10");
            expected = "";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(), "should write " + expected);

            tf.setText("abc");
            expected = "";

            Checker.check_input(tf);
            assertEquals(expected, tf.getText(), "should write " + expected);

        }

        @Test
        void check_box_Test()

        {
            NumberBox nb = new NumberBox(3, 3, 0, 0);
            NumberField[][] nft = nb.getNf();
            nft[0][0].setNumber(3);
            nft[1][0].setNumber(3);
            nft[1][1].setNumber(7);
            nft[1][2].setNumber(6);
            nft[2][0].setNumber(2);
            nft[2][1].setNumber(8);

            JTextField tf = nft[0][1];

            tf.setText("4");
            String expected = "4";

            Checker.check_box(tf);

            assertEquals(expected, tf.getText(), "should change on " + expected);

            tf.setText("3");
            expected = "";

            Checker.check_box(tf);

            assertEquals(expected, tf.getText(), "should change on " + expected);
        }

        @Disabled
        @Test
        void check_line_in_row_Test()
        {
            BoardPanel bp = new BoardPanel(3, 3);
            NumberBox[][] nbt = bp.getNumberBoxes();

            NumberField[][][] nft = new NumberField[3][3][3];
            nft[0] = nbt[0][0].getNf();
            nft[1] = nbt[0][1].getNf();
            nft[2] = nbt[0][2].getNf();

            nft[0][1][0].setNumber(5);
            nft[0][1][1].setNumber(4);
            nft[1][1][1].setNumber(3);
            nft[1][1][2].setNumber(7);
            nft[2][1][0].setNumber(1);
            nft[2][1][1].setNumber(2);
            nft[2][1][2].setNumber(6);

            NumberField tf = nft[1][1][0];
            tf.setText("4");
            String expected = "";

            Checker.check_row(tf);

            assertEquals(expected, tf.getText(), "should write " + '"'+expected+'"');

            tf = nft[1][1][0];
            tf.setText("8");
            expected = "8";

            Checker.check_row(tf);

            assertEquals(expected, tf.getText(), "should write " + expected);

        }


        @Test
        void check_line_in_column_Test()
        {
            SudokuView sv = new SudokuView();
            SudokuModel sm = new SudokuModel();

            int[][] numbers;
            numbers = sm.get_numbers_from_file();
            sv.genNumbers(numbers);
            NumberField testedNumberField = sv.getBoardPanel().getNumberBoxes()[2][0].getNf()[0][0];

            testedNumberField.setText("2");
            String expected = "";
            Checker.check_column(testedNumberField);

            assertEquals(expected, testedNumberField.getText(), "should write " + '"' + expected + '"');

            testedNumberField = sv.getBoardPanel().getNumberBoxes()[1][1].getNf()[0][1];
            testedNumberField.setText("3");
            expected = "";
            Checker.check_column(testedNumberField);

            assertEquals(expected, testedNumberField.getText(), "should write " + '"' + expected + '"');


            testedNumberField = sv.getBoardPanel().getNumberBoxes()[0][1].getNf()[0][1];
            testedNumberField.setText("8");
            expected = "";
            Checker.check_column(testedNumberField);

            assertEquals(expected, testedNumberField.getText(), "should write " + '"' + expected + '"');

            testedNumberField = sv.getBoardPanel().getNumberBoxes()[0][0].getNf()[0][1];
            testedNumberField.setText("6");
            expected = "6";
            Checker.check_column(testedNumberField);

            assertEquals(expected, testedNumberField.getText(), "should write " + '"' + expected + '"');

        }
    }
}
