public class ManagementCompany{

    private final int MAX_PROPERTY = 5;
    private final int MGMT_WIDTH = 10;
    private final int MGMT_DEPTH = 10;
    private String name, taxID;
    private double mgmFee;
    private Plot managementPlot;


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














}