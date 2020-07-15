package pl.c0.kaczuch.sudoku;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.c0.kaczuch.sudoku.model.Checker;
import pl.c0.kaczuch.sudoku.model.SudokuModel;
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
            JTextField tf = new JTextField();
            String[] input = {"4", "0", "9", "10", "abc"};
            String[] expected = {"4", "0", "9", "", ""};


            for (int i = 0; i < expected.length; i++)
            {
                tf.setText(input[i]);
                Checker.check_input(tf);
                assertEquals(expected[i], tf.getText(), "should write " + expected);
            }
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

        @Test
        void check_line_in_row_Test()
        {
            SudokuView sv = new SudokuView();
            SudokuModel sm = new SudokuModel();


            sv.setNumbers(sm.create_sudoku());
            NumberField testedNumberField;

            int[][] numberBoxesCor = {
                    {2, 0},
                    {2, 0},
                    {1, 2},
                    {0, 1},
            };
            int[][] numberNumberFieldsCor = {
                    {0, 0},
                    {0, 0},
                    {1, 2},
                    {0, 0},
            };

            String[] inputs = {"9", "4", "9", "4"};
            String[] expected = {"", "", "", "4"};

            for (int i = 0; i < inputs.length; i++)
            {
                testedNumberField = sv.getBoardPanel().getNumberBoxes()[numberBoxesCor[i][0]][numberBoxesCor[i][1]].getNf()[numberNumberFieldsCor[i][0]][numberNumberFieldsCor[i][1]];
                testedNumberField.setText(inputs[i]);
                Checker.check_row(testedNumberField);
                assertEquals(expected[i], testedNumberField.getText(), "should write " + '"' + expected[i] + '"');
            }

        }

        @Test
        void check_line_in_column_Test()
        {
            SudokuView sv = new SudokuView();
            SudokuModel sm = new SudokuModel();
            NumberField testedNumberField;

            sv.setNumbers(sm.create_sudoku());

            int[][] numberBoxesCor = {
                    {2, 0},
                    {2, 0},
                    {1, 2},
                    {0, 1},
            };
            int[][] numberNumberFieldsCor = {
                    {0, 0},
                    {0, 0},
                    {1, 2},
                    {0, 1},
            };

            String[] inputs = {"2", "3", "8", "1"};
            String[] expected = {"", "", "", "1"};


            for (int i = 0; i < inputs.length; i++)
            {
                testedNumberField = sv.getBoardPanel().getNumberBoxes()[numberBoxesCor[i][0]][numberBoxesCor[i][1]].getNf()[numberNumberFieldsCor[i][0]][numberNumberFieldsCor[i][1]];
                testedNumberField.setText(inputs[i]);
                Checker.check_column(testedNumberField);
                assertEquals(expected[i], testedNumberField.getText() , "should write " + '"' + expected[i] + '"');
            }
        }
    }
}
