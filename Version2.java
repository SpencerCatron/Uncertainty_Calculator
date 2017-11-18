package uncertaintycalc;
import java.util.Scanner;
public class Version2 {
	public static void main ( String [ ] args)
	{
		//variables in program
		Scanner kb = new Scanner(System.in);
		String input = "null";
		String right = "null";
		String calc = "null";
		String left = "null";
		int ch = 0;
		
		//gets user input
		System.out.println("input expression. denote +- as x. don't use parenthesis\nEx. \"5x1+25x5*2x.02\"");
		input = kb.nextLine();
		
		//loop until the user types quit
		while(!input.equalsIgnoreCase("quit"))
		{
			//while the string has a math operator symbol in it. the loop will run
			while(calculate.simple(input)==false)
			{
				//finds the index of the correct math symbol that needs to be assessed first
				ch = calculate.sweepforfunction(input);
				//from the index of math function symbol it will split the large string 
				//into three strings. it will calculate the middle string that the math symbol is
				//doing. and then add all of these together. 
				left = calculate.getleftstring(input, ch);
				calc = calculate.getcalcstring(input, ch);
				right = calculate.getrightstring(input, ch);
				
				input = calculate.addstrings(left, calc, right);
			}
			//prints answer in a format that has the plus minus symbol
			System.out.println("answer: " + calculate.getoutputformat(input));
			
			System.out.println("enter expressions(quit to quit)");
			input=kb.nextLine();
		}
			kb.close();
	}
}
