import java.awt.*;

public  class Constants {
    public final static int windowHeight=600;
    public final static int windowWidth=800;
    public final static String windowTitle="PingPong";

    public final static double playerHeight=120;

    public final static double playerWidth=10;
    public final static int playerSpeed = 400;

    public final static Color playerColor= Color.WHITE;


    public static double toolbarHeight = 30;

    // Aslında  vx ve vy nin birleşimi olan hipotenüsü hızı giriyoda başlangıç değerleriyle örtüşmüyor.

    public static double ballVelocityX = 150.0 ; // first  X speed
    public static double ballVelocityY = 30.0 ; // first Y speed
    public static double ballSpeed = Math.sqrt(Math.pow(ballVelocityX,2)+Math.pow(ballVelocityY,2)) ;
    // i dont even fucking now at this point  like he just  make a soup with videos
    public static final double maxAngle = 45.0 ;

    public static final Font scoreFont = new Font("Times New Roman",Font.PLAIN,36);

    public static final int scoreY = 70;

    public static final int scoreX = 25;
    public static final int winningScore=4;






}
