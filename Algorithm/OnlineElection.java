// Solution: HashTable + Binary Search 
// Compute the leads for each t in times using a hash table.
// binary search the upper bound of t, and return the lead of previous entry.
// Time complexity: Constructor O(n), Query: O(logn)
// Space complexity: O(n)
class TopVotedCandidate {
    private TreeMap<Integer, Integer> leads_; // time -> lead
    public TopVotedCandidate(int[] persons, int[] times) {
        leads_ = new TreeMap<Integer, Integer>();
        int[] votes = new int[persons.length + 1];
        int last_lead = persons[0];
        for (int i = 0; i < persons.length; ++i) {
            if (++votes[persons[i]] >= votes[last_lead])
                last_lead = persons[i];
            leads_.put(times[i], last_lead);
        }
    }
    
    public int q(int t) {
        return leads_.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
