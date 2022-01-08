class Solution {
    public String convert(String s, int numRows) {
        
        StringBuilder sb = new StringBuilder();
        
        StringBuilder[] rowStrings = new StringBuilder[numRows];
        
        for(int i = 0; i < rowStrings.length; i ++){
            rowStrings[i] = new StringBuilder();
        }
            
        int dir = 1;
        int currRow = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(numRows == 1) dir = 0;
            else if(currRow == 0){
                dir = 1;
            }else if(currRow == numRows - 1){
                dir = -1;
            }
            
            rowStrings[currRow].append(s.charAt(i));
            
            currRow += dir;
        }
        
        for(StringBuilder rowStr: rowStrings){
            sb.append(rowStr.toString());
        }
       
        return sb.toString();
    }
}