import processing.core.PApplet;
import processing.core.PImage;

public class SwappedPanel extends Panel implements Clickable, Shower {
    private boolean show;

    public SwappedPanel(int _x, int _y, int _w, int _h, String _imageName) {
        super(_x,  _y,  _w,  _h, _imageName); //calling the super class constuctor
        show = true;
    }

    //overriding the inherited display method
    public void display() {
        if (show != true) {
            super.display();
        }else{
            PImage newImg = getImage().copy(); // apply contrasting to a copy of the original
            newImg.loadPixels();

            // apply the contrast to the new image
            for (int x = 0; x < newImg.width; x++) {
                for (int y = 0; y < newImg.height; y++) {
                    int loc = x + y * newImg.width;
                    if (Main.app.alpha(newImg.pixels[loc]) != 0){
                        if (Main.app.brightness(newImg.pixels[loc]) > 50) {
                            float r = Main.app.red(newImg.pixels[loc]);
                            float g = Main.app.green(newImg.pixels[loc]);
                            float b = Main.app.blue(newImg.pixels[loc]);
                            newImg.pixels[loc] = Main.app.color(b, r, g);
                        }
                    }
                }
                newImg.updatePixels();
                Main.app.image(newImg, getX(), getY(), getWidth(), getHeight());
            }
        }
    }

    public void handleMouseClicked(int _x, int _y) {
        if (_x > getX() && _x < getX() + getWidth() && _y > getY() && _y < getHeight() + getY()) {
            show = !show;
        }
    }

    public boolean getShow() {

        return show;
    }

    public void setShow(boolean _show) {

        show = _show;
    }
}