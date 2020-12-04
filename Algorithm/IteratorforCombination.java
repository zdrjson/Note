// Solution: Bitmask
// Use a bitmask to represent the chars selected.
// start with (2^n - 1), decrease the mask until there are c bit set.
// stop when mask reach to 0.
// mask: 111 => abc
// mask: 110 => ab
// mask: 101 => ac
// mask: 011 => bc
// mask: 000 => "" Done
// Time complexity: O(2^n)
// Space complexity: O(1)
class CombinationIterator {
    private int mask_;
    private int length_;
    private StringBuilder chars_;
    public CombinationIterator(String characters, int combinationLength) {
        chars_ = new StringBuilder(characters).reverse();
        length_ = combinationLength;
        mask_ = (1 << characters.length()) - 1; // 注意外面加括号，否则运算顺序不对，导致答案不对。
    }
    
    public String next() {
        hasNext();
        StringBuilder ans = new StringBuilder();
        for (int i = chars_.length(); i >= 0; --i)
            if (((mask_ >> i) & 1) != 0)
                ans.append(chars_.charAt(i));
        --mask_;
        return ans.toString();
    }
    
    public boolean hasNext() {
        while (mask_ >= 0 && Integer.bitCount(mask_) != length_) --mask_;
        return mask_ > 0;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
