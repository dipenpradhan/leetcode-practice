class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = buildMap(nums2);
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
    
    private Map<Integer, Integer> buildMap(int[] arr){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stk = new Stack<Integer>();
        
        int[] res = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            // if(stk.isEmpty() || arr[stk.peek()] > arr[i]){
            //     stk.push(i);
            // }
            while(!stk.isEmpty() && arr[stk.peek()] < arr[i]){
                map.put(arr[stk.pop()], arr[i]);
            }
            
            stk.push(i);
        }
        
        return map;
        
    }
}