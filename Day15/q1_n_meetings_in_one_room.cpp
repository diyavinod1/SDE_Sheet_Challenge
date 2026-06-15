#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Meeting {
    int start;
    int end;
    int pos;
};

bool compare(Meeting a, Meeting b) {
    if (a.end == b.end)
        return a.pos < b.pos;
    return a.end < b.end;
}

int main() {
    int N;
    cout << "Enter number of meetings: ";
    cin >> N;

    vector<int> start(N), end(N);

    cout << "Enter start times: ";
    for (int i = 0; i < N; i++) {
        cin >> start[i];
    }

    cout << "Enter end times: ";
    for (int i = 0; i < N; i++) {
        cin >> end[i];
    }

    vector<Meeting> meetings;

    for (int i = 0; i < N; i++) {
        meetings.push_back({start[i], end[i], i + 1});
    }

    sort(meetings.begin(), meetings.end(), compare);

    vector<int> answer;

    int lastEnd = meetings[0].end;
    answer.push_back(meetings[0].pos);

    for (int i = 1; i < N; i++) {
        if (meetings[i].start > lastEnd) {
            answer.push_back(meetings[i].pos);
            lastEnd = meetings[i].end;
        }
    }

    cout << "Meetings that can be performed: ";
    cout << "[";
    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i];
        if (i != answer.size() - 1)
            cout << ", ";
    }
    cout << "]" << endl;

    return 0;
}
