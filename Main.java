import javax.swing.plaf.TableHeaderUI;

public class Main {

    public static int state = 2 ;
    public static Thread mainThread;
    public static MainMenu menu;
    public static Window window;



    public static void main(String[] args) {
        /*Thread : iplik bir programın birden fazla görevi aynı anda yapmasını
        // sağlayan yapıdır.Mesela ekranda bir video izlerken arka planda indirme
        //yapmak buna örnek gösterilebilir sen indirmenin bitmesini beklerken
        // programda başka işlemler yapabilmeni sağlayan yapıdır.Burada da oyunun
        //penceresi için ayrı bir thread oluşturmuş oluyoruz.
        */

        // OYUN ARKADA ÇALIŞMAYA DEVAM EDIYOR
        menu = new MainMenu();
        while (state == 2) {
            menu.update();
            while (state == 5) {
                menu.stop();
                System.exit(0);
            }
        }
        if (state == 3) {
            menu.stop();
            window = new Window();
            Thread mainThread = new Thread(window);
            mainThread.start();
        }
        //Useless codddeeeeeeeeeeeeeeeeeeee ffffffffffffuucc
        while(state==3){
            while(state == 5){
                System.exit(5);
            }
        }

        /* Another Useless Try
        while (state == 3) {
            if(BallMovement.rightScore >=Constants.winningScore ||BallMovement.leftScore>=Constants.winningScore){
                System.exit(17);
            }
        }
        */

        //Whether i use state or other variable it doesnot work

    }

}




