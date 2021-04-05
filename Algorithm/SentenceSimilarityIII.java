// Solution: Dequeue / Common Prefix + Suffix
// Break sequences to words, store them in two deques. Pop the common prefix and suffix. At least one of the deque should be empty.
// Time complexity: O(m+n)
// Space complexity: O(m+n)
class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> w1 = getWords(s1), w2 = getWords(s2);
        while (w1.size() != 0 && w2.size() != 0 && w1.peekFirst().equals(w2.peekFirst())) {
            w1.pollFirst();
            w2.pollFirst();
            // Java中 不能写成w1.pollFirst(), w2.pollFirst(); 不能编译通过。如果写成w1.pollFirst(); w2.pollFirt(); 可以运行，但是while循环外面不加括号，答案是错误的。
        }
        while (w1.size() != 0 && w2.size() != 0 && w1.peekLast().equals(w2.peekLast())) {
            w1.pollLast();
            w2.pollLast();
        }
        return w1.isEmpty() || w2.isEmpty();       
    }
    private Deque<String> getWords(String s) {
        Deque<String> words = new LinkedList<>();
        String[] sp = s.split(" ");
        for (final String str : sp)
            words.offerLast(str);
        return words;
    }
}
