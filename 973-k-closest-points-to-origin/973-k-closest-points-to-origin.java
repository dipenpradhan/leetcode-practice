class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        // formula:
        // sqrt(points[0] - 0)^2 + (points[1] - 0)^2
        // x = points[0], y = points[1]
        //  sqrt((x)^2 + (y)^2)
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((p1, p2)->{
                int x1 = p1[0], y1 = p1[1];
                int x2 = p2[0], y2 = p2[1];
                double diff = Math.sqrt(x1*x1 + y1*y1) - Math.sqrt(x2*x2 + y2*y2);
                return diff>0 ? 1: diff<0 ? -1:0;
            });
        
        for(int[] point : points){ 
            heap.add(point);
        }
        
        for(int i = 0; i < k; i++){
            int[] p = heap.poll();
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        return res;
    }
    
}