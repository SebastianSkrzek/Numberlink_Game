import javax.swing.*;
import java.awt.*;

public class Square extends JButton {

    protected Color color;
    protected final int xCoordinate;
    protected final int yCoordinate;
    protected boolean digit;
    protected int name;

    public Square (Color color, int xCoordinate, int yCoordinate, boolean digit) {
        this.color = color;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.digit = digit;
        this.name = -1; //jesli name == -1 to kwadrat nie jest digitem, wtedy tez digit = false
    }

    public void setColor (Color color) {

        this.color = color;
    }


    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public Color getColor() {
        return color;
    }

    public boolean isDigit() { return digit; }

    public int getname() {
        return name;
    }
}
