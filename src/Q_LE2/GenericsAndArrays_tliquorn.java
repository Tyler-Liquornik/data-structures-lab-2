package Q_LE2;

// Imports
import java.util.*;

public class GenericsAndArrays_tliquorn
{

    // Header Method
    public static void myHeader(int exerciseNum)
    {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise: %d-Q1%n", exerciseNum);
        System.out.println("Prepared by: Tyler Liquornik");
        System.out.println("Student Number: 251271244");
        System.out.printf("Goal of this exercise: %s%n", "Understanding Generic Classes");
        System.out.println("=======================================================");
    }

    // Footer Method
    public static void myFooter(int exerciseNum)
    {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d-Q1 is successful!%n", exerciseNum);
        System.out.println("Signing off - Tyler");
        System.out.println("=======================================================");
    }

    public static void main(String[] args) {

        // Print the header
        myHeader(2);

        // Keep track of user input to repeat
        String repeat;

        // Intro paragraph
        System.out.println("""
                This program prints the names of the student leaders from year 2, 3 and 4.
                To see the list of the students from a specific year enter an integer between 2 and 4 when
                prompted.""");

        // Repeat until user wishes to exit program
        do
        {
            // ArrayList of years and names
            ArrayList<Integer> years = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2, 2));
            ArrayList<String> names = new ArrayList<>(Arrays.asList("Harry", "Lavender", "Ron", "Hermoine", "Luna", "Vincent"));

            // Array of pairs
            Pair<Integer, String>[] pairs = new Pair[years.size()];

            // Populating pair array
            for (int i = 0; i < years.size(); i++) {
                pairs[i] = new Pair<>(years.get(i), names.get(i));
            }

            // Scanner object to prompt user for input year
            Scanner input = new Scanner(System.in);

            // Ensure the user inputs the correct data
            int year = 0;
            boolean caught = false;
            boolean allowedYear = false;

            do {
                caught = false;

                try
                {
                    System.out.print("Enter Academic Year (2, 3 or 4): ");
                    year = input.nextInt();
                    allowedYear = year == 2 || year == 3 || year == 4;
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Invalid Input");
                    input.next();
                    caught = true;
                }

                if (!allowedYear && !caught)
                    System.out.println("Invalid Input");
            }
            while (!allowedYear);

            // Keep track of matches of inputted year to people of that year
            ArrayList<String> matches = new ArrayList<String>();
            int matchCounter = 0;

            for (int i = 0; i < years.size(); i++)
            {
                if (pairs[i].getKey() == year)
                {
                    matches.add(pairs[i].getValue());
                    matchCounter++;
                }
            }

            // Print the results
            System.out.printf("Found %d leader(s) from year %d.%n", matchCounter, year);
            System.out.printf("Here is the list:%n%s", matches.toString());

            // Prompt the user to input if they wish to continue
            System.out.print("\nDo you wish to continue? (Press y to continue or any other key to terminate): ");
            repeat = input.next();
        }

        // Repeat as long as the user enters "y"
        while(Objects.equals(repeat, "y"));

        // Print the footer
        myFooter(2);
    }
}