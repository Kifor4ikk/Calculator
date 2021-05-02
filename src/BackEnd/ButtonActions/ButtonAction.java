package BackEnd.ButtonActions;

import BackEnd.Calculate;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonAction extends AbstractAction {
    private String symbols = " ";
    public ButtonAction(String name, Icon icon, int number , String symbols) {
        putValue(Action.NAME , name);
        putValue(Action.SMALL_ICON, icon);
        putValue("KEY", number);
        this.symbols = symbols;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Calculate.addSymbols(symbols);
    }
}
