#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

void solve(int x, int y, vector<vector<int>>& maze, int n,
           vector<vector<int>>& visited, string path,
           vector<string>& ans) {

    if (x == n - 1 && y == n - 1) {
        ans.push_back(path);
        return;
    }

    visited[x][y] = 1;

    // Down
    if (x + 1 < n && maze[x + 1][y] == 1 && !visited[x + 1][y]) {
        solve(x + 1, y, maze, n, visited, path + 'D', ans);
    }

    // Left
    if (y - 1 >= 0 && maze[x][y - 1] == 1 && !visited[x][y - 1]) {
        solve(x, y - 1, maze, n, visited, path + 'L', ans);
    }

    // Right
    if (y + 1 < n && maze[x][y + 1] == 1 && !visited[x][y + 1]) {
        solve(x, y + 1, maze, n, visited, path + 'R', ans);
    }

    // Up
    if (x - 1 >= 0 && maze[x - 1][y] == 1 && !visited[x - 1][y]) {
        solve(x - 1, y, maze, n, visited, path + 'U', ans);
    }

    visited[x][y] = 0; // Backtrack
}

int main() {
    int n;

    cout << "Enter n: ";
    cin >> n;

    vector<vector<int>> maze(n, vector<int>(n));

    cout << "Enter the grid:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> maze[i][j];
        }
    }

    vector<string> ans;

    if (maze[0][0] == 1) {
        vector<vector<int>> visited(n, vector<int>(n, 0));
        solve(0, 0, maze, n, visited, "", ans);
    }

    sort(ans.begin(), ans.end());

    if (ans.empty()) {
        cout << "No path exists\n";
    } else {
        cout << "Possible paths:\n";
        for (string path : ans) {
            cout << path << endl;
        }
    }

    return 0;
}
