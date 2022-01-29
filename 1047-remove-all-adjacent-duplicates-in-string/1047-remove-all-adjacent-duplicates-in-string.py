class Solution:
    def removeDuplicates(self, s: str) -> str:
        st = []
        for i in s: # a b b a c
            if len(st)>0: 
                el = st[-1] # a b a 
                if el == i: # F T 
                    st.pop() 
                    continue
            st.append(i) # a  ab
        return "".join(st)
        