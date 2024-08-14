import java.awt.event.KeyEvent;

public class PlayerController {

    private Rectangle rectangle;
    private KeyList keyListener;

    public  PlayerController(Rectangle rectangle,KeyList keyListener){
        this.setRectangle(rectangle);
        this.keyListener = keyListener;
    }
    public  PlayerController(Rectangle rectangle){
        this.setRectangle(rectangle);
        this.keyListener=null;
    }
    public void update(double dt){
        if(keyListener != null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
                moveDown(dt);
            }
            if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                moveUp(dt);
            }

        }
    }
    public void moveDown (double dt){
        double positionY = this.getRectangle().getY();
        positionY += Constants.playerSpeed*dt;
        if((positionY+Constants.playerHeight)<Constants.windowHeight){
            this.getRectangle().setY(positionY);
        }
    }
    public void moveUp (double dt){
        double positionY = this.getRectangle().getY();
        positionY -= Constants.playerSpeed*dt;
        if(positionY>Constants.toolbarHeight){
            this.getRectangle().setY(positionY);
        }
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }




/*
    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public KeyList getKeyListener() {
        return keyListener;
    }

    public void setKeyListener(KeyList keyListener) {
        this.keyListener = keyListener;
    }

*/
}
