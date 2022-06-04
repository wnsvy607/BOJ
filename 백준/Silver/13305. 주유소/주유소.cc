#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    long n, temp, total = 0, min;
    cin >> n;
    vector <long> dis, price;
    for (int i = 0; i < n - 1; ++i) {
        cin >> temp;
        dis.push_back(temp);
    }
    for (int i = 0; i < n; ++i) {
        cin >> temp;
        price.push_back(temp);
    }
    min = price[0];
    for (int i = 0; i < n - 1; ++i) {
        if(min > price[i]){
            min = price[i];
        }
        total += min * dis[i];
    }
    cout << total;
}