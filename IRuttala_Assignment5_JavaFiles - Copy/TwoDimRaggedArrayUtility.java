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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility
{
    public TwoDimRaggedArrayUtility() { }

    public static double[][] readFile(File file) throws FileNotFoundException
    {
        String[][] storage = new String[10][10];
        Scanner input = new Scanner(file);
        int row = 0;
        while (input.hasNextLine())
        {
            String line = input.nextLine().trim();
            if(line.isEmpty())
            {
                continue;
            }
            String[] parts = line.split(" ");
            for(int col = 0; col < parts.length; col++)
            {
                storage[row][col] = parts[col];
            }
            row++;
        }
        if(row == 0)
        {
            return null;
        }

        int rowCount = 0;
        for(int r = 0; r < 10; r++)
        {
            if(storage[r][0] != null)
            {
                rowCount++;
            }
        }

        double[][] data = new double[rowCount][];
        for(int r = 0; r < rowCount; r++)
        {
            int colCount = 0;
            for(int c = 0; c < 10; c++)
            {
                if(storage[r][c] != null)
                {
                    colCount++;
                }
            }
            data[r] = new double[colCount];
            for(int c = 0; c < colCount; c++)
            {
                data[r][c] = Double.parseDouble(storage[r][c]);
            }
        }

        return data;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
    {
        PrintWriter printer = new PrintWriter(outputFile);
        for(int r = 0; r < data.length; r++)
        {
            for(int c = 0; c < data[r].length; c++)
            {
                printer.print(data[r][c] + " ");
            }
            printer.println();
        }
        printer.close();
    }

    public static double getTotal(double[][] data)
    {
        double total = 0;
        for(int r = 0; r < data.length; r++)
        {
            for(int c = 0; c < data[r].length; c++)
            {
                total += data[r][c];
            }
        }
        return total;
    }

    public static double getAverage(double[][] data)
    {
        double total = 0;
        int count = 0;
        for(int r = 0; r < data.length; r++)
        {
            for(int c = 0; c < data[r].length; c++)
            {
                total += data[r][c];
                count++;
            }
        }
        return total / count;
    }

    public static double getRowTotal(double[][] data, int row)
    {
        double total = 0;
        for(int c = 0; c < data[row].length; c++)
        {
            total += data[row][c];
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col)
    {
        double total = 0;
        for(int r = 0; r < data.length; r++)
        {
            if(col < data[r].length)
            {
                total += data[r][col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row)
    {
        double highest = data[row][0];
        for(int c = 1; c < data[row].length; c++)
        {
            if(data[row][c] > highest)
            {
                highest = data[row][c];
            }
        }
        return highest;
    }

    public static int getHighestInRowIndex(double[][] data, int row)
    {
        int index = 0;
        double highest = data[row][0];
        for(int c = 1; c < data[row].length; c++)
        {
            if(data[row][c] > highest)
            {
                highest = data[row][c];
                index = c;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row)
    {
        double lowest = data[row][0];
        for(int c = 1; c < data[row].length; c++)
        {
            if(data[row][c] < lowest)
            {
                lowest = data[row][c];
            }
        }
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] data, int row)
    {
        int index = 0;
        double lowest = data[row][0];
        for(int c = 1; c < data[row].length; c++)
        {
            if(data[row][c] < lowest)
            {
                lowest = data[row][c];
                index = c;
            }
        }
        return index;
    }

    public static double getHighestInColumn(double[][] data, int col) {

        boolean columnExists = false;
        double highest = -1;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                if (!columnExists || data[r][col] > highest) {
                    highest = data[r][col];
                }
                columnExists = true;
            }
        }

        return highest;
    }

    public static int getHighestInColumnIndex(double[][] data, int col)
    {
        boolean columnExists = false;
        int index = -1;
        double highest = 0;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                if (!columnExists) {
                    highest = data[r][col];
                    index = r;
                    columnExists = true;
                } else {
                    if (data[r][col] > highest) {
                        highest = data[r][col];
                        index = r;
                    }
                }
            }
        }

        return index;

    }

    public static double getLowestInColumn(double[][] data, int col){

    boolean columnExists = false;
    double lowest = 0;

    for (int r = 0; r < data.length; r++) {
    if (col < data[r].length) {
        if (!columnExists) {
            lowest = data[r][col];
            columnExists = true;
        } else {
              if (data[r][col] < lowest) {
                lowest = data[r][col];
            }
        }
    }
}
       return lowest;
}

    public static int getLowestInColumnIndex(double[][] data, int col)
    {

        boolean columnExists = false;
        int index = -1;
        double lowest = 0;

        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                if (!columnExists) {
                     lowest = data[r][col];
                    index = r;
                    columnExists = true;
                } else {
                   if (data[r][col] < lowest) {
                        lowest = data[r][col];
                        index = r;
                    }
                }
            }
        }

        return index;
    }

    public static double getHighestInArray(double[][] data)
    {
        double highest = data[0][0];
        for(int r = 0; r < data.length; r++)
        {
            for(int c = 0; c < data[r].length; c++)
            {
                if(data[r][c] > highest)
                {
                    highest = data[r][c];
                }
            }
        }
        return highest;
    }

    public static double getLowestInArray(double[][] data)
    {
        double lowest = data[0][0];
        for(int r = 0; r < data.length; r++)
        {
            for(int c = 0; c < data[r].length; c++)
            {
                if(data[r][c] < lowest)
                {
                    lowest = data[r][c];
                }
            }
        }
        return lowest;
    }
}
