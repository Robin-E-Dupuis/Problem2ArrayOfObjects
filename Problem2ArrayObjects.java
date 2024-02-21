
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Robin Dupuis
 */
public class Problem2ArrayObjects {

    private String[] names;

    /**
     * Displays: Enter number of names or -1 to quit
     *
     * @return number of students or -1;
     */
    public static int menu() {
        Scanner input = new Scanner(System.in);
        int number = -1;
        do {
            System.out.println("Enter number of students or -1 to quit : ");
            number = input.nextInt();
            if (number == 0) {
                System.out.println("You cannot have 0 names");
            }
            return number;
        } while (number != -1);

    }

    /**
     * Reads form user a number of names, creates the array of names and returns
     * it. Stores the array into this.names
     *
     * @param numberOfNames
     * @return array of names.
     */
    public String[] readNames(int numberOfNames) {
        Scanner input = new Scanner(System.in);
        String name = "";
        names = new String[numberOfNames];
        for (int i = 0; i < numberOfNames; ++i) {
            System.out.println("enter name " + (i + 1) + " of " + numberOfNames);
            names[i] = input.next();
        }

        return names;
    }

    /**
     * Sorts the array of names in ascending order Does not replace the
     * this.names
     *
     * @param ar the array to be sorted
     * @return returns the sorted array
     */
    public static String[] sortNames(String[] ar) {
        for (int i = 0; i < ar.length - 1; ++i) {
            for (int j = i + 1; j < ar.length; ++j) {
                if (ar[i].compareTo(ar[j]) > 0) {
                    String temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        return ar;
    }

    /**
     * Prints the array of objects
     *
     * @param ar is printed
     */
    public static void print(String[] ar) {
        for (int i = 0; i < ar.length; ++i) {
            System.out.println(ar[i]);

        }
    }

    public static void main(String[] args) {
        Problem2ArrayObjects problem2 = new Problem2ArrayObjects();
        int choice = menu();
        while (choice != -1) {
            problem2.readNames(choice);
            System.out.println("---Original Array---");
            print(problem2.names);
            String[] copyOfnames = Arrays.copyOf(problem2.names, problem2.names.length);
            copyOfnames = sortNames(copyOfnames);
            System.out.println("---Sorted Array---");
            print(copyOfnames);
            choice = menu();
            System.out.println("------------------");

        }
        System.out.println("Goobye!");
    }

}
