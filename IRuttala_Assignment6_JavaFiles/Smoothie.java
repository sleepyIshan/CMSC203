public class Smoothie extends Beverage
{
    private static final double PROTEIN_PRICE = 1.5;
    private static final double FRUIT_PRICE = 0.5;

    private int numOfFruits;
    private boolean addProtein;
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
    {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }
    public int getNumOfFruits()
    {
        return numOfFruits;
    }
    public boolean getAddProtein()
    {
        return addProtein;
    }
    public void setNumOfFruits(int numOfFruits)
    {
        this.numOfFruits = numOfFruits;
    }
    public void setAddProtein(boolean addProtein)
    {
        this.addProtein = addProtein;
    }
    @Override
    public double calcPrice()
    {
        double price = addSizePrice();
        price += numOfFruits * FRUIT_PRICE;
        if(addProtein)
        {
            price += PROTEIN_PRICE;
        }
        return price;
    }
    @Override
    public boolean equals(Object anotherBev)
    {
        if (!super.equals(anotherBev)) {
            return false;
        }

        Smoothie other = (Smoothie) anotherBev;
        return this.numOfFruits == other.numOfFruits &&
                this.addProtein == other.addProtein;
    }
    @Override
    public String toString()
    {
        return getBevName() + ", " + getSize() + ", Fruits: " + numOfFruits + ", Protein: " + addProtein + ", Price: " + calcPrice();
    }
}
