package FrontEnd;

import BackEnd.Calculate;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawInterface extends JComponent {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Random rand = new Random();

    public void paintComponent(Graphics g) {
       g.setColor(Color.GRAY);
       g.fillRect(7,7,464,85);
       g.fillRect(410 - 67*6,300 - 67,60*3+7*2,60*3+7*2);
       g.setColor(Color.BLACK);
       g.setFont(new Font("Comic Sans", 10, 10));
       g.drawString("By Kifor4ik" , 10 , 18);

        if (Calculate.getFormula().length() + 1 > 40) {
            g.setFont(new Font("Comic Sans", 10, 10));
            g.drawString(Calculate.getFormula(), 464 - 6 * Calculate.getFormula().length(), 60);
        } else if(Calculate.getFormula().length()+1 > 26) {
           g.setFont(new Font("Comic Sans", 10, 20));
           g.drawString(Calculate.getFormula(), 464 - 11 * Calculate.getFormula().length(), 60);
       }
       else{
           g.setFont(new Font("Comic Sans",10 ,30));
           g.drawString(Calculate.getFormula() ,464-17*Calculate.getFormula().length(),60);
       }


       g.setFont(new Font("Comic Sans",10 ,30));
       g.drawString("1: ", 12,300-67 + 30);
       if(Calculate.getResultByPos(0).length()+1 > 9) g.setFont(new Font("Comic Sans",10 ,10));
       g.drawString(Calculate.getResultByPos(0) + "" ,40,300-67 + 30);

       g.setFont(new Font("Comic Sans",10 ,30));
       g.drawString("2: ", 12,300-67 + 70);
       if(Calculate.getResultByPos(1).length()+1 > 9) g.setFont(new Font("Comic Sans",10 ,10));
       g.drawString(Calculate.getResultByPos(1) + "" , 40,300-67 + 70);

       g.setFont(new Font("Comic Sans",10 ,30));
       g.drawString("3: ", 12,300-67 + 110);
       if(Calculate.getResultByPos(2).length()+1 > 9) g.setFont(new Font("Comic Sans",10 ,10));
       g.drawString(Calculate.getResultByPos(2) + "" , 40,300-67 + 110);

       g.setFont(new Font("Comic Sans",10 ,30));
       g.drawString("4: ", 12,300-67 + 150);
       if(Calculate.getResultByPos(3).length()+1 > 9) g.setFont(new Font("Comic Sans",10 ,10));
       g.drawString(Calculate.getResultByPos(3) + "" , 40,300-67 + 150);

       g.setFont(new Font("Comic Sans",10 ,30));
       g.drawString("5: ", 12,300-67 + 190);
       if(Calculate.getResultByPos(4).length()+1 > 9) g.setFont(new Font("Comic Sans",10 ,10));
       g.drawString(Calculate.getResultByPos(4) + "" , 40,300-67 + 190);
    }
}