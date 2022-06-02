#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool compare(int a, int b) {
    return a > b;
}

int main(void) {
    int n, left, count = 0;
    cin >> n;
    left = 1000 - n;
    while(left > 0){
        if(left < 5)
            left -= 1;
        else if(left < 10)
            left -= 5;
        else if(left < 50)
            left -= 10;
        else if(left < 100)
            left -= 50;
        else if(left < 500)
            left -= 100;
        else if(left < 1000)
            left -= 500;
        count ++;
    }
    cout << count;
}