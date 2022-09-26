import processing.core.PApplet;
import processing.core.PImage;

public class ContrastedPanel extends Panel {
    public ContrastedPanel(int _x, int _y, int _w, int _h, String _imageName) {
        super(_x,  _y,  _w,  _h,_imageName); //calling the super class constuctor
    }

    //overriding the inherited display method
    public void display() {
        PImage newImg = getImage().copy(); // apply contrasting to a copy of the original
        newImg.loadPixels();

        // apply the contrast to the new image
        for (int y = 0; y < newImg.height; y++) {
            for (int x = 0; x < newImg.width; x++) {
                int loc = x + y * newImg.width;
                if (Main.app.brightness(newImg.pixels[loc]) < 240) {
                    newImg.pixels[loc] = Main.app.color(255); // if very bright, then make it white
                } else {
                    newImg.pixels[loc] = Main.app.color(0, 0); // if not very bright, make completely transparent
                }
            }
        }
        newImg.updatePixels();
        Main.app.image(newImg, getX(), getY(), getWidth(), getHeight());
    }
}