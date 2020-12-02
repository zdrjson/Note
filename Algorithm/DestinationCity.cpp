// Solution: Count in / out degree for each node
// Nore: this is a more general solution to this type of problems
// Time complexity: O(n)
// Space complexity: O(n)
// Destination City: in_degree == 1 and out_degree == 0
class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        unordered_map<string, int> in, out;
        for (const auto& path : paths) {
            ++out[path[0]];
            ++in[path[1]];
        }
        
        for (const auto& [city, degree] : in)
            if (degree == 1 && out[city] == 0) return city;
    
        return "";
    }
};
