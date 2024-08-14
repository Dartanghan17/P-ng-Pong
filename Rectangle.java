import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle {
    private double x, y, width, height;
    private Color color;
    //Constructor
    public Rectangle(double x, double y, double witdh, double height, Color color){
        this.x = x;
        this.y = y;
        this.width = witdh;
        this.height = height;
        this.color = color;
    }
    //Getter
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public Color getColor(){
        return color;
    }
    //Setter
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y= y;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setColor(Color color){
        this.color = color;
    }




    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fill(new Rectangle2D.Double(x,y,width,height));

    }



}
