#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
using namespace std;

void solve(string s, int index, unordered_set<string>& dict,
           string current, vector<string>& ans) {

    if (index == s.length()) {
        ans.push_back(current);
        return;
    }

    string word = "";

    for (int i = index; i < s.length(); i++) {
        word += s[i];

        if (dict.find(word) != dict.end()) {
            string next;

            if (current.empty())
                next = word;
            else
                next = current + " " + word;

            solve(s, i + 1, dict, next, ans);
        }
    }
}

int main() {
    int n;

    cout << "Enter number of words in dictionary: ";
    cin >> n;

    unordered_set<string> dict;

    cout << "Enter dictionary words:\n";
    for (int i = 0; i < n; i++) {
        string word;
        cin >> word;
        dict.insert(word);
    }

    string s;
    cout << "Enter string: ";
    cin >> s;

    vector<string> ans;

    solve(s, 0, dict, "", ans);

    if (ans.empty()) {
        cout << "No valid word breaks found.\n";
    } else {
        cout << "\nPossible word breaks:\n";
        for (string str : ans) {
            cout << str << endl;
        }
    }

    return 0;
}
