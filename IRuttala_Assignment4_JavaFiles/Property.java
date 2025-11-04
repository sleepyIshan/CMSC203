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

public class Property
{
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }

    //  constructor with 4 params
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();  // default plot
    }
	
    //Parameterized constructor 8 params
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

// Copy constructor
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }

    public Plot getPlot()
    {
        return plot;
    }
    public String getPropertyName()
    {
        return propertyName;
    }
    public String getCity()
    {
        return city;
    }
    public double getRentAmount()
    {
        return  rentAmount;
    }
    public String getOwner()
    {
        return owner;
    }


    @Override
    public String toString()
    {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }


}