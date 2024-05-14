import java.util.*;
import java.awt.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        
        boolean deleted = true;
        
        char[][] block = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            block[i] = board[i].toCharArray();
        }
        
        Set<Point> toDelete = new HashSet<>();
        
        int count = 0;
        while(deleted) {
            deleted = false;
            
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if(check(i, j, block)) {
                        toDelete.add(of(i, j));
                        toDelete.add(of(i+1, j));
                        toDelete.add(of(i, j+1));
                        toDelete.add(of(i+1, j+1));
                        deleted = true;
                    }
                    
                }
            }
            
            for(Point p: toDelete) {
                block[p.y][p.x] = '-';
                count++;
            }
            
            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i > -1; i--) {
                    if(block[i][j] != '-')
                        continue;
                    
                    int index = i;
                    while(index > -1 && block[index][j] == '-') {
                        index--;
                    }
                    if(index == -1)
                        break;
                    block[i][j] = block[index][j];
                    block[index][j] = '-';
                }
            }
            
            toDelete.clear();
        }        
        
        
        return count;
    }
    
    boolean check(int i, int j, char[][] block) {
        char b = block[i][j];
        return b != '-' && b == block[i+1][j] && b == block[i][j+1] && b == block[i+1][j+1];
    }

    Point of(int y, int x) {
        return new Point(x, y);
    }
}