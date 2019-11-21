/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    //  DFS
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> es = new HashMap<Integer, Employee>();
        for (Employee e: employees) {
            es.put(e.id, e);
        }
        return dfs(id, es);
    }

    private int dfs(int id, Map<Integer, Employee> es) {
        Employee e = es.get(id);
        int sum = e.importance;
        for (int rid : e.subordinates) {
            sum += dfs(rid, es);
        }
        return sum;
    }

    // BFS
//     public int getImportance(List<Employee> employees, int id) {
//         Map<Integer, Employee> es = new HashMap<Integer, Employee>();
//         for (Employee e : employees) {
//             es.put(e.id, e);
//         }

//         Queue<Integer> q = new LinkedList<>();
//         q.offer(id);
//         int sum = 0;
//         while(!q.isEmpty()) {
//             Integer eid = q.peek();
//             q.remove();
//             Employee e = es.get(eid);
//             sum += e.importance;
//             for (int rid : e.subordinates) {
//                 q.offer(rid);
//             }
//         }
//         return sum;
//     }

}