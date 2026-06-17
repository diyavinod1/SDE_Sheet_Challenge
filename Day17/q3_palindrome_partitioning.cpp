#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPalindrome(string &s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    void dfs(int start, string &s, vector<string> &path,
             vector<vector<string>> &res) {

        if (start == s.size()) {
            res.push_back(path);
            return;
        }

        for (int i = start; i < s.size(); i++) {
            if (isPalindrome(s, start, i)) {
                path.push_back(s.substr(start, i - start + 1));
                dfs(i + 1, s, path, res);
                path.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> path;
        dfs(0, s, path, res);
        return res;
    }
};

int main() {
    string s;
    cin >> s;

    Solution obj;
    vector<vector<string>> ans = obj.partition(s);

    for (auto &vec : ans) {
        for (auto &str : vec) {
            cout << str << " ";
        }
        cout << "\n";
    }

    return 0;
}
