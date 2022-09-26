import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    final int NUM_PANELS_HORIZONTAL = 5; // the horizontal quantity of panels
    final int NUM_PANELS_VERTICAL = 5; // the vertical quantity of panels
    private ArrayList<Drawable> panels; //declaring panels as an arraylist

    public static PApplet app;

    public static void main(String[] args) {
        PApplet.main("Main"); // the name of our class
    }

    public Main() {
        super();
        app = this;
    }

    public void settings() {
        size(600, 600); //the size of the canvas
    }

    public void setup() {

        panels = new ArrayList<Drawable>(NUM_PANELS_HORIZONTAL * NUM_PANELS_VERTICAL); //finding out how many panels you need

        int index = 0; //initialising index to 0
        for (int i = 0; i < NUM_PANELS_VERTICAL; i++) { // look at every panel in rows
            for (int j = 0; j < NUM_PANELS_HORIZONTAL; j++) { //look at every panel in columns
                int x = j * width / NUM_PANELS_HORIZONTAL;
                int y = i * height / NUM_PANELS_VERTICAL; //finding the location of the upper left corner of each panel
                int w = width / NUM_PANELS_HORIZONTAL; // spacing out the width of each panel
                int h = height / NUM_PANELS_VERTICAL;
                Drawable s;
                if (i % 5 == 0) {
                    s = new Panel(x, y, w, h, "data/flower.png");
                } else if (i % 5 == 1) {
                    s = new TintedPanel(x, y, w, h, "data/flower.png");
                } else if (i % 5 == 2) {
                    s = new ContrastedPanel(x, y, w, h, "data/flower.png");
                } else if (i % 5 == 3) {
                    s = new SwappedPanel(x, y, w, h, "data/flower.png");
                } else {
                    s = new FlashingTintedPanel(x, y, w, h, "data/flower.png");
                }
                //s.setupImage("data/flower.png"); //adding the images
                panels.add(s); //making the panels that image
                index++;  //index is whatever panel your currently working on, once you do the code you move to the next panel
            }
        }
    }

    public void draw() {
        fancyBackground(); //using fancy background

        for (int i = 0; i < panels.size(); i++) { //going through the panels to draw and display them
            Drawable s = panels.get(i); //displaying each panel
            s.display();
        }
    }

    public void mouseClicked() {
        for (int i = 0; i < panels.size(); i++) { //go through every panel,
            Drawable s = panels.get(i);
            if (panels.get(i) instanceof Clickable || panels.get(i) instanceof FlashingTintedPanel) {
                ((Clickable) panels.get(i)).handleMouseClicked(mouseX, mouseY); //figures out which panel you clicked on
            }
        }
    }

    private void fancyBackground() {
        loadPixels(); //tells processing we're going to look at pixels
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x + y * width] = color(255, x / 3 + 10, x / 2 + 130);
            }
        }
        updatePixels(); //set the pixels to whatever the code set them to
    }

    public void keyPressed() {
        if (key == 's') {
            Drawable last = panels.get(panels.size() - 1);
            Drawable first = panels.get(0);
            panels.remove(last);
            panels.remove(first);
            panels.add(0, last);
            panels.add(first);

            int fX = ((Panel) first).getX();
            int fY = ((Panel) first).getY();
            int lX = ((Panel) last).getX();
            int lY = ((Panel) last).getY();

            ((Panel) first).setX(lX);
            ((Panel) first).setY(lY);
            ((Panel) last).setX(fX);
            ((Panel) last).setY(fY);
        } else if (key == 'r') {
            for (int i = 0; i < panels.size(); i++) {
                int index = (int) (Math.random() * panels.size()-1);
                Drawable random = panels.get(index);
                Drawable first = panels.get(0);
                panels.remove(first);
                panels.remove(random);
                panels.add(0, random);
                panels.add(index, first);

                int fX = ((Panel) first).getX();
                int fY = ((Panel) first).getY();
                int rX = ((Panel) random).getX();
                int rY = ((Panel) random).getY();

                ((Panel) first).setX(rX);
                ((Panel) first).setY(rY);
                ((Panel) random).setX(fX);
                ((Panel) random).setY(fY);
            }

        }
    }
}
