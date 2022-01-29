class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        // formula:
        // sqrt(points[0] - 0)^2 + (points[1] - 0)^2
        // x = points[0], y = points[1]
        //  sqrt((x)^2 + (y)^2)
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
            (p1, p2)->{
                int x1 = p1[0], y1 = p1[1];
                int x2 = p2[0], y2 = p2[1];
                
                double diff = Math.sqrt(x1*x1 + y1*y1) - Math.sqrt(x2*x2 + y2*y2);
                if(diff == 0){
                    return 0;
                }else if(diff > 0){
                    return 1;
                }else{
                    return  -1;    
                }
                
            }
            );
        
        for(int[] point : points){ 
            heap.add(point);
        }
        // System.out.println(minHeap);
        for(int i = 0; i < k; i++){
            int[] p = heap.poll();
            // System.out.println("polled= "+p);
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        return res;
    }
    
}



// backup

// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         int[][] result = new int[k][2];
//         // formula:
//         // sqrt(points[0] - 0)^2 + (points[1] - 0)^2
//         // x = points[0], y = points[1]
//         //  sqrt((x)^2 + (y)^2)
        
//         PriorityQueue<PointDistance> minHeap = new PriorityQueue<PointDistance>(
//             (p1, p2)->{
//                 double distanceDifference = p1.getDistanceFromOrigin() - p2.getDistanceFromOrigin();
//                 if(distanceDifference == 0){
//                     return 0;
//                 }else if(distanceDifference > 0){
//                     return 1;
//                 }else{
//                     return  -1;    
//                 }
                
//             }
//             );
        
//         for(int[] point : points){
            
//             int x = point[0];
//             int y = point[1];

//             PointDistance p = new PointDistance(x, y);
//             minHeap.add(p);
//         }
//         // System.out.println(minHeap);
//         for(int i = 0; i < k; i++){
//             PointDistance p = minHeap.poll();
//             // System.out.println("polled= "+p);
//             result[i][0] = p.getX();
//             result[i][1] = p.getY();
//         }
//         return result;
//     }
    
//     private static class PointDistance{
//         private int x, y;
//         private double distanceFromOrigin = -1;
        
//         PointDistance(int x, int y){
//             this.x = x;
//             this.y = y;
//         }
        
//         public int getX(){
//             return x;
//         }
        
//         public int getY(){
//             return y;
//         }
        
//         public double getDistanceFromOrigin(){
//             if(distanceFromOrigin < 0){
//                 distanceFromOrigin = Math.sqrt(x*x + y*y);
//             }
//             return distanceFromOrigin;
//         }
//         @Override
//         public String toString(){
//             return "x= "+x+" y="+y+" distanceFromOrigin="+distanceFromOrigin;
//         }
//     }
// }