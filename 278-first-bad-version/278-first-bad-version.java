/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        return binarySearch(n);
        
    }
    
    private int binarySearch(int n){
        
        int left = 0, right = n, mid;
        
        while(left <= right){
            
            mid = left + (right - left) / 2;
            
            // check if mid is bad version
            // if it is a bad version, we will check if the previous version was also bad
            if(isBadVersion(mid)){
                
                // if previous version was not bad, and we are not looking at the first version then mid is the first bad version
                if(mid != left && !isBadVersion(mid-1)){
                    return mid;
                }else if(mid == left){
                    // if we are looking at the first version then first is the first bad version
                    return left;
                }else{
                    // if we find that previous version was also bad then we search to the left of mid
                    // because first bad version will be somewhere before the current mid we are looking at
                    right = mid - 1;
                }
                
            }else{
                // if we find a version that is not bad at mid, it implies the first bad version has not yet happened
                // so we continue our search to the right of the mid
                left = mid + 1;
            }
            
            
        }
        return -1;
    }
    
}