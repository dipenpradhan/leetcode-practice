class Solution {
    
/*
    Create map of digits to characters "numpad". key is digit, value is list of chars
    
    
    fn letterCombos(String number)
        if number is empty or null or if it contains any invalid chars (not 2-9) return null
        
        create result = list of strings
        
        backtrack(result, "", numpad, number, 0, 0)
        
        return result
        
    fn backtrack(result, currStr, numpad, number, start, currCharIx)
        
        if currStr exceeds number length: add currStr to result and STOP
        if start exceeds length of number string: STOP recursion
    
        loop over every digit from "start" onwards    // 2
            loop over every numpad char  // 2 - a b c
                append numpad char to currStr    // "a"
                backtrack(result, currStr, numpad, number, start+1, --) // 3
                remove numpad char from currStr
    


    // Example: "23"
                  2
            a     b     c
            3     3     3
         d e f   d e f   d e f   
         
  ad ae af      bd be bf   cd ce cf 
            
             

*/
  String[] numpad = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
  
  public List<String> letterCombinations(String digits) {
    
      List<String> res = new ArrayList<String>();
      StringBuilder curr = new StringBuilder();
      
      for(int i = 0; i < digits.length(); i++){
          backtrack(digits, i, curr, res);
      }
      return res;
    
  }
  
  
  private void backtrack(String digits, int pos, StringBuilder curr, List<String> res){
        
        if(pos == digits.length()){
            if(curr.length() == digits.length()) res.add(curr.toString());
            return;
        }
      
        int d = Character.getNumericValue(digits.charAt(pos));
        
        for(char c: numpad[d].toCharArray()){
            curr.append(c);
            backtrack(digits, pos+1, curr, res);
            curr.setLength(curr.length()-1);
        }
      
  }
    
  
  public void printResult(List<String> results){
    System.out.println("Result");
    System.out.println(results);
    for(String r: results){
        System.out.print(r);
    }
    
    
  }
}