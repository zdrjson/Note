class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        unordered_map<string, int> indices;
        for (int i = 0; i < list1.size(); ++i)
            indices[list1[i]] = i;
        
        vector<string> ans;
        int best_index = INT_MAX;
        string best;
        
        for (int i = 0; i < list2.size(); ++i) {
            if (!indices.count(list2[i])) continue;
            int index = indices[list2[i]] + i;
            if (index < best_index) ans.clear();
            if (index <= best_index) {
                best_index = index;
                ans.push_back(list2[i]);
            }
        }
        
        return ans;
    }
};
