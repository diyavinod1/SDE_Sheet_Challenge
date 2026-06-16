#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void findSums(int index, int sum, vector<int>& arr, vector<int>& ans) {
    if (index == arr.size()) {
        ans.push_back(sum);
        return;
    }

    // Include current element
    findSums(index + 1, sum + arr[index], arr, ans);

    // Exclude current element
    findSums(index + 1, sum, arr, ans);
}

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    vector<int> ans;

    findSums(0, 0, arr, ans);

    sort(ans.begin(), ans.end());

    for (int x : ans) {
        cout << x << " ";
    }

    return 0;
}
