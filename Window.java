import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    Rectangle playerOne;
    Rectangle ai;
    Rectangle ball;
    Graphics2D g2;
    KeyList keylistener =new KeyList();

    double toolbarHEIGHT=0;
    PlayerController playerController;
    AiController aiController;

    BallMovement ballMovement;

    public Text leftScoreText,rightScoreText;
    public int leftScoreCounter,rightScoreCounter;
    public static boolean isRunning = true;



    public Window(){
        this.setSize(Constants.windowWidth,Constants.windowHeight);//Pencere ana boyutları
        this.setTitle(Constants.windowTitle);//Pencere Başlığı
        this.setResizable(false); // Pencerenin genişletme özelliğinin açılıp kapanmasına yarar.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Çarpı tuşunun pencereyi kapatmasını sağlayan kod
        this.setVisible(true);  // Pencere görünürlük
        this.addKeyListener(keylistener);


        g2=(Graphics2D)this.getGraphics();


        leftScoreCounter = 0;
        rightScoreCounter = 0;

        leftScoreText = new Text(leftScoreCounter,Constants.scoreFont,Constants.scoreX,Constants.scoreY,Color.CYAN);
        rightScoreText = new Text(rightScoreCounter,Constants.scoreFont,Constants.windowWidth-Constants.scoreX-Constants.scoreFont.getSize(),Constants.scoreY,Color.CYAN);

        playerOne=new Rectangle(60,60,Constants.playerWidth,Constants.playerHeight,Constants.playerColor);
        playerController= new PlayerController(playerOne,keylistener);

        ai=new Rectangle(Constants.windowWidth-60,Constants.windowHeight-60,Constants.playerWidth,Constants.playerHeight,Constants.playerColor);
        ball=new Rectangle(Constants.windowWidth/2,Constants.windowHeight/2, 10,10,Color.WHITE);

        ballMovement = new BallMovement(ball,playerOne,ai,leftScoreText,rightScoreText);
        aiController= new AiController(ball,new PlayerController(ai));

    }

    public void update(double dt){

        Image dbImage = createImage(getWidth(),getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage,0,0,this);
        //Burada fillRect komutunda x,y kordinatları şeklin çizileceği kordinatları gösteriyor fakat
        //İlginç bir durum var 0,0 noktası JFramede ekranın sol üst köşesinden başlıyor.Aşağı giderken
        //y si azalmıyor artıyor. x te sağa giderken artıyor.

        playerController.update(dt);
        aiController.update(dt);
        ballMovement.update(dt);

    }

    public void draw(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRect(0,0 ,Constants.windowWidth,Constants.windowHeight);
        leftScoreText.draw(g2);
        rightScoreText.draw(g2);
        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);

    }

    public void stop(){
        isRunning = false;
        this.dispose();
    }


    //DELTA-TIME
    // Bu kısım oyunların deltatime denilen süreyi hesaplamak için kullanılmıştır.
    //Deltatime oyun ekranındaki art arda gösterilen 2 kare arasındaki zaman farkıdır.
    //Bu konu baya kabarık ama basitçe özetlemek gerekirse donanımı iyi olan oyuncu
    //ile donanımı kötü olan oyuncu eşit şekilde oynaması için şart.Şöyle açıklayayım görüntüdeki değişiklikiğin
    //çalışması için kod döngüsü tamamlanması gerekiyor hızlı makine çabuk tamamlar 50 kere yapar yavaş makine 1 kere yapar gibi
    //Daha fazlası için Jonas Tyroller,Dear Game Developers, Stop Messing This Up!: https://www.youtube.com/watch?v=yGhfUcPjXuE
    // izleyerek yada deltatime ile alakalı bilgi edinebilirsin!
    @Override
    public void run() {
        double lastFrameTime=0.0;
        while(isRunning){
            double time=Time.getTime();
            double deltaTime = time-lastFrameTime;
            lastFrameTime=time;
            update(deltaTime);
        }
        this.dispose();
        return;
    }


}

