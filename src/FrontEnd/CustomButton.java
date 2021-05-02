package FrontEnd;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CustomButton extends JButton {
    CustomButton(int sizeX,int sizeY,int posX ,int posY,String text){
     setSize(sizeX,sizeY);
     setLocation(posX,posY);
     setText(text);
     setFocusable(false);
    }
    CustomButton(int sizeX, int sizeY, int posX , int posY ,String text, AbstractAction action){
        this(sizeX,sizeY,posX,posY,text);
        setAction(action);
    }
}
