package uncertaintycalc;

public class calculate {
	
	//the main method for this program. returns the answer to a 
	//complex expression with parenthesis. or any type of expression with error in it
	public static String Calculate(String input)
	{
		String left = "null";
		String calc = "null";
		String right = "null";

			//go through getting rid of all parenthesis and simplifying
		while(calculate.parenthesisboolean(input) ==true)
		{
			
			//split into three parts calc the middle and add
			left  = calculate.getleftofparenthesisstring(input);
			calc  = calculate.getparenthesisstring(input);
			right  = calculate.getrightofparenthesisstring(input);				
			calc = calculate.simplifyparenthesis(calc);
			
			input = calculate.addstrings(left, calc, right);
		}
		
		//the resulting string is also a mathematical expression(without parenthesis) that needs to 
		//be simplified
		input = calculate.simplify(input);
		
		//replaced the x with the +- unicode symbol
		input = calculate.getoutputformat(input);
		
		
	return input; 
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	//parenthesis methods
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//given an expression with parenthesis it will simplify the expression and remove the parenthesis
	public static String simplifyparenthesis(String input)
	{
		//remove parenthesis
		input = input.replace("(", "");
		input = input.replace(")", "");
		
		input = calculate.simplify(input);
		
		return input;
	}
	
	//returns the parenthesis that should be operated first
	public static String getparenthesisstring(String input)
	{
		int open=0, close=0;
		String output = "null";
		
		open = calculate.findopenparenthesis(input);
		close = calculate.findcloseparenthesis(input, open);
		
		output = input.substring(open, close);
		return output;
	}
	//gets substring that is left of the substring that gets calculated
	public static String getleftofparenthesisstring(String input)
	{
		int open=0;
		String output = "null";
		
		open = calculate.findopenparenthesis(input);
		
		output = input.substring(0, open);
		return output;
	}
	//returns the substring right of the substring that gets calculated
	public static String getrightofparenthesisstring(String input)
	{
		int close=0;
		int open = 0;
		
		String output = "null";
		
		open = calculate.findopenparenthesis(input);
		close = calculate.findcloseparenthesis(input, open);
		
		output = input.substring(close,input.length());
		return output;
	}
	
	//finds the index of the rightmost openparenthesis
	public static int findopenparenthesis(String input)
	{
		//returns index of the last open parenthesis (
		int openparenthesisindex = 0;
		int count = 0;
		
		while(count<input.length())
		{
			if(input.charAt(count)=='(')
			{
				openparenthesisindex=count;
			}
			count++;
		}
		
		return openparenthesisindex; 
	}
	
	//find index of first close parenthesis right of the rightmost open parenthesis
	public static int findcloseparenthesis(String input, int startingch)
	{
		int count = startingch;
		
		while(count<input.charAt(count) && input.charAt(count)!=')')
		{
			count++;
		}
		count++;
		return count;
	}
	
	//true if string has parenthesis in it
	public static boolean parenthesisboolean(String input)
	{
		int count  = 0 ;
		boolean output = false; 
		
		while(count< input.length())
		{
			if(input.charAt(count) == '(' || input.charAt(count)==')')
			{
				output = true;
			}
			count++;
		}
		return output; 
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//determine which method to use with two values and return answer as string
	public static String calc(String input)
	{
		String output = "null";
		int count = 0;
		char ch = 'n';
		String a= "null", b="null";
		
		while(count<input.length())
		{
			if(calculate.mathfunct(input.charAt(count)) == true)
			{
				ch = input.charAt(count);
				a=input.substring(0, count);
				b= input.substring((count+1), input.length());	
			}
			count++;	
		}
		
		
		if(ch=='+')
		{
			output = calculate.add(a, b);
		}
		if(ch=='-')
		{
			output = calculate.sub(a, b);
		}
		if(ch=='*')
		{
			output = calculate.mult(a, b);
		}
		if(ch=='/')
		{
			output = calculate.div(a, b);
		}
		return output;
	}
	
	public static String simplify(String input)
	{
		String right  = "null";
		String left = "null";
		String calc = "null";
		int ch = 0;
		
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
		
		
		return input; 
	}
	
	
	//adds two strings and outputs a string that is answer
	public static String add(String a, String b)
	{
		uncertainnum x = new uncertainnum();
		uncertainnum y = new uncertainnum();
		x.getnum(a);
		y.getnum(b);
		
		double num1 = x.returnnum();
		double unum1 = x.returnunum();
		double num2 = y.returnnum();
		double unum2 = y.returnunum();
		
		double val = num1 + num2;
		double uval = unum1 + unum2;
		
		return(val + "x" + uval);
	}
	
	//subtracts two strings and outputs the answer
	public static String sub(String a, String b)
	{
		uncertainnum x = new uncertainnum();
		uncertainnum y = new uncertainnum();
		x.getnum(a);
		y.getnum(b);
		
		double num1 = x.returnnum();
		double unum1 = x.returnunum();
		double num2 = y.returnnum();
		double unum2 = y.returnunum();
		
		double val = num1 - num2;
		double uval = unum1 + unum2;
		
		return(val + "x" + uval);
	}
	
	//multiplies two strings and outputs answer
	public static String mult(String a, String b)
	{
		uncertainnum x = new uncertainnum();
		uncertainnum y = new uncertainnum();
		x.getnum(a);
		y.getnum(b);
		
		double num1 = x.returnnum();
		double unum1 = x.returnunum();
		double num2 = y.returnnum();
		double unum2 = y.returnunum();
		
		double val = num1 * num2;
		double uval = val*( (unum1/num1) + (unum2/num2) );
		
		return(val + "x" + uval);
	}
	
	//divides two strings
	public static String div(String a, String b)
	{
		uncertainnum x = new uncertainnum();
		uncertainnum y = new uncertainnum();
		x.getnum(a);
		y.getnum(b);
		
		double num1 = x.returnnum();
		double unum1 = x.returnunum();
		double num2 = y.returnnum();
		double unum2 = y.returnunum();
		
		double val = num1 / num2;
		double uval = val*( (unum1/num1) + (unum2/num2) );
		
		return(val + "x" + uval);
	}
	//if character is a math operator returns true
	public static boolean mathfunct(char ch)
	{
		if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
		{
			return true;
		}
		else
			return false;
		
	}
	//if a string has any math function thing in it, then returns false. else true
	public static boolean simple(String input)
	{
		int count = 0;
		boolean simple =true;
		while(count<input.length())
		{
			if (calculate.mathfunct(input.charAt(count)) == true)
			{
				simple = false;
			}
			count++;
		}
		return simple; 
	}
	public static int sweepforfunction(String str)
	{
		//given a string will find the math operator that the string must be broken up upon
		//ex 25x5+2x5*24x1 it would be the *
		
		//first loop for + - and then * /
		int count = 0;
		int chindex = 0;
		String haltprocess="null";
		
		while(count<str.length() && haltprocess.equals("null"))
		{
			if(str.charAt(count) == '+' || str.charAt(count)=='-')
			{
				chindex=count; 
				haltprocess="quit";
			}
			count++;
		}

		
		count=0;
		haltprocess="null";
		while(count<str.length() && haltprocess.equals("null"))
		{
			if(str.charAt(count) == '*' || str.charAt(count)=='/')
			{
				chindex=count; 
				haltprocess="quit";
			}
			count++;
		}
		
		return chindex;
	}
	public static String getcalcstring(String str, int ch)
	{
		//Str is full string
		//int ch is index of the math operator being assessed
		//return a string that will calculated. 
		int countleft=0;
		int countright=(ch+1);
		int leftboundindex=0;
		int rightboundindex= str.length();
		String output = "null";
		
		//leftbound
		while (countleft<ch)//from beginning to right before the math operator
		{
			if(calculate.mathfunct(str.charAt(countleft))==true)
			{
				leftboundindex=countleft+1;//the right operator can't be in string
				//System.out.println(str.charAt(count));
			}
			countleft++;
		}
		
		
		countright = ch+1;
		//rightbound;
		while(countright<str.length() && (calculate.mathfunct(str.charAt(countright)) ==false))
		{
			countright++;
		}
		rightboundindex=(countright);
		
		output = str.substring(leftboundindex, rightboundindex);
		output = calculate.calc(output);
		return output;
	}
	public static String getleftstring(String str, int ch)
	{
		String output="";
		int count=0;
		int rightboundindex = 0;
		
		//from 0 to right before ch look for the last math oeprator
		//string will be from 0 to last operator
		//if no operator is found then return nothing
		while(count<ch )
		{
			if(calculate.mathfunct(str.charAt(count)) == true)
				rightboundindex=count;
			count++; 
		}
		if(rightboundindex!=0)
		{
			output=str.substring(0, (rightboundindex+1));
		}
		
		return output;
	}
	
	//after getting the math function breaks off the left string
	public static String getrightstring(String str, int ch)
	{
		String output="";
		int count=ch+1;
		int leftboundindex=ch;
		
		while(count<str.length() && (calculate.mathfunct(str.charAt(count)) ==false))
		{
			count++;
		}
		leftboundindex=(count);
		if(count!=str.length())
			output = str.substring(leftboundindex, str.length());
		return output;	
	}
	
	//adds the left right and calculated string so it can be simplified again
	public static String addstrings(String a, String b, String c)
	{
		String output = "null";
		String d = a.concat(b);
		output=d.concat(c);
		return output;
	}
	
	//replaces x with the plus minus symbol
	public static String getoutputformat(String str)
	{
		String output = null; 
		uncertainnum a = new uncertainnum();
		a.getnum(str);
		output = (a.returnnum() + "\u00B1" + a.returnunum());
		return output; 
		
	}
	
}
