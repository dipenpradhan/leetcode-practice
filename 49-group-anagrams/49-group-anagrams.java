class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strs){
            
            int[] a = new int[26];
            for(char c : s.toCharArray()){
                a[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < a.length; i++){
                char c = (char)('a'+i);
                if(a[i] > 0){
                    sb.append(c);
                    sb.append(':');
                    sb.append(a[i]);
                    sb.append('|');
                }
            }
            if(sb.length() > 0){
                sb.setLength(sb.length()-1);    
            }
            String cstr = sb.toString();
            if(!map.containsKey(cstr)){
                map.put(cstr, new ArrayList<String>());
            }
            map.get(cstr).add(s);
        }
        // System.out.println(map);
        return new ArrayList<List<String>>(map.values());
    }
}