/*
 * Class: CMSC203
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: 11/03/2025
 * Platform/compiler: Intellij
 * I pledge that I have completed the programming
assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: ISHAN RUTTALA
*/


public class ManagementCompany
{
    private String name;
    private String taxID;
    private double mgmFeePer;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    public ManagementCompany()
    {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0.0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
    {
        this(name, taxID, mgmFee);
        this.plot = new Plot(x,y,width,depth);
    }

    public ManagementCompany(ManagementCompany otherCompany)
    {
        this.name=otherCompany.name;
        this.taxID=otherCompany.taxID;
        this.mgmFeePer=otherCompany.mgmFeePer;
        this.plot = new Plot(otherCompany.plot);
        this.numberOfProperties = otherCompany.numberOfProperties;
        this.properties = new Property[MAX_PROPERTY];
        for(int i = 0; i < this.numberOfProperties; i++)
        {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
    }

   public int addProperty(String name, String city, double rent, String owner)
    {
        Property newProperty = new Property(name, city, rent, owner);
        return addProperty(newProperty);
    }


    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
    {
        Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(newProperty);
    }

    //Overloaded method for addProperty
    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }
        else if (property == null) {
            return -2;
        }
        else if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot()))
                return -4;
        }
        properties[numberOfProperties] = new Property(property);
        return numberOfProperties++;
    }

    //Method removeLastProperty
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull()
    {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public int getPropertiesCount()
    {
        return numberOfProperties;
    }

    //Method getTotalRent

    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    //Method getHighestRentProperty
    public Property getHighestRentPropperty() {
        if (numberOfProperties == 0){
            return null;
        }
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
        if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                    highestRentProperty = properties[i];
                 }
               }
           return highestRentProperty;
    }

    //Method isManagementFeeValid
    public boolean isMangementFeeValid()
    {
        return mgmFeePer >= 0 &&  mgmFeePer <= 100;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }
    public Property[] getProperties()
    {
        return properties;
    }

    public Plot getPlot() {
        return plot;
    }



    //Method toString
    @Override
    public String toString() {
        String complete = "List of the properties for " + name + ", taxID: " + taxID + "\n";
        complete += "______________________________________________________\n";

        for (int i = 0; i < numberOfProperties; i++) {
            complete += properties[i].toString() + "\n";
        }

        complete += "______________________________________________________\n";
        double totalRent = getTotalRent();
        double managementFee = totalRent * (mgmFeePer / 100.0);
        complete += "Total management Fee: " + managementFee;

        return complete;
    }

}
