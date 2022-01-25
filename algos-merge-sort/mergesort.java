public class Main {
    
    void mergeSort(int[] arr){
        int N = arr.length;
        
        for(int s = 1; s < N; s*=2){
            for(int l = 0; l < N - s; l+=2*s){
                int m = l + s - 1;
                int r = Math.min(l+2*s -1, N-1);
                merge(arr, l,m,r);
            }
            
        }
    }
    
    void merge(int[] arr, int l, int m, int r){
        int i = l, j = m+1, k = 0;
        int[] tmp = new int[r-l+1];
        
        while(i<=m || j <= r){
            if(i>m || j<= r && arr[i]>arr[j]){
                tmp[k++] = arr[j++];
            }else{
                tmp[k++] = arr[i++];
            }
        }
        
        for(int p = 0; p < tmp.length; p++){
            arr[l+p] = tmp[p];
        }
        
    }
    
    
    public static void main(String[] args) {
        
        int[] arr = new int[]{7,3,4,6,9,3,2,3,9,6,8};
        Main m = new Main();
        m.mergeSort(arr);
        m.debug(arr);
    }
    
    void debug(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            sb.append(a);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
