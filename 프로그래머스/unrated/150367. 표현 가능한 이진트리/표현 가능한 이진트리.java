import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {    
        int[] answer = new int[numbers.length];
        
        for(int j = 0; j < numbers.length; j++) {
            long num = numbers[j];
            String binary = "";
            
            while(num > 0) {
                binary = num % 2 + binary; 
                num = num / 2;
            }
            
            int pow = 1;
            int level = 0;
            while(pow < 100) {
                level++;
                pow = pow * 2;
                int len = binary.length();
                if(len > pow - 1)
                    continue;
                
                String tree = "0".repeat(pow - 1 - len) + binary;
 
                if(tree.charAt((pow/2) - 1) == '0') 
                    continue;
                
                if(checkTree(tree, level, pow - 1, 1)) {
                    answer[j] = 1;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    
    public boolean checkTree(String tree, int level, int base, int parent) {
        if(level == 1) {
            if(tree.charAt(0) == '1' && parent == 0)
                return false;
            return true;
        }
 
        int mid = base / 2;
        int nextBase = ((base + 1) / 2) - 1;
        
        String left = tree.substring(0, mid);
        String right = tree.substring(mid + 1);
        
        if(tree.charAt(mid) == '1') {
            if(parent == 0)
                return false;
            return checkTree(left, level - 1, nextBase, 1) && checkTree(right, level - 1, nextBase, 1);
        }
    
        return checkTree(left, level - 1, nextBase, 0) && checkTree(right, level - 1, nextBase, 0);
    }
}