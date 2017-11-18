package uncertaintycalc;
import java.util.Scanner;

public class Version3 {
	public static void main ( String  [ ] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("enter an expression to propagate error for");
		String input = kb.nextLine();
		
		while(!input.equalsIgnoreCase("quit"))
		{
			System.out.println(calculate.Calculate(input));
			System.out.println("Enter another value to evaluate(quit to quit");
			input = kb.nextLine();
		}
	}
	

}
