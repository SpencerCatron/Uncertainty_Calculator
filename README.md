# uncertainty_calculator

How this program works:

  1. Driver program takes string input from user
  2. the program runs through the string to find the math operator symbol.
  3. the initial string is split into three substrings bases on the index of the math oeprator symbol
        The middle string, string left of middle string, and string right of middle string
  4. the the middle string(the string with the correct math oeprator in it) is calculated.
  5. the calculated version of the middle string is then concatted with the two other substrings and saved as the initial            string.
  6. this is repeated until the program cannot find any more math operator symbols in the string
  
  
  
  Goals: be able to calculate strings that contain parenthesis. Create a GUI

