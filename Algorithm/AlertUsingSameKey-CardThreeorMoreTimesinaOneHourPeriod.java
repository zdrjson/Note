// Solution: Hashtable + sorting
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> t = new HashMap<>();
        for (int i = 0; i < keyTime.length; ++i) {
            // 注释的方法只是String->int方法不同。
            // final int h = Integer.parseInt(keyTime[i].substring(0, 2));
            // final int m = Integer.parseInt(keyTime[i].substring(3));
            final int h = Integer.valueOf(keyTime[i].substring(0, 2)).intValue();
            final int m = Integer.valueOf(keyTime[i].substring(3)).intValue();
            // 后面.add方法在数组中加入值后，在字典中key对应的这个数组就有这个值了，不用再把数组手动put进字典里面更新了。
            t.computeIfAbsent(keyName[i], k -> new ArrayList<Integer>()).add(h  * 60 + m); 
        }
        List<String> ans = new ArrayList<String>();
        for (Map.Entry<String, List<Integer>> kv : t.entrySet()) {
            String name = kv.getKey();
            List<Integer> times = kv.getValue();
            Collections.sort(times);
            for (int i = 2; i < times.size(); ++i) 
                if (times.get(i) - times.get(i - 2) <= 60) {
                    ans.add(name);
                    break;
                }
        }
        Collections.sort(ans);
        return ans;
    }
}
