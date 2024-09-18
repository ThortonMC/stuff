public class ManagementCompany{

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    private String name, taxID;
    private double mgmFee;
    private Plot managementPlot;
    private Property[] array;

    public ManagementCompany(){

        name = "";
        taxID = "";
        mgmFee = 0.0;
        managementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);

    }
    public ManagementCompany(String name, String taxID, double mgmFee){

        managementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;

    }
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){


        managementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;

    }
    public ManagementCompany(ManagementCompany otherCompany){

        new ManagementCompany(otherCompany.getName(), otherCompany.getTaxID(), otherCompany.getMgmFee());

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

    public Property[] getArray() {
        return array;
    }
    public Plot getPlot(){
        return managementPlot;
    }

}