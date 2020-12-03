class CombinationIterator {
public:
    CombinationIterator(string characters, int combinationLength): 
      chars_(rbegin(characters), rend(characters)),
      length_(combinationLength),
      mask_((1 << characters.size()) - 1) {}
    
    string next() {
        hasNext();
        string ans;
        for (int i = chars_.size() - 1; i >= 0; --i)
            if ((mask_ >> i) & 1)
                ans.push_back(chars_[i]);
        --mask_;
        return ans;
    }
    
    bool hasNext() {
        while (mask_ >= 0 && __builtin_popcount(mask_) != length_) --mask_;
        return mask_ > 0;
    }
private:
    int mask_ = 0;
    const int length_;
    const string chars_;
};

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator* obj = new CombinationIterator(characters, combinationLength);
 * string param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
