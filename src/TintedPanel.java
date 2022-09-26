import processing.core.PApplet;

public class TintedPanel extends Panel{
    public TintedPanel(int _x, int _y, int _w, int _h, String _imageName){
        super(_x,  _y,  _w,  _h, _imageName); //calling the super class constuctor
    }

    //overriding the inherited display method
    public void display(){
        Main.app.tint(5, 180, 255, 255);
        super.display(); //calling the inherited display method
        Main.app.noTint(); // turns off tint effect after the image is displayed
    }
}