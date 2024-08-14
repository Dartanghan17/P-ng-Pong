import java.awt.*;

public class Text {

    public String text;
    public Font font;
    public double x,y;
    public double width,height;
    public Color color;

    public Text(String text,Font font,double x, double y,Color color){
        this.text = text;
        this.font = font;
        this.x = x;
        this.y = y;
        this.width = font.getSize() * text.length();
        this.height =font.getSize();
        this.color = color;
    }
    public Text(int text,Font font,double x, double y,Color color){
        this.text = "" + text;
        this.font = font;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics2D graphics){
        graphics.setColor(color);
        graphics.setFont(font);
        graphics.drawString(text,(float)x,(float)y);
    }




}
