package BackEnd.ButtonActions;

import BackEnd.Calculate;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClearAction extends AbstractAction {

    public ClearAction(String name, Icon icon, int number) {
        putValue(Action.NAME , name);
        putValue(Action.SMALL_ICON, icon);
        putValue("CLR", number);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculate.clearFormula();
    }
}
