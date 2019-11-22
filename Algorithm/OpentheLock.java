class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains(start)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int steps = 0;
        q.add(start);
        while(!q.isEmpty()) {
            ++steps;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String node = q.poll();
                for (int a = 0; a < 4; ++a) {
                    for (int j = -1; j <= 1; j+=2) {
                        char[] chars = node.toCharArray();
                        chars[a] = (char)(((chars[a] - '0') + j + 10) % 10 + '0');
                        String next = new String(chars);
                        if (next.equals(target)) {
                            return steps;
                        }
                        if (dead.contains(next) || visited.contains(next)) {
                            continue;
                        }
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }
}