package BackEnd.ButtonActions;

import BackEnd.Calculate;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class EnterAction extends AbstractAction{

    public EnterAction(String name, Icon icon, int number) {
        putValue(Action.NAME , name);
        putValue(Action.SMALL_ICON, icon);
        putValue("Ent", number);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Calculate.getFormula().length() > 1){
            Calculate.getSolution();
        }
    }
}
