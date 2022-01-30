class Solution {
    public String addStrings(String fst, String sec) {
        
        return addNum(parseNum(fst),parseNum(sec));
    }
    
    private String addNum(List<Integer> fst, List<Integer> sec){
        int f = fst.size()-1, s = sec.size()-1;
        List<Integer> res = new ArrayList<Integer>();
        int c = 0;
        while(f>=0 || s>=0){
            
            if(f>=0 && s>=0){
                int r = (fst.get(f)+sec.get(s)+c)%10;
                res.add(r);
                c = (fst.get(f)+sec.get(s)+c)/10;
            }else if (f>=0){
                res.add((fst.get(f)+c)%10);
                c = (fst.get(f)+c)/10;
            }else{
                res.add((sec.get(s)+c)%10);
                c = (sec.get(s)+c)/10;
            }
            f--;
            s--;

        }
        StringBuilder numStr = new StringBuilder();
        if(c>0)numStr.append(c);
        for(int i = res.size()-1; i>=0; i--){
            numStr.append(res.get(i));
        }
        
        return numStr.toString();
    }
    
    private List<Integer> parseNum(String s){
        List<Integer> num = new ArrayList<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            int n = Character.getNumericValue(s.charAt(i));
            num.add(n);
        }
        
        return num;
        
    }
}

//"3876620623801494171"
//"6529364523802684779"