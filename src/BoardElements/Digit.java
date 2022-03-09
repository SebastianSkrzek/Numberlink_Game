import java.awt.*;

public class Digit extends Square {

    public Digit(Color color, int xCoordinate, int yCoordinate, int name, boolean digit) {
        super(color, xCoordinate, yCoordinate, digit);
        this.name = name;
    }


    @Override
    public String toString() {
        return "BoardElements.Digit{" +
                "color=" + color +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", digit=" + digit +
                ", name=" + name +
                '}';
    }
}





