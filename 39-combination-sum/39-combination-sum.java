class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        /* 
            fn combsum(candidates, target)
                    result = [][]
                    currList = []
                    backtrack(candidates, 0, result, currList,target)
                    
        
            fn backtrack(candidates, start, chosen, remaining)
                if start exceeds candidates - STOP
                if remaining = 0 - STOP, add this chosen list to result
                if remaining is less than zero - STOP
                
                
                loop over candidates, starting from "start"
                    add candidate on chosen list
                    // try using same candidate again
                    // update remaining value

                    backtrack(candidates, start, result, chosen, target-chosen)

                    remove candidate from chosen list
                    
        */
        
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> chosen = new ArrayList<Integer>();
        
        backtrack(candidates, 0, result, chosen, target);
        
        return result;
    }
    
    
    private void backtrack(int[] candidates, int start, List<List<Integer>> result, List<Integer> chosen, int remaining){
        
        if(start >= candidates.length || remaining < 0) return;
        else if(remaining == 0) {
            List<Integer> resultItem = new ArrayList<Integer>();
            resultItem.addAll(chosen);
            result.add(resultItem);
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            chosen.add(candidates[i]);
            backtrack(candidates, i, result, chosen, remaining - candidates[i]);
            chosen.remove(chosen.size()-1);
        }
        
    }
}