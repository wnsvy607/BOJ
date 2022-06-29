/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 1
 *      1080번 행렬
 *      created: 2022.06.29
 */
#include <iostream>

using namespace std;

int matA[52][52];
int matB[52][52];

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i < n + 1; ++i) {
        for (int j = 1; j < m + 1; ++j) {
            scanf("%1d", &matA[i][j]);
        }
    }
    for (int i = 1; i < n + 1; ++i) {
        for (int j = 1; j < m + 1; ++j) {
            scanf("%1d", &matB[i][j]);
        }
    }
    
    if (n < 3 || m < 3) {
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                if(matA[i][j] != matB[i][j]){
                    cout << -1;
                    return 0;
                }
            }
        }
        cout << 0;
        return 0;
    }
    
    int count = 0;
    for (int i = 1; i < n - 1; ++i) {
        for (int j = 1; j < m - 1; ++j) {
            if (matA[i][j] != matB[i][j]) {
                for (int k = i; k < i + 3; ++k) {
                    for (int l = j; l < j + 3; ++l) {
                        if (matA[k][l])
                            matA[k][l] = 0;
                        else
                            matA[k][l] = 1;
                    }
                }
                count++;
            }
        }
    }

    for (int i = 1; i < n + 1; ++i) {
        for (int j = 1; j < m + 1; ++j) {
            if (matA[i][j] != matB[i][j]) {
                cout << -1;
                return 0;
            }
        }
    }
    cout << count;
}