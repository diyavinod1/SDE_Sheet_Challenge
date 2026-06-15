#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N;

    cout << "Enter number of trains: ";
    cin >> N;

    vector<int> arr(N), dep(N);

    cout << "Enter arrival times (e.g. 900 for 9:00): ";
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    cout << "Enter departure times (e.g. 920 for 9:20): ";
    for (int i = 0; i < N; i++) {
        cin >> dep[i];
    }

    sort(arr.begin(), arr.end());
    sort(dep.begin(), dep.end());

    int platforms = 1;
    int maxPlatforms = 1;

    int i = 1; // arrival pointer
    int j = 0; // departure pointer

    while (i < N && j < N) {

        if (arr[i] <= dep[j]) {
            platforms++;
            maxPlatforms = max(maxPlatforms, platforms);
            i++;
        }
        else {
            platforms--;
            j++;
        }
    }

    cout << "Minimum number of platforms required: "
         << maxPlatforms << endl;

    return 0;
}
