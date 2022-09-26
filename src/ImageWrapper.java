import processing.core.PApplet;

public abstract class ImageWrapper {
    private int x;
    private int y;
    private int w;
    private int h;

    private String img;
    public ImageWrapper (int _x, int _y, int _w, int _h, String _imageName){
        x = _x;
        y = _y;
        w = _w;
        h = _h;
        img = _imageName;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int _x){
        x = _x;
    }

    public void setY(int _y){
        y = _y;
    }
    public int getWidth(){
        return w;
    }
    public int getHeight(){
        return h;
    }

}
