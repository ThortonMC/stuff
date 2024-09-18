public class Property {

    private String propertyName;
    private String city;
    private Plot plot;
    private double rentAmount;
    private String owner;

    public Property(){

        plot = new Plot();
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
    }

    public Property(String propertyName, String city, double rentAmount, String owner){

        plot = new Plot();
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {


        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        plot = new Plot(x, y, width, depth);

    }
    public Property(Property otherProperty){

        propertyName = otherProperty.getPropertyName();
        city = otherProperty.getCity();
        rentAmount = otherProperty.getRentAmount();
        owner = otherProperty.getOwner();
        plot = new Plot(otherProperty.getPlot());

    }
    public Plot getPlot(){
        return plot;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }
    public String toString(){

        return propertyName + ", " + city + ", " + owner + ", " + rentAmount;
    }

}
