package uncertaintycalc;

public class uncertainnum {
	
	private double num;
	private double unum;
	
	//when given a string like "55x1.5" will save the first part as value and the second part as the values uncertainty to the object class
	public void getnum(String numbers)
	{
		int count =0;
		String nums="null", unums="null";
		while( count<numbers.length())
		{
			if(numbers.charAt(count) == 'x' || numbers.charAt(count) == 'X')
			{
				nums= numbers.substring(0, count);
				unums = numbers.substring((count+1), numbers.length());
			}
			count++;
		}
		num = Double.parseDouble(nums);
		unum = Double.parseDouble(unums);
		
	}
	//returns actual number
	public double returnnum()
	{
		return num;
	}
	//returns uncertainty
	public double returnunum()
	{
		return unum; 
	}

}
