#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Job {
    int id;
    int deadline;
    int profit;
};

bool compare(Job a, Job b) {
    return a.profit > b.profit;
}

int main() {
    int N;

    cout << "Enter number of jobs: ";
    cin >> N;

    vector<Job> jobs(N);

    cout << "Enter Job ID, Deadline and Profit:\n";

    for (int i = 0; i < N; i++) {
        cin >> jobs[i].id
            >> jobs[i].deadline
            >> jobs[i].profit;
    }

    sort(jobs.begin(), jobs.end(), compare);

    int maxDeadline = 0;
    for (int i = 0; i < N; i++) {
        maxDeadline = max(maxDeadline, jobs[i].deadline);
    }

    vector<int> slot(maxDeadline + 1, -1);

    int countJobs = 0;
    int totalProfit = 0;

    for (int i = 0; i < N; i++) {

        for (int j = jobs[i].deadline; j > 0; j--) {

            if (slot[j] == -1) {
                slot[j] = jobs[i].id;

                countJobs++;
                totalProfit += jobs[i].profit;
                break;
            }
        }
    }

    cout << "\nNumber of jobs done: " << countJobs << endl;
    cout << "Maximum profit: " << totalProfit << endl;

    return 0;
}
