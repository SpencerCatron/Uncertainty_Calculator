package uncertaintycalc;
import java.util.Scanner;

public class Version3 {
	public static void main ( String  [ ] args)
	{
		//gets input
		Scanner kb = new Scanner(System.in);
		System.out.println("enter an expression to propagate error for\nDenote +- as x");
		String input = kb.nextLine();
		
		//loop until the user wants to stop putting in values
		while(!input.equalsIgnoreCase("quit"))
		{
			//calculates the answer
			System.out.println(calculate.Calculate(input));
			System.out.println("Enter another value to evaluate(quit to quit");
			input = kb.nextLine();
		}
		
		kb.close(); 
	}
	

}
