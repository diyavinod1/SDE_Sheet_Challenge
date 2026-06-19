#include <iostream>
#include <vector>
using namespace std;

bool isSafe(int node, int color, vector<int>& colors, vector<vector<int>>& graph) {
    for (int neighbor : graph[node]) {
        if (colors[neighbor] == color)
            return false;
    }
    return true;
}

bool solve(int node, int n, int m, vector<int>& colors, vector<vector<int>>& graph) {
    if (node == n)
        return true;

    for (int color = 1; color <= m; color++) {
        if (isSafe(node, color, colors, graph)) {
            colors[node] = color;

            if (solve(node + 1, n, m, colors, graph))
                return true;

            colors[node] = 0; // backtrack
        }
    }

    return false;
}

int main() {
    int N, M, E;

    cout << "Enter number of vertices: ";
    cin >> N;

    cout << "Enter number of colors: ";
    cin >> M;

    cout << "Enter number of edges: ";
    cin >> E;

    vector<vector<int>> graph(N);

    cout << "Enter edges (u v):\n";
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    vector<int> colors(N, 0);

    if (solve(0, N, M, colors, graph))
        cout << 1 << endl;
    else
        cout << 0 << endl;

    return 0;
}
