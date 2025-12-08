public class Coffee extends Beverage
{
    private static final double EXTRA_SHOT_PRICE = 0.5;
    private static final double EXTRA_SYRUP_PRICE = 0.5;

    private boolean extraShot;
    private boolean extraSyrup;
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
    {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }
    public boolean getExtraShot()
    {
        return extraShot;
    }
    public boolean getExtraSyrup()
    {
        return extraSyrup;
    }
    public void setExtraShot(boolean extraShot)
    {
        this.extraShot = extraShot;
    }
    public void setExtraSyrup(boolean extraSyrup)
    {
        this.extraSyrup = extraSyrup;
    }
    @Override
    public double calcPrice()
    {
        double price = addSizePrice();
        if (extraShot) {
            price += EXTRA_SHOT_PRICE;
        }

        if (extraSyrup) {
            price += EXTRA_SYRUP_PRICE;
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
        Coffee other = (Coffee) anotherBev;
        return this.extraShot == other.extraShot && this.extraSyrup == other.extraSyrup;
    }
    @Override
    public String toString()
    {
        return getBevName() + ", " + getSize() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup + ", Price: " + calcPrice();
    }
}
