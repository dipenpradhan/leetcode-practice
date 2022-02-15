class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> res = new ArrayList<String>();
        
        for(int i = 0; i < cpdomains.length; i++){
            String[] cp = cpdomains[i].split(" ");
            int c = Integer.parseInt(cp[0]);
            String[] dom = cp[1].split("\\.");
            
            for(int j = 0; j < dom.length; j++){
                String subd = findSubdomain(dom, j);
                map.put(subd, map.getOrDefault(subd,0)+c);
            }
        }
        
        for(Map.Entry<String, Integer> e: map.entrySet()){
            StringBuilder r = new StringBuilder();
            r.append(e.getValue());
            r.append(" ");
            r.append(e.getKey());
            res.add(r.toString());
        }
        return res;
    }
    private String findSubdomain(String[] dom, int start){
        StringBuilder subd = new StringBuilder();
        for(int i = start; i < dom.length; i++){
            if(i!=start){
                subd.append('.');
            }
            subd.append(dom[i]);
        }
        return subd.toString();
    }
}