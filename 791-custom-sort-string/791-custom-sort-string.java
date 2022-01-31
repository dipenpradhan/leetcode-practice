class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> sc = new HashMap<Character, Integer>();
        
        for(char c: s.toCharArray()){
            sc.put(c, sc.getOrDefault(c, 0)+1);
        }
        StringBuilder res = new StringBuilder();
        
        for(char c: order.toCharArray()){
            int i = 0;
            while(i < sc.getOrDefault(c, 0)){
                res.append(c);
                i++;
            }
            if(sc.containsKey(c))sc.remove(c);
        }
        for(char c: sc.keySet()){
            int i = 0;
            while(i < sc.getOrDefault(c, 0)){
                res.append(c);
                i++;
            }
        }
        return res.toString();
    }
}