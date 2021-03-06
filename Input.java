import java.text.*;
import java.util.Scanner;

public class Input {
	double input;
	
	//markups
	static double flatRate = 0.05;
	static int numPeople;
	double peopleMarkup;
	double pharmaMarkup;
	double foodMarkup;
	double elecMarkup;
	double otherMarkup;
	
	//variables
	double flatMarkup;
	double basePrice;
	double markUps;
	double finalCost;
	static double finalRoundedCost;
	static boolean drugs;
	static boolean eat;
	static boolean tech;
	static boolean etc;
	
	//additional variables relationship
	boolean involvedPharma;
	boolean involvedFood;
	boolean involvedElec;
	boolean involvedOther;
	
	
	//constructor
	public Input(double originalPrice) {
		input = originalPrice;
	}
	// relationships
	public boolean isPharma(boolean pharma){
		involvedPharma = drugs;
		if (involvedPharma == true){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFood(boolean food){
		involvedFood = food;
		if (involvedFood == true){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isElec(boolean elec){
		involvedElec = elec;
		if (involvedElec == true){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isOther(boolean other){
		involvedOther = other;
		if (involvedOther == true){
			return true;
		} else {
			return false;
		}
	}

	public double calcFlatMarkup(double origPrice){
		flatMarkup = origPrice * flatRate;
		return flatMarkup;
	}
	
	public double calcBasePrice (double origPrice, double inputFlat){
		basePrice = origPrice + inputFlat;
		return basePrice;
	}
	
	public double calcMarkUps(double base, int people, boolean pharma, boolean food, boolean elec, boolean other){
		peopleMarkup = people * 0.012;
		
		if (pharma == true){
			pharmaMarkup = 0.075;
		} else {
			pharmaMarkup = 0;
		}
		
		if (food == true){
			foodMarkup = 0.13;
		} else {
			foodMarkup = 0;
		}
		
		if (elec == true){
			elecMarkup = 0.02;
		} else {
			elecMarkup = 0;
		}
		
		if (other == true || other == false){
			otherMarkup = 0;
		}
		
		markUps = peopleMarkup + pharmaMarkup + foodMarkup + elecMarkup + otherMarkup;
		
		return markUps;
	}
	
	public double calcFinalCost (double b, double m) {
		finalCost = b * (1 + m);
		return finalCost;
	}
	
	public static void main (String[] arguments){
		System.out.println ("Welcome to NuPack Pricing Calculator\n");
	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter initial cost");
		String initialize = keyboard.nextLine();
		double initialCost = Double.parseDouble(initialize);
		
		Input testInput = new Input (initialCost);
		double initialPrice = testInput.input;
		
		System.out.println ("Number of people that needs to work on the job: ");		
		String enterPeople = keyboard.nextLine();
		numPeople = Integer.parseInt(enterPeople);
		
		System.out.println ("Are there pharmaceuticals involved [true/false]? " );
		String enterDrugs = keyboard.nextLine();
		drugs = Boolean.parseBoolean(enterDrugs);
		
		System.out.println ("Are there any food involved [true/false]? ");
		String enterFood = keyboard.nextLine();
		eat = Boolean.parseBoolean(enterFood);
		
		System.out.println ("Are there electronics involved [true/false]? ");
		String enterTech = keyboard.nextLine();
		tech = Boolean.parseBoolean(enterTech);
		
		System.out.println ("Are there any more materials (other than pharmaceuticals, food and/or electronics) involved [true/false]? ");
		String enterOther = keyboard.nextLine();
		etc = Boolean.parseBoolean(enterOther);
		
		
		//System.out.println ("\n\nCalculate Flat Markup Cost");
		testInput.calcFlatMarkup(testInput.input);
		//System.out.println ("Flat Markup Cost is (should be 64.9995) $" + testInput.flatMarkup);
		
		
		//System.out.println ("\n\nCalculate Base Price");
		testInput.calcBasePrice(initialPrice, testInput.flatMarkup);
		//System.out.println ("Base Price is (should be 1364.9895) $" + testInput.basePrice);
	
		//System.out.println ("\n\nCalculate the additional markups");
		testInput.calcMarkUps(testInput.basePrice, numPeople, drugs, eat, tech, etc);
		//System.out.println ("The additional markup is " + testInput.markUps);
		
		//System.out.println ("\n\nCalculate the final cost");
		testInput.calcFinalCost(testInput.basePrice, testInput.markUps);
		
		DecimalFormat twoDec = new DecimalFormat("0.00");
		//System.out.println ("The final cost of the Project is $" + twoDec.format(testInput.finalCost));
	
		System.out.println ("\n");
		//Printing output
		if (drugs == true && eat == false && tech == false && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs");
		} else if (drugs == true && eat == true && tech == false && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs, food");
		} else if (drugs == true && eat == true && tech == true && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs, food, electronics");
		} else if (drugs == true && eat == true && tech == true && etc == true){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs, food, electronics, other");
		} else if (drugs == false && eat == true && tech == false && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, food");
		} else if (drugs == false && eat == true && tech == true && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, food, electronics");
		} else if (drugs == false && eat == true && tech == true && etc == true){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, food, electronics, other");
		} else if (drugs == false && eat == false && tech == true && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs, electronics");
		} else if (drugs == false && eat == false && tech == true && etc == true){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, electronics, other");
		} else if (drugs == true && eat == false && tech == true && etc == true){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs, electronics, other");
		} else if (drugs == true && eat == false && tech == true && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs, electronics");
		} else if (drugs == false && eat == false && tech == false && etc == true){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, other");
		} else if (drugs == true && eat == false && tech == false && etc == true){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, drugs, other");
		} else if (drugs == false && eat == true && tech == false && etc == true){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people, food, other");
		} else if (drugs == false && eat == false && tech == false && etc == false){
			System.out.println("Input: $" + testInput.input +
					", " + numPeople + " people");
		}
		
		System.out.println("Output: $" +twoDec.format(testInput.finalCost));
		
	}
	
}
