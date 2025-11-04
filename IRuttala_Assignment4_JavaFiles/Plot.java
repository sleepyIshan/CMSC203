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

public class Plot
{
    private int x;
    private int y;
    private int width;
    private int depth;


    // Default constructor
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }
    //Parameterized constructor
    public Plot(int x, int y, int width, int depth)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
	
	//Copy Constructor
    public Plot(Plot otherPlot) {
        if (otherPlot == null) {
            this.x = 0;
            this.y = 0;
            this.width = 1;
            this.depth = 1;
        } else {
            this.x = otherPlot.x;
            this.y = otherPlot.y;
            this.width = otherPlot.width;
            this.depth = otherPlot.depth;
        }
    }

    //Method overlaps
    public boolean overlaps(Plot plot) {
        boolean noOverlap = plot.x + plot.width <= this.x ||  // plot is to the left
                this.x + this.width <= plot.x ||  // plot is to the right
                plot.y + plot.depth <= this.y ||  // plot is above
                this.y + this.depth <= plot.y;  // plot is below
        return !noOverlap;
    }

    //Method encompasses
    public boolean encompasses(Plot plot) {
        if (plot == null) return false;

        return this.x <= plot.x &&
                this.y <= plot.y &&
                this.x + this.width >= plot.x + plot.width &&
                this.y + this.depth >= plot.y + plot.depth;
    }

    //setters
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setDepth(int depth)
    {
        this.depth = depth;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }

    //getters
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getDepth()
    {
        return depth;
    }
    public int getWidth()
    {
        return width;
    }


    @Override
    public String toString()
    {
        return x + ", " + y + ", " + width + ", " + depth;
    }

}
