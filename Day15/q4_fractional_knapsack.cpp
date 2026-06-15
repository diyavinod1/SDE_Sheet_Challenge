#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>
using namespace std;

struct Item {
    int value;
    int weight;
    double ratio;
};

bool compare(Item a, Item b) {
    return a.ratio > b.ratio;
}

int main() {
    int n;

    cout << "Enter number of items: ";
    cin >> n;

    vector<Item> items(n);

    cout << "Enter values:\n";
    for (int i = 0; i < n; i++) {
        cin >> items[i].value;
    }

    cout << "Enter weights:\n";
    for (int i = 0; i < n; i++) {
        cin >> items[i].weight;
        items[i].ratio = (double)items[i].value / items[i].weight;
    }

    int capacity;
    cout << "Enter knapsack capacity: ";
    cin >> capacity;

    sort(items.begin(), items.end(), compare);

    double totalValue = 0.0;

    for (int i = 0; i < n; i++) {

        if (capacity >= items[i].weight) {
            // Take whole item
            totalValue += items[i].value;
            capacity -= items[i].weight;
        }
        else {
            // Take fraction of item
            totalValue += items[i].ratio * capacity;
            break;
        }
    }

    cout << fixed << setprecision(6);
    cout << "Maximum value = " << totalValue << endl;

    return 0;
}
