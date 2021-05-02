package BackEnd.ButtonActions;

import BackEnd.Calculate;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BackSpaceAction extends AbstractAction {
    public BackSpaceAction(String name, Icon icon, int number) {
        putValue(Action.NAME , name);
        putValue(Action.SMALL_ICON, icon);
        putValue("KEY", number);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculate.deleteLastSymbol();
    }
}
