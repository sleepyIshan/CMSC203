/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Due: 11/21/2025
 * Platform/compiler: Intellij
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Ishan Ruttala
 */


public class HolidayBonus extends Object
{
    public static final double BONUS_HIGH = 6000.0;
    public static final double BONUS_LOW = 1000.0;
    public static final double BONUS_GENERAL = 3000.0;

    public HolidayBonus() { }

    public static double[] calculateHolidayBonus(double[][] data)
    {
        double[] newBonus = new double[data.length];
        for(int col = 0; col < 10; col++)
        {
            double high = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
            double low = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            for(int row = 0; row < data.length; row++)
            {
                if(col < data[row].length)
                {
                    if(row == highIndex)
                    {
                        newBonus[row] += BONUS_HIGH;
                    }
                    else if(row == lowIndex)
                    {
                        newBonus[row] += BONUS_LOW;
                    }
                    else
                    {
                        newBonus[row] += BONUS_GENERAL;
                    }
                }
            }
        }

        return newBonus;
    }

    public static double calculateTotalHolidayBonus(double[][] data)
    {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}
