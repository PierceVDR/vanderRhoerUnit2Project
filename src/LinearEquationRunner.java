import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {

        System.out.println("Welcome!\n"); // Welcome the user, and add a line-break below it

        int x1;
        int y1;
        int x2;
        int y2;

        Scanner scan = new Scanner(System.in);

        // Getting coordinate 1:
        System.out.println("Enter coordinate 1, in form (x, y)");
        System.out.print(" > ");
        String coord1 = scan.nextLine();
        x1 = Integer.parseInt( coord1.substring( coord1.indexOf("(")+1, coord1.indexOf(",") ) );
        y1 = Integer.parseInt( coord1.substring( coord1.indexOf(" ")+1, coord1.indexOf(")") ) );

        // Getting coordinate 2:
        System.out.println("Enter coordinate 2, in form (x, y)");
        System.out.print(" > ");
        String coord2 = scan.nextLine();
        x2 = Integer.parseInt( coord2.substring( coord2.indexOf("(")+1, coord2.indexOf(",") ) );
        y2 = Integer.parseInt( coord2.substring( coord2.indexOf(" ")+1, coord2.indexOf(")") ) );

        System.out.println(); // Just a line break

        // Everything else:

        if (x1==x2) { // Check if not a linear equation
            System.out.println("Uh oh! That's a vertical line, which isn't a linear equation. Anyway:");
            System.out.println("Equation: x = " + x1);
        } else { // If it is linear...
            LinearEquation obj = new LinearEquation(x1,y1,x2,y2);

            // Print all the info:
            System.out.println(obj.lineInfo());

            // Ask for x-value and print that point:
            System.out.println("\nEnter a value for x");
            System.out.print(" > ");
            System.out.println("The point on the line is " + obj.coordinateForX(scan.nextDouble())); // Takes number within line
            scan.nextLine();
        }

        scan.close();

    }
}
