import java.util.Random;

public class Plot {


    private int x, y;
    private int width, depth;
    private int c, d;

    public Plot(){

        Random randomNumber = new Random();
        int random = randomNumber.nextInt(10);              // creates a plot
        int random2 = randomNumber.nextInt(10);

        //int random = randomNumber.nextInt((9+0)+1) + 0;

        x = random;
        y = random2;
        width = 1;
        depth = 1;
        c = x + width;
        d = y + depth;

    }
    public Plot(int x, int y, int width, int depth){

        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;

        c = x + width;
        d = y + depth;
    }

    public Plot(Plot otherPlot){

        new Plot(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());

    }
    public boolean overlaps(Plot plot){

        if(plot.getX() > c || (plot.getX() + plot.getWidth()) < x){
            return false;
        }
        if(plot.getY() > d || (plot.getY() + plot.getDepth()) < y) {
            return false;
        }
        return true;

    }
    public boolean encompasses(Plot plot){

        if(plot.getX() >= x && plot.getX() <= c && (plot.getX() + plot.getWidth()) <= c && plot.getY() >= y && plot.getY() <= d && (plot.getY() + plot.getDepth()) <= d)
            return true;
        else
            return false;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getDepth(){
        return depth;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public String toString(){

        return "x: " + x + ", y: " + y + ", width: " + width + ", depth: " + depth;
    }












}
