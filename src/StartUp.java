import FrontEnd.MainFrame;

public class StartUp {
    public static void main(String ... args){
        new Thread(MainFrame::new).start();
    }
}
