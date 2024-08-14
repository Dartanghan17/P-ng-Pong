import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;


public class MainMenu extends JFrame  {

    public Graphics2D g2;
    public Text startGame, exitGame,gameMode,Diffuculty,PingPong;
    KeyList keylistener =new KeyList();
    MouseList mouseListener = new MouseList();
    public boolean isRunningMenu=true;


    public MainMenu(){
        this.setSize(Constants.windowWidth,Constants.windowHeight);//Pencere ana boyutları
        this.setTitle(Constants.windowTitle);//Pencere Başlığı
        this.setResizable(false); // Pencerenin genişletme özelliğinin açılıp kapanmasına yarar.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Çarpı tuşunun pencereyi kapatmasını sağlayan kod
        this.setVisible(true);  // Pencere görünürlük
        this.addKeyListener(keylistener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.startGame = new Text("Start Game",new Font("Times New Roman",Font.BOLD,60),Constants.windowWidth/2-180,Constants.windowHeight/2-10,Color.WHITE);
        this.exitGame = new Text("Exit Game", new Font("Times New Roman",Font.BOLD,40),Constants.windowWidth/2-150,Constants.windowHeight/2+40,Color.WHITE);
        this.PingPong = new Text("Ping Pong", new Font("Times New Roman",Font.ITALIC,100),Constants.windowWidth/2-230,Constants.windowHeight/2-150,Color.WHITE);
        g2= (Graphics2D) getGraphics();
    }



    public void update(){
        Image dbImage = createImage(getWidth(),getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage,0,0,this);
        //System.out.println(mouseListener.getMouseX());
        //System.out.println(mouseListener.getMouseY());
            if (mouseListener.getMouseX() > startGame.x && mouseListener.getMouseX() < startGame.x + startGame.width
                    && mouseListener.getMouseY() > startGame.y - startGame.height / 2 && mouseListener.getMouseY() < startGame.y + startGame.height / 2) {
                startGame.color = new Color(150, 150, 150);
                if (mouseListener.isMousePressed()) {
                    Main.state = 3;
                }
            } else {
                startGame.color = Color.WHITE;
            }
            if (mouseListener.getMouseX() > exitGame.x && mouseListener.getMouseX() < exitGame.x + exitGame.width
                    && mouseListener.getMouseY() > exitGame.y - exitGame.height / 2 && mouseListener.getMouseY() < exitGame.y + exitGame.height / 2) {
                exitGame.color = new Color(150, 150, 150);
                if (mouseListener.isMousePressed()) {
                    Main.state = 5;
                }
            } else {
                exitGame.color = Color.WHITE;
            }


    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRect(0,0,Constants.windowWidth,Constants.windowHeight);
        startGame.draw(g2);
        exitGame.draw(g2);
        PingPong.draw(g2);

    }
    public  void stop(){
        this.dispose();
    }




}

