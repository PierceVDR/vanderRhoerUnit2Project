public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // Private methods for convenience

    private boolean isPos(double n) {return n==Math.abs(n);}
    private double roundedToHundredth(double n) {
        if (isPos(n)) { // Have to do separate thing for negative numbers
            return (int) (n*100 + 0.5) / 100.0;
        } else {
            return (int) (n*100 - 0.5) / 100.0;
        }
    }

    private double exactSlope() {
        return (double) (y2-y1)/(x2-x1);
    }

    private double f( double x ) { // Returns exact y value for a x value
        return exactSlope()*(x-x1) + y1;
    }

    // Constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }

    public double distance() {
        return roundedToHundredth( Math.sqrt( Math.pow(y2-y1,2) + Math.pow(x2-x1,2) ) );
    }

    public double yIntercept() {
        return roundedToHundredth(f(0));
    }

    public double slope() {
        return roundedToHundredth(exactSlope());
    }

    public String equation() {
        String str = "y = ";
        int num = y2-y1;
        int den = x2-x1;

        double yInt = yIntercept();
        if (exactSlope() != 0) { // Before we add the slope or intercept, check if we need to write the slope

            // Slope
            if ( (int) exactSlope() == exactSlope() ) { // Returns true if the slope simplifies to a whole number/integer

                if (exactSlope()==-1) { // Check if slope is -1
                    str+="-"; // Add just the minus sign if slope is -1
                } else if (exactSlope()!=1) { // Check if slope is 1
                    str+=(int) exactSlope(); // Add slope (skipped if it's 1 or -1)
                }

            } else { // If the slope isn't an integer:

                if (!isPos(den)) { // Fix neg/neg and pos/neg fractions
                    den*=-1;
                    num*=-1;
                }

                str+=num + "/" + den; // Write fraction
            }

            str+="x"; // Add the x-variable

            if (yInt!=0) { // Check if we need to write the y-intercept
                if (isPos(yInt)) { // If positive...
                    str+=" + "; // ...add a +
                } else { // If negative...
                    str+=" - "; // add a -
                }
                str+=Math.abs(yInt); // Add abs of y-intercept -- if statement takes care of the sign
            }

        } else { // If the slope is 0...
            str+= (int) yInt; // y-intercept will have to be an int if the slope is 0
        }


        return str;
    }

    public String coordinateForX(double xValue) {
        return "(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(f(xValue)) + ")";
    }

    public String lineInfo() {
        return "The two points are (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\nThe equation between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe distance between these two points is: " + distance();
    }
}