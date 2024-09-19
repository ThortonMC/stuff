public class ManagementCompany{



    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    private String name, taxID;
    private double mgmFee;
    private Plot managementPlot;
    private Property[] properties;


    public static void main(String[] args){

        Plot testplot = new Plot(5, 5 , 5, 5);
        Plot testplot2 = new Plot(6, 6, 1, 1);

        Property prop = new Property();
        prop = null;



        System.out.println(testplot.encompasses(testplot2));

    }
    public ManagementCompany(){

        managementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        properties = new Property[MAX_PROPERTY];
        name = "";
        taxID = "";
        mgmFee = 0.0;

    }
    public ManagementCompany(String name, String taxID, double mgmFee){

        managementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        properties = new Property[MAX_PROPERTY];
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;


    }
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){

        //managementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
       // properties = new Property[MAX_PROPERTY];
        //properties[0] = new Property(x, y, width, depth);
     // this(name, taxID,mgmFee);

        managementPlot = new Plot(x, y, width, depth);
        properties = new Property[MAX_PROPERTY];
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;

    }
    public ManagementCompany(ManagementCompany otherCompany){

       this(otherCompany.getName(), otherCompany.getTaxID(), otherCompany.getMgmFee());
       this.managementPlot = otherCompany.managementPlot;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFee() {
        return mgmFee;
    }

    public Property[] getProperties() {

        return properties;
    }
    public int getPropertiesCount(){

        int count = 0;
        for(int i = 0; i < properties.length; i++){

            if(properties[i] != null){
                count++;
            }
        }
        return count;

    }
    public boolean isPropertiesFull(){

        if(this.getPropertiesCount() == 5)
            return true;
        else
            return false;


    }
    public double getTotalRent(){

        double totalRent = 0.0;
        for(int i = 0; i < properties.length; i++){

            if(properties[i] != null)
                totalRent += properties[i].getRentAmount();
        }
        return totalRent;

    }
    public Property getHigestRentProperty(){

        if(getPropertiesCount() == 0)
            return null;
        else {

            int highestIndex = 0;
            double highestRent = -1;

            for (int i = 0; i < properties.length; i++) {

                if (properties[i].getRentAmount() > highestRent) {
                    highestRent = properties[i].getRentAmount();
                    highestIndex = i;
                }
            }
            return properties[highestIndex];
        }
    }
    public boolean isManagementFeeValid(){

        if(mgmFee < 101 && mgmFee > -1)
            return true;
        else
            return false;


    }
    public Plot getPlot(){
        return managementPlot;
    }
}