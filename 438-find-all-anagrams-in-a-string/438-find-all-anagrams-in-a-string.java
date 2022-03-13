class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pc = buildCounts(p);
        
        List<Integer> res = new ArrayList<Integer>();
        
        addAna(s, pc, p.length(), res);
        
        return res;
    }
    
    private void addAna(String str, int[] pc, int pl, List<Integer> res){
        
        char[] ca = str.toCharArray();
        int s = 0, e = 0;
        while(e < str.length()){
            // System.out.println(Arrays.toString(pc));
            char ce = ca[e];
            pc[ce-'a']--;
            
            if(e-s+1 > pl){
                char cs = ca[s];
                pc[cs-'a']++;
                s++;
            }
            
            if(valid(pc)){
                res.add(s);
            }
            e++;
        }
    }
    private boolean valid(int[] pc){
        for(int p: pc){
            if(p!=0) return false;
        }
        return true;
    }
    private int[] buildCounts(String p){
        char[] ca = p.toCharArray();
        int[] pc = new int[26];
        for(char c: ca){
            pc[c-'a']++;
        }
        return pc;
    }
}