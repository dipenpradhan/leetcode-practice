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
        List<String> result = new ArrayList<String>();

       if (digits == null || digits.length() == 0)
         return result;
       
      for(char c: digits.toCharArray()){
        if(c < '2' || c > '9'){
          return result;
        }  
      }
    
      backtrack(result, new StringBuilder(), numpad, digits, 0);
        
      return result;
    
  }
  
  
  private void backtrack(
    List<String> result, StringBuilder currStr,
    String[] numpad, String digits, int start){
    
    if(currStr.length() >= digits.length()){
      
      result.add(currStr.toString());
      return;
    }else if (start >= digits.length()){
      return;
    } 
    
    for(int i = start; i < digits.length(); i++){
      
      int digit = Character.getNumericValue(digits.charAt(i));
      for(char c : numpad[digit].toCharArray()){
        
        currStr.append(c);
        backtrack(result, currStr, numpad, digits, i+1);
        currStr.setLength(currStr.length()-1);
          
      }
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