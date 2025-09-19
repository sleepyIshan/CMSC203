/*
 * Class: CMSC203
 * Instructor: Professor Thai
 * Description: This is a program that reads a file with a variety of names of colors and the user has to guess what color the program is thinking of.
 * The program randomizes the list of colors to select its option.
 * Due: 09/19/2025
 * Platform/compiler: Intellij
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: ISHAN RUTTALA
 */

//Imports
import java.io.File; //For reading files
import java.io.FileNotFoundException; //Exception in the case a file isnt found
import java.io.PrintWriter; //For writing results into a file
import java.util.Random; //Generate Random Numbers
import java.util.Scanner; //For User Input

public class ESPGame
{
    public static void main(String[] args)
    {
        //Variables and new Scanner object creation for inputs
        Scanner input = new Scanner(System.in);
        final String FILE_NAME = "colors.txt"; //Reads that specific name
        final int ROUNDS = 3; //Game rounds
        final int MAX_NUMCOLORS = 16; //Total number of colors

        //Will the game continue or not? boolean checking
        boolean continueGame = true;

        //Game starting messages
        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        System.out.println("Welcome to ESP - extrasensory perception!");

        while(continueGame)
        {
            //Options menu popup with \n to separate the options from the game starting messages
            System.out.println("\nWould you please choose one of the 4 options from the menu:");
            System.out.println("1 - Read and display first 16 colors");
            System.out.println("2 - Read and display first 10 colors");
            System.out.println("3 - Read and display first 5 colors");
            System.out.println("4 - Exit from program");
            System.out.print("Enter the option: ");
            String UserOption = input.nextLine();

            int colorsNumCurrent;

            //Users inputs for which option they select
            if(UserOption.equals("1"))
            {
                colorsNumCurrent = 16;
            }
            else if(UserOption.equals("2"))
            {
                colorsNumCurrent = 10;
            }
            else if(UserOption.equals("3"))
            {
                colorsNumCurrent = 5;
            }
            else if(UserOption.equals("4"))
            {
                break;
            }
            else
            {
                System.out.println("Enter a valid option.");
                continue;
            }
            //To open the file and to display the number of colors based on user option selection
            try {
                Scanner fileScan = new Scanner(new File(FILE_NAME));
                int counter = 0; //Counts how many colors in the file have been read
                System.out.println("There are " + MAX_NUMCOLORS + " colors from a file: "); //Prints the total number of colors after reading the file
                while(fileScan.hasNextLine() && counter < colorsNumCurrent) //Keeps looping through the file for as many lines as there are but with a restriction to the user selected number (16, 10, 5)
                {
                    counter++; //Color count increased by one
                    String color = fileScan.nextLine();
                    System.out.println(counter + " " + color); //Prints color found
                }
            }
            catch (FileNotFoundException e)
            {
                //Exception handling for if the file can't be located
                System.out.println("Error Code 1: Could not locate file " + FILE_NAME);
                return;
            }

            //Creating a new random object for the randomized color selection
            Random rand = new Random();
            //Tracker for correct guesses (quite self explanatory)
            int correctGuessCounter = 0;

            for(int round = 1; round <= ROUNDS; round++)
            {
                System.out.println("Round " + round); //Displaying what round it is
                System.out.println("I am thinking of a color.");
                System.out.println("Is it one of list of colors above?");
                System.out.print("Enter your guess (color name): "); //I added (color name) to specify to enter the name of the color and not the number (I admit I got a bit confused at first when I saw the numbers)
                String UserGuess = input.nextLine().trim(); //Standard practice to remove extra spaces

                //To generate a new random number between 1 and the max number of colors
                int randomNumber = rand.nextInt(MAX_NUMCOLORS) + 1;
                String selectColor = ""; //Used for holding the color that was selected

                //Reading the file again to find a color at a random line in the list
                try{
                    Scanner fileScanner = new Scanner(new File(FILE_NAME));
                    int line = 1; //Tracks the current line in the file
                    while(fileScanner.hasNextLine()) //Loops through each line
                    {
                        String color = fileScanner.nextLine();
                        if(line == randomNumber) //Checks if the line number equals the number that was generated before
                        {
                            selectColor = color; //If match was found then store it as color
                            break;
                        }
                        line++; //If nothing was found yet, move to the next line
                    }
                }
                //Exception handling in case program can't find the file
                catch (FileNotFoundException e)
                {
                    System.out.println("Error Code 1: Could not locate file " + FILE_NAME);
                    return;
                }

                //Checks if the users guess is matching with the randomly selected color
                if(UserGuess.equalsIgnoreCase(selectColor))
                {
                    correctGuessCounter++; //Counter goes up by 1
                }
                System.out.println("I was thinking of " + selectColor + ".");
            }
            //3 rounds are over now
            System.out.println("Game Over");
            System.out.println("You guessed " + correctGuessCounter + " out of " + ROUNDS + " colors correctly.");

            //Prompt user to choose if they want to play the game again
            System.out.print("\nWould you like to continue a Game? Type Yes/No: ");
            String notherUserInp = input.nextLine();
            if(!notherUserInp.equalsIgnoreCase("Yes"))
            {
                continueGame = false; //Meaning the game will end because the user does not want to "continue game"
            }
        }

        //End of game and now asking for the users details/information
        System.out.print("\nEnter your name User: ");
        String userName = input.nextLine();
        System.out.print("Describe yourself: ");
        String userDescription = input.nextLine();
        System.out.print("Due Date (MM/DD/YY): ");
        String userDueDate = input.nextLine();

        //Displaying the user details
        System.out.println("\nUsername: " + userName);
        System.out.println("User Description: " + userDescription);
        System.out.println("Date: " + userDueDate);

        //writing the game results and user details into a file
        try
        {
            PrintWriter printer = new PrintWriter("EspGameResults.txt");
            printer.println("Game Over");
            printer.print("UserName: " + userName);
            printer.print("User Description: " + userDescription);
            printer.println("Date: " + userDueDate);
            printer.close();
        }
        //In case something happens show an error
        catch (FileNotFoundException e)
        {
            System.out.println("Error Code 2 writing to EspGameResults.txt");
        }
        //End of program!!!!!
    }
}