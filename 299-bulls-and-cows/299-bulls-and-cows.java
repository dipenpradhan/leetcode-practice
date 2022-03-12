class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> map = buildMap(secret);
        StringBuilder res = new StringBuilder();
        char[] gArr = guess.toCharArray();
        int bulls = 0, cows = 0;
        Map<Character, Integer> cowMap = new HashMap<Character, Integer>();
        Map<Character, Integer> bullMap = new HashMap<Character, Integer>();
        
        for(int i = 0; i < gArr.length; i++){
            char c = gArr[i];
            if(map.containsKey(c)){
                if(map.get(c).contains(i)){
                    bullMap.put(c, bullMap.getOrDefault(c, 0)+1);
                }else{
                    cowMap.put(c, cowMap.getOrDefault(c, 0)+1);
                }
            }
        }
        
        
        for(Map.Entry<Character, Integer> b : bullMap.entrySet()){
            bulls += b.getValue();
        }
        res.append(bulls);
        res.append("A");

        for(Map.Entry<Character, Integer> c : cowMap.entrySet()){
            
            int minCow = map.get(c.getKey()).size() - bullMap.getOrDefault(c.getKey(),0);
            
            cows += Math.min(minCow, c.getValue());
        }
        res.append(cows);
        res.append("B");
        
        return res.toString();
    }
    
    private Map<Character, Set<Integer>> buildMap(String secret){
        Map<Character, Set<Integer>> map = new HashMap<Character, Set<Integer>>();
        char[] cArr = secret.toCharArray();
        for(int i = 0; i < secret.length(); i++){
            char s = cArr[i];
            Set<Integer> set = map.getOrDefault(s, new HashSet<Integer>());
            set.add(i);
            map.put(s, set);
        }
        
        return map;
    }
}