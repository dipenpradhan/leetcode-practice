class Solution {
    public int maximumSwap(int num) {
        // 2736 -> 7236
        // 9973 -> 9973
        // 111979 -> 911971
        
        List<Integer> digitsList = splitNumToDigitsList(num);
        
        int[] digits = new int[digitsList.size()];
        int[] largest = new int[digitsList.size()];
        int[] smallest = new int[digitsList.size()];
        
        for(int i = digitsList.size() - 1; i >= 0; i--){
            digits[digitsList.size()-1-i] = digitsList.get(i);
        }
        
        for(int l = 0, r = digits.length - 1; l < digits.length; l++, r--){
            int left = digits[l];
            int right = digits[r];
            int prevSmallest = l==0 ? left:smallest[l-1];
            int prevLargest = r==digits.length-1 ? right:largest[r+1];
            
            smallest[l] = left < prevSmallest ? left : prevSmallest;
            largest[r] = right > prevLargest ? right : prevLargest;
            
        }
        
        
        int numToSwap = -1;
        int posToSwap = -1;
        
        for(int i = 0; i < digits.length; i++){
            if(smallest[i] < largest[i]){
                numToSwap = largest[i];
                posToSwap = i;
                break;
            }
            
        }
        
        if(numToSwap >= 0 && posToSwap >= 0){
            
            for(int j = digits.length-1; j>=0; j--){
                
                if(largest[j] == numToSwap){
                    int swap = digits[j];
                    digits[j] = digits[posToSwap];
                    digits[posToSwap] = swap;
                    break;
                }

            }

        }
        
        
        return combineDigitsArrToNum(digits);
    }
    
    
    
    
    public List<Integer> splitNumToDigitsList(int num){
        List<Integer> digitsList = new ArrayList<Integer>();   
        
        int currNum = num;
        
        while(currNum != 0){
            int digit = currNum % 10;
            currNum = currNum / 10;
            digitsList.add(digit);
        }
     return digitsList;   
    }
    
    public int combineDigitsArrToNum(int[] digitsArr){
        int factor = 1;
        int resultNum = 0;
        for(int i = digitsArr.length - 1; i >= 0; i--){
            int digit = digitsArr[i];
            resultNum += digit*factor;
            factor *= 10;
        }
        return resultNum;
    }
    
}