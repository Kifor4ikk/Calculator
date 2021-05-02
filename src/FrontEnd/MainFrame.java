package FrontEnd;


import javax.swing.*;
import java.awt.*;
import BackEnd.ButtonActions.*;
public class MainFrame extends JFrame {

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.BLACK);
        g.fillRect(10,10,200,200);
    }

    public MainFrame(){
        Components components = new Components();

        setSize(494,471);
        setTitle("Calculator v1.1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600,100);
        /*
        E       ( ) ← C / * -
        D       ! √ ^ 7 8 9 +
        C             4 5 6 +
        B             1 2 3 E
        A             0 0 . E
         */

        JPanel buttonPanel = new JPanel();
        //Right panel
        CustomButton enter = new CustomButton(60,127,410,300,"+",new ButtonAction("+" , null, 1 , "+"));
        CustomButton plus = new CustomButton(60,127,410,300 - 67*2,"Ent",new EnterAction("Ent",null ,1));
        //A
        CustomButton dot = new CustomButton(60,60,410-67,300+67,".",new ButtonAction(".",null ,1 , "."));
        CustomButton zero = new CustomButton(127,60,410- 67 * 3,300+67,"0" ,new ButtonAction("0",null ,1 , "0"));
        //B
        CustomButton one = new CustomButton(60,60,410- 67*3,300,"1",new ButtonAction("1",null ,1 , "1"));
        CustomButton two = new CustomButton(60,60,410- 67*2,300,"2",new ButtonAction("2",null ,1 , "2"));
        CustomButton three = new CustomButton(60,60,410- 67,300,"3",new ButtonAction("3",null ,1 , "3"));
        //C
        CustomButton four = new CustomButton(60,60,410 - 67*3,300 - 67,"4",new ButtonAction("4",null ,1 , "4"));
        CustomButton five = new CustomButton(60,60,410 - 67*2,300 - 67,"5",new ButtonAction("5",null ,1 , "5"));
        CustomButton six = new CustomButton(60,60,410 - 67,300 - 67,"6",new ButtonAction("6",null ,1 , "6"));
        //D
        CustomButton factorial = new CustomButton(60,60,410 - 67*6,300 - 67*2,"!",new ButtonAction("!",null ,1 , "!"));
        CustomButton root = new CustomButton(60,60,410 - 67*5,300 - 67*2,"√",new ButtonAction("√",null ,1 , "sqrt"));
        CustomButton power = new CustomButton(60,60,410 - 67*4,300 - 67*2,"^",new ButtonAction("^",null ,1 , "^"));
        CustomButton seven= new CustomButton(60,60,410 - 67*3,300 - 67*2,"7",new ButtonAction("7",null ,1 , "7"));
        CustomButton eight = new CustomButton(60,60,410 - 67*2,300 - 67*2,"8",new ButtonAction("8",null ,1 , "8"));
        CustomButton nine = new CustomButton(60,60,410 - 67,300 - 67*2,"9",new ButtonAction("9",null ,1 , "9"));
        //E
        CustomButton leftBracket = new CustomButton(60,60,410 - 67*6,300 - 67*3,"(",new ButtonAction("(",null ,1 , "("));
        CustomButton rightBracket = new CustomButton(60,60,410 - 67*5,300 - 67*3,")",new ButtonAction(")",null ,1 , ")"));
        CustomButton backspace = new CustomButton(60,60,410 - 67*4,300 - 67*3,"<-",new BackSpaceAction("<-" , null , 1));
        CustomButton clear = new CustomButton(60,60,410 - 67*3,300 - 67*3,"CLR" ,new ClearAction("CLR", null ,1));
        CustomButton divide = new CustomButton(60,60,410 - 67*2,300 - 67*3,"/" ,new ButtonAction("/",null , 1 , "/"));
        CustomButton multiply = new CustomButton(60,60,410 - 67,300 - 67*3,"*" ,new ButtonAction("*",null , 1 , "*"));
        CustomButton minus = new CustomButton(60,60,410,300 - 67 * 3,"-",new ButtonAction("-",null , 1 , "-"));

        add(enter);
        add(plus);
        add(dot);
        add(zero);
        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);
        add(leftBracket);
        add(rightBracket);
        add(backspace);
        add(clear);
        add(divide);
        add(multiply);
        add(minus);
        add(factorial);
        add(root);
        add(power);
        add(buttonPanel);
        add(components);
        setVisible(true);

        for(;;){
            //System.out.println(" - " + Calculate.getFormula());
            repaint();
        }
    }
}
