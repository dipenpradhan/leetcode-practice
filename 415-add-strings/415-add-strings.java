class Solution {
    public String addStrings(String fst, String sec) {
        
        return addNum(fst,sec);
    }
    
    private String addNum(String fst, String sec){
        int f = fst.length()-1, s = sec.length()-1;
        StringBuilder numStr = new StringBuilder();

        int c = 0;
        while(f>=0 || s>=0){
            int fn = f>=0?Character.getNumericValue(fst.charAt(f)):-1;
            int sn = s>=0?Character.getNumericValue(sec.charAt(s)):-1;
            
            if(f>=0 && s>=0){
                int r = (fn+sn+c)%10;
                numStr.append(r);
                c = (fn+sn+c)/10;
            }else if (f>=0){
                numStr.append((fn+c)%10);
                c = (fn+c)/10;
            }else{
                numStr.append((sn+c)%10);
                c = (sn+c)/10;
            }
            f--;
            s--;

        }
        if(c>0)numStr.append(c);
        
        return numStr.reverse().toString();
    }
  
}

//"3876620623801494171"
//"6529364523802684779"