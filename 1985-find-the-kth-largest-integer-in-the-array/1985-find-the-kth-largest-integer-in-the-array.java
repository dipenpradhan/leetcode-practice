class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String> pq = new PriorityQueue<String>((a,b)->compare(a,b));
        for(String n: nums){
            pq.offer(n);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }

    
    
    
//     public String kthLargestNumber(String[] nums, int k) {
//         return qSel(nums, nums.length - k, 0, nums.length - 1);
//     }
    
//     private String qSel(String[] nums, int k, int l, int r){
//         int sw = l;
//         for(int i = l; i < r; i++){
//             if(compare(nums[i], nums[r]) < 1){
//                 swap(nums, i, sw);
//                 sw++;
//             }
//         }
//         swap(nums, sw, r);
//         if(sw == k){
//             return nums[k];
//         }else if(sw < k){
//             return qSel(nums, k, sw+1, r);
//         }else{
//             return qSel(nums, k, l, sw-1);
//         }
        
//     }
               
//     private void swap(String[] arr, int x, int y){
//         String tmp = arr[x];
//         arr[x] = arr[y];
//         arr[y] = tmp;
//     }
    private int compare(String a, String b){
        if(a.length()!=b.length()) return a.length()-b.length();
        
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) > b.charAt(i)) return 1;
            else if(a.charAt(i) < b.charAt(i)) return -1;
        }
        return 0;
    }
    
}