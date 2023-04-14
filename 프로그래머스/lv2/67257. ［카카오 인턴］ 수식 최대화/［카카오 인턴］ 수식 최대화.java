import java.util.*;
import java.util.stream.*;

class Solution {
    String[] sym = {"*","-","+"};
    long answer = 0;
    String exp;
    
    
    public long solution(String expression) {
        exp = expression;
        combi("", 0, 0);    
        
        return answer;
    }
    
    public void combi(String result, int cur, int depth) {
        //탈출
        if(depth == 3){
            long res = calWithResult(result);
            answer = Math.max(answer, res);
        }
        
        //수행
        for(int i = 0; i < 3; i++) {
            if(result.contains(sym[i]))
                continue;
            combi(result + sym[i] , i, depth + 1);
        }    
        
    }    
    
    
    public long calWithResult(String result) {
        String[] n = exp.split("[*+-]");
        String[] o = exp.replaceAll("[0-9]", " ").split(" ");
        List<Long> num = Arrays.stream(n).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());

        List<String> oper =Arrays.stream(o).filter(s -> !s.equals("")).collect(Collectors.toList());
        
        for(int i = 0; i < 3; i++) {
            if(result.charAt(i) == '*') {
                for(int j = 0; j < oper.size(); j++) {
                    if(oper.get(j).equals("*")) 
                    {
                        Long fo = num.get(j);
                        Long la = num.get(j + 1);
                        num.add(j, fo * la);                   
                        num.remove(j + 1);
                        num.remove(j + 1);    
                        oper.remove(j);
                        j--;
                    }
                }
            }
            else if(result.charAt(i) == '-') {
                for(int j = 0; j < oper.size(); j++) {
                    if(oper.get(j).equals("-")) 
                    {
                        Long fo = num.get(j);
                        Long la = num.get(j + 1);
                        num.add(j, fo - la);                   
                        num.remove(j + 1);   
                        num.remove(j + 1);    
                        oper.remove(j);
                        j--;
                    }
                }
            }
            else {
                for(int j = 0; j < oper.size(); j++) {
                    if(oper.get(j).equals("+")) 
                    {
                        Long fo = num.get(j);
                        Long la = num.get(j + 1);
                        num.add(j, fo + la);                   
                        num.remove(j + 1);
                        num.remove(j + 1);    
                        oper.remove(j);
                        j--;
                    }
                }
            } 
        }
        
        
        
        return Math.abs(num.get(0));
    }

}