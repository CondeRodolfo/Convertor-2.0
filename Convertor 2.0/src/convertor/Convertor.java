
/*
Creator:
    Rodolfo Melanda Conde
    Creation Date:
    04/04/16

Methods:
    + void main (String [] args)
    + public static void printMessage (double value)
    + public static void measureList()
    + public static int measureSelect(int op)
    + public static void calculate()
    + public static void temperatureSelection()
    + public static void temperatureCalculation()
    

Classes this class requires
    Java.util.scanner

Classes that require this class
    None

*/
 
package convertor;

import java.util.Scanner;

public class Convertor {

    /**
     * @param args the command line arguments
     */
    
    //List of measures
    static String[] measure = {"Cm", "Meters", "Inch", "Feet", "Miles", "Kilometres"};
    
    //List of Convertion values
    static double[] fromCmValues = {1, 0.01, 0.3937007874015748, 0.0328083989501312, 0.00000621371192237334, 0.00001};
	static double[] toCmValues = {1, 100, 2.54, 30.48, 160934.4, 100000};
    
    //Global variables declaration
    static int posFrom = 0;
    static int posTo = 0;
	static int temperatureSelect = 0;
	
    public static void main(String[] args) {
        //Variable declaration
        int operation = 0;
        Scanner scan = new Scanner(System.in);
        
        while(operation != 3)
        {
            //Main menu
            System.out.println("\nChoose an action:");
            System.out.println("(1)Length Conversion.");
            System.out.println("(2)Temperature Conversion." );
			System.out.println("(3)Exit." );
            System.out.println("Type the number relative to the action you want:");
            operation = scan.nextInt();
            
            switch (operation)
            {
                case 1:
                    //Select measure to convert
                    System.out.println("\nSelect the measure you want to convert:");
                    measureList();
                    System.out.println("Please choose a measure to convert from.");
                    posFrom = scan.nextInt();
                    measureSelect(posFrom);
                    System.out.println("Now choose a measure to convert to:");
                    posTo = scan.nextInt();
                    
                    //Display measures selected
                    System.out.println("You chose from " + measure[posFrom] 
                    + " to " + measure[posTo] + ".\n");
                    
                    //Get user input and calculate
                    calculate();
                    break;
				case 2:
                    System.out.println("\nSelect the convertion:");
					temperatureSelection();
					
                    break;
                case 3:
                    //Exits the program
                    System.out.println("Thank you for using this program.");
                    break;
                default:
                    //Display message to user
                    System.out.println("Invalid Option. Choose from 1 to 3.");
                    break;
            }
        }
    }
    
	//Printing and formatting of the value
    public static void printMessage (double value)
    {
        System.out.println("The Value is: " + String.format("%.2f", value));
    }
    
    //Loop to print the list of measures 
    public static void measureList()
    {
        for(int counter = 0; counter < measure.length; counter++)
            {
                System.out.println("(" + counter + ")" + measure[counter]);
            }
    }
	
	//Selection of the Measures
	public static int measureSelect(int op)
    {
        switch (op)
        {
            case 1:
                System.out.println("\nPlease type one of the numbers bellow:");
                measureList();
                break;
            case 2:
                System.out.println("Now choose a measure to converto to:");
                measureList();
                System.out.println("Please type one of the numbers bellow:");
                break;
            case 3:
                System.out.println("Now choose a measure to converto to:");
                measureList();
                System.out.println("Please type one of the numbers bellow:");
                break;
            case 4:
                System.out.println("Now choose a measure to converto to:");
                measureList();
                System.out.println("Please type one of the numbers bellow:");
                break;
            case 5:
                System.out.println("Now choose a measure to converto to:");
                measureList();
                System.out.println("Please type one of the numbers bellow:");
                break;
            case 6:
                System.out.println("Now choose a measure to converto to:");
                measureList();
                System.out.println("Please type one of the numbers bellow:");
                break;
        }   
        return op;
    }
    
	//Calculations
    public static void calculate()
    {
		//Local Variables
        Scanner scan = new Scanner(System.in);
        double userInput;
		double total;
        double calc;
        
        System.out.println("Type the value you want to convert");
        userInput = scan.nextDouble();
        
		//Transforms user input into Cm and convert to the selected measure
        calc = userInput * toCmValues[posFrom];
		total = calc * fromCmValues[posTo];
        
		//Display the converted value
        System.out.print("Your convertion from " + measure[posFrom] 
                + " to " + measure[posTo] + " is ");
        printMessage(total);
    }
	
	//Selection of the temperature
	public static void temperatureSelection()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("(1)From Celsius to Fahrenheit.");
		System.out.println("(2)From Fahrenheit to Celsius.");
		System.out.println("Type a number between 1 and 2.");
		temperatureSelect = scan.nextInt();
		switch(temperatureSelect)
		{
			case 1:
				temperatureCalculation();
				break;
			case 2:
				temperatureCalculation();
				break;
			default:
				System.out.println("Invalid Option. Choose from 1 to 2.");
				break;
		}
	}
	
	//Calculation of the Temperature
	public static void temperatureCalculation()
	{
		//Local Variables
		Scanner scan = new Scanner(System.in);
        double userInput;
		
		System.out.println("\nType the value you want to convert:");
		userInput = scan.nextDouble();
		
		if(temperatureSelect == 1)
		{
			userInput = (userInput * 1.8) + 32;
		}
		else
		{
			userInput = ((userInput - 32) * 5) / 9;
		}
		//Display the converted value
        System.out.println("Your convertion is " + userInput);
	}
}
