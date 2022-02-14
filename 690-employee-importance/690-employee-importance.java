/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int tot = 0;
    public int getImportance(List<Employee> emp, int id) {
        Map<Integer, Employee> map =  new HashMap<Integer, Employee>();
        buildMap(emp, map);
        Set<Integer> seen = new HashSet<Integer>();
        dfs(map, id, seen);
        
        return tot;
    }
    

private void dfs(Map<Integer, Employee> map, int id, Set<Integer> seen){
    
    if(seen.contains(id)) return;
    seen.add(id);
    Employee e = map.get(id);
    tot += e.importance;
    for(Integer s: e.subordinates){
        dfs(map, s, seen);
    }
}


/*
    employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]]
    e1|5 - [e2, e3]
    e2|3 - [e3]
    e3|3 - []
    
//map

*/

private void buildMap(List<Employee> emp, Map<Integer, Employee> map){
    
    for(Employee e: emp){
        if(!map.containsKey(e.id)){
            map.put(e.id, e);
        }
    }
}

}