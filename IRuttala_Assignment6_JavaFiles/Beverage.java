public abstract class Beverage extends Object
{
    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 0.5;

    private String bevName;
    private Type type;
    public Size size;

    public Beverage(String bevName, Type type, Size size)
    {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }
    public double getBasePrice()
    {
        return BASE_PRICE;
    }
    public String getBevName()
    {
        return bevName;
    }
    public Type getType()
    {
        return type;
    }
    public Size getSize()
    {
        return size;
    }
    public void setBevName(String bevName)
    {
        this.bevName = bevName;
    }
    public void setType(Type type)
    {
        this.type = type;
    }
    public void setSize(Size size)
    {
        this.size = size;
    }
    public double addSizePrice()
    {
        double price = BASE_PRICE;
        switch(size)
        {
            case LARGE: price += 2 * SIZE_PRICE;
            break;
            case MEDIUM: price += SIZE_PRICE;
            break;
            case SMALL:
            default:
                break;
        }
        return price;
    }
    public abstract double calcPrice();

    @Override
    public boolean equals(Object anotherBev)
    {
        if(this == anotherBev)
        {
            return true;
        }
        if(!(anotherBev instanceof Beverage))
        {
            return false;
        }
        Beverage other = (Beverage) anotherBev;
        return this.bevName.equalsIgnoreCase(other.bevName) && this.type == other.type && this.size == other.size;
    }

    @Override
    public String toString()
    {
        return bevName + ", " + size;
    }


}
