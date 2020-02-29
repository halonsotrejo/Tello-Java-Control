import annix.tello.Dji.DjiTello;
import annix.tello.Dji.Tello;
import annix.tello.Exception.TelloException;
import annix.tello.UI.TelloUI;
import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws TelloException {
        TelloUI tello = new TelloUI();

        /*Tello tello = new DjiTello();
        tello.connect();
        tello.enterCommandMode();

        tello.takeOff();


        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tello.land();*/
    }

}
