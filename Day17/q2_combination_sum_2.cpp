class Solution {
public:
    void dfs(vector<int>& candidates, int target, int start,
             vector<int>& path, vector<vector<int>>& res) {

        if (target == 0) {
            res.push_back(path);
            return;
        }

        for (int i = start; i < candidates.size(); i++) {

            // skip duplicates at same level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;

            path.push_back(candidates[i]);

            // i + 1 because each number can be used only once
            dfs(candidates, target - candidates[i], i + 1, path, res);

            path.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());

        vector<vector<int>> res;
        vector<int> path;

        dfs(candidates, target, 0, path, res);

        return res;
    }
};
