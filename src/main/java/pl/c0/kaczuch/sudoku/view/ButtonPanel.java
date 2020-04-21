package pl.c0.kaczuch.sudoku.view;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

class ButtonPanel extends JPanel {
    private ArrayList<JButton> buttonsList = new ArrayList();

    public ButtonPanel(String[] var1)
    {
        String[] var2 = var1;
        int var3 = var1.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            this.buttonsList.add(new JButton(var5));
        }

        Iterator var6 = this.buttonsList.iterator();

        while (var6.hasNext()) {
            JButton var7 = (JButton) var6.next();
            this.add(var7);
        }
    }

    public ArrayList<JButton> getButtonsList() {
        return this.buttonsList;
    }
}