public class Alcohol extends Beverage
{
    private static final double WEEKEND_PRICE = 0.5;

    private boolean isWeekend;

    public Alcohol(String bevName, Size size, boolean isWeekend)
    {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }
    public boolean isWeekend()
    {

        return isWeekend;
    }
    public void setWeekend(boolean weekend)
    {
        isWeekend = weekend;
    }
    @Override
    public double calcPrice()
    {
        double price = addSizePrice();
        if (isWeekend)
        {
            price += WEEKEND_PRICE;
        }
        return price;
    }
    @Override
    public boolean equals(Object anotherBev)
    {
        if(!super.equals(anotherBev))
        {
            return false;
        }
        Alcohol other = (Alcohol) anotherBev;
        return this.isWeekend == other.isWeekend;
    }
    @Override
    public String toString()
    {
        return getBevName() + ", " + getSize() + ", Weekend: " + isWeekend + ", Price: " + calcPrice();
    }
}
