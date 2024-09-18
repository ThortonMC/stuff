public class Property {

    String propertyName;
    String city;
    Plot plot;
    double rentAmount;
    String owner;
    int x;
    int y;
    int width;
    int depth;
    int c;
    int d;





    public Property(){


    }

    public Property(String propertyName, String city, double rentAmount, String owner){



    }
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){


        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);




//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.depth = depth;
//
//        c = x + width;
//        d = y + depth;



    }





}
