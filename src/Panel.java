import processing.core.PApplet;
import processing.core.PImage;

public class Panel extends ImageWrapper implements Drawable {
    // private instance variables
    private PImage img;

    // constructor
    Panel(int _x, int _y, int _w, int _h, String _imageName){
        super(_x,  _y,  _w,  _h, _imageName);
        img = Main.app.loadImage(_imageName);
    }



    public void display(){
        Main.app.image(img, getX(), getY(), getWidth(),getHeight());
    }

   // public void handleMouseClicked(int _x, int _y){
   //     System.out.println("Mouse clicked " + Integer.toString(identifier));
  //  }

    public PImage getImage(){
        return img;
    }
}