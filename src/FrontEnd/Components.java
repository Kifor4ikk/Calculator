package FrontEnd;

import BackEnd.Calculate;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Components extends JComponent {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Random rand = new Random();

    public void paintComponent(Graphics g) {
       g.setColor(Color.GRAY);
       g.fillRect(7,7,464,85);
       g.fillRect(410 - 67*6,300 - 67,60*3+7*2,60*3+7*2);
       g.setColor(Color.BLACK);
       g.setFont(new Font("Comic Sans",10 ,30));
       g.drawString(Calculate.getFormula().toString() ,464-17*Calculate.getFormula().length(),60);
       //-------
       //g.drawString(Calculate.getResultByPos(0) , 7,200);
    }
}