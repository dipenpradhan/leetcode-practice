class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        // word -> count
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String w : words){
            map.put(w, map.getOrDefault(w,0) + 1);
        }
        // count -> word
        PriorityQueue<Pair<Integer,String>> heap = new PriorityQueue<Pair<Integer,String>>((w1, w2) ->
                                                                                           w1.getKey() == w2.getKey() ?
                                                                                           w1.getValue().compareTo(w2.getValue()):
                                                                                           w2.getKey() - w1.getKey());
        
        for(String w : map.keySet()){
            heap.add(new Pair<Integer, String>(map.getOrDefault(w,0),w));
        }
        
        List<String> res = new ArrayList<>();
        int count = 0;
        while(count < k && heap.size() > 0){
            res.add(heap.poll().getValue());
            count++;
        }
        return res;
    }
}