class Solution {
    private static final int DIR_DOWN = 1, DIR_UP = -1, DIR_NONE = 0;
    
    public String convert(String s, int numRows) {
        
        // Create a stringbuilder for the final result
        // and an array of stringbuilders, one for each row
        StringBuilder result = new StringBuilder();
        StringBuilder[] rowStrings = new StringBuilder[numRows];
        
        // Initialize stringbuilder for each row
        for(int i = 0; i < rowStrings.length; i ++){
            rowStrings[i] = new StringBuilder();
        }
        
        // Initialize direction to 1 (going down in zigzag)
        int dir = DIR_DOWN;
        // Initialize currRow counter
        // We will increment and decrement this counter to identify the row number
        // and add item into stringbuilder of that row accordingly
        int currRow = 0;
        
        for(int i = 0; i < s.length(); i++){
            // If we have only 1 row, DO NOT change direction (set dir=DIR_NONE)
            if(numRows == 1) {
                dir = DIR_NONE;
            }else if(currRow == 0){
                // If we hit top row (currRow=0), set direction to DIR_DOWN (increment by 1 till we hit end)
                dir = DIR_DOWN;
            }else if(currRow == numRows - 1){
                // If we hit bottom row (currRow = numRows-1), set direction to DIR_UP (decrement by 1 till we hit start)
                dir = DIR_UP;
            }
            // Append current character to appropriate row's stringbuilder
            rowStrings[currRow].append(s.charAt(i));
            
            // increment or decrement currRow based on +1/-1/0 value of dir
            currRow += dir;
        }
        
        // Iterate through all rows and append strings to result
        for(StringBuilder rowStr: rowStrings){
            result.append(rowStr.toString());
        }
       
        return result.toString();
    }
}