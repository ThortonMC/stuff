import java.util.Random;

public class Plot {


    private int x = -1, y = -1;
    private int width, depth;
    private int c, d;

    public Plot(){

        Random randomNumber = new Random();
        int random = randomNumber.nextInt(10);
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

        if(plot.getX() > x && plot.getX() > x + width)
            return



    }
    public boolean encompasses(Plot plot){


    }
    public boolean

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












}
