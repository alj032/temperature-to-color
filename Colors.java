//Program made by: Austin Jackson
//Homework 3

import java.util.Scanner;

public class Colors {
    /**
     * The minimum value the user can enter
     */
    private static final double MIN_VALUE = 0.0;
    /**
     * The maximum value the user can enter
     */
    private static final double MAX_VALUE = 100.0;
    /**
     * Temperature of 0 degrees
     */
    public static final int ZERO = 0;
    /**
     * the constant used in the color number formula
     */
    public static final int COLOR_NUMBER = 65536;
    /**
     * Temperature of 25 degrees
     */
    public static final int TWENTY_FIVE = 25;
    /**
     * Temperature of 50 degrees
     */
    public static final int FIFTY = 50;
    /**
     * Temperature of 75 degrees
     */
    public static final int SEVENTY_FIVE = 75;
    /**
     * Temperature of 100 degrees
     */
    public static final int ONE_HUNDRED = 100;
    /**
     * Max RGB
     */
    public static final int TWO_HUNDRED_FIFTY_FIVE = 255;
    /**
     * Constant from the color formula
     */
    private static final int TWO_HUNDRED_FIFTY_SIX = 256;


    /**
     * A loop that keeps prompting the user for a temperature until they enter Q to quit.
     * @param args
     */
    public static void main(String[] args) {

        var isExitProgram = false;

        do {

            isExitProgram = getDouble();

        } while (!isExitProgram);


    }

    /**
     * Validate a integer between the defined min/max range or enter 'Q' to quit.
     * This method then calls getRGB if a valid number is entered
     *
     *  @return true if a valid int false if not; used in the main method.
     */
    public static boolean getDouble(){
        var isValid = false; // notice the variable starts with is.
        var temp = ZERO;
        var isReturnFlag = false;

        //prompting the user to enter a number between the defined range MIN_VALUE and MAX_VALUE
        do {
            System.out.printf("Enter a number between %1.1f and %3.1f > %s ",
                                                                            MIN_VALUE,
                                                                            MAX_VALUE,
                                                                            System.lineSeparator());

            var scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                // If the first letter is Q the this method returns true and subsequently ends the program
                if (scanner.next().charAt(ZERO) == 'Q') {
                    System.out.println("Exiting program");
                    isValid = true;
                    isReturnFlag = true;
                } else {
                    //If its not a Q then it tells the user invalid and clears the input stream
                    System.out.println("Invalid Entry, try again");
                    scanner.nextLine();
                }
            } else {
                // check for range.
                // we have a valid number.
                temp = scanner.nextInt();
                // compare temp to our min and max values
                // if not within range it will let the user know they need to try again
                var isWithinRange = Double.compare(temp, MIN_VALUE) >= 0 &&
                                    Double.compare(temp, MAX_VALUE) <= 0;
                if (!isWithinRange) {
                    System.out.println("Number not within Range, try again");
                } else {
                    isValid = true;
                }

                //The user has entered a valid temperature
                System.out.println(getRGB(temp));
                isReturnFlag = false;
            }
        } while (!isValid);

        return isReturnFlag;

    }

    /**
     * Recieves an input temperature and returns the corresponding RGB, Color Value, and the hex value to the user
     *
     * @param temp the temperature that the user has entered
     * @return a string message that tells the user the program has completed
     */

    public static String getRGB(Integer temp){

        var z = 0.0;
        var tempLow = ZERO;
        var tempHigh = ZERO;
        var redLow = ZERO;
        var redHigh = ZERO;
        var greenLow = ZERO;
        var greenHigh = ZERO;
        var blueLow = ZERO;
        var blueHigh = ZERO;
        var red = ZERO;
        var green = ZERO;
        var blue = ZERO;

        // Checking to see what temperature range the given temperature is in.
        // Depending what range it is in different results are printed out

        if (temp >= ZERO && temp  <= TWENTY_FIVE) {

            tempLow = ZERO;
            tempHigh = TWENTY_FIVE;

            redLow = ZERO;
            redHigh = ZERO;
            greenLow = ZERO;
            greenHigh = TWO_HUNDRED_FIFTY_FIVE;
            blueLow = TWO_HUNDRED_FIFTY_FIVE;
            blueHigh = TWO_HUNDRED_FIFTY_FIVE;

            z = ((temp-tempLow)/(double) (tempHigh-tempLow));
            red = (int)((redHigh*z)+redLow*(1-z));
            green = (int)((greenHigh*z)+greenLow*(1-z));
            blue = (int)((blueHigh*z)+blueLow*(1-z));

            System.out.printf("(%d,%d,%2d) %n", red, green, blue);
            System.out.println(getColorNumber(red, green, blue));
            System.out.println(getHexValue(red, green, blue));


        }else if (temp >= TWENTY_FIVE && temp  <= FIFTY){

            tempLow = TWENTY_FIVE;
            tempHigh = FIFTY;

            redLow = ZERO;
            redHigh = ZERO;
            greenLow = TWO_HUNDRED_FIFTY_FIVE;
            greenHigh = TWO_HUNDRED_FIFTY_FIVE;
            blueLow = TWO_HUNDRED_FIFTY_FIVE;
            blueHigh = ZERO;

            z = (temp-tempLow)/(double) (tempHigh-tempLow);
            red = (int)((redHigh*z)+redLow*(1-z));
            green = (int)((greenHigh*z)+greenLow*(1-z));
            blue = (int)((blueHigh*z)+blueLow*(1-z));
            System.out.println(z);

            System.out.printf("(%d,%d,%d) %n", red, green, blue);
            System.out.println(getColorNumber(red, green, blue));
            System.out.println(getHexValue(red, green, blue));

        }else if (temp >= FIFTY && temp <= SEVENTY_FIVE){

            tempLow = FIFTY;
            tempHigh = SEVENTY_FIVE;

            redLow = ZERO;
            redHigh = TWO_HUNDRED_FIFTY_FIVE;
            greenLow = TWO_HUNDRED_FIFTY_FIVE;
            greenHigh = TWO_HUNDRED_FIFTY_FIVE;
            blueLow = ZERO;
            blueHigh = ZERO;

            z = ((temp-tempLow)/(double) (tempHigh-tempLow));
            red = (int)((redHigh*z)+redLow*(1-z));
            green = (int)((greenHigh*z)+greenLow*(1-z));
            blue = (int)((blueHigh*z)+blueLow*(1-z));
            System.out.println(z);

            System.out.printf("(%d,%d,%d) %n", red, green, blue);
            System.out.println(getColorNumber(red, green, blue));
            System.out.println(getHexValue(red, green, blue));

        }else if (temp >= SEVENTY_FIVE && temp <= ONE_HUNDRED) {

            tempLow = SEVENTY_FIVE;
            tempHigh = ONE_HUNDRED;

            redLow = TWO_HUNDRED_FIFTY_FIVE;
            redHigh = TWO_HUNDRED_FIFTY_FIVE;
            greenLow = TWO_HUNDRED_FIFTY_FIVE;
            greenHigh = ZERO;
            blueLow = ZERO;
            blueHigh = ZERO;

            z = ((temp-tempLow)/(double) (tempHigh-tempLow));
            red = (int)((redHigh*z)+redLow*(1-z));
            green = (int)((greenHigh*z)+greenLow*(1-z));
            blue = (int)((blueHigh*z)+blueLow*(1-z));
            System.out.println(z);

            System.out.printf("(%d,%d,%d) %n", red, green, blue);
            System.out.println(getColorNumber(red, green, blue));
            System.out.println(getHexValue(red, green, blue));
        }
        return "Completed";
    }

     /**
     * Use the Red, Green, Blue values of our color and transform them into the color number.
     *
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @return the color number of the given RBG color
     */

    public static int getColorNumber(Integer red, Integer green,Integer blue){
        var colorNumber = ZERO;

        colorNumber = (COLOR_NUMBER*red+TWO_HUNDRED_FIFTY_SIX*green+blue);

        return colorNumber;
    }

    /**
     * Use the Red, Green, Blue values of our color and transform them into there respective
     * hex value. Currently it is broken and when the user enters 0 it SHOULD return 00 however it ACTUALLY returns 0
     *
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @return the hex form of the given RGB color
     */

    public static String getHexValue(Integer red, Integer green, Integer blue){

        String redHex = Integer.toHexString(red);
        String greenHex =  Integer.toHexString(green);
        String blueHex =  Integer.toHexString(blue);

        var hex = ("#" + redHex + greenHex +blueHex);

        return hex;


    }
}


