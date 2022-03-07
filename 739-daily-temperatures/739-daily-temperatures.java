class Solution {
    
    // [73,74,75,71,69,72,76,73]
    // [0,  0, 0, 0, 1, 1, 0, 0]
    
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] res = new int[temps.length];
        for(int i = 0; i < temps.length; i++){
            while(!stk.isEmpty() && temps[i] > temps[stk.peek()]){
                int pop = stk.pop();
                res[pop] = i - pop;
            }
            stk.push(i);
            
        }
        
        return res;
    }
}