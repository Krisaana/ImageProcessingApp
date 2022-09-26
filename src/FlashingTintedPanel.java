import processing.core.PApplet;

public class FlashingTintedPanel extends Panel implements Clickable {
    private boolean flashState;
    public FlashingTintedPanel(int _x, int _y, int _w, int _h, String _imageName){
        super(_x,  _y,  _w,  _h, _imageName); //calling the super class constuctor
        flashState = true;
    }

    //overriding the inherited display method
    public void display(){
        if (flashState == true) {
            Main.app.tint(78, 98, 255, 255);
        }
        else {
            Main.app.tint(83, 17, 89, 255);
        }
          super.display(); //calling the inherited display method
        Main.app.noTint(); // turns off tint effect after the image is  displayed

    }
    public void handleMouseClicked(int _x, int _y){
        if (_x > getX() && _x < getX() + getWidth() && _y > getY() && _y < getHeight() + getY()) {
            flashState = !flashState;
        }

    }
}

